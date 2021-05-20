package ru.sabteh.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sabteh.model.Client;
import ru.sabteh.service.ServiceClient;

public class ControllerMane {
    SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();

    @FXML
    private TableView<Client> TableView;
    @FXML
    private TableColumn <Client,String>name;
    @FXML
    private void initialize() {
        ServiceClient serviceClient = new ServiceClient(sessionFactory);
        ObservableList<Client> list = FXCollections.observableArrayList();
        list.addAll(serviceClient.readAll());
        name.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        TableView.setItems(list);

    }
}
