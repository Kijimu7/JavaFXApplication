package ViewController;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Product;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ModifyproductController implements Initializable {

    public static Product productToUpdate;
    Stage stage;
    Parent scene;

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

    }



    public void modifyProductIdTxt(ActionEvent actionEvent) {
    }

    public void modifyProductSearch(ActionEvent actionEvent) {
    }

    public void modifyProductSave(ActionEvent actionEvent) {
    }

    public void modifyProductDelete(ActionEvent actionEvent) {
    }

    public void modifyProductAdd(ActionEvent actionEvent) {
    }

    public void modifyProductCancel(ActionEvent event) throws IOException {

        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        stage.setScene(new Scene((Parent) scene));
        stage.show();

    }
}
