package MongoDB.Entities.Collection;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

public class BasicCollectionOperations {
	DBCollection collection;
	
	public BasicCollectionOperations (DBCollection collection) {
		this.collection = collection;
	}
	
	public boolean ShowAll () {
		boolean success = true;
		try {
			
		DBCursor cursor = collection.find();
        int i = 1;
			
        while (cursor.hasNext()) { 
           System.out.println("Inserted Document: "+i); 
           System.out.println(cursor.next()); 
           i++;
        }
		} catch (Exception e) {
			success = false;
			e.printStackTrace();
		}
		return success;
	}
}
