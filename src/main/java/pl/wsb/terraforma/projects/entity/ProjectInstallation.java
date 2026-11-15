package pl.wsb.terraforma.projects.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import pl.wsb.terraforma.infrastructure.entity.Installation;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/** **/
@Entity
@Table(name = "project_installation")
public class ProjectInstallation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "installation_id", nullable = false)
    private Installation installation;

    @Column(name = "allocated_power_kw", nullable = false, precision = 10, scale = 2)
    private BigDecimal allocatedPowerKw;

    @Column(name = "allocated_from", nullable = false)
    private LocalDateTime allocatedFrom;

    @Column(name = "allocated_to")
    private LocalDateTime allocatedTo;

    @Column(name = "energy_used_kwh", precision = 14, scale = 2)
    private BigDecimal energyUsedKwh;

    protected ProjectInstallation() {
    }

    public ProjectInstallation(Project project, Installation installation, BigDecimal allocatedPowerKw,
                               LocalDateTime allocatedFrom, LocalDateTime allocatedTo, BigDecimal energyUsedKwh) {
        this.project = project;
        this.installation = installation;
        this.allocatedPowerKw = allocatedPowerKw;
        this.allocatedFrom = allocatedFrom;
        this.allocatedTo = allocatedTo;
        this.energyUsedKwh = energyUsedKwh;
    }

    public Long getId() { return id; }
    public Project getProject() { return project; }
    public Installation getInstallation() { return installation; }
    public BigDecimal getAllocatedPowerKw() { return allocatedPowerKw; }
    public LocalDateTime getAllocatedFrom() { return allocatedFrom; }
    public LocalDateTime getAllocatedTo() { return allocatedTo; }
    public BigDecimal getEnergyUsedKwh() { return energyUsedKwh; }
}
