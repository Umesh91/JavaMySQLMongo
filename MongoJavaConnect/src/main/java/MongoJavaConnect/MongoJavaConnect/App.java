package MongoJavaConnect.MongoJavaConnect;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
    	
    	//var mongoClient = MongoClients.create("");
    	MongoClient mongoClient2 = MongoClients.create("mongodb://localhost:27017");
    	
    	MongoDatabase mdb=mongoClient2.getDatabase("mydb");
    	System.out.println("Database Name  ->"+mdb.getName());
    	for(String name : mdb.listCollectionNames())
    	{
    		System.out.println(name);
    	}
        
    }
}
