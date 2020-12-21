package com.example.memoryappbackend.bo;
import com.example.memoryappbackend.dao.MemoryRepository;
import com.example.memoryappbackend.dao.UserRepository;
import com.example.memoryappbackend.model.MemoryItem;
import com.example.memoryappbackend.model.Tag;
import com.example.memoryappbackend.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemoryBusinessLogic {
    private static final Logger log = LoggerFactory.getLogger(MemoryBusinessLogic.class);

    //Inject an instance of MemoryRepository here
    @Autowired
    private MemoryRepository memoryRepository;

    //Inject an instance of UserRepository here
    @Autowired
    private UserRepository userRepository;

    //Returns all memories from specific user
    public List<MemoryItem> getUserMemories(String googleID) {
         return memoryRepository.findAllByUser_GoogleID(googleID);
    }

    //Posts a memory to the database
    public void postMemory(String googleID, String memoryTitle, String memoryBody, List<String> memoryTags) {
        User user = userRepository.findByGoogleID(googleID);

        ArrayList<Tag> tags = new ArrayList<>();
        memoryTags.forEach(t -> tags.add(new Tag(t)));

        MemoryItem memoryItem = new MemoryItem(user, memoryTitle, memoryBody, tags);
        memoryRepository.save(memoryItem);
    }

    //Deletes memory from database
    public void deleteMemory(int memoryID) {
        memoryRepository.deleteById(memoryID);
    }

    //Edits existing memory in database
    public void editMemory(String googleID, Integer memoryID, String memoryTitle, String memoryBody, List<String> memoryTags) {
        MemoryItem oldMemory = memoryRepository.findById(memoryID).get();
        deleteMemory(oldMemory.getMemoryID());
        postMemory(googleID, memoryTitle, memoryBody, memoryTags);
    }
}
