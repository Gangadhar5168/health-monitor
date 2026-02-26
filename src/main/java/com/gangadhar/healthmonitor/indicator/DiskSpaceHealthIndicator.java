package com.gangadhar.healthmonitor.indicator;

import com.gangadhar.healthmonitor.model.HealthStatus;

import java.io.File;

public class DiskSpaceHealthIndicator implements HealthIndicator{
    public static final String COMPONENT_NAME = "Disk Space";
    public static final double THRESHOLD_PERCENT = 85.0;


    @Override
    public HealthStatus check() {

        File root = new File("/");
        long totalSpace = root.getTotalSpace();
        long freeSpace = root.getFreeSpace();
        long usedSpace = totalSpace - freeSpace;

        double usedPercentage = (double) usedSpace/totalSpace * 100;
        String message = String.format("Used : %.2f%%" , usedPercentage);
        if(usedPercentage > THRESHOLD_PERCENT){
            return new HealthStatus(COMPONENT_NAME,"DOWN",message);
        }
        else{
            return new HealthStatus(COMPONENT_NAME,"UP",message);
        }
    }
}
