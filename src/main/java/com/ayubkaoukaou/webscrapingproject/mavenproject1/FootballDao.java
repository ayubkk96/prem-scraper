/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ayubkaoukaou.webscrapingproject.mavenproject1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 *
 * @author kaouk
 */
public class FootballDao {
    /** Spring injecting the session factory. */
     SessionFactory sessionFactory;

     /** Getters and setters for sessionFactory.
     * @return  */
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    } 
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    
   /** initialising session factory*/
     public void init(){
        try {
            /** Create a builder for the standard service registry. */
            StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder();

            /** Load configuration from hibernate configuration file.
            Here we are using a configuration file that specifies Java annotations. */
            standardServiceRegistryBuilder.configure("hibernate.cfg.xml"); 

            /** Create the registry that will be used to build the session factory. */
            StandardServiceRegistry registry = standardServiceRegistryBuilder.build();
            try {
                /**Create the session factory - this is the goal of the init method. */
                sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
            }
            catch (Exception e) {
                    /* The registry would be destroyed by the SessionFactory, 
                        but we had trouble building the SessionFactory, so destroy it manually. */
                    System.err.println("Session Factory build failed.");
                    e.printStackTrace();
                    StandardServiceRegistryBuilder.destroy( registry );
            }

            /** Output result. */
            System.out.println("Session factory built.");

        }
        catch (Throwable ex) {
            /** Make sure you log the exception, as it might be swallowed. */
            System.err.println("SessionFactory creation failed." + ex);
        }
     }
     
     
     /** Shutdown the session in Hibernate. */
      public void shutDown(){
        sessionFactory.close();
    }
    
     public void saveCheesePrice(Football football ){
        /** Get a new Session instance from the SessionFactory. */
        Session session = sessionFactory.getCurrentSession();

        /** Start transaction. */
        session.beginTransaction();

        /** Add Cheese to database - will not be stored until we commit the transaction. */
        session.save(football);

        /** Commit transaction to save it to database. */
        session.getTransaction().commit();
        
        /** Close the session and release database connection. */
        session.close();
        System.out.println("Cheese added to database with ID: " + football.getId());
    }
}

