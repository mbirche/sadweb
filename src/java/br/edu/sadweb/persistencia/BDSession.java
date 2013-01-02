/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.sadweb.persistencia;

import org.hibernate.Session;

/**
 *
 * @author Birche
 */
public class BDSession {
    
    public static Session getSession(){
        return BDSessionFactory.getInstance().openSession();
    }
}
