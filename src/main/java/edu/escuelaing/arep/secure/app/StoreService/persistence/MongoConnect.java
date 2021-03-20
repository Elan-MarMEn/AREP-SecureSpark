package edu.escuelaing.arep.secure.app.StoreService.persistence;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Sorts;
import org.bson.Document;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/**
 * @author Alan Marin
 */
public class MongoConnect {

    private MongoClientURI uri;
    private MongoClient mongoClient;
    private MongoCollection<Document> collection;
    private FindIterable<Document> info;

    public MongoConnect() {

        try {
            uri =  new MongoClientURI(
                    "mongodb+srv://awsel:1234M@cluster0.thucb.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");

            mongoClient = new MongoClient(uri);
            MongoDatabase database = mongoClient.getDatabase("awsDockerJson");
            collection = database.getCollection("dataApp");
            System.out.println(mongoClient.listDatabaseNames().toString());
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    /**
     * Store the message in a remote database
     * @param message
     */
    public void saveData(String message) {
        // System.out.println(message);
        Map<String, Object> document = new HashMap<String,Object>();
        document.put("Data", message );
        document.put("date",new Date().toString());
        try {
            collection.insertOne(new Document(document));
        } catch (MongoException ex)
        {
            System.out.println("Failed Mongo auth");
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    /**
     * Return all data stored on the remote database
     * @return
     */
    public String getAlldata() {
        String dataList = "{ \"Dataset\": [";
        int iterator = 0;
        info = collection.find().sort(Sorts.descending("date"));
        for (Document document : info) {
            String data = "";
            if (iterator < 10) {
                data = "{\"Data\": \""+document.get("Data").toString() +"\", \"Date\": \""+document.get("date").toString()+"\"},";
                dataList=dataList+data;
            }
            iterator = iterator + 1;
        }
        String dataList2 = dataList.substring(0, dataList.length()-1);
        dataList2=dataList2+"]}";
        return dataList2;
    }

}
