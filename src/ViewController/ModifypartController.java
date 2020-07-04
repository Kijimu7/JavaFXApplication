package ViewController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.InHouse;
import model.Inventory;
import model.Outsourced;
import model.Part;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ModifypartController implements Initializable {


    Part part;
    private boolean isOutsourced = true;
    private int index = 0;




    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public ModifypartController(){

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


    public void setPart(Part part){
        this.part = part;


        modifyPartIdTxt.setText(Integer.toString(part.getId()));
        modifyPartNameTxt.setText(part.getName());
        modifyPartInvTxt.setText(Integer.toString(part.getInv()));
        modifyPartPriceTxt.setText(Double.toString(part.getPrice()));
        modifyPartMaxTxt.setText(Integer.toString(part.getMax()));
        modifyPartMinTxt.setText(Integer.toString(part.getMin()));

        if(part instanceof InHouse){
            inHouseRBtn.fire();
            modifyPartDynamicTxt.setText(String.valueOf(((InHouse)part).getMachineId()));
        }else{
            outsourcedRBtn.fire();
            modifyPartDynamicTxt.setText(String.valueOf(((Outsourced)part).getCompanyName()));
        }

    }

    @FXML
    void modifyPartSave(javafx.event.ActionEvent event) throws IOException{



            InHouse newInHouse = new InHouse(0, "", 0, 0, 0, 0, 0);
            index = Inventory.getAllParts().indexOf(part);

        if (!isOutsourced) {

            if (isValid(modifyPartNameTxt.getText(), modifyPartPriceTxt.getText(), modifyPartInvTxt.getText(), modifyPartMinTxt.getText(),
                    modifyPartMaxTxt.getText(), modifyPartDynamicTxt.getText())) {


                if (!modifyPartNameTxt.getText().isEmpty()) {
                    newInHouse.setName(modifyPartNameTxt.getText());
                }
                if (!modifyPartPriceTxt.getText().isEmpty()) {
                    newInHouse.setPrice(Double.parseDouble(modifyPartPriceTxt.getText()));
                }
                if (!modifyPartInvTxt.getText().isEmpty()) {
                    newInHouse.setInv(Integer.parseInt(modifyPartInvTxt.getText()));
                }
                if (!modifyPartMinTxt.getText().isEmpty()) {
                    newInHouse.setMin(Integer.parseInt(modifyPartMinTxt.getText()));
                }
                if (!modifyPartMaxTxt.getText().isEmpty()) {
                    newInHouse.setMax(Integer.parseInt(modifyPartMaxTxt.getText()));
                }
                if (!modifyPartDynamicTxt.getText().isEmpty()) {
                    newInHouse.setMachineId(Integer.parseInt(modifyPartDynamicTxt.getText()));
                }

                Inventory.updatePart(index, newInHouse);
                System.out.println("Part modified");

                Stage stage;
                Parent root;
                stage = (Stage) saveBtn.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/ViewController/MainScreen.fxml"));
                root = loader.load();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

        }else {
            Outsourced newOutsourced = new Outsourced(0, "", 0, 0, 0, 0, "");

            if (isValid(modifyPartNameTxt.getText(), modifyPartPriceTxt.getText(), modifyPartInvTxt.getText(), modifyPartMinTxt.getText(), modifyPartMaxTxt.getText(), modifyPartDynamicTxt.getText())) {


                if (!modifyPartNameTxt.getText().isEmpty()) {
                    newOutsourced.setName(modifyPartNameTxt.getText());
                }
                if (!modifyPartPriceTxt.getText().isEmpty()) {
                    newOutsourced.setPrice(Double.parseDouble(modifyPartPriceTxt.getText()));
                }
                if (!modifyPartInvTxt.getText().isEmpty()) {
                    newOutsourced.setInv(Integer.parseInt(modifyPartInvTxt.getText()));
                }
                if (!modifyPartMinTxt.getText().isEmpty()) {
                    newOutsourced.setMin(Integer.parseInt(modifyPartMinTxt.getText()));
                }
                if (!modifyPartMaxTxt.getText().isEmpty()) {
                    newOutsourced.setMax(Integer.parseInt(modifyPartMaxTxt.getText()));
                }
                if (!modifyPartDynamicTxt.getText().isEmpty()) {
                    newOutsourced.setCompanyName(modifyPartDynamicTxt.getText());
                }

                Inventory.updatePart(index, newOutsourced);
                System.out.println("Part modified");

                Stage stage;
                Parent root;
                stage = (Stage) saveBtn.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/ViewController/MainScreen.fxml"));
                root = loader.load();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();


            }

        }
    }



    private boolean isValid(String partName, String partPrice, String partInv, String partMin, String partMax, String toggleGroup ) {

        String errorMessage = "";
        Integer intMin = null, intMax = null;
        boolean isValid;



       if (partName == null || partName.isEmpty()) {
        errorMessage += ("Need to input part name\n");
    }

        try {
        intMin = Integer.parseInt(partMin);
    } catch (NumberFormatException e) {
        errorMessage += ("Min must a number\n");
    }

        try {
        intMax = Integer.parseInt(partMax);
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
        int intInv = Integer.parseInt(partInv);

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
        try {
        double price = Double.parseDouble(partPrice);
        if (price < 0) {
            errorMessage += ("Price cannot be less than zero\n");
        }
    } catch (NumberFormatException e) {
        errorMessage += ("Price cannot be blank and must be a number\n");
    }

        if (!isOutsourced) {
        if (!toggleGroup.isEmpty()) {
            try {
                Integer.parseInt(toggleGroup);
            } catch (NumberFormatException e) {
                errorMessage += ("MachineId must be a number");
            }
        } else {
            errorMessage += ("MachineId cannot be black\n");
        }
    } else {
        if (toggleGroup.isEmpty()) {
            errorMessage += ("Company name cannot be blank \n");
        }
    }
        if (errorMessage.isEmpty() == true) {
        isValid = true;
    } else {
        isValid = false;
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Part Validation error");
        alert.setHeaderText("Error");
        alert.setContentText(errorMessage);
        alert.showAndWait();
    }

        return isValid;
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

    public void modifyPartInvOnAction(javafx.event.ActionEvent actionEvent) {
    }

    public void modifyPartNameOnAction(javafx.event.ActionEvent actionEvent) {
    }
}