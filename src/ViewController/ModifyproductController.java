package ViewController;


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

public class ModifyproductController implements Initializable {

    public static Product productToUpdate;


    Product product;
    private int index;
    Stage stage;
    Parent scene;

    @FXML
    private TableView<Part> modifyProductPartTbl;

    @FXML
    public TableView<Part> modifyProductTbl;

    @FXML
    private TextField modifyProductMin;

    @FXML
    private TextField modifyProductPrice;

    @FXML
    private TextField modifyProductMax;

    @FXML
    private TextField modifyProductInv;

    @FXML
    private TextField modifyProductName;

    @FXML
    private TextField modifyProductId;

    @FXML
    private TableColumn<?, ?> modifyProductIdCol;

    @FXML
    private TableColumn<?, ?> modifyProductNameCol;

    @FXML
    private TableColumn<?, ?> modifyProductInvCol;

    @FXML
    private TableColumn<?, ?> modifyProductPriceCol;

    @FXML
    private TableColumn<?, ?> modifyProductIdCol2;

    @FXML
    private TableColumn<?, ?> modifyProductNameCol2;

    @FXML
    private TableColumn<?, ?> modifyProductInvCol2;

    @FXML
    private TableColumn<?, ?> modifyProductPriceCol2;

    @FXML
    private Button modifyProductSearchBtn;

    @FXML
    private Button modifyProductSaveBtn;

    @FXML
    private Button modifyProductCancelBtn;

    @FXML
    private Button modifyProductDeleteBtn;

    @FXML
    private Button modifyProductAddBtn;

    @FXML
    private TextField ModifyProductSearchTxt;
    private Object Product;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        generateAssociatedPartTable();
        generateAssociatedPart2Table();

    }

    private void generateAssociatedPartTable() {

        modifyProductPartTbl.setItems(Inventory.getAllParts());
        modifyProductIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        modifyProductNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        modifyProductInvCol.setCellValueFactory(new PropertyValueFactory<>("inv"));
        modifyProductPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        modifyProductPartTbl.refresh();

    }

    private void generateAssociatedPart2Table() {
        if (!product.getAllAssociatedParts().isEmpty()) {
            modifyProductTbl.setItems(product.getAllAssociatedParts());
            modifyProductIdCol2.setCellValueFactory(new PropertyValueFactory<>("id"));
            modifyProductNameCol2.setCellValueFactory(new PropertyValueFactory<>("name"));
            modifyProductInvCol2.setCellValueFactory(new PropertyValueFactory<>("inv"));
            modifyProductPriceCol2.setCellValueFactory(new PropertyValueFactory<>("price"));
            modifyProductTbl.refresh();

        }
    }
        @FXML
        public void modifyProductAdd(ActionEvent actionEvent) {

            Part selectedPart = (Part) modifyProductPartTbl.getSelectionModel().getSelectedItem();

            product.addAssociatedPart(selectedPart);
            generateAssociatedPart2Table();

        }


        public void modifyProductIdTxt (ActionEvent actionEvent){
        }



        public void modifyProductSave (ActionEvent actionEvent) throws IOException {
            //Create auto Ids
            Random random = new Random();
            int id = random.nextInt(50);
            Product modifiedProduct = product;



            if (inventoryisValid(modifyProductName.getText(), modifyProductInv.getText(), modifyProductMin.getText(), modifyProductMax.getText())) {

                modifiedProduct.setId(id);
                if (!modifyProductName.getText().isEmpty()) {
                    modifiedProduct.setName(modifyProductName.getText());
                }
                if (!modifyProductInv.getText().isEmpty()) {
                    modifiedProduct.setPrice(Double.parseDouble(modifyProductInv.getText()));
                }
                if (!modifyProductMin.getText().isEmpty()) {
                    modifiedProduct.setInv(Integer.parseInt(modifyProductMin.getText()));
                }
                if (!modifyProductMax.getText().isEmpty()) {
                    modifiedProduct.setMin(Integer.parseInt(modifyProductMax.getText()));
                }


                modifiedProduct.getAllAssociatedParts();
                Inventory.updateProduct(index, modifiedProduct);
                System.out.println("Product Added");

                Stage stage;
                Parent root;
                stage = (Stage) modifyProductSaveBtn.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/ViewController/MainScreen.fxml"));
                root = loader.load();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        }





        public void modifyProductDelete (ActionEvent actionEvent){
            // Delete Part Items
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Delete Product");
            alert.setContentText("Are you sure you want to delete this product?");

            Optional<ButtonType> result = alert.showAndWait();
            if(result.get() == ButtonType.OK){
                Part selectedPart= (Part) modifyProductPartTbl.getSelectionModel().getSelectedItem();
                product.deleteAssociatedPart(selectedPart);
                modifyProductPartTbl.refresh();
            }


        }

        public void setProduct(Product product){
        this.product = product;

            modifyProductId.setText(Integer.toString(product.getId()));
            modifyProductName.setText(product.getName());
            modifyProductInv.setText(Integer.toString(product.getInv()));
            modifyProductPrice.setText(Double.toString(product.getPrice()));
            modifyProductMax.setText(Integer.toString(product.getMax()));
            modifyProductMin.setText(Integer.toString(product.getMin()));

            product.getAllAssociatedParts();
            generateAssociatedPartTable();

        }


        public void modifyProductCancel (ActionEvent event) throws IOException {

            stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
            stage.setScene(new Scene((Parent) scene));
            stage.show();

        }

    private boolean inventoryisValid( String productName, String productMax, String productMin, String productInv) {

        String errorMessage = "";
        Integer intMin = null, intMax = null;
        boolean inventoryisValid = false;





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

    public void addProductCancel(ActionEvent event) throws IOException

    {

        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        stage.setScene(new Scene((Parent) scene));
        stage.show();
    }

    public void modifyProductSearch(ActionEvent actionEvent) {
        String searchedProduct = ModifyProductSearchTxt.getText();
        for(Part part : Inventory.getAllParts()){
            if(part.getName().equals(searchedProduct)||Integer.toString(part.getId()).equals(searchedProduct)){
                modifyProductPartTbl.getSelectionModel().select(part);
            }
        }
    }


    public void ModifyProductSearchAction(ActionEvent actionEvent) {
    }
}

