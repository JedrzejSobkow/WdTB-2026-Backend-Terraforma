package pl.wsb.terraforma.infrastructure.entity;

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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import pl.wsb.terraforma.account.domain.UserAccount;
import pl.wsb.terraforma.territory.entity.Measurement;

import java.time.LocalDateTime;

/** Service ticket for maintanence 1-1 relation (one ticket is connected with one issuer, installation_id and measurement_id). **/
@Entity
@Table(name = "maintenance_ticket")
public class MaintenanceTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "installation_id", nullable = false)
    private Installation installation;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_account_id", nullable = false)
    private UserAccount reportedBy;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "measurement_id", unique = true)
    private Measurement measurement;

    @Column(name = "title", nullable = false, length = 120)
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 30)
    private TicketStatus status;

    @Column(name = "opened_at", nullable = false)
    private LocalDateTime openedAt;

    protected MaintenanceTicket() {
    }

    public MaintenanceTicket(Installation installation, UserAccount reportedBy, Measurement measurement,
                             String title, TicketStatus status, LocalDateTime openedAt) {
        this.installation = installation;
        this.reportedBy = reportedBy;
        this.measurement = measurement;
        this.title = title;
        this.status = status;
        this.openedAt = openedAt;
    }

    public Long getId() { return id; }
    public Installation getInstallation() { return installation; }
    public UserAccount getReportedBy() { return reportedBy; }
    public Measurement getMeasurement() { return measurement; }
    public String getTitle() { return title; }
    public TicketStatus getStatus() { return status; }
    public LocalDateTime getOpenedAt() { return openedAt; }
}
