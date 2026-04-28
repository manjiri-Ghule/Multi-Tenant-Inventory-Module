package com.Inventory.dealer_inventory_system.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Inventory.dealer_inventory_system.Entity.SubscriptionType;
import com.Inventory.dealer_inventory_system.Repository.DealerRepository;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private DealerRepository repo;

    @GetMapping("/dealers/countBySubscription")
    public Map<String, Long> count() {
        return Map.of(
            "BASIC", repo.countBySubscriptionType(SubscriptionType.BASIC),
            "PREMIUM", repo.countBySubscriptionType(SubscriptionType.PREMIUM)
        );
    }
}
