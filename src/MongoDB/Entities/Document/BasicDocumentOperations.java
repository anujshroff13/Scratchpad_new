package MongoDB.Entities.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;

public class BasicDocumentOperations {

	DBCollection collection;
	
	public BasicDocumentOperations(DBCollection collection) {
		this.collection = collection;
	}
	
	public boolean Add (String title, String description) {
		boolean success = true;
		try {
		BasicDBObject doc = new BasicDBObject("title", title).
								append("description", description);
					
		collection.insert(doc);
		System.out.println("Document inserted successfully");
		} catch (Exception e) {
			success = false;
			e.printStackTrace();
		}
		return success;
	}
}
