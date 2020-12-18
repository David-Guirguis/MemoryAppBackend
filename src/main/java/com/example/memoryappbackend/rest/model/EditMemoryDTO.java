package com.example.memoryappbackend.rest.model;
import java.util.List;

public class EditMemoryDTO {

    private Integer memoryID;
    private String googleID;
    private String memoryTitle;
    private String memoryBody;
    private List<String> tags;

    public Integer getMemoryID() {
        return memoryID;
    }
    public String getGoogleID() {
        return googleID;
    }
    public String getMemoryTitle() {
        return memoryTitle;
    }
    public String getMemoryBody() {
        return memoryBody;
    }
    public List<String> getTags() {
        return tags;
    }
}
