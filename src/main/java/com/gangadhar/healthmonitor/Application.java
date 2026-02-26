package com.gangadhar.healthmonitor;

import com.gangadhar.healthmonitor.indicator.DiskSpaceHealthIndicator;
import com.gangadhar.healthmonitor.indicator.InternetHealthIndicator;
import com.gangadhar.healthmonitor.indicator.MemoryHealthIndicator;
import com.gangadhar.healthmonitor.model.HealthStatus;
import com.gangadhar.healthmonitor.service.HealthCheckService;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args){
        HealthCheckService service = new HealthCheckService();

        service.addIndicator(new InternetHealthIndicator());
        service.addIndicator(new DiskSpaceHealthIndicator());
        service.addIndicator(new MemoryHealthIndicator());

        List<HealthStatus> results = service.performHealthChecks();

        for (HealthStatus status : results){
            System.out.println(status);
        }

    }
}
