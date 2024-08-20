package com.cns.demo_pms.projection;

import org.springframework.stereotype.Service;

@Service
public interface ProjectReportProjection {
    String getId();
    String getProjectname();
    String getIntroduction();

    String getOwnername();
    String getStatus();
    String getStartdate();
    String getEnddate();
    String getMembername();
}
