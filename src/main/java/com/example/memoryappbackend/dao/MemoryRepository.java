package com.example.memoryappbackend.dao;
import com.example.memoryappbackend.model.MemoryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MemoryRepository extends JpaRepository<MemoryItem, Integer> {

    List<MemoryItem> findAllByUser_GoogleID(String googleID);
}
