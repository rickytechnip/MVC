/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Audit;
import DTO.Item;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author chris
 */
public class AuditDAOImplementation implements AuditDAOInterface {

    final String AUDIT_RECORD;


    public AuditDAOImplementation() {

        this.AUDIT_RECORD = "audit_file.txt";
       
    }

    public AuditDAOImplementation(String AUDIT_RECORD) {
        this.AUDIT_RECORD = AUDIT_RECORD;
       
    }

 
  

    @Override
    public void saveAudit(Audit audit) {

        PrintWriter writer = null;

        try {
            writer = new PrintWriter(new FileWriter(AUDIT_RECORD, true));

        } catch (IOException e) {
            System.err.println("Audit not logged");
        }

        writer.println(audit.toString());

        writer.close();

    }

  

}
