package ViewController;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ModifypartController implements Initializable {

    Stage stage;
    Parent scene;

    @FXML
    private RadioButton InHouseRBtn;

    @FXML
    private ToggleGroup toggleGroup;

    @FXML
    private RadioButton OutsourcedRBtn;

    @FXML
    private TextField addPartMinTxt;

    @FXML
    private TextField addPartPriceTxt;

    @FXML
    private TextField addPartCompnNmeTxt;

    @FXML
    private TextField maxTxt;

    @FXML
    private TextField InventoryTxt;

    @FXML
    private TextField addPartnameTxt;

    @FXML
    private TextField addPartIdTxt;

    @FXML
    private Button saveBtn;

    @FXML
    private Button cancelBtn;

    @FXML
    void modifyPartCancel(ActionEvent event) {

    }

    @FXML
    void modifyPartCompanyTxt(ActionEvent event) {

    }

    @FXML
    void modifyPartCostTxt(ActionEvent event) {

    }

    @FXML
    void modifyPartInvTxt(ActionEvent event) {

    }

    @FXML
    void modifyPartMaxTxt(ActionEvent event) {

    }

    @FXML
    void modifyPartMinTxt(ActionEvent event) {

    }

    @FXML
    void modifyPartNameTxt(ActionEvent event) {

    }

    @FXML
    void modifyPartSave(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void modifyPartMinTxt(javafx.event.ActionEvent actionEvent) {
    }

    public void modifyPartCostTxt(javafx.event.ActionEvent actionEvent) {
    }

    public void modifyPartCompanyTxt(javafx.event.ActionEvent actionEvent) {
    }

    public void modifyPartMaxTxt(javafx.event.ActionEvent actionEvent) {
    }

    public void modifyPartInvTxt(javafx.event.ActionEvent actionEvent) {
    }

    public void modifyPartNameTxt(javafx.event.ActionEvent actionEvent) {
    }

    public void modifyPartSave(javafx.event.ActionEvent actionEvent) {
    }

    public void modifyPartCancel(javafx.event.ActionEvent event) throws IOException {

        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        stage.setScene(new Scene((Parent) scene));
        stage.show();
    }

    public void modifyProductIdTxt(javafx.event.ActionEvent actionEvent) {
    }

    public void modifyProductSearch(javafx.event.ActionEvent actionEvent) {
    }

    public void modifyProductSave(javafx.event.ActionEvent actionEvent) {
    }

    public void modifyProductCancel(javafx.event.ActionEvent actionEvent) {
    }

    public void modifyProductDelete(javafx.event.ActionEvent actionEvent) {
    }

    public void modifyProductAdd(javafx.event.ActionEvent actionEvent) {
    }
}