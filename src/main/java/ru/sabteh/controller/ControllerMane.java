package ru.sabteh.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sabteh.model.Client;
import ru.sabteh.service.ServiceClient;

import java.io.IOException;

public class ControllerMane {
    public Button create;
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
        TableView.getSelectionModel().selectedItemProperty().addListener(
                (observableValue,oldProduct,newProduct) -> {
                    System.out.println();
                });

    }
    @FXML
    public void create(ActionEvent actionEvent) throws IOException {
        create.getScene().getWindow().hide();
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/create.fxml"));
        stage.setScene(new Scene(root));
        stage.show();

    }
    @FXML
    public void update(ActionEvent actionEvent) {
    }
    @FXML
    public void delet(ActionEvent actionEvent) {

    }
}
