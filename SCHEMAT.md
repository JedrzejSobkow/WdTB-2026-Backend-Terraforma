# Schemat bazy danych

Plik generują reguły projektu (panel Maven → Lifecycle → verify). Nie edytujcie go ręcznie.

Tabele: 7 · kolumny: 49 · relacje: 9 × @ManyToOne, 2 × @OneToMany, 1 × @OneToOne, 0 × @ManyToMany

| Tabela | Encja | Kolumny | Klucze obce |
|---|---|---|---|
| installation | Installation | 7 | zone_id |
| maintenance_ticket | MaintenanceTicket | 7 | installation_id, measurement_id, user_account_id |
| measurement | Measurement | 7 | recorded_by_id, zone_id |
| project | Project | 10 | manager_id, zone_id |
| project_installation | ProjectInstallation | 7 | installation_id, project_id |
| user_account | UserAccount | 5 | — |
| zone | Zone | 6 | — |

```mermaid
erDiagram
    installation {
        Long id PK
        LocalDate commissioned_at
        BigDecimal max_power_kw
        String name
        InstallationStatus status
        InstallationType type
        Long zone_id FK
    }
    maintenance_ticket {
        Long id PK
        Long installation_id FK
        Long measurement_id FK
        LocalDateTime opened_at
        TicketStatus status
        String title
        Long user_account_id FK
    }
    measurement {
        Long id PK
        boolean is_anomaly
        LocalDateTime measured_at
        BigDecimal measured_value
        zoneMeasurementParameter parameter
        Long recorded_by_id FK
        Long zone_id FK
    }
    project {
        Long id PK
        BigDecimal baseline_value
        LocalDate deadline
        BigDecimal energy_budget_kwh
        Long manager_id FK
        String name
        ProjectStatus status
        TargetParameter target_parameter
        BigDecimal target_value
        Long zone_id FK
    }
    project_installation {
        Long id PK
        LocalDateTime allocated_from
        BigDecimal allocated_power_kw
        LocalDateTime allocated_to
        BigDecimal energy_used_kwh
        Long installation_id FK
        Long project_id FK
    }
    user_account {
        Long id PK
        LocalDateTime created_at
        String display_name
        String email
        AccountRole role
    }
    zone {
        Long id PK
        BigDecimal area_km2
        Integer elevation_m
        String name
        String region
        ZoneStatus status
    }
    installation ||--o{ maintenance_ticket : "installation_id"
    installation ||--o{ project_installation : "installation_id"
    measurement |o--o| maintenance_ticket : "measurement_id"
    project ||--o{ project_installation : "project_id"
    user_account ||--o{ maintenance_ticket : "user_account_id"
    user_account ||--o{ measurement : "recorded_by_id"
    user_account ||--o{ project : "manager_id"
    zone ||--o{ installation : "zone_id"
    zone ||--o{ measurement : "zone_id"
    zone ||--o{ project : "zone_id"
```
