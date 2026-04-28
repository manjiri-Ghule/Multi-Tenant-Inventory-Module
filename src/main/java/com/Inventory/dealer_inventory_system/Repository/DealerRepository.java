package com.Inventory.dealer_inventory_system.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

import com.Inventory.dealer_inventory_system.Entity.Dealer;
import com.Inventory.dealer_inventory_system.Entity.SubscriptionType;

public interface DealerRepository extends JpaRepository<Dealer, UUID> {

    // Tenant-based pagination
    Page<Dealer> findByTenantId(String tenantId, Pageable pageable);

    // Admin count
    long countBySubscriptionType(SubscriptionType type);
}