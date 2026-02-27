package com.gangadhar.healthmonitor.scheduler;

import com.gangadhar.healthmonitor.indicator.DiskSpaceHealthIndicator;
import com.gangadhar.healthmonitor.indicator.FileJobHealthIndicator;
import com.gangadhar.healthmonitor.indicator.InternetHealthIndicator;
import com.gangadhar.healthmonitor.indicator.MemoryHealthIndicator;
import com.gangadhar.healthmonitor.mail.MailService;
import com.gangadhar.healthmonitor.model.HealthStatus;
import com.gangadhar.healthmonitor.report.ReportBuilder;
import com.gangadhar.healthmonitor.service.HealthCheckService;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class HealthScheduler {
    private final ScheduledExecutorService scheduler =
            Executors.newSingleThreadScheduledExecutor();
    public void start(){
        Runnable task = ()->{
            try {
                {
                    System.out.println("Running scheduled health check...");
                    HealthCheckService service = new HealthCheckService();

                    service.addIndicator(new InternetHealthIndicator());
                    service.addIndicator(new DiskSpaceHealthIndicator());
                    service.addIndicator(new MemoryHealthIndicator());
                    service.addIndicator(new FileJobHealthIndicator());

                    List<HealthStatus> results = service.performHealthChecks();

                    ReportBuilder reportBuilder = new ReportBuilder();
                    String report = reportBuilder.buildHtmlReport(results);

                    MailService mailService = new MailService();
                    mailService.sendEmail("System Health Report", report);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        };
        scheduler.scheduleAtFixedRate(task, 0, 1, TimeUnit.MINUTES);
    }

    public void stop() {
        scheduler.shutdown();
    }
}
