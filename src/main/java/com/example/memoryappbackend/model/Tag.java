package com.example.memoryappbackend.model;

import javax.persistence.*;

@Entity
@Table(name = "t_tag")
public class Tag {

    @Id
    @Column(name = "tagID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int tagID;

    @Column(name = "tag")
    private String tag;

    @ManyToOne(optional = false)
    @JoinColumn(name = "memoryID")
    private MemoryItem memoryItem;

    public Tag(String tag) {
        this.tag = tag;
    }

    public Tag() {

    }

    public int getTagID() {
        return tagID;
    }

    public void setTagID(int tagID) {
        this.tagID = tagID;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public MemoryItem getMemoryItem() {
        return memoryItem;
    }

    public void setMemoryItem(MemoryItem memoryItem) {
        this.memoryItem = memoryItem;
    }
}
