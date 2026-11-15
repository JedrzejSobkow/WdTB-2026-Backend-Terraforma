package pl.wsb.terraforma.territory.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import pl.wsb.terraforma.infrastructure.entity.Installation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "zone")
public class Zone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true, length = 80)
    private String name;

    @Column(name = "region", nullable = false, length = 80)
    private String region;

    @Column(name = "elevation_m")
    private Integer elevationM;

    @Column(name = "area_km2", precision = 12, scale = 2)
    private BigDecimal areaKm2;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 30)
    private ZoneStatus status;

    @OneToMany(mappedBy = "zone")
    private List<Installation> installations = new ArrayList<>();

    protected Zone() {
    }

    public Zone(String name, String region, Integer elevationM, BigDecimal areaKm2, ZoneStatus status) {
        this.name = name;
        this.region = region;
        this.elevationM = elevationM;
        this.areaKm2 = areaKm2;
        this.status = status;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getRegion() { return region; }
    public Integer getElevationM() { return elevationM; }
    public BigDecimal getAreaKm2() { return areaKm2; }
    public ZoneStatus getStatus() { return status; }
    public List<Installation> getInstallations() { return installations; }
}