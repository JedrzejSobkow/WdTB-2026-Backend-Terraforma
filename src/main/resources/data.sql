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
insert into installation (name, type, max_power_kw, commissioned_at, status) values
    ('OX-03', 'OXYGEN_GENERATOR', 1500.00, '2026-03-12', 'ACTIVE'),
    ('GE-01', 'GAS_EMITTER',      2200.00, '2025-11-01', 'DEGRADED'),
    ('GH-01', 'GREENHOUSE',        800.00, null,         'BUILDING');

-- ===== LAB 02 · project =====
insert into project (name, target_parameter, baseline_value, target_value, energy_budget_kwh, deadline, status) values
    ('Podniesienie ciśnienia w Dolinie Marinera do 1000 Pa', 'PRESSURE_PA',    600,   1000, 5000000.00, '2027-12-31', 'IN_PROGRESS'),
    ('Zwiększenie udziału O2 w Kraterze Gale do 5%',          'OXYGEN_PERCENT',   0.15,  5, 2500000.00, '2028-06-30', 'PROPOSED'),
    ('Ogrzanie Równiny Utopia o 10°C',                        'TEMPERATURE_C',  -63,   -53, 8000000.00, '2026-12-31', 'ABORTED');