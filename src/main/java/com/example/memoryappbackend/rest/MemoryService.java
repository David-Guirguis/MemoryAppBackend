package com.example.memoryappbackend.rest;
import com.example.memoryappbackend.bo.MemoryBusinessLogic;
import com.example.memoryappbackend.model.MemoryItem;
import com.example.memoryappbackend.rest.model.EditMemoryDTO;
import com.example.memoryappbackend.rest.model.MemoryItemDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("MemoryService")
public class MemoryService {

   private final static Logger log = LoggerFactory.getLogger(MemoryService.class);

    @Autowired
    private MemoryBusinessLogic memoryBusinessLogic;

    @GetMapping("/getUserMemories")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<MemoryItem> getUserMemories(@RequestParam String googleID) {
        return memoryBusinessLogic.getUserMemories(googleID);
    }

    @PostMapping("/postMemory")
    public void postMemory(@RequestBody MemoryItemDTO mDTO) {
        memoryBusinessLogic.postMemory(mDTO.getGoogleID(), mDTO.getMemoryTitle(), mDTO.getMemoryBody(), mDTO.getTags());
    }

    @PostMapping("/deleteMemory")
    public void deleteMemory(@RequestBody int memoryID) {
        memoryBusinessLogic.deleteMemory(memoryID);
    }

    @PostMapping("/editMemory")
    public void editMemory(@RequestBody EditMemoryDTO mDTO) {
        memoryBusinessLogic.editMemory(mDTO.getGoogleID(), mDTO.getMemoryID(), mDTO.getMemoryTitle(), mDTO.getMemoryBody(), mDTO.getTags());
    }
}
