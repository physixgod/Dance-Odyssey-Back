package devnatic.danceodyssey.Schedular;

import devnatic.danceodyssey.DAO.Entities.Dancer;
import devnatic.danceodyssey.DAO.Repositories.DancerRepository;
import devnatic.danceodyssey.Services.CompetitionIServices;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
@Slf4j
public class UpdateEventsStatus {
    DancerRepository dancerRepository;
    CompetitionIServices competitionIServices;
    @Scheduled(fixedRate = 10000)
    public void updateCompetitionStatus(){
        competitionIServices.autoCloseCompetition();
    }
    @Scheduled(cron = "0 0 0 * * *")
    public void updateMiniGame(){
        List<Dancer> dancers=dancerRepository.findAll();
        for (Dancer d:dancers){
                d.setGameplayed(false);
        }
    }
}
