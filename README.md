# Multi-Tenant-Inventory-Module

Goal

Build a multi-tenant Inventory module inside a Modular Monolith application that manages dealers and their vehicles.

The module must be designed using clean architecture principles and should clearly separate responsibilities such as controller, service, domain/entity, repository, validation, and security/tenant enforcement.

Data Model
Dealer

id (UUID)

tenant_id

name

email

subscriptionType ∈ {BASIC, PREMIUM}

Vehicle

id (UUID)

tenant_id

dealerId (FK)

model

price (decimal)

status ∈ {AVAILABLE, SOLD}

Required Endpoints
Dealers

POST /dealers

GET /dealers/{id}

GET /dealers (pagination/sort)

PATCH /dealers/{id}

DELETE /dealers/{id}

Vehicles

POST /vehicles

GET /vehicles/{id}

GET /vehicles
Filters:

model

status

priceMin

priceMax
Also support pagination/sort

PATCH /vehicles/{id}

DELETE /vehicles/{id}

Query

GET /vehicles?subscription=PREMIUM
Return vehicles whose dealer has subscriptionType=PREMIUM while still remaining tenant-scoped.

Admin (GLOBAL_ADMIN only)

GET /admin/dealers/countBySubscription
Expected response:

{ "BASIC": n, "PREMIUM": n }

Document whether this count is per-tenant or overall.

Acceptance Checks

Missing X-Tenant-Id → 400

Cross-tenant access blocked → 403

subscription=PREMIUM only returns vehicles for PREMIUM dealers within the caller’s tenant

Admin counts endpoint requires GLOBAL_ADMIN
