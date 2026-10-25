package pl.wsb.terraforma.projects.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    public Project(String name, ProjectTarget target, BigDecimal energyBudgetKwh,
                   LocalDate deadline, ProjectStatus status) {
        this.name = name;
        this.target = target;
        this.energyBudgetKwh = energyBudgetKwh;
        this.deadline = deadline;
        this.status = status;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public ProjectTarget getTarget() { return target; }
    public BigDecimal getEnergyBudgetKwh() { return energyBudgetKwh; }
    public LocalDate getDeadline() { return deadline; }
    public ProjectStatus getStatus() { return status; }
}