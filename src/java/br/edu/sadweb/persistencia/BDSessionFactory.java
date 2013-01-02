/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.sadweb.persistencia;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Birche
 */
public class BDSessionFactory {

    private static SessionFactory sf = null;

    public static SessionFactory getInstance() {

        if (sf == null) {
            Configuration config = new AnnotationConfiguration();
            config.configure("/hibernate.cfg.xml");

            sf = config.buildSessionFactory();
        }
        return sf;
    }
}
