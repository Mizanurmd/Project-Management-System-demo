package com.cns.demo_pms.entities;

public enum ProjectStatus {
    PRE(0), START(1), END(2),
    ;
    private final int statusCode;

    ProjectStatus(int statusCode){
        this.statusCode=statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }

    //==== create a method for get status value
    public static ProjectStatus projectFormCode(int statusCode){
        for(ProjectStatus status:values()){
            if(status.statusCode == statusCode){
                return  status;
            }
        }
        throw new IllegalArgumentException("Invalid status code: " + statusCode);
    }


}
