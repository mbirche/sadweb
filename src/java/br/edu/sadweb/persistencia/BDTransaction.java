/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.sadweb.persistencia;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Birche
 */
public class BDTransaction {
    
    public static Transaction getTransaction(Session session){
        return session.beginTransaction();
    }
    
}
