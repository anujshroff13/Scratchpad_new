package main.java.scratchpad.MongoDB.Entities.Document;

import com.mongodb.DBObject;

// Resource representation class
public class KeyValueEntry2 {

    private final DBObject[] obj;
    
    public KeyValueEntry2(DBObject[] obj) {
        this.obj = obj;
    }

    public DBObject[] getObj() {
        return obj;
    }
}