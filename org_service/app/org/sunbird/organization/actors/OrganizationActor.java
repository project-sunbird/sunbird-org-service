package org.sunbird.organization.actors;

import com.typesafe.config.Config;
import org.sunbird.actor.core.BaseActor;
import org.sunbird.actor.router.ActorConfig;
import org.sunbird.common.request.Request;
import org.sunbird.organization.utils.Constant;
import org.sunbird.util.ConfigUtil;

/**
 * @author arvind.
 */
@ActorConfig(
    tasks = {Constant.CREATE_ORGANIZATION, Constant.UPDATE_ORGANIZATION},
    asyncTasks = {}
)
public class OrganizationActor extends BaseActor {

  private static Config config = ConfigUtil.getConfig();

  @Override
  public void onReceive(Request request) throws Throwable {

    String operation = request.getOperation();

    switch (operation) {
      case "createOrg":
        createOrganization(request);
        break;
      case "updateOrg":
        updateOrganization(request);
        break;
      default:
        onReceiveUnsupportedOperation("OrganizationActor");
    }
  }

  private void createOrganization(Request request) {
  }

  private void updateOrganization(Request request) {
  }

}
