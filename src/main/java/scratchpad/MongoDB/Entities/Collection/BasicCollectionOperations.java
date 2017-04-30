package main.java.scratchpad.MongoDB.Entities.Collection;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class BasicCollectionOperations {
	DBCollection collection;
	
	public BasicCollectionOperations (DBCollection collection) {
		this.collection = collection;
	}
	
	public boolean ShowAllDisplay () {
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
	
	public DBObject[] ShowAll () {
		DBObject result[] = null;
		try {
			
			DBCursor cursor = collection.find();
			result = new DBObject[cursor.size()];
	        int resultCount = 0;
			
	        while (cursor.hasNext()) {
	           result[resultCount] = cursor.next();
	           resultCount++;
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
