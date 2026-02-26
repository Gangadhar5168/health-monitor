package com.gangadhar.healthmonitor.service;

import com.gangadhar.healthmonitor.indicator.HealthIndicator;
import com.gangadhar.healthmonitor.model.HealthStatus;

import java.util.ArrayList;
import java.util.List;

public class HealthCheckService {
    List<HealthIndicator> indicators = new ArrayList<>();

    public void addIndicator(HealthIndicator indicator){
        indicators.add(indicator);
    }

    public List<HealthStatus> performHealthChecks(){
        List<HealthStatus> results = new ArrayList<>();
        for (HealthIndicator indicator: indicators ){
            results.add(indicator.check());
        }
        return results;
    }
}
