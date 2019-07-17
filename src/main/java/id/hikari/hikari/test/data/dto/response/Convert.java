package id.hikari.hikari.test.data.dto.response;


import com.google.gson.Gson;

public abstract class Convert {
    public static Object[] convertToJsonArray(String json){
        Gson gson = new Gson();
        Object[] result = gson.fromJson(json, Object[].class);
        return result;
    }

    public static Object convertToJson(String json){
        Gson gson = new Gson();
        Object result = gson.fromJson(json, Object.class);
        return result;
    }
}
