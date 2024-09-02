package api_validvisi.API.Service.AdminVisi;

import api_validvisi.API.Repo.AdminVisi.ValidRecordsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidRecordsService {

    @Autowired
    private ValidRecordsRepo validRecordsRepo;

    public Long getTotalValidRecords() {
        return validRecordsRepo.countTotalValidRecords();
    }
}
