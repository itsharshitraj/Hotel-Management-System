package com.hotel.report_microservice.service;

import com.hotel.report_microservice.model.Report;
import com.hotel.report_microservice.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private ReportRepository reportRepository;

    @Override
    public Report createReport(Report report){
        return reportRepository.save(report);
    }

    @Override
    public List<Report> getAllReports(){
        return reportRepository.findAll();
    }

    public Optional<Report> getReportById(int id){
        return reportRepository.findById(id);
    }

    public Report updateReport(int id, Report updatedReport){
        Report existingReport = reportRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Report not found with id: " + id));

        existingReport.setReportType(updatedReport.getReportType());
        existingReport.setReportDate(updatedReport.getReportDate());
        existingReport.setReportAmount(updatedReport.getReportAmount());
        existingReport.setGeneratedBy(updatedReport.getGeneratedBy());

        return reportRepository.save(existingReport);
    }

    public void deleteReport(int id){
        reportRepository.deleteById(id);
    }
}
