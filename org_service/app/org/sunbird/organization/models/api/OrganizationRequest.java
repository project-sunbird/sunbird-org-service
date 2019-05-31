package org.sunbird.organization.models.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import org.sunbird.organization.models.entity.Address;

/**
 * @author arvind
 */
@JsonIgnoreProperties(
    ignoreUnknown = true
)
@JsonInclude(Include.NON_NULL)
public class OrganizationRequest implements Serializable {
  private String id;
  private String addressId;
  private String channel;
  private String communityId;
  private String contactDetail;
  private String createdBy;
  private String createdDate;
  private Timestamp dateTime;
  private String description;
  private String externalId;
  private String hashTagId;
  private String homeUrl;
  private String imgUrl;
  private Boolean isDefault;
  private Boolean isRootOrg;
  private String locationId;
  private Integer noOfMembers;
  private String orgCode;
  private String orgName;
  private String orgType;
  private String orgTypeId;
  private String preferredLanguage;
  private String provider;
  private String rootOrgId;
  private String slug;
  private Integer status;
  private String theme;
  private String thumbnail;
  private String updatedBy;
  private String updatedDate;
  private List<String> locationIds;
  private List<Map<String, Object>> contactDetails;
  private List<String> locationCode;
  private Address address;

  public OrganizationRequest() {
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getAddressId() {
    return this.addressId;
  }

  public void setAddressId(String addressId) {
    this.addressId = addressId;
  }

  public String getChannel() {
    return this.channel;
  }

  public void setChannel(String channel) {
    this.channel = channel;
  }

  public String getCommunityId() {
    return this.communityId;
  }

  public void setCommunityId(String communityId) {
    this.communityId = communityId;
  }

  public String getContactDetail() {
    return this.contactDetail;
  }

  public void setContactDetail(String contactDetail) {
    this.contactDetail = contactDetail;
  }

  public String getCreatedBy() {
    return this.createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public String getCreatedDate() {
    return this.createdDate;
  }

  public void setCreatedDate(String createdDate) {
    this.createdDate = createdDate;
  }

  public Timestamp getDateTime() {
    return this.dateTime;
  }

  public void setDateTime(Timestamp dateTime) {
    this.dateTime = dateTime;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getExternalId() {
    return this.externalId;
  }

  public void setExternalId(String externalId) {
    this.externalId = externalId;
  }

  public String getHashTagId() {
    return this.hashTagId;
  }

  public void setHashTagId(String hashTagId) {
    this.hashTagId = hashTagId;
  }

  public String getHomeUrl() {
    return this.homeUrl;
  }

  public void setHomeUrl(String homeUrl) {
    this.homeUrl = homeUrl;
  }

  public String getImgUrl() {
    return this.imgUrl;
  }

  public void setImgUrl(String imgUrl) {
    this.imgUrl = imgUrl;
  }

  public Boolean getDefault() {
    return this.isDefault;
  }

  public void setDefault(Boolean aDefault) {
    this.isDefault = aDefault;
  }

  public Boolean getRootOrg() {
    return this.isRootOrg;
  }

  public void setRootOrg(Boolean rootOrg) {
    this.isRootOrg = rootOrg;
  }

  public String getLocationId() {
    return this.locationId;
  }

  public void setLocationId(String locationId) {
    this.locationId = locationId;
  }

  public Integer getNoOfMembers() {
    return this.noOfMembers;
  }

  public void setNoOfMembers(Integer noOfMembers) {
    this.noOfMembers = noOfMembers;
  }

  public String getOrgCode() {
    return this.orgCode;
  }

  public void setOrgCode(String orgCode) {
    this.orgCode = orgCode;
  }

  public String getOrgName() {
    return this.orgName;
  }

  public void setOrgName(String orgName) {
    this.orgName = orgName;
  }

  public String getOrgType() {
    return this.orgType;
  }

  public void setOrgType(String orgType) {
    this.orgType = orgType;
  }

  public String getOrgTypeId() {
    return this.orgTypeId;
  }

  public void setOrgTypeId(String orgTypeId) {
    this.orgTypeId = orgTypeId;
  }

  public String getPreferredLanguage() {
    return this.preferredLanguage;
  }

  public void setPreferredLanguage(String preferredLanguage) {
    this.preferredLanguage = preferredLanguage;
  }

  public String getProvider() {
    return this.provider;
  }

  public void setProvider(String provider) {
    this.provider = provider;
  }

  public String getRootOrgId() {
    return this.rootOrgId;
  }

  public void setRootOrgId(String rootOrgId) {
    this.rootOrgId = rootOrgId;
  }

  public String getSlug() {
    return this.slug;
  }

  public void setSlug(String slug) {
    this.slug = slug;
  }

  public Integer getStatus() {
    return this.status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getTheme() {
    return this.theme;
  }

  public void setTheme(String theme) {
    this.theme = theme;
  }

  public String getThumbnail() {
    return this.thumbnail;
  }

  public void setThumbnail(String thumbnail) {
    this.thumbnail = thumbnail;
  }

  public String getUpdatedBy() {
    return this.updatedBy;
  }

  public void setUpdatedBy(String updatedBy) {
    this.updatedBy = updatedBy;
  }

  public String getUpdatedDate() {
    return this.updatedDate;
  }

  public void setUpdatedDate(String updatedDate) {
    this.updatedDate = updatedDate;
  }

  public List<String> getLocationIds() {
    return this.locationIds;
  }

  public void setLocationIds(List<String> locationIds) {
    this.locationIds = locationIds;
  }

  public List<Map<String, Object>> getContactDetails() {
    return contactDetails;
  }

  public void setContactDetails(
      List<Map<String, Object>> contactDetails) {
    this.contactDetails = contactDetails;
  }

  public List<String> getLocationCode() {
    return this.locationCode;
  }

  public void setLocationCode(List<String> locationCode) {
    this.locationCode = locationCode;
  }

  public Address getAddress() {
    return this.address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }
}
