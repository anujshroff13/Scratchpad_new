package main.java.scratchpad.app.Misc;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.DBCollection;

import main.java.scratchpad.Database.IConnect;
import main.java.scratchpad.MongoDB.Entities.Collection.BasicCollectionOperations;
import main.java.scratchpad.MongoDB.Entities.Document.KeyValueEntry2;
import main.java.scratchpad.MongoDB.connection.Connect;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/basic")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    @RequestMapping("/showAll")
    public KeyValueEntry2 displayDB() {
    	
		try {
			// To connect to mongodb server
	        IConnect conn = new Connect();
	        DBCollection coll = conn.connect();
	        
        	// Display all the documents.
			BasicCollectionOperations op = new BasicCollectionOperations(coll);
			return new KeyValueEntry2(op.ShowAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return null;
    	
    }
}