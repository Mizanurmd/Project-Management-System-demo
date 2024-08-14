package com.cns.demo_pms.services;

import com.cns.demo_pms.entities.Project;

import java.util.List;

public interface ProjectService {
    Project getProjectById(Long id);
    List<Project> getAllProjects();
    Project createProject(Project project);
    Project updateProject(Long id, Project project);
    void deleteProject(Long id);
}
