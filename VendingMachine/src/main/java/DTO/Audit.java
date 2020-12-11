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
 */
public class Audit {
    
    private int id;
    private LocalDateTime auditDate;
    private String auditInfo;
    private final String DELIMITER = "::";

    public Audit() {
    }

    public Audit(int id, LocalDateTime auditDate, String auditInfo) {
        this.id = id;
        this.auditDate = auditDate;
        this.auditInfo = auditInfo;
    }

    
    public String getAuditInfo() {
        return auditInfo;
    }

    public void setAuditInfo(String auditInfo) {
        this.auditInfo = auditInfo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(LocalDateTime auditDate) {
        this.auditDate = auditDate;
    }

    @Override
    public String toString() {
        
        DateTimeFormatter auditFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd 'at' HH:mm z");

        return  id + DELIMITER + auditDate.format(auditFormatter) + DELIMITER+ auditInfo;
    }
    
    
    
    
    
    
    
}
