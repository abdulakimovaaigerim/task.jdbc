package org.example.config;

import jakarta.persistence.EntityManager;
import org.example.models.Address;
import org.example.models.Country;
import org.example.models.Programmer;
import org.example.models.Project;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import static org.hibernate.cfg.AvailableSettings.*;


public class HibernateConfig {

    public static EntityManager getEntityManager(){
        Configuration configuration = new Configuration();
        configuration.setProperty(DRIVER, "org.postgresql.Driver");
        configuration.setProperty(URL, "jdbc:postgresql://localhost:5432/hibernate");
        configuration.setProperty(USER, "postgres");
        configuration.setProperty(PASS, "postgres");
        configuration.setProperty(HBM2DDL_AUTO, "create");
        configuration.setProperty(DIALECT, "org.hibernate.dialect.PostgreSQL9Dialect");
        configuration.setProperty(SHOW_SQL, "true");
        configuration.addAnnotatedClass(Programmer.class);
        configuration.addAnnotatedClass(Project.class);
        configuration.addAnnotatedClass(Country.class);
        configuration.addAnnotatedClass(Address.class);

        return configuration.buildSessionFactory().createEntityManager();
    }
}
