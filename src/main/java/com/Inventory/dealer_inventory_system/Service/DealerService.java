package com.Inventory.dealer_inventory_system.Service;

import com.Inventory.dealer_inventory_system.Entity.Dealer;
import com.Inventory.dealer_inventory_system.Repository.DealerRepository;
import com.Inventory.dealer_inventory_system.config.Tenant.TenantContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class DealerService {

    @Autowired
    private DealerRepository dealerRepository;

    // CREATE
    public Dealer createDealer(Dealer dealer) {
        dealer.setTenantId(TenantContext.getTenantId());
        return dealerRepository.save(dealer);
    }

    // GET ALL
    public Page<Dealer> getAllDealers(Pageable pageable) {
        return dealerRepository.findByTenantId(
                TenantContext.getTenantId(),
                pageable
        );
    }

    // GET BY ID (NO LAMBDA)
    public Dealer getDealerById(UUID id) {

        Optional<Dealer> optional = dealerRepository.findById(id);

        if (!optional.isPresent()) {
            throw new RuntimeException("Dealer not found");
        }

        Dealer dealer = optional.get();

        if (!dealer.getTenantId().equals(TenantContext.getTenantId())) {
            throw new RuntimeException("403 Forbidden");
        }

        return dealer;
    }

    // UPDATE (PATCH)
    public Dealer updateDealer(UUID id, Dealer input) {

        Dealer dealer = getDealerById(id);

        if (input.getName() != null) {
            dealer.setName(input.getName());
        }

        if (input.getEmail() != null) {
            dealer.setEmail(input.getEmail());
        }

        if (input.getSubscriptionType() != null) {
            dealer.setSubscriptionType(input.getSubscriptionType());
        }

        return dealerRepository.save(dealer);
    }

    // DELETE
    public void deleteDealer(UUID id) {
        dealerRepository.delete(getDealerById(id));
    }
}