package edu.escuelaing.arep.secure.app.LogService;

import static spark.Spark.*;

import org.json.JSONObject;

import edu.escuelaing.arep.secure.app.LogService.model.User;
import edu.escuelaing.arep.secure.app.LogService.sevices.LogService;


/**
 * @author Alan Marin
 */
public class LogServiceApp 
{
    public static void main( String[] args )
    {
        LogService logService = new LogService();
        User user = new User("labArep2021","LABarep72021");
        logService.addUser(user);
        staticFiles.location("public");

        port(getPort());
        secure("keyscerts/securelab.p12", "123456", "keyscerts/ownTrustStore", "654321");

        options("/*", (request, response) -> {
            String accessControlRequestHeaders = request
                    .headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers",
                        accessControlRequestHeaders);
            }
            String accessControlRequestMethod = request
                    .headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods",
                        accessControlRequestMethod);
            }

            return "OK";
        });
        before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));

        post("/logged", (req,res) -> {
            JSONObject jsonObject = new JSONObject(req.body());
            String name = jsonObject.getString("name");
            String pwd = jsonObject.getString("pwd");
            return logService.userAuth(name,pwd);
        });

        get("/auth", (req,res) -> logService.isActive());


        
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 35000;
    }
}
