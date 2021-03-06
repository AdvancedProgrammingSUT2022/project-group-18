package Chatserver.Model;


import com.google.gson.Gson;

import java.util.HashMap;

public class Request {
    private String header;
    private HashMap<String, Object> data;

    public String getHeader() {
        return header;
    }

    public HashMap<String, Object> getData() {
        return data;
    }

    public void addData(String key, Object value) {
        this.data.put(key, value);
    }

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public static Request fromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Request.class);
    }
}
