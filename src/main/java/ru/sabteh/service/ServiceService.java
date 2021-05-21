package ru.sabteh.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.sabteh.DAO.DAO;
import ru.sabteh.model.Service;

import java.util.List;


public class ServiceService implements DAO<Service,Integer> {
    private final SessionFactory sessionFactory;

    public ServiceService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Service service) {
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.save(service);
            session.getTransaction().commit();

        }

    }

    @Override
    public void update(Service service) {
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.update(service);
            session.getTransaction().commit();

        }

    }

    @Override
    public void delete(Service service) {
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.delete(service);
            session.getTransaction().commit();

        }

    }

    @Override
    public Service read(Integer integer) {
        return null;
    }

    @Override
    public List<Service> readAll() {
        try (Session session = sessionFactory.openSession()){
            return session.createQuery("FROM service",Service.class).list();
        }

    }
}
