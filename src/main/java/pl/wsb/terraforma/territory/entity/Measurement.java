package pl.wsb.terraforma.territory.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import pl.wsb.terraforma.account.domain.UserAccount;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/** Measurement that has been taken M:1 relation. **/
@Entity
@Table(name = "measurement")
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "zone_id", nullable = false) //a measurement can be in only in one zone but zone can have multiple measurements
    private Zone zone;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "recorded_by_id", nullable = false) //a measurement can be connected to one id but user can have multiple measurements
    private UserAccount recordedBy;

    @Enumerated(EnumType.STRING)
    @Column(name = "parameter", nullable = false, length = 30)
    private zoneMeasurementParameter parameter;

    @Column(name = "measured_value", nullable = false, precision = 12, scale = 2)
    private BigDecimal measuredValue;

    @Column(name = "measured_at", nullable = false)
    private LocalDateTime measuredAt;

    @Column(name = "is_anomaly", nullable = false)
    private boolean anomaly;

    protected Measurement() {
    }

    public Measurement(Zone zone, UserAccount recordedBy, zoneMeasurementParameter parameter,
                       BigDecimal measuredValue, LocalDateTime measuredAt, boolean anomaly) {
        this.zone = zone;
        this.recordedBy = recordedBy;
        this.parameter = parameter;
        this.measuredValue = measuredValue;
        this.measuredAt = measuredAt;
        this.anomaly = anomaly;
    }

    public Long getId() { return id; }
    public Zone getZone() { return zone; }
    public UserAccount getRecordedBy() { return recordedBy; }
    public zoneMeasurementParameter getParameter() { return parameter; }
    public BigDecimal getMeasuredValue() { return measuredValue; }
    public LocalDateTime getMeasuredAt() { return measuredAt; }
    public boolean isAnomaly() { return anomaly; }
}
