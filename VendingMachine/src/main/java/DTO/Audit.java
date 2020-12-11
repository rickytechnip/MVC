/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author chris
 * 
 * Simple POJO used as a Data Transfer Object for audits. 
 */
public class Audit {
    
 
    private LocalDateTime auditDate;
    private String auditInfo;
    private final String DELIMITER = "::";

    public Audit() {
    }

    public Audit(LocalDateTime auditDate, String auditInfo) {
        
        this.auditDate = auditDate;
        this.auditInfo = auditInfo;
    }

    
    public String getAuditInfo() {
        return auditInfo;
    }

    public void setAuditInfo(String auditInfo) {
        this.auditInfo = auditInfo;
    }



    public LocalDateTime getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(LocalDateTime auditDate) {
        this.auditDate = auditDate;
    }

    @Override
    public String toString() {
        
        DateTimeFormatter auditFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd 'at' HH:mm");

        return  auditDate.format(auditFormatter) + DELIMITER+ auditInfo;
    }
    
    
    
    
    
    
    
}
