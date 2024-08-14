package com.cns.demo_pms.seviceImpl;

import com.cns.demo_pms.entities.Project;
import com.cns.demo_pms.repository.ProjectRepository;
import com.cns.demo_pms.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository proRepo;
    @Override
    public Project getProjectById(Long id) {
        return proRepo.findById(id).orElseThrow(()->new RuntimeException("Project id is not found : " +id));
    }

    @Override
    public List<Project> getAllProjects() {
        return proRepo.findAll();
    }

    @Override
    public Project createProject(Project project) {

        return proRepo.save(project);
    }

    @Override
    public Project updateProject(Long id, Project project) {
        Project existingProject = getProjectById(id);
        existingProject.setName(project.getName());
        existingProject.setIntro(project.getIntro());
        existingProject.setOwner(project.getOwner());
        existingProject.setStatus(project.getStatus());
        existingProject.setStartDateTime(project.getStartDateTime());
        existingProject.setEndDateTime(project.getEndDateTime());
        existingProject.setMembers(project.getMembers());
        return proRepo.save(existingProject);
    }

    @Override
    public void deleteProject(Long id) {
       Project proId = getProjectById(id);
       proRepo.delete(proId);
    }
}
