package com.Inventory.dealer_inventory_system.Controller;

import com.Inventory.dealer_inventory_system.Entity.Vehicle;
import com.Inventory.dealer_inventory_system.Entity.VehicleStatus;
import com.Inventory.dealer_inventory_system.Service.VehicleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    // CREATE VEHICLE
    @PostMapping
    public Vehicle createVehicle(@RequestBody Vehicle vehicle,
                                 @RequestParam UUID dealerId) {
        return vehicleService.createVehicle(vehicle, dealerId);
    }

    // FILTER + PAGINATION
    @GetMapping
    public Page<Vehicle> filterVehicles(
            @RequestParam(required = false) String model,
            @RequestParam(required = false) VehicleStatus status,
            @RequestParam(required = false) BigDecimal priceMin,
            @RequestParam(required = false) BigDecimal priceMax,
            Pageable pageable
    ) {
        return vehicleService.filterVehicles(
                model,
                status,
                priceMin,
                priceMax,
                pageable
        );
    }

    // PREMIUM VEHICLES
    @GetMapping(params = "subscription")
    public List<Vehicle> getPremiumVehicles() {
        return vehicleService.getPremiumVehicles();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Vehicle getVehicle(@PathVariable UUID id) {
        return vehicleService.getVehicleById(id);
    }

    // PATCH UPDATE
    @PatchMapping("/{id}")
    public Vehicle updateVehicle(@PathVariable UUID id,
                                 @RequestBody Vehicle vehicle) {
        return vehicleService.updateVehicle(id, vehicle);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteVehicle(@PathVariable UUID id) {
        vehicleService.deleteVehicle(id);
    }
}