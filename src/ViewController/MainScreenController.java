

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ViewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author pinko
 */
public class MainScreenController implements Initializable {

    @FXML
    private Button imsPartSearchBtn;

    @FXML
    private TextField imsPartSearchTxt;

    @FXML
    private TableView<?> partTableView;

    @FXML
    private TableColumn<?, ?> partIdCol;

    @FXML
    private TableColumn<?, ?> partNameCol;

    @FXML
    private TableColumn<?, ?> partInvCol;

    @FXML
    private TableColumn<?, ?> partPriceCol;

    @FXML
    private Button imsPartAddBtn;

    @FXML
    private AnchorPane addPartButton;

    @FXML
    private Button imsSearchBtn;

    @FXML
    private TextField imsProductTxt;

    @FXML
    private TableView<?> table1;

    @FXML
    private TableColumn<?, ?> productIdCol;

    @FXML
    private TableColumn<?, ?> productNameCol;

    @FXML
    private TableColumn<?, ?> productInvCol;

    @FXML
    private TableColumn<?, ?> productPriceCol;

    @FXML
    private Button imsAddBtn;

    @FXML
    private Button imsModifyBtn;

    @FXML
    private Button imsDeleteBtn;

    @FXML
    private Button imsExitBtn;

    @FXML
    void addHandler(MouseEvent event) {

    }

    @FXML
    void addHandler1(MouseEvent event) {

    }

    @FXML
    void deleteHandler(MouseEvent event) {

    }

    @FXML
    void deleteHandler1(MouseEvent event) {

    }

    @FXML
    void exitHandler(MouseEvent event) {

    }

    @FXML
    void modifyHandler(MouseEvent event) {

    }

    @FXML
    void modifyHandler1(MouseEvent event) {

    }

    @FXML
    void partOnActionAdd(ActionEvent event) {

    }

    @FXML
    void partOnActionDelete(ActionEvent event) {

    }

    @FXML
    void partOnActionModify(ActionEvent event) {

    }

    @FXML
    void partOnActionSearch(ActionEvent event) {

    }

    @FXML
    void productOnActionAdd(ActionEvent event) {

    }

    @FXML
    void productOnActionDelete(ActionEvent event) {

    }

    @FXML
    void productOnActionModify(ActionEvent event) {

    }

    @FXML
    void productOnActionSearch(ActionEvent event) {

    }

    @FXML
    void searchHandler(MouseEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
