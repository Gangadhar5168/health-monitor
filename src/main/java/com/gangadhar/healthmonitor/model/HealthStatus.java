package com.gangadhar.healthmonitor.model;

import java.time.LocalDateTime;

public class HealthStatus {
    private String name;
    private String status;
    private String message;
    private LocalDateTime timestamp;

    public HealthStatus(String name,String status, String message){
        this.name=name;
        this.status=status;
        this.message=message;
        this.timestamp=LocalDateTime.now();
    }

    public String getName(){
        return name;
    }

    public String getStatus(){
        return status;
    }

    public String getMessage(){
        return message;
    }

    public LocalDateTime getTimestamp(){
        return timestamp;
    }

    @Override
    public String toString() {
        return "HealthStatus{" +
                "name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
