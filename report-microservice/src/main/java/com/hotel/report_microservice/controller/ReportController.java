package com.hotel.report_microservice.controller;

import com.hotel.report_microservice.model.Report;
import com.hotel.report_microservice.service.EmailService;
import com.hotel.report_microservice.service.ReportService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reports")
public class ReportController {
    @Autowired
    private ReportService reportService;

    @Autowired
    private EmailService emailService;

    @PostMapping
    public ResponseEntity<Report> createReport(@RequestBody @Valid Report report) {
        Report saved = reportService.createReport(report);

        // Send email notification after report creation
        emailService.sendReportNotification(
                "itsharshitraj@gmail.com", // Replace with the recipient's email address
                "New Report Generated",
                "Report Type: " + saved.getReportType() +
                        "\nAmount: " + saved.getReportAmount() +
                        "\nDate: " + saved.getReportDate()
        );
        return ResponseEntity.ok(saved);

    }

  @GetMapping
    public ResponseEntity<List<Report>> getAllReports(){
      return ResponseEntity.ok(reportService.getAllReports());
  }

    @GetMapping("/{id}")
    public ResponseEntity<Report> getReportById(@PathVariable int id) {
        return reportService.getReportById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

  @PutMapping("/{id}")
    public ResponseEntity<Report> updateReport(@PathVariable int id, @RequestBody @Valid Report report){
      return ResponseEntity.ok(reportService.updateReport(id, report));
  }

  @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReport(@PathVariable int id){
      reportService.deleteReport(id);
      return ResponseEntity.noContent().build();
  }
}
