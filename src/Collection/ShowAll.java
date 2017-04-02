package Collection;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

public class ShowAll {
	public static DB db;
	public static DBCollection coll;
	public ShowAll (DB db, DBCollection coll) {
		this.db = db;
		this.coll = coll;
	}
	public void exec () {
		DBCursor cursor = coll.find();
        int i = 1;
			
        while (cursor.hasNext()) { 
           System.out.println("Inserted Document: "+i); 
           System.out.println(cursor.next()); 
           i++;
        }
	}
}
