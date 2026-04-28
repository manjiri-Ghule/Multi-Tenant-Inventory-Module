package com.Inventory.dealer_inventory_system.Entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class Dealer {

    @Id
    @GeneratedValue
    private UUID id;

    private String tenantId;
    private String name;
    private String email;

    @Enumerated(EnumType.STRING)
    private SubscriptionType subscriptionType;

    // getters & setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getTenantId() { return tenantId; }
    public void setTenantId(String tenantId) { this.tenantId = tenantId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public SubscriptionType getSubscriptionType() { return subscriptionType; }
    public void setSubscriptionType(SubscriptionType subscriptionType) {
        this.subscriptionType = subscriptionType;
    }
}