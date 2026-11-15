package pl.wsb.terraforma.projects.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wsb.terraforma.projects.entity.Project;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    List<Project> findByZone_Name(String zoneName);
}
