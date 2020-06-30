package ViewController;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Part;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ModifypartController implements Initializable {

    Part part;
    private boolean isOutsourced = true;
    private int index;

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
    private TextField modifyPartIdTxt;

    @FXML
    private Button saveBtn;

    @FXML
    private Button cancelBtn;

    @FXML
    public Label modifyPartCnameLbl;

    @FXML
    void inHouseRBtnS(javafx.event.ActionEvent event) {
        isOutsourced  = false;
        modifyPartCnameLbl.setText("Machine ID");
    }

    @FXML
    void outsourcedRBtnS(javafx.event.ActionEvent event) {
        isOutsourced  = true;
        modifyPartCnameLbl.setText("Company Name");
    }

    public void setPart(Part part){
        this.part = part;


        modifyPartIdTxt.setText(new Integer(part.getId()).toString());


    }

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
        System.out.println("test");



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

    //public void cancelanction(ActionEvent e) thrwsIOException{
//    if(DialogBoxes.confirmAction("Cancel")){
//        ReturnToMainScreen(e);
//    }

//    public void ReturnToMainScreen(ActionEvent e) throuws IOExeption{
//
//    }

    private void ReturnToMainScreen(javafx.event.ActionEvent event) throws IOException {
        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();

    }
//        ReturnToMainScreen(event);

    public void modifyPartCancel(javafx.event.ActionEvent event) throws IOException {

        ReturnToMainScreen(event);
    }

    public void modifyProductIdTxt(javafx.event.ActionEvent actionEvent) {
    }

    public void modifyProductSearch(javafx.event.ActionEvent actionEvent) {
    }






    public void modifyProductSave(javafx.event.ActionEvent actionEvent) {
        System.out.println("test");
    }

    public void modifyProductCancel(javafx.event.ActionEvent actionEvent) {
    }

    public void modifyProductDelete(javafx.event.ActionEvent actionEvent) {
    }

    public void modifyProductAdd(javafx.event.ActionEvent actionEvent) {
    }
}