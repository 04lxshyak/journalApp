package net.engineeringdigest.journalApp.api.response;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class weatherResponse {

    private Current current;


    @Getter
    @Setter
    public class Current{
        private int temperature;
        @JsonProperty
        private ArrayList<String> weather_descriptions;

        private int feelslike;

    }

}


