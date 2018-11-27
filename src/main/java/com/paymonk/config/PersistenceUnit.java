package com.paymonk.config;

import com.paymonk.domain.Employee;
import com.paymonk.domain.Manager;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.io.IOException;
import java.util.Properties;

public class PersistenceUnit {
    private StandardServiceRegistryBuilder registryBuilder;
    private SessionFactory sessionFactory;
    private MetadataSources metadataSources;


    public PersistenceUnit() throws IOException {
        registryBuilder = new StandardServiceRegistryBuilder();
        registryBuilder.applySettings(loadProperties());
        metadataSources = new MetadataSources(registryBuilder.build());

        addManagerMetadata();
        buildSeessionFactory();
    }


    private Properties loadProperties() throws IOException {
        Properties props = new Properties();
        props.load(getClass().getClassLoader().getResourceAsStream("hibernate.properties"));
        return props;
    }


    private void addManagerMetadata() {

        metadataSources.addPackage("com.paymonk.domain");
        metadataSources.addAnnotatedClass(Manager.class);
        metadataSources.addAnnotatedClass(Employee.class);


    }


    private void buildSeessionFactory() {
        Metadata metadata = metadataSources.getMetadataBuilder().build();

        sessionFactory = metadata.getSessionFactoryBuilder().build();

    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}


