package nl.mawoo.migratejs.extend.dbconnector;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Arrays;

/**
 * This class is responsible for the connection to MongoDB
 *
 * @author Bob van der Valk
 */
public class MongoDBConnector {

    private MongoClient mongoClient;
    private MongoDatabase db;

    /**
     * Start a MongoDB client with custom host, port, username, password
     * @param host Address of MongoDB
     * @param port Port of MongoDB
     * @param database Database you want to use
     * @param username credentials
     * @param password credentials
     */
    public MongoDBConnector(String host, int port, String database, String username, char[] password) {
        MongoCredential credential = MongoCredential.createCredential(username, database, password);
        mongoClient = new MongoClient(new ServerAddress(host, port), Arrays.asList(credential));

        db = mongoClient.getDatabase(database);
    }

    /**
     * Start a MongoDB client with credentials and default port and host
     * @param database Database you want to use
     * @param username credentials
     * @param password credentials
     */
    public MongoDBConnector(String database, String username, char[] password) {
        MongoCredential credential = MongoCredential.createCredential(username, database, password);
        mongoClient = new MongoClient(new ServerAddress(), Arrays.asList(credential));

        db = mongoClient.getDatabase(database);
    }

    /**
     * Start a MongoDB client with credentials and default port and host and no credentials
     * @param database Database you want to use
     */
    public MongoDBConnector(String database) {
        mongoClient = new MongoClient(new ServerAddress());
        db = mongoClient.getDatabase(database);
    }

    /**
     * Insert data into collection
     * @param collection collection name
     * @param input json/document input
     * TODO: Create method to input json and convert to document
     */
    public void insert(String collection, Document input) {
        db.getCollection(collection).insertOne(input);
    }

}