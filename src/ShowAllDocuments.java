import com.mongodb.MongoClient;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

public class ShowAllDocuments {

   public static void main( String args[] ) {
	
      try{
		
         // To connect to mongodb server
         MongoClient mongoClient = new MongoClient( "localhost" );
			
         // Now connect to your databases
         DB db = mongoClient.getDB( "anujtestdb" );
         System.out.println("Connect to database successfully");
         
         DBCollection coll = db.getCollection("scratchpad");
         System.out.println("Collection scratchpad selected successfully");
         
         DBCursor cursor = coll.find();
         int i = 1;
			
         while (cursor.hasNext()) { 
            System.out.println("Inserted Document: "+i); 
            System.out.println(cursor.next()); 
            i++;
         }
         	
      }catch(Exception e){
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      }
   }
}