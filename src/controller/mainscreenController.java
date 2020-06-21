package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author pinko
 */
public class mainscreenController implements Initializable {

    @FXML
    private Button Search;
    @FXML
    private TextField SearchText;
    @FXML
    private TableView<?> table;
    @FXML
    private TableColumn<?, ?> Id;
    @FXML
    private TableColumn<?, ?> Name;
    @FXML
    private TableColumn<?, ?> inStock;
    @FXML
    private TableColumn<?, ?> Price;
    @FXML
    private Button Search1;
    @FXML
    private TextField SearchText1;
    @FXML
    private TableView<?> table1;
    @FXML
    private TableColumn<?, ?> Id1;
    @FXML
    private TableColumn<?, ?> Name1;
    @FXML
    private TableColumn<?, ?> inStock1;
    @FXML
    private TableColumn<?, ?> Price1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Search.setText("search button test");
    }    

    @FXML
    private void searchHandler(ActionEvent event) {
            Search.setText("search button");
    }

    @FXML
    private void addHandler(ActionEvent event) {

    }

    @FXML
    private void modifyHandler(ActionEvent event) {
    }

    @FXML
    private void deleteHandler(ActionEvent event) {
    }

    @FXML
    private void addHandler1(ActionEvent event) {
    }

    @FXML
    private void modifyHandler1(ActionEvent event) {
    }

    @FXML
    private void deleteHandler1(ActionEvent event) {
    }

    @FXML
    private void exitHandler(ActionEvent event) {
    }

    @FXML
    private void searchHandler(MouseEvent event) {
    }

    @FXML
    private void addHandler(MouseEvent event) {
    }

    @FXML
    private void modifyHandler(MouseEvent event) {
    }

    @FXML
    private void deleteHandler(MouseEvent event) {
    }

    @FXML
    private void Search1(MouseEvent event) {
    }

    @FXML
    private void addHandler1(MouseEvent event) {
    }

    @FXML
    private void modifyHandler1(MouseEvent event) {
    }

    @FXML
    private void deleteHandler1(MouseEvent event) {
    }

    @FXML
    private void exitHandler(MouseEvent event) {
    }
    
}
