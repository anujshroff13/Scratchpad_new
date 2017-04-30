package main.java.scratchpad.app.keyvalue;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;;

//@RepositoryRestResource(collectionResourceRel = "keyvalue", path = "keyvalue")
public interface KeyValueRepository extends MongoRepository<KeyValue, String> {

	List<KeyValue> findByValue(@Param("value") String value);
	KeyValue findByKey(@Param("key") String key);
	KeyValue findById(@Param("id") String id);

}