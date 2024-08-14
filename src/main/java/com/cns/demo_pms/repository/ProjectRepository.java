package com.cns.demo_pms.repository;

import com.cns.demo_pms.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
