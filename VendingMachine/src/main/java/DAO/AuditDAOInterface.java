/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Audit;

/**
 *
 * @author chris
 */
public interface AuditDAOInterface {

    void saveAudit(Audit audit);
    
    void determineNextId();
    
    int getNextId();
    
}
