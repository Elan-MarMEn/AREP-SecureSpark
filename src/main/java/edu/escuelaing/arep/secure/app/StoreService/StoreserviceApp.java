package edu.escuelaing.arep.secure.app.StoreService;

import static spark.Spark.*;


import edu.escuelaing.arep.secure.app.StoreService.persistence.MongoConnect;

/**
 * @author Alan Marin
 */
public class StoreserviceApp
{
    public static void main( String[] args )
    {
        MongoConnect mongoConnect =  new MongoConnect();
        
        port(getPort());
        secure("keyscertsStore/secureStorepart.p12", "123456", "keyscertsStore/ownstoreTrustStore", "654321");
        
        staticFiles.location("public2");

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


        get("/dataset", (req,res) -> mongoConnect.getAlldata());

        post("/add",(request, response) -> {
            mongoConnect.saveData(request.body());
            return true;
        });

    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5001;
    }
}
