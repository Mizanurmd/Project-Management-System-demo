package com.cns.demo_pms.controllers;

import com.cns.demo_pms.entities.Project;
import com.cns.demo_pms.services.ProjectService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/projects")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProjectController {
    @Autowired
    private ProjectService proServ;
    @GetMapping("/{id}")
    public ResponseEntity<Project>getProjectById(@PathVariable("id") Long id){
        System.out.println("Project Id is  =============="+ id);
         Project project = proServ.getProjectById(id);
         return  new ResponseEntity<Project>(project, HttpStatus.OK);
     }

     @GetMapping("/all")
     public ResponseEntity<List<Project>>getAllProjects(){
        List<Project> projectList = proServ.getAllProjects();
         System.out.println("Project save =============="+ projectList);
        return new ResponseEntity<List<Project>>(projectList, HttpStatus.OK);
     }

     @PostMapping("/save")
     public ResponseEntity<Project>saveProject(@RequestBody Project project){
        System.out.println("Project save =============="+ project);
        Project saveProject = proServ.createProject(project);
        return  new ResponseEntity<Project>(saveProject, HttpStatus.CREATED);
     }

     @PutMapping("/update/{id}")
     public ResponseEntity<Project>updateProject(@PathVariable("id")Long id, @RequestBody Project project){
        Project updateProject = proServ.updateProject(id,project);
        System.out.println("Update Project=============="+ updateProject(id, project));
        return new ResponseEntity<>(updateProject, HttpStatus.OK);
     }
    @DeleteMapping("/{id}")
     public ResponseEntity<Void>deleteProject(@PathVariable("id")Long id){
        System.out.println("==================="+ id);
         proServ.deleteProject(id);
         return ResponseEntity.noContent().build();
     }


}
