package ViewController;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Inventory;
import model.Part;
import model.Product;

import java.io.IOException;
import java.net.URL;
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
    public TableView modifyProductTbl;

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

        }
    }
        @FXML
        public void modifyProductAdd(ActionEvent event) {

            Part selectedPart = (Part) modifyProductPartTbl.getSelectionModel().getSelectedItem();

            Product.addAssociatedPart(selectedPart);
            generateAssociatedPartTable();
            modifyProductPartTbl.refresh();

        }






        public void modifyProductIdTxt (ActionEvent actionEvent){
        }

        public void modifyProductSearch (ActionEvent actionEvent){
        }

        public void modifyProductSave (ActionEvent actionEvent){
        }

        public void modifyProductDelete (ActionEvent actionEvent){
        }


        public void modifyProductCancel (ActionEvent event) throws IOException {

            stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
            stage.setScene(new Scene((Parent) scene));
            stage.show();

        }
    }

