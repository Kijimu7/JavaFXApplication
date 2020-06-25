

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ViewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Inventory;
import model.Part;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author pinko
 */
public class MainScreenController implements Initializable {

    Stage stage;
    Parent scene;



    @FXML
    private Button imsPartSearchBtn;

    @FXML
    private TextField imsPartSearchTxt;

    @FXML
    private TableView<Part> partTableView;

    @FXML
    private TableColumn<Part, Integer> partIdCol;

    @FXML
    private TableColumn<Part, String> partNameCol;

    @FXML
    private TableColumn<Part, String> partInvCol;

    @FXML
    private TableColumn<Part, Double> partPriceCol;

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
    void exitHandler(ActionEvent event) {

        System.exit(0);


    }

    @FXML
    void modifyHandler(MouseEvent event) {

    }

    @FXML
    void modifyHandler1(MouseEvent event) {

    }

    @FXML
    void partOnActionAdd(ActionEvent event) throws IOException {

        stage = (Stage)(( Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/ViewController/Addpart.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void partOnActionDelete(ActionEvent event) {
        // Delete Part Items
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Delete Part");
        alert.setContentText("Are you sure you want to delete this part?");

        Optional<ButtonType>result = alert.showAndWait();
        if(result.get() == ButtonType.OK){
            Part partToDelete= partTableView.getSelectionModel().getSelectedItem();
            Inventory.deletePart(partToDelete);
        }

    }

    @FXML
    void partOnActionModify(ActionEvent event) throws IOException{

        stage = (Stage)(( Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/ViewController/Modifypart.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void partOnActionSearch(ActionEvent event) {

    }

    @FXML
    void productOnActionAdd(ActionEvent event) throws IOException {

        stage = (Stage)(( Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/ViewController/Addproduct.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void productOnActionDelete(ActionEvent event) {


        }


    @FXML
    void productOnActionModify(ActionEvent event) throws IOException {

        stage = (Stage)(( Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/ViewController/Modifyproduct.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void productOnActionSearch(ActionEvent event) {

    }

    @FXML
    void searchHandler(MouseEvent event) {

    }

    //Initializes the controller class
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        partTableView.setItems(Inventory.getAllParts());

        partIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        partNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        partInvCol.setCellValueFactory(new PropertyValueFactory<>("inv"));
        partPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));





    }

}
