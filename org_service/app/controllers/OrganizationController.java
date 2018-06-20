package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sunbird.common.models.util.ActorOperations;
import org.sunbird.common.models.util.JsonKey;
import org.sunbird.common.models.util.LoggerEnum;
import org.sunbird.common.models.util.ProjectLogger;
import org.sunbird.common.models.util.ProjectUtil;
import org.sunbird.common.models.util.ProjectUtil.EsType;
import org.sunbird.common.request.Request;
import org.sunbird.common.request.RequestValidator;
import org.sunbird.controllers.BaseController;

import com.fasterxml.jackson.databind.JsonNode;

import play.libs.F.Promise;
import play.mvc.Result;

/**
 * @author arvind.
 */
public class OrganizationController extends BaseController {

	/**
	 * This method will do the registration process. Registered organization data
	 * will be store inside cassandra DB.
	 *
	 * @return Promise<Result>
	 */
	@SuppressWarnings("unchecked")
	public Promise<Result> createOrg() {

		try {
			JsonNode requestData = request().body().asJson();
			ProjectLogger.log("OrganisationController: createOrg called" + requestData, LoggerEnum.DEBUG.name());
			Request reqObj = createAndInitRequest(ActorOperations.CREATE_ORG.getValue(), requestData);
			Map<String, Object> orgData = reqObj.getRequest();
			ProjectUtil.updateMapValueToLowerCase(orgData, JsonKey.PROVIDER, JsonKey.EXTERNAL_ID);
			Map<String, Object> requestMap = createRequestMap(orgData, true);
			reqObj.setRequest(requestMap);
			return actorResponseHandler(getActorRef(), reqObj, timeout, null, request());
		} catch (Exception e) {
			return Promise.<Result>pure(createCommonExceptionResponse(e, request(), true));
		}
	}

	/**
	 * This method will update organization data.
	 *
	 * @return Promise<Result>
	 */
	@SuppressWarnings("unchecked")
	public Promise<Result> updateOrg() {

		try {
			JsonNode requestData = request().body().asJson();
			ProjectLogger.log("OrganisationController: updateOrg called with data = " + requestData,
					LoggerEnum.DEBUG.name());
			Request reqObj = createAndInitRequest(ActorOperations.UPDATE_ORG.getValue(), requestData);
			Map<String, Object> orgData = reqObj.getRequest();
			Map<String, Object> requestMap = createRequestMap(orgData, true);
			reqObj.setRequest(requestMap);
			return actorResponseHandler(getActorRef(), reqObj, timeout, null, request());
		} catch (Exception e) {
			return Promise.<Result>pure(createCommonExceptionResponse(e, request(), true));
		}
	}

	/**
	 * This method will provide user profile details based on requested userId.
	 *
	 * @return Promise<Result>
	 */
	public Promise<Result> getOrgDetails() {

		try {
			JsonNode requestData = request().body().asJson();
			ProjectLogger.log("OrganisationController: getOrgDetails called with data = " + requestData,
					LoggerEnum.DEBUG.name());
			Request reqObj = createAndInitRequest(ActorOperations.GET_ORG_DETAILS.getValue(), requestData);
			ProjectUtil.updateMapSomeValueTOLowerCase(reqObj);
			RequestValidator.validateOrg(reqObj);
			Map<String, Object> orgData = reqObj.getRequest();
			Map<String, Object> requestMap = createRequestMap(orgData, false);
			reqObj.setRequest(requestMap);
			return actorResponseHandler(getActorRef(), reqObj, timeout, null, request());
		} catch (Exception e) {
			return Promise.<Result>pure(createCommonExceptionResponse(e, request(), true));
		}
	}

	/**
	 * This method will do the organisation search for Elastic search. this will
	 * internally call composite search api.
	 *
	 * @return Promise<Result>
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Promise<Result> search() {
		try {
			JsonNode requestData = request().body().asJson();
			ProjectLogger.log("OrganisationController: search called", LoggerEnum.DEBUG.name());
			Request reqObj = createAndInitRequest(ActorOperations.COMPOSITE_SEARCH.getValue(), requestData);
			ProjectUtil.updateMapSomeValueTOLowerCase(reqObj);
			List<String> esObjectType = new ArrayList<>();
			esObjectType.add(EsType.organisation.getTypeName());

			if (reqObj.getRequest() != null && reqObj.getRequest().containsKey(JsonKey.FILTERS)
					&& reqObj.getRequest().get(JsonKey.FILTERS) != null
					&& reqObj.getRequest().get(JsonKey.FILTERS) instanceof Map) {
				((Map) (reqObj.getRequest().get(JsonKey.FILTERS))).put(JsonKey.OBJECT_TYPE, esObjectType);
			} else {
				Map<String, Object> dataMap = new HashMap<>();
				dataMap.put(JsonKey.OBJECT_TYPE, esObjectType);
				if (reqObj.getRequest() != null) {
					reqObj.getRequest().put(JsonKey.FILTERS, dataMap);
				} else {
					Map<String, Object> requestmap = new HashMap<>();
					requestmap.put(JsonKey.FILTERS, dataMap);
					reqObj.setRequest(requestmap);
				}
			}
			return actorResponseHandler(getActorRef(), reqObj, timeout, null, request());
		} catch (Exception e) {
			return Promise.<Result>pure(createCommonExceptionResponse(e, request(), true));
		}
	}

	@SuppressWarnings("unchecked")
	private Map<String, Object> createRequestMap(Map<String, Object> orgData, boolean updateAddress) {
		Map<String, Object> requestMap = new HashMap<>();
		if (updateAddress) {
			Map<String, Object> address = (Map<String, Object>) orgData.get(JsonKey.ADDRESS);
			if (null != address && address.size() > 0 && orgData.containsKey(JsonKey.ADDRESS)) {
				requestMap.put(JsonKey.ADDRESS, address);
				orgData.remove(JsonKey.ADDRESS);
			}
		}
		requestMap.put(JsonKey.ORGANISATION, orgData);
		requestMap.put(JsonKey.REQUESTED_BY, ctx().flash().get(JsonKey.USER_ID));

		return requestMap;
	}
}
