package com.gangadhar.healthmonitor.indicator;

import com.gangadhar.healthmonitor.model.HealthStatus;

import java.io.File;

public class FileJobHealthIndicator implements HealthIndicator{
    public static final String COMPONENT_NAME = "Daily batch Job";
    public static final String FILE_PATH = "job-status.txt";

    @Override
    public HealthStatus check() {

        File file = new File(FILE_PATH);
        if (file.exists()){
            return new HealthStatus(COMPONENT_NAME,"UP","Job output file found");
        }
        else {
            return new HealthStatus(COMPONENT_NAME,"DOWN","Job output file not found");
        }
    }
}
