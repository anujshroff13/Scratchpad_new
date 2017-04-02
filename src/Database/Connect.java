package Database;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class Connect {
	
	DB connect () {
		
		DB db = null;
		
		try {
	        // To connect to mongodb server
	        MongoClient mongoClient = new MongoClient( "localhost" );
				
	        // Now connect to your databases
	        db = mongoClient.getDB( "anujtestdb" );
	        System.out.println("Connect to database successfully");
	        	
	     } catch(Exception e){
	        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	     }
		return db;
	}
}
