package com.hotel.report_microservice.service;

import com.hotel.report_microservice.model.Report;

import java.util.List;
import java.util.Optional;

public interface ReportService {
    Report createReport(Report report);

    List<Report> getAllReports();

    Optional<Report> getReportById(int id);

    Report updateReport(int id, Report report);

    void deleteReport(int id);
}
