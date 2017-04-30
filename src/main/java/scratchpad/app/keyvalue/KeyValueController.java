package main.java.scratchpad.app.keyvalue;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/keyvalue")
public class KeyValueController {
	
	@Autowired
	private KeyValueRepository repo;
	
	@RequestMapping(method = RequestMethod.GET, path="/create") // 'POST' here does not work???
	public Map<String, Object> createEntry(@Param("key") String key, @Param("value") String value){

		KeyValue input = new KeyValue(key, value);
	    repo.save(input);
	        
		Map<String, Object> response = new LinkedHashMap<String, Object>();
	    response.put("message", "Entry created successfully");
	    response.put("Entry", input);
	    return response;
	}

	@RequestMapping(method = RequestMethod.GET, value="/searchByKey")
	  public Map<String, Object> getKeyValueDetails(@Param("key") String key){
			KeyValue res = repo.findByKey(key);
			//KeyValue res = repo.findOne(key); // This does not work, why??
			Map<String, Object> response = new LinkedHashMap<String, Object>();
			  response.put("result", res);
			return response;
	  }
	
	@RequestMapping(method = RequestMethod.GET, value="/test")
	  public String getTest(@Param("key") String key) {
			return key;
	  }
	
	@RequestMapping(method = RequestMethod.GET, path="/showAll")
	public Map<String, Object> getAllValues(){
	  List<KeyValue> kvs = repo.findAll();
	  Map<String, Object> response = new LinkedHashMap<String, Object>();
	  response.put("totalValues", kvs.size());
	  response.put("kvs", kvs);
	  return response;
	}
	
	// Update //Not working (Does not updates but adds new)
	@RequestMapping(method = RequestMethod.GET, value="/update") //PUT ??
	public Map<String, Object> editKeyValue(@Param("key") String key,
	    @Param("value") String value){
			KeyValue val = new KeyValue(key, value);

	  Map<String, Object> response = new LinkedHashMap<String, Object>();
	  response.put("message", "Book Updated successfully");
	  response.put("book", repo.save(val));
	  return response;
	}
	
	// Delete // Not working (Does not delete)
	@RequestMapping(method = RequestMethod.GET, value="/delete") //GET??
	public Map<String, String> deleteBook(@Param("key") String key){
	  repo.delete(key);
	  Map<String, String> response = new HashMap<String, String>();
	  response.put("message", "Entry with '"+ key + "' deleted successfully");

	  return response;
	}
}
