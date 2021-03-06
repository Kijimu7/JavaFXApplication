package ViewController;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Inventory;
import model.Part;
import model.Product;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.Random;
import java.util.ResourceBundle;

public class AddproductController implements Initializable {

    @FXML
    public TableView deletePartProductTable;

    @FXML
    public TableView addProductPartTable;

    Product newProduct;

    Stage stage;
    Parent scene;

    @FXML
    private TextField addProductMin;

    @FXML
    private TextField addProductPrice;

    @FXML
    private TextField addProductMax;

    @FXML
    private TextField addProductInv;

    @FXML
    private TextField addProductName;

    @FXML
    private TextField addProductId;

    @FXML
    private TableColumn<?, ?> addProductPartIdCol;

    @FXML
    private TableColumn<?, ?> addProductPartNameCol;

    @FXML
    private TableColumn<?, ?> addProductPartInvCol;

    @FXML
    private TableColumn<?, ?> addProductPartPriceCol;

    @FXML
    private TableColumn<?, ?> addProductIdCol2;

    @FXML
    private TableColumn<?, ?> addProductNameCol2;

    @FXML
    private TableColumn<?, ?> addProductInvCol2;

    @FXML
    private TableColumn<?, ?> addProductPriceCol2;

    @FXML
    private Button addProductSaveBtn;

    @FXML
    private Button addProductCancelBtn;

    @FXML
    private Button addProductDeleteBtn;

    @FXML
    private Button addProductAddBtn;

    @FXML
    private TextField AddProductSearchTxt;
    private String productName;
    private String productPrice;

    public AddproductController() {
        newProduct = new Product(0," ",0,0,0,0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        generateAssociatedPartTable();
        generateAssociatedPart2Table();


    }


    private void generateAssociatedPartTable(){


                addProductPartTable.setItems(Inventory.getAllParts());
                addProductPartIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
                addProductPartNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
                addProductPartInvCol.setCellValueFactory(new PropertyValueFactory<>("inv"));
                addProductPartPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
                addProductPartTable.refresh();

        }

    private void generateAssociatedPart2Table() {

        if (newProduct.getAllAssociatedParts().isEmpty()) {

            deletePartProductTable.setItems(newProduct.getAllAssociatedParts());
            addProductIdCol2.setCellValueFactory(new PropertyValueFactory<>("id"));
            addProductNameCol2.setCellValueFactory(new PropertyValueFactory<>("name"));
            addProductInvCol2.setCellValueFactory(new PropertyValueFactory<>("inv"));
            addProductPriceCol2.setCellValueFactory(new PropertyValueFactory<>("price"));

        }

    }








    public void addProductAddBtnOnAction(ActionEvent actionEvent) {

        Part selectedPart = (Part) addProductPartTable.getSelectionModel().getSelectedItem();

        newProduct.addAssociatedPart(selectedPart);
        generateAssociatedPart2Table();




    }

    //test add button for repeat parts dialog







    @FXML
    void addProductDeleteBtnOnAction(ActionEvent event) {
        // Delete Part Items
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Delete Product");
        alert.setContentText("Are you sure you want to delete this product?");

        Optional<ButtonType> result = alert.showAndWait();
        if(result.get() == ButtonType.OK){
            Part selectedPart= (Part) deletePartProductTable.getSelectionModel().getSelectedItem();
            newProduct.deleteAssociatedPart(selectedPart);
            addProductPartTable.refresh();
        }

    }



    public void addProductSaveBtnOnAction(ActionEvent actionEvent) throws IOException {



            //Create auto Ids
            Random random = new Random();
            int id = random.nextInt(50);


            if (inventoryisValid(addProductName.getText(), addProductInv.getText(), addProductPrice.getText(), addProductMax.getText(), addProductMin.getText())) {

                newProduct.setId(id);
                if (!addProductName.getText().isEmpty()) {
                    newProduct.setName(addProductName.getText());
                }
                if (!addProductInv.getText().isEmpty()) {
                    newProduct.setInv(Integer.parseInt(addProductInv.getText()));
                }
                if (!addProductPrice.getText().isEmpty()) {
                    newProduct.setPrice(Double.parseDouble(addProductPrice.getText()));
                }
                if (!addProductMax.getText().isEmpty()) {
                    newProduct.setMax(Integer.parseInt(addProductMax.getText()));
                }
                if (!addProductMin.getText().isEmpty()) {
                    newProduct.setMin(Integer.parseInt(addProductMin.getText()));
                }



                Inventory.addProduct(newProduct);
                System.out.println("Product Added");


                ObservableList<Part> parts = deletePartProductTable.getItems();

                 if (!parts.isEmpty()) {
                    Stage stage;
                    Parent root;
                    stage = (Stage) addProductSaveBtn.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/ViewController/MainScreen.fxml"));
                    root = loader.load();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else
                    {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Dialog");
                    alert.setContentText("Please select an item");
                    alert.showAndWait();
                }







            }

    }









    public void AddProductSearchOnAction(ActionEvent actionEvent) {

        String searchedProduct = AddProductSearchTxt.getText();
        for(Part part : Inventory.getAllParts()){
            if(part.getName().equals(searchedProduct)||Integer.toString(part.getId()).equals(searchedProduct)){
                addProductPartTable.getSelectionModel().select(part);
            }
        }


    }

    private boolean inventoryisValid( String productName, String productInv, String productPrice, String productMax,  String productMin) {
        this.productName = productName;
        this.productPrice = productPrice;

        String errorMessage = "";
        Integer intMin = null, intMax = null;
        boolean inventoryisValid;




        try {
        intMin = Integer.parseInt(productMin);
    } catch (NumberFormatException e) {
        errorMessage += ("Min must a number\n");
    }

        try {
        intMax = Integer.parseInt(productMax);
    } catch (NumberFormatException e) {
        errorMessage += ("Maximum must be a number\n");
    }

        try {
        if (intMin > intMax) {
            errorMessage += ("Minimum must be less than maximum \n");
        }
        if (intMin < 0 || intMax < 0) {
            errorMessage += ("Quantity cannot be less than zero\n");
        }
    } catch (NullPointerException e) {
        errorMessage += ("Min and Max cannot be less than zero \n");
    }
        try {
        int intInv = Integer.parseInt(productInv);

        if (intMax != null && intMin != null) {
            if (intInv < intMin || intInv > intMax) {
                errorMessage += ("Inventory must be between minimum and maximum \n");
            }
        } else {
            errorMessage += ("Inventory cannot be blank \n");
        }
    } catch (NumberFormatException e) {
        errorMessage += ("Inventory cannot be blank and must be a number\n");
    }


        if (errorMessage.isEmpty() == true) {
        inventoryisValid = true;
    } else {
        inventoryisValid = false;
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Part Validation error");
        alert.setHeaderText("Error");
        alert.setContentText(errorMessage);
        alert.showAndWait();
    }

        return inventoryisValid;

}

    public void addProductCancel(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "This will clear all text field values, do you want to continue?");

        Optional<ButtonType> results = alert.showAndWait();

        if (results.isPresent() && results.get() == ButtonType.OK) {
            stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
            stage.setScene(new Scene((Parent) scene));
            stage.show();
        }
    }


}


