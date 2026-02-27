# Automated System Health & Resource Monitoring Tool

Java 8 based modular health monitoring system that checks:
- Internet connectivity
- Disk usage
- Memory usage
- File-based job validation

Generates HTML report and sends email notifications.

## Configuration Setup

Before running the project:

1. Copy `config-template.properties`
2. Rename it to `config.properties`
3. Replace the placeholder values with your Gmail and App Password.

Note: `config.properties` is ignored from version control for security reasons.