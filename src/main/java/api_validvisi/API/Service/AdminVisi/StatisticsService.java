package api_validvisi.API.Service.AdminVisi;

import api_validvisi.API.Repo.AdminVisi.StatisticsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticsService {

    @Autowired
    private StatisticsRepo statisticRepo;

    public Long getTotalStatistic() {
        return statisticRepo.countTotalStatistic();
    }
}
