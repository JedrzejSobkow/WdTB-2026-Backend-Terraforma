package pl.wsb.terraforma.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wsb.terraforma.infrastructure.entity.Installation;

import java.util.List;

public interface InstallationRepository extends JpaRepository<Installation, Long> {

    List<Installation> findByZone_Name(String zoneName);
}
