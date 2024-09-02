package api_validvisi.API.Service.AdminVisi;

import api_validvisi.API.Repo.AdminVisi.BillingDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class BillingDetailService {

    private static final Logger logger = LoggerFactory.getLogger(BillingDetailService.class);

    @Autowired
    private BillingDetailRepo billingDetailRepo;

    public Double getTotalTrxTotal() {
        String status = "d3c50344-e690-4733-b832-bd9145bd21af"; // Status fixed in code
        return billingDetailRepo.getTotalTrxTotalByStatus(status);
    }
}
