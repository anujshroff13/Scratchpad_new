package main.java.scratchpad.app.keyvalue;

import org.springframework.data.annotation.Id;

public class KeyValue {

	@Id private String id;

	private String key;
	private String value;
	
	public KeyValue() {}
	
    public KeyValue(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format(
                "KeyValue[id=%s, key='%s', value='%s']",
                id, key, value);
    }
	
    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
