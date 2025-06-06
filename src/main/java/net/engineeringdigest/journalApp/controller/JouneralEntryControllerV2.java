package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JouneralEntryControllerV2 {


    @GetMapping
    public List<JournalEntry> getAll(){
        return null;
    }
    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry ){
        return true;
    }
    @GetMapping("id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable Long myId){
        return null;
    }
    @DeleteMapping("id/{myId}")
    public JournalEntry deleteJournalEntryById(@PathVariable Long myId){
        return null;
    }
    @PutMapping("/id/{Id}")
    public JournalEntry updateJournalEntryById(@PathVariable Long Id ,@RequestBody JournalEntry myEntry){
        return null;
    }


}
