package com.gangadhar.healthmonitor.indicator;

import com.gangadhar.healthmonitor.model.HealthStatus;

public class MemoryHealthIndicator implements HealthIndicator{
    public static final String COMPONENT_NAME = "JVM Memory";
    public static final double THRESHOLD_PERCENT = 80.0;

    @Override
    public HealthStatus check() {
       Runtime runtime = Runtime.getRuntime();

       long totalMemory = runtime.totalMemory();
       long freeMemory = runtime.freeMemory();
       long usedMemory = totalMemory - freeMemory;

       double usedPercentage = (double) usedMemory/totalMemory *100;
       String message = String.format("Used : %.2f%%",usedPercentage);

       if(usedPercentage>THRESHOLD_PERCENT){
           return new HealthStatus(COMPONENT_NAME,"DOWN",message);
       }
       else{
           return new HealthStatus(COMPONENT_NAME,"UP",message);
       }
    }
}
