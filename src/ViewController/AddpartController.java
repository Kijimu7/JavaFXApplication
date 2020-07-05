package ViewController;


import javafx.event.ActionEvent;
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

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.Random;

public class AddpartController implements Initializable {
    Inventory inventory;
    private boolean isOutsourced = true;


    Stage stage;
    Parent scene;
    private Object ResourceBundle;
    @FXML

    private Object ActionEvent;


    @Override
    public void initialize(URL location, java.util.ResourceBundle resources) {

    }

    public AddpartController() {

    }

    public AddpartController(Inventory inventory) {
        this.inventory = inventory;
    }


    @FXML
    public Label addPartCnameLbl;

    @FXML
    private RadioButton addPartInhouseRBtn;

    @FXML
    private ToggleGroup toggleGroup;

    @FXML
    private RadioButton addPartOutsourcedRBtn;

    @FXML
    private TextField addPartMinTxt;

    @FXML
    private TextField addPartPriceTxt;

    @FXML
    private TextField addPartCnameTxt;

    @FXML
    private TextField addPartMachineTxt;

    @FXML
    private TextField addPartMaxTxt;

    @FXML
    private TextField addPartInvTxt;

    @FXML
    private TextField addPartNameTxt;

    @FXML
    private TextField addPartIdTxt;

    @FXML
    private TextField addPartDynamicTxt;

    @FXML
    private Button addPartsaveBtn;

    @FXML
    private Button addPartcancelBtn;


    @FXML
    void inhouseRbtnS(javafx.event.ActionEvent event) {
        isOutsourced = false;
        addPartCnameLbl.setText("Machine ID");
    }

    @FXML
    void outsourcedRBtnS(javafx.event.ActionEvent event) {
        isOutsourced = true;
        addPartCnameLbl.setText("Company Name");
    }


    @FXML
    void onActionSavePart(ActionEvent event) throws IOException {


        //Create auto Ids
        Random random = new Random();
        int id = random.nextInt(50);


        if (!isOutsourced) {

            InHouse newInHouse = new InHouse(0, "", 0, 0, 0, 0, 0);

            if (isValid(addPartNameTxt.getText(), addPartPriceTxt.getText(), addPartInvTxt.getText(), addPartMinTxt.getText(),
                    addPartMaxTxt.getText(), addPartDynamicTxt.getText())) {

                newInHouse.setId(id);
                if (!addPartNameTxt.getText().isEmpty()) {
                    newInHouse.setName(addPartNameTxt.getText());
                }
                if (!addPartPriceTxt.getText().isEmpty()) {
                    newInHouse.setPrice(Double.parseDouble(addPartPriceTxt.getText()));
                }
                if (!addPartInvTxt.getText().isEmpty()) {
                    newInHouse.setInv(Integer.parseInt(addPartInvTxt.getText()));
                }
                if (!addPartMinTxt.getText().isEmpty()) {
                    newInHouse.setMin(Integer.parseInt(addPartMinTxt.getText()));
                }
                if (!addPartMaxTxt.getText().isEmpty()) {
                    newInHouse.setMax(Integer.parseInt(addPartMaxTxt.getText()));
                }
                if (!addPartDynamicTxt.getText().isEmpty()) {
                    newInHouse.setMachineId(Integer.parseInt(addPartDynamicTxt.getText()));
                }

                Inventory.addPart(newInHouse);
                System.out.println("Part Added");

                Stage stage;
                Parent root;
                stage = (Stage) addPartsaveBtn.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/ViewController/MainScreen.fxml"));
                root = loader.load();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

        }else {
            Outsourced newOutsourced = new Outsourced(0, "", 0, 0, 0, 0, "");

            if (isValid(addPartNameTxt.getText(), addPartPriceTxt.getText(), addPartInvTxt.getText(), addPartMinTxt.getText(), addPartMaxTxt.getText(), addPartDynamicTxt.getText())) {

                newOutsourced.setId(id);
                if (!addPartNameTxt.getText().isEmpty()) {
                    newOutsourced.setName(addPartNameTxt.getText());
                }
                if (!addPartPriceTxt.getText().isEmpty()) {
                    newOutsourced.setPrice(Double.parseDouble(addPartPriceTxt.getText()));
                }
                if (!addPartInvTxt.getText().isEmpty()) {
                    newOutsourced.setInv(Integer.parseInt(addPartInvTxt.getText()));
                }
                if (!addPartMinTxt.getText().isEmpty()) {
                    newOutsourced.setMin(Integer.parseInt(addPartMinTxt.getText()));
                }
                if (!addPartMaxTxt.getText().isEmpty()) {
                    newOutsourced.setMax(Integer.parseInt(addPartMaxTxt.getText()));
                }
                if (!addPartDynamicTxt.getText().isEmpty()) {
                    newOutsourced.setCompanyName(addPartDynamicTxt.getText());
                }

                Inventory.addPart(newOutsourced);
                System.out.println("Part Added");

                Stage stage;
                Parent root;
                stage = (Stage) addPartsaveBtn.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/ViewController/MainScreen.fxml"));
                root = loader.load();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();


            }

        }
    }



    @FXML
    public void onActionCancel(javafx.event.ActionEvent event) throws IOException {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "This will clear all text field values, do you want to continue?");

        Optional<ButtonType> results = alert.showAndWait();

        if(results.isPresent() && results.get() == ButtonType.OK){
            stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
            stage.setScene(new Scene(scene));
            stage.show();

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

}



//    //                    int id = Integer.parseInt(addPartIdTxt.getText());
//    String name = addPartNameTxt.getText();
//    int inv = Integer.parseInt(addPartInvTxt.getText());
//    int max = Integer.parseInt(addPartMaxTxt.getText());
//    int min = Integer.parseInt(addPartMinTxt.getText());
//    double price = Double.parseDouble(addPartPriceTxt.getText());
//
//
//            if(addPartInhouseRBtn.isSelected()){
//        int machineId = Integer.parseInt(addPartMachineTxt.getText());
//        InHouse newInhousePart = new InHouse(id, name, price, inv, min, max, machineId);
//        Inventory.addPart(newInhousePart);
//    }
//            if(addPartOutsourcedRBtn.isSelected())
//
//    {
//        String Cname = addPartCnameTxt.getText();
//        Outsourced newOutsourcedPart = new Outsourced(id, name, price, inv, min, max, Cname);
//        Inventory.addPart(newOutsourcedPart);
//
//    }

