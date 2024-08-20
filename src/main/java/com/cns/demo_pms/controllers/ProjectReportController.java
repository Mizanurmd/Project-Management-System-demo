package com.cns.demo_pms.controllers;

import com.cns.demo_pms.services.ProjectReportService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
@RequestMapping("/api/v1/reports")
public class ProjectReportController {
    private final ProjectReportService proReportserv;

    public ProjectReportController(ProjectReportService proReportserv) {
        this.proReportserv = proReportserv;
    }

    @GetMapping("/{format}")
    public String generateReport(@PathVariable String format) throws FileNotFoundException, JRException {
        System.out.println("Pdf is generated-------------------------------");
        return proReportserv.exportReport(format);

    }


}
