package ViewController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.InHouse;
import model.Outsourced;
import model.Part;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ModifypartController implements Initializable {

    Part part;
    private boolean isOutsourced = true;
    private int index;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    Stage stage;
    Parent scene;

    @FXML
    private RadioButton inHouseRBtn;

    @FXML
    private ToggleGroup toggleGroup;

    @FXML
    private RadioButton outsourcedRBtn;

    @FXML
    private TextField modifyPartMinTxt;

    @FXML
    private TextField modifyPartPriceTxt;

    @FXML
    private TextField modifyPartDynamicTxt;

    @FXML
    private TextField modifyPartMaxTxt;

    @FXML
    private TextField modifyPartInvTxt;

    @FXML
    private TextField modifyPartNameTxt;

    @FXML
    private TextField modifyPartIdTxt;

    @FXML
    private Button saveBtn;

    @FXML
    private Button cancelBtn;

    @FXML
    public Label modifyPartCnameLbl;


    @FXML
    void modifyPartSave(javafx.event.ActionEvent event) throws IOException{

        System.out.println("test");

    }

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
        modifyPartNameTxt.setText(part.getName());
        modifyPartInvTxt.setText(new Integer(part.getInv()).toString());
        modifyPartPriceTxt.setText(new Double(part.getPrice()).toString());
        modifyPartMaxTxt.setText(new Integer(part.getMax()).toString());
        modifyPartMinTxt.setText(new Integer(part.getMin()).toString());

        if(part instanceof InHouse){
            inHouseRBtn.fire();
            modifyPartDynamicTxt.setText(String.valueOf(((InHouse)part).getMachineId()));
        }else{
            outsourcedRBtn.fire();
            modifyPartDynamicTxt.setText(String.valueOf(((Outsourced)part).getMachineId()));
        }




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