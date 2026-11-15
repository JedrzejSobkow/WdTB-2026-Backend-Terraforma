package pl.wsb.terraforma.infrastructure.entity;

import jakarta.persistence.Column;
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

import pl.wsb.terraforma.territory.entity.Zone;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "installation")
public class Installation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "zone_id", nullable = false)
    private Zone zone;

    @Column(name = "name", nullable = false, unique = true, length = 40)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false, length = 30)
    private InstallationType type;

    @Column(name = "max_power_kw", nullable = false, precision = 10, scale = 2)
    private BigDecimal maxPowerKw;

    @Column(name = "commissioned_at")
    private LocalDate commissionedAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 30)
    private InstallationStatus status;

    protected Installation() {
    }

    public Installation(Zone zone, String name, InstallationType type, BigDecimal maxPowerKw,
                        LocalDate commissionedAt, InstallationStatus status) {
        this.zone = zone;
        this.name = name;
        this.type = type;
        this.maxPowerKw = maxPowerKw;
        this.commissionedAt = commissionedAt;
        this.status = status;
    }

    public Long getId() { return id; }
    public Zone getZone() { return zone; }
    public String getName() { return name; }
    public InstallationType getType() { return type; }
    public BigDecimal getMaxPowerKw() { return maxPowerKw; }
    public LocalDate getCommissionedAt() { return commissionedAt; }
    public InstallationStatus getStatus() { return status; }
}