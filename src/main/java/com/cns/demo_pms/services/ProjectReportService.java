package com.cns.demo_pms.services;

import com.cns.demo_pms.entities.Project;
import com.cns.demo_pms.projection.ProjectReportProjection;
import com.cns.demo_pms.repository.ProjectRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProjectReportService {


    private final ProjectRepository proRepo;

    public ProjectReportService(ProjectRepository proRepo) {
        this.proRepo = proRepo;
    }

    public String exportReport(String reportFromat) throws FileNotFoundException, JRException {


        String path = "C:\\Users\\DELL-PC\\Desktop\\Report";
        List<ProjectReportProjection> pa = proRepo.findProjectReport();
        pa.stream().forEach(projectReportProjection -> {
            System.out.println(projectReportProjection.getProjectname());
        });
        // load file and compile
        File file = ResourceUtils.getFile("classpath:Project_Report.jrxml");

        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(pa);

        System.err.println("before parameter passing...........");
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("Createdby", "MD.Mizanur Rahman");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, dataSource);

        if (reportFromat.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\Project_Report.html");
        }

        if (reportFromat.equalsIgnoreCase("pdf")) {

            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\Project_Report.pdf");

        }

        return "Report generated in the path : " + path;
    }

}
