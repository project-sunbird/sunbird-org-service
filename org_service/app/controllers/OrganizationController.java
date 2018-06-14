package controllers;

import java.util.HashMap;
import java.util.Map;

import org.sunbird.common.models.util.ActorOperations;
import org.sunbird.common.models.util.JsonKey;
import org.sunbird.common.models.util.LoggerEnum;
import org.sunbird.common.models.util.ProjectLogger;
import org.sunbird.common.models.util.ProjectUtil;
import org.sunbird.common.request.ExecutionContext;
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

			HashMap<String, Object> innerMap = new HashMap<>();
			Map<String, Object> address = (Map<String, Object>) reqObj.getRequest().get(JsonKey.ADDRESS);
			Map<String, Object> orgData = reqObj.getRequest();
			if (null != address && address.size() > 0 && orgData.containsKey(JsonKey.ADDRESS)) {
				innerMap.put(JsonKey.ADDRESS, address);
				orgData.remove(JsonKey.ADDRESS);
			}
			if (orgData.containsKey(JsonKey.PROVIDER)) {
				orgData.put(JsonKey.PROVIDER, ((String) orgData.get(JsonKey.PROVIDER)).toLowerCase());
			}
			if (orgData.containsKey(JsonKey.EXTERNAL_ID)) {
				orgData.put(JsonKey.EXTERNAL_ID, ((String) orgData.get(JsonKey.EXTERNAL_ID)).toLowerCase());
			}
			innerMap.put(JsonKey.ORGANISATION, orgData);
			innerMap.put(JsonKey.REQUESTED_BY, ctx().flash().get(JsonKey.USER_ID));
			reqObj.setRequest(innerMap);
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
			HashMap<String, Object> innerMap = new HashMap<>();
			Map<String, Object> address = (Map<String, Object>) reqObj.getRequest().get(JsonKey.ADDRESS);
			Map<String, Object> orgData = reqObj.getRequest();
			if (null != address && address.size() > 0 && orgData.containsKey(JsonKey.ADDRESS)) {
				innerMap.put(JsonKey.ADDRESS, address);
				orgData.remove(JsonKey.ADDRESS);
			}
			innerMap.put(JsonKey.ORGANISATION, orgData);
			innerMap.put(JsonKey.REQUESTED_BY, ctx().flash().get(JsonKey.USER_ID));
			reqObj.setRequest(innerMap);
			return actorResponseHandler(getActorRef(), reqObj, timeout, null, request());
		} catch (Exception e) {
			return Promise.<Result>pure(createCommonExceptionResponse(e, request(), true));
		}
	}
}
