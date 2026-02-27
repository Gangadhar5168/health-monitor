package com.gangadhar.healthmonitor;

import com.gangadhar.healthmonitor.indicator.DiskSpaceHealthIndicator;
import com.gangadhar.healthmonitor.indicator.FileJobHealthIndicator;
import com.gangadhar.healthmonitor.indicator.InternetHealthIndicator;
import com.gangadhar.healthmonitor.indicator.MemoryHealthIndicator;
import com.gangadhar.healthmonitor.mail.MailService;
import com.gangadhar.healthmonitor.model.HealthStatus;
import com.gangadhar.healthmonitor.report.ReportBuilder;
import com.gangadhar.healthmonitor.scheduler.HealthScheduler;
import com.gangadhar.healthmonitor.service.HealthCheckService;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args){

        HealthScheduler scheduler = new HealthScheduler();
        scheduler.start();

        System.out.println("Health Monitoring Scheduler Started...");

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down scheduler...");
        }));
    }





//        HealthCheckService service = new HealthCheckService();
//        MailService mailService = new MailService();
//
//        service.addIndicator(new InternetHealthIndicator());
//        service.addIndicator(new DiskSpaceHealthIndicator());
//        service.addIndicator(new MemoryHealthIndicator());
//        service.addIndicator(new FileJobHealthIndicator());
//        List<HealthStatus> results = service.performHealthChecks();
//        ReportBuilder reportBuilder = new ReportBuilder();
//        String report = reportBuilder.buildHtmlReport(results);
//        //System.out.println(report);
//
//        mailService.sendEmail(
//                "System Health Report",
//                report
//        );

//        for (HealthStatus status : results){
//            System.out.println(status);
//        }



    }

