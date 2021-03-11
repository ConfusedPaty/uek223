package ch.noser.uek223.domain.purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/purchases")
public class PurchaseWeb {

    private PurchaseService purchaseService;

    @Autowired
    public PurchaseWeb(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }
}
