package com.cns.demo_pms.repository;

import com.cns.demo_pms.entities.Project;
import com.cns.demo_pms.projection.ProjectReportProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    @Query(value = "SELECT CAST(p.id AS VARCHAR(20)) AS id, " +
            "p.name AS projectName, " +
            "p.intro AS introduction, " +
            "u.username AS ownerName, " +
            "p.status AS status, " +
            "p.start_date_time AS startDate, " +
            "p.end_date_time AS endDate, " +
            "um.username AS memberName " +
            "FROM project p " +
            "LEFT JOIN project_members pm ON p.id = pm.project_id " +
            "INNER JOIN users u ON p.owner_id = u.id " +
            "LEFT JOIN users um ON pm.user_id = um.id " +
            "ORDER BY p.id", nativeQuery = true)
    List<ProjectReportProjection> findProjectReport();
}
