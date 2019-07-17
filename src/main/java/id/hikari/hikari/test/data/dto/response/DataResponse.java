package id.hikari.hikari.test.data.dto.response;


import java.io.Serializable;


public class DataResponse implements Serializable {
    private static final long serialVersionUID = 6719738720208746210L;

    private Object attributes;
    private String type;
    private String id;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Object getAttributes() {
        return attributes;
    }

    public void setAttributes(Object attributes) {
        this.attributes = attributes;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DataResponse(Object attributes, String type, String id) {
        this.attributes = attributes;
        this.type = type;
        this.id = id;
    }

    public DataResponse(Object attributes) {
        this.attributes = attributes;
    }
}
