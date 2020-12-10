package com.example.memoryappbackend.bo;

import com.example.memoryappbackend.db.MemoryRepository;
import com.example.memoryappbackend.db.UserRepository;
import com.example.memoryappbackend.model.MemoryItem;
import com.example.memoryappbackend.model.Tag;
import com.example.memoryappbackend.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemoryBusinessLogic {
    private static Logger log = LoggerFactory.getLogger(MemoryBusinessLogic.class);


    @Autowired
    private MemoryRepository memoryRepository;

    @Autowired
    private UserRepository userRepository;

    public List<MemoryItem> getUserMemories(String googleID) {
         return memoryRepository.findAllByUser_GoogleID(googleID);
    }


    public void postMemory(String googleID, String memoryTitle, String memoryBody, List<String> receivedTags) {

        User user = userRepository.findByGoogleID(googleID);

        ArrayList<Tag> tags = new ArrayList<>();
        receivedTags.forEach(t -> tags.add(new Tag(t)));

        tags.stream().map(tag -> tag.getTag()).forEach(log::info);

        MemoryItem memoryItem = new MemoryItem(user, memoryTitle, memoryBody, tags);
        memoryRepository.save(memoryItem);
    }

    public void deleteMemory(int memoryID) {
        memoryRepository.deleteById(memoryID);
    }

    public void editMemory(String googleID, Integer memoryID, String memoryTitle, String memoryBody, List<String> receivedTags) {
        //Ta bort gamla
        MemoryItem oldMemory = memoryRepository.findById(memoryID).get();
        deleteMemory(oldMemory.getMemoryID());

        //Lägg till nya
        postMemory(googleID, memoryTitle, memoryBody, receivedTags);
    }


}
