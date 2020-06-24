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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddproductController implements Initializable {

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
    private TableColumn<?, ?> addProductIdCol;

    @FXML
    private TableColumn<?, ?> addProductNameCol;

    @FXML
    private TableColumn<?, ?> addProductInvCol;

    @FXML
    private TableColumn<?, ?> addProductPriceCol;

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
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void addProductCancel(ActionEvent event) throws IOException

    {

        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        stage.setScene(new Scene((Parent) scene));
        stage.show();
    }
}
