package com.allcom.domain.service;

import com.allcom.domain.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    public boolean generateReport(){
        return reportRepository.generateReport();
    }

}
