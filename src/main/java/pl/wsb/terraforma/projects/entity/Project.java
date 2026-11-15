package pl.wsb.terraforma.projects.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import pl.wsb.terraforma.account.domain.UserAccount;
import pl.wsb.terraforma.territory.entity.Zone;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "zone_id", nullable = false)
    private Zone zone;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "manager_id", nullable = false)
    private UserAccount manager;

    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @Embedded
    private ProjectTarget target;

    @Column(name = "energy_budget_kwh", nullable = false, precision = 14, scale = 2)
    private BigDecimal energyBudgetKwh;

    @Column(name = "deadline")
    private LocalDate deadline;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 30)
    private ProjectStatus status;

    protected Project() {
    }

    public Project(Zone zone, UserAccount manager, String name, ProjectTarget target, BigDecimal energyBudgetKwh,
                   LocalDate deadline, ProjectStatus status) {
        this.zone = zone;
        this.manager = manager;
        this.name = name;
        this.target = target;
        this.energyBudgetKwh = energyBudgetKwh;
        this.deadline = deadline;
        this.status = status;
    }

    public Long getId() { return id; }
    public Zone getZone() { return zone; }
    public UserAccount getManager() { return manager; }
    public String getName() { return name; }
    public ProjectTarget getTarget() { return target; }
    public BigDecimal getEnergyBudgetKwh() { return energyBudgetKwh; }
    public LocalDate getDeadline() { return deadline; }
    public ProjectStatus getStatus() { return status; }
}