-- Dane startowe aplikacji. Tabele tworzy Hibernate z encji, a ten plik Spring Boot uruchamia zaraz potem.
-- LAB 01: dopiszcie tu konta wszystkich osób z zespołu (reguła R1.03).
-- LAB 02: dopiszcie dane do swoich tabel (kolejność: najpierw tabele, na które wskazują klucze obce).
insert into user_account (email, display_name, role, created_at) values
    ('s189677@student.wroclaw.merito.pl',   'Jędrzej',   'USER',    current_timestamp),
    ('wrx81890@student.wroclaw.merito.pl',  'Kornelia',  'USER',    current_timestamp),
    ('s734249@student.wroclaw.merito.pl',       'Krzysztof', 'USER', current_timestamp),
    ('admin@example.com',       'Admin', 'ADMIN',   current_timestamp);

-- LAB 01: Wasze konta (zmieńcie na swoje dane, rola USER)
-- insert into user_account (email, display_name, role, created_at) values
--     ('imie.nazwisko@student.merito.pl', 'Imię', 'USER', current_timestamp);

-- ===== LAB 02 · zone =====
insert into zone (name, region, elevation_m, area_km2, status) values
    ('Dolina Marinera', 'półkula południowa', -2000, 4000000.00, 'IN_TRANSFORMATION'),
    ('Równina Utopia',  'półkula północna',   -4000, 3300000.00, 'UNTOUCHED'),
    ('Krater Gale',     'okolice równika',    -4400, 154.00,     'IN_TRANSFORMATION');

-- ===== LAB 02 · installation =====
insert into installation (zone_id, name, type, max_power_kw, commissioned_at, status) values
    (1, 'OX-03', 'OXYGEN_GENERATOR', 1500.00, '2026-03-12', 'ACTIVE'),
    (3, 'GE-01', 'GAS_EMITTER',      2200.00, '2025-11-01', 'DEGRADED'),
    (2, 'GH-01', 'GREENHOUSE',        800.00, null,         'BUILDING');

-- ===== LAB 02 · project =====
insert into project (zone_id, manager_id, name, target_parameter, baseline_value, target_value, energy_budget_kwh, deadline, status) values
    (1, 1, 'Podniesienie ciśnienia w Dolinie Marinera do 1000 Pa', 'PRESSURE_PA',    600,   1000, 5000000.00, '2027-12-31', 'IN_PROGRESS'),
    (3, 2, 'Zwiększenie udziału O2 w Kraterze Gale do 5%',          'OXYGEN_PERCENT',   0.15,  5, 2500000.00, '2028-06-30', 'PROPOSED'),
    (2, 3, 'Ogrzanie Równiny Utopia o 10°C',                        'TEMPERATURE_C',  -63,   -53, 8000000.00, '2026-12-31', 'ABORTED');
-- ===== LAB 03 · measurement =====
-- zone_id: numer strefy, recorded_by_id: numer konta z user_account
insert into measurement (zone_id, recorded_by_id, parameter, measured_value, measured_at, is_anomaly) values
    (1, 1, 'PRESSURE_PA',    640.00, '2026-11-10 08:00:00', false),
    (3, 2, 'OXYGEN_PERCENT',   0.40, '2026-11-11 09:30:00', false),
    (2, 3, 'TEMPERATURE_C',  -80.00, '2026-11-12 03:15:00', true);

-- ===== LAB 03 · maintenance_ticket =====
-- measurement_id jest opcjonalne i unikalne (jeden-do-jednego)
insert into maintenance_ticket (installation_id, user_account_id, measurement_id, title, status, opened_at) values
    (2, 1, null, 'Spadek wydajności emitera GE-01',      'OPEN',     '2026-11-09 10:00:00'),
    (1, 2, 1,    'Wahania ciśnienia przy OX-03',         'ASSIGNED', '2026-11-10 08:30:00'),
    (3, 3, 3,    'Anomalia temperatury przy szklarni',   'RESOLVED', '2026-11-12 04:00:00');

-- ===== LAB 03 · project_installation (wiele-do-wielu: projekt <-> instalacja) =====
insert into project_installation (project_id, installation_id, allocated_power_kw, allocated_from, allocated_to, energy_used_kwh) values
    (1, 1, 1200.00, '2026-06-01 00:00:00', '2027-12-31 23:59:00', 350000.00),
    (1, 2,  900.00, '2026-06-01 00:00:00', null,                  120000.00),
    (2, 3,  500.00, '2027-01-01 00:00:00', '2028-06-30 23:59:00', null);
