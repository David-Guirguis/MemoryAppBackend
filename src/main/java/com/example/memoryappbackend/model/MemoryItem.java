package com.example.memoryappbackend.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_memory")
public class MemoryItem {

    @Id
    @Column(name = "memoryID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int memoryID;

    @OneToOne
    @JoinColumn(name = "userID")
    private User user;

    @Column(name = "memorytitle")
    private String memoryTitle;

    @Column(name = "memorybody")
    private String memoryBody;

    @OneToMany(mappedBy = "memoryItem", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("memoryItem")
    private List<Tag> tags;

    public MemoryItem(User user, String memoryTitle, String memoryBody, ArrayList<Tag> tags) {
        this.user = user;
        this.memoryTitle = memoryTitle;
        this.memoryBody = memoryBody;
        this.tags = tags;
        this.tags.forEach(tag -> tag.setMemoryItem(this));
    }

    public MemoryItem() {}

    public int getMemoryID() {
        return memoryID;
    }
    public void setMemoryID(int memoryID) {
        this.memoryID = memoryID;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public String getMemoryTitle() {
        return memoryTitle;
    }
    public void setMemoryTitle(String memoryTitle) {
        this.memoryTitle = memoryTitle;
    }
    public String getMemoryBody() {
        return memoryBody;
    }
    public void setMemoryBody(String memoryBody) {
        this.memoryBody = memoryBody;
    }
    public List<Tag> getTags() {
        return tags;
    }

    public void setTag(List<Tag> tags) {
        this.tags = tags;
        if(tags != null)
            tags.forEach(tag -> tag.setMemoryItem(this));
    }

}
