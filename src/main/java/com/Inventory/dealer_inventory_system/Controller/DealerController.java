package com.Inventory.dealer_inventory_system.Controller;

import com.Inventory.dealer_inventory_system.Entity.Dealer;
import com.Inventory.dealer_inventory_system.Service.DealerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/dealers")
public class DealerController {

    @Autowired
    private DealerService dealerService;

    // CREATE
    @PostMapping
    public Dealer createDealer(@RequestBody Dealer dealer) {
        return dealerService.createDealer(dealer);
    }

    // GET ALL (Pagination)
    @GetMapping
    public Page<Dealer> getAllDealers(Pageable pageable) {
        return dealerService.getAllDealers(pageable);
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Dealer getDealer(@PathVariable UUID id) {
        return dealerService.getDealerById(id);
    }

    // PATCH UPDATE
    @PatchMapping("/{id}")
    public Dealer updateDealer(@PathVariable UUID id,
                               @RequestBody Dealer dealer) {
        return dealerService.updateDealer(id, dealer);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteDealer(@PathVariable UUID id) {
        dealerService.deleteDealer(id);
    }
}