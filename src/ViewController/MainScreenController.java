

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
import model.Product;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author pinko
 */
public abstract class MainScreenController<AddProductClear> implements Initializable {

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
    private TableView<Product> table1;

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

    //Part table delete button
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
    void partOnActionModify(ActionEvent event) throws IOException {
        try {
            Part selectedPart = partTableView.getSelectionModel().getSelectedItem();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/ViewController/Modifypart.fxml"));
            loader.load();



            ModifypartController controller = loader.getController();
            controller.setPart(selectedPart);
            stage = (Stage)((Button)event.getSource()).getScene().getWindow();
            Parent scene = loader.getRoot();


            stage.setScene(new Scene(scene));
            stage.show();


        } catch (NullPointerException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setContentText("Please select an item");
            alert.showAndWait();
        }
    }
    //Part table search button
    @FXML
    void partOnActionSearch(ActionEvent event) {
        String searchedPart = imsPartSearchTxt.getText();
        for(Part part : Inventory.getAllParts()){
            if(part.getName().equals(searchedPart)||Integer.toString(part.getId()).equals(searchedPart)){
                partTableView.getSelectionModel().select(part);
            }
        }

    }

    @FXML
    void productOnActionAdd(ActionEvent event) throws IOException {

        stage = (Stage)(( Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/ViewController/Addproduct.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();


    }





    //Product table delete
    @FXML
    void productOnActionDelete(ActionEvent event) {
        // Delete Part Items
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Delete Product");
        alert.setContentText("Are you sure you want to delete this product?");

        Optional<ButtonType>result = alert.showAndWait();
        if(result.get() == ButtonType.OK){
            Product productToDelete= table1.getSelectionModel().getSelectedItem();
            Inventory.deleteProduct(productToDelete);
        }

        }


    @FXML
    void productOnActionModify(ActionEvent event) throws IOException {


        try {

            Product selectedProduct = table1.getSelectionModel().getSelectedItem();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/ViewController/Modifyproduct.fxml"));
            loader.load();



            ModifyproductController controller = loader.getController();
            controller.setProduct(selectedProduct);
            stage = (Stage)((Button)event.getSource()).getScene().getWindow();
            Parent scene = loader.getRoot();


            stage.setScene(new Scene(scene));
            stage.show();


        } catch (NullPointerException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setContentText("Please select an item");
            alert.showAndWait();
        }
    }
    //Product table search
    @FXML
    void productOnActionSearch(ActionEvent event) {
        String searchedProduct = imsProductTxt.getText();
        for(Product product : Inventory.getAllProducts()){
            if(product.getName().equals(searchedProduct)||Integer.toString(product.getId()).equals(searchedProduct)){
                table1.getSelectionModel().select(product);
            }
        }
    }

    @FXML
    void searchHandler(MouseEvent event) {

    }

    //Initializes the controller class
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //set the part table data
        partTableView.setItems(Inventory.getAllParts());

        partIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        partNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        partInvCol.setCellValueFactory(new PropertyValueFactory<>("inv"));
        partPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));


        //set the product table data
        table1.setItems(Inventory.getAllProducts());

        productIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        productNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        productInvCol.setCellValueFactory(new PropertyValueFactory<>("inv"));
        productPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));



    }

}
