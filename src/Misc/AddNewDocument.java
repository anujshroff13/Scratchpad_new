package Misc;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class AddNewDocument {
	public static void main( String args[] ) {
		
	      try{
			
	         // To connect to mongodb server
	         MongoClient mongoClient = new MongoClient( "localhost" );
				
	         // Now connect to your databases
	         DB db = mongoClient.getDB( "anujtestdb" );
	         System.out.println("Connect to database successfully");
	         
	         DBCollection coll = db.getCollection("scratchpad");
	         System.out.println("Collection scratchpad selected successfully");
	         
	         BasicDBObject doc = new BasicDBObject("title", "Bhschild2").
	            append("description", "hybrid snap cluster");
					
	         coll.insert(doc);
	         System.out.println("Document inserted successfully");
	         	
	      }catch(Exception e){
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      }
	   }
}
