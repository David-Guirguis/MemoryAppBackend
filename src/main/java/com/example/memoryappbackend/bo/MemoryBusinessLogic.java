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

    @Autowired
    private MemoryRepository memoryRepository;

    @Autowired
    private UserRepository userRepository;

    public List<MemoryItem> getUserMemories(String googleID) {
         return memoryRepository.findAllByUser_GoogleID(googleID);
    }

    public void postMemory(String googleID, String memoryTitle, String memoryBody, List<String> memoryTags) {
        User user = userRepository.findByGoogleID(googleID);

        ArrayList<Tag> tags = new ArrayList<>();
        memoryTags.forEach(t -> tags.add(new Tag(t)));

        MemoryItem memoryItem = new MemoryItem(user, memoryTitle, memoryBody, tags);
        memoryRepository.save(memoryItem);
    }

    public void deleteMemory(int memoryID) {
        memoryRepository.deleteById(memoryID);
    }

    public void editMemory(String googleID, Integer memoryID, String memoryTitle, String memoryBody, List<String> memoryTags) {
        MemoryItem oldMemory = memoryRepository.findById(memoryID).get();
        deleteMemory(oldMemory.getMemoryID());
        postMemory(googleID, memoryTitle, memoryBody, memoryTags);
    }
}
