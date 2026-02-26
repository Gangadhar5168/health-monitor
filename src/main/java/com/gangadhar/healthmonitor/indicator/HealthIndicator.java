package com.gangadhar.healthmonitor.indicator;

import com.gangadhar.healthmonitor.model.HealthStatus;

public interface HealthIndicator {
    HealthStatus check();
}
