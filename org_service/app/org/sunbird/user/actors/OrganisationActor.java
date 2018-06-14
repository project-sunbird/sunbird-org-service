package org.sunbird.user.actors;

import com.typesafe.config.Config;
import org.sunbird.actor.core.BaseActor;
import org.sunbird.actor.router.ActorConfig;
import org.sunbird.common.request.Request;
import org.sunbird.util.ConfigUtil;

/**
 * @author arvind.
 */
@ActorConfig(
    tasks = {"createOrg", "updateOrg"},
    asyncTasks = {}
)
public class OrganisationActor extends BaseActor {

  private static Config config = ConfigUtil.getConfig();

  @Override
  public void onReceive(Request request) throws Throwable {

    String operation = request.getOperation();

  }

}
