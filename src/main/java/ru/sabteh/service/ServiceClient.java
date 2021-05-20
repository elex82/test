package ru.sabteh.service;


import ru.sabteh.DAO.DAO;
import ru.sabteh.model.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.List;

public class ServiceClient implements DAO<Client,Integer> {
    private final SessionFactory factory;

    public ServiceClient(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Client client) {

    }

    @Override
    public void update(Client client) {

    }

    @Override
    public void delete(Client client) {

    }

    @Override
    public Client read(Integer integer) {
        return null;
    }

    @Override
    public List<Client> readAll() {
        try(Session session = factory.openSession()) {
            return session.createQuery("FROM Client ", Client.class).list();
        }
    }
}
