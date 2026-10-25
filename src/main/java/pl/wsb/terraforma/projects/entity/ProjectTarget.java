package pl.wsb.terraforma.projects.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.math.BigDecimal;

@Embeddable
public class ProjectTarget {

    @Enumerated(EnumType.STRING)
    @Column(name = "target_parameter", nullable = false, length = 30)
    private TargetParameter targetParameter;

    @Column(name = "baseline_value", nullable = false, precision = 12, scale = 2)
    private BigDecimal baselineValue;

    @Column(name = "target_value", nullable = false, precision = 12, scale = 2)
    private BigDecimal targetValue;

    protected ProjectTarget() {
    }

    public ProjectTarget(TargetParameter targetParameter, BigDecimal baselineValue, BigDecimal targetValue) {
        this.targetParameter = targetParameter;
        this.baselineValue = baselineValue;
        this.targetValue = targetValue;
    }

    public TargetParameter getTargetParameter() { return targetParameter; }
    public BigDecimal getBaselineValue() { return baselineValue; }
    public BigDecimal getTargetValue() { return targetValue; }
}