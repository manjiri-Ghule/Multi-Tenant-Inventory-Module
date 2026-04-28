package com.Inventory.dealer_inventory_system.Repository;

import com.Inventory.dealer_inventory_system.Entity.Vehicle;
import com.Inventory.dealer_inventory_system.Entity.VehicleStatus;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface VehicleRepository extends JpaRepository<Vehicle, UUID> {

    // ✅ FILTER (MATCHES SERVICE)
    @Query("""
        SELECT v FROM Vehicle v
        WHERE v.tenantId = :tenantId
        AND (:model IS NULL OR v.model = :model)
        AND (:status IS NULL OR v.status = :status)
        AND (:min IS NULL OR v.price >= :min)
        AND (:max IS NULL OR v.price <= :max)
    """)
    Page<Vehicle> filter(
            String tenantId,
            String model,
            VehicleStatus status,
            BigDecimal min,
            BigDecimal max,
            Pageable pageable
    );

    // ✅ PREMIUM VEHICLES (MATCHES SERVICE)
    @Query("""
        SELECT v FROM Vehicle v
        JOIN v.dealer d
        WHERE v.tenantId = :tenantId
        AND d.subscriptionType = 'PREMIUM'
    """)
    List<Vehicle> premiumVehicles(String tenantId);
}