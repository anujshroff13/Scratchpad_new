package Document;

import com.mongodb.DB;
import com.mongodb.DBCollection;

public class Add {
	public static DB db;
	public static DBCollection coll;
	Add (DB db, DBCollection coll) {
		this.db = db;
		this.coll = coll;
	}
	
	

}
