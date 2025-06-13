package util;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import io.github.cdimascio.dotenv.Dotenv;


public class MongoDBUtil {
    private static final Dotenv dotenv = Dotenv.load();
    private static final String URI = dotenv.get("MONGO_URI");
    private static final String DB_NAME = "expense_manager";
    private static final String COLLECTION_NAME = "expenses";

    private static MongoClient mongoClient = null;

    public static MongoCollection<Document> getExpenseCollection() {
        if (mongoClient == null) {
            mongoClient = MongoClients.create(URI);
        }

        MongoDatabase database = mongoClient.getDatabase(DB_NAME);
        return database.getCollection(COLLECTION_NAME);
    }

    public static void closeConnection() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }
}
