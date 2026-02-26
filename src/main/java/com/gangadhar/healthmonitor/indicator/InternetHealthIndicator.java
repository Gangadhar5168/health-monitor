package com.gangadhar.healthmonitor.indicator;

import com.gangadhar.healthmonitor.model.HealthStatus;

import java.net.InetSocketAddress;
import java.net.Socket;

public class InternetHealthIndicator implements HealthIndicator{

    public final static String COMPONENT_NAME = "Internet Connectivity";
    @Override
    public HealthStatus check() {
        try(Socket socket = new Socket()){
            socket.connect(new InetSocketAddress("google.com",80),3000);
            return new HealthStatus(
                    COMPONENT_NAME,
                    "UP",
                    "Successfully connected to google.com:80"
                    );
        } catch (Exception e) {
            return new HealthStatus(
                    COMPONENT_NAME,
                    "DOWN",
                    "Connection failed "+e.getMessage()
            );
        }
    }
}
