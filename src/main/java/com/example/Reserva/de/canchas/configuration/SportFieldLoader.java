package com.example.Reserva.de.canchas.configuration;

import com.example.Reserva.de.canchas.entity.domain.Sport;
import com.example.Reserva.de.canchas.entity.domain.SportField;
import com.example.Reserva.de.canchas.repository.ISportFieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SportFieldLoader implements ApplicationRunner {
    @Autowired
    private ISportFieldRepository sportFieldRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String footballFieldName = "dalmine";

        SportField footballfield = SportField.builder()
                .name("dalmine")
                .sport(Sport.FOOTBALL)
                .availability(Map.of("10:00", true, "11:00", false, "12:00", true))
                .build();

        if (sportFieldRepository.findByName(footballFieldName).isEmpty()) {
            sportFieldRepository.save(footballfield);
        }

        String footballFieldName2 = "club atletico vcp";

        SportField footballfield2 = SportField.builder()
                .name(footballFieldName2)
                .sport(Sport.FOOTBALL)
                .availability(Map.of("13:00", true, "14:00", true, "15:00", true))
                .build();

        if (sportFieldRepository.findByName(footballFieldName2).isEmpty()) {
            sportFieldRepository.save(footballfield2);
        }


        String tennisFieldName = "nalbandian";
        SportField tennisfield = SportField.builder()
                .name("nalbandian")
                .sport(Sport.TENNIS)
                .availability(Map.of("10:00", true, "11:00", false, "12:00", true))
                .build();
        if(sportFieldRepository.findByName(tennisFieldName).isEmpty()){
            sportFieldRepository.save(tennisfield);
        }
    }
}
