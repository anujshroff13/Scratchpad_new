package main.java.scratchpad.MongoDB.connection;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

import main.java.scratchpad.Database.IConnect;

public class Connect implements IConnect{
	
	public DBCollection connect() {
		
		MongoClient mongoClient = null;
		DB db = null;
		DBCollection coll = null;
		
		try {
	        // To connect to mongodb server
	        mongoClient = new MongoClient( "localhost" );
				
	        // Now connect to your databases
	        db = mongoClient.getDB( "anujtestdb" );
	        //System.out.println("Connect to database successfully");
	        
	        coll = db.getCollection("scratchpad");
	        	
	     } catch(Exception e){
	        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	     }
		return coll;
	}
}
