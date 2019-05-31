package controllers.organisationmanagement;

import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;

public class OrgMemberController extends Controller {

  public Result addMemberToOrganisation() {
  //  ProjectLogger.log("Start add member to Org ",LoggerEnum.INFO);
    return Results.ok("200");
  }

  public Result removeMemberFromOrganisation() {
  //  ProjectLogger.log("Start remove member from Org",LoggerEnum.INFO);
    return Results.ok("200");
  }
}
