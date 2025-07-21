package net.engineeringdigest.journalApp.cache;

import net.engineeringdigest.journalApp.Repository.ConfigJournalAppRepository;
import net.engineeringdigest.journalApp.entity.ConfigJournalAppEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Component
public class AppCache {
    public enum keys{
        WEATHER_API
    }
    @Autowired
    private ConfigJournalAppRepository configJournalAppRepository;
    public Map<String,String> App_Cache;

    @PostConstruct
    public void init(){
        App_Cache=new HashMap<>();
        List<ConfigJournalAppEntity> all =configJournalAppRepository.findAll();
        for(ConfigJournalAppEntity configJournalAppEntity:all){
            App_Cache.put(configJournalAppEntity.getKey(),configJournalAppEntity.getValue());

        }

    }
}
