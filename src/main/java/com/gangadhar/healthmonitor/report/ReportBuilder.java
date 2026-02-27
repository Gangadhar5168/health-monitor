package com.gangadhar.healthmonitor.report;

import com.gangadhar.healthmonitor.model.HealthStatus;

import java.time.LocalDateTime;
import java.util.List;

public class ReportBuilder {
    public String buildHtmlReport(List<HealthStatus> statuses){
        StringBuilder html = new StringBuilder();
        Boolean overallUp = statuses.stream()
                .allMatch(status -> "UP".equalsIgnoreCase(status.getStatus()));
        html.append("<html>");
        html.append("<body>");
        html.append("<h2>System Health Report</h2>");
        html.append("<p><strong>Generated At:</strong> ")
                .append(LocalDateTime.now())
                .append("</p>");
        html.append("<p><strong>Overall Status:</strong> ")
                .append(overallUp ? "UP ✅" : "DOWN ❌")
                .append("</p>");

        html.append("<table border='1' cellpadding='5' cellspacing='0'>");
        html.append("<tr>")
                .append("<th>Component</th>")
                .append("<th>Status</th>")
                .append("<th>Message</th>")
                .append("<th>Timestamp</th>")
                .append("</tr>");
        for (HealthStatus status : statuses) {
            html.append("<tr>")
                    .append("<td>").append(status.getName()).append("</td>")
                    .append("<td>").append(status.getStatus()).append("</td>")
                    .append("<td>").append(status.getMessage()).append("</td>")
                    .append("<td>").append(status.getTimestamp()).append("</td>")
                    .append("</tr>");
        }
        html.append("</table>");
        html.append("</body>");
        html.append("</html>");

        return html.toString();
    }
}
