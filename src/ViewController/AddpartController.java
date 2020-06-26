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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddpartController implements Initializable {
    Inventory inventory;
    private boolean isOutsourced = true;


    Stage stage;
    Parent scene;

    public AddpartController() {

    }

    public AddpartController(Inventory inventory) { this.inventory = inventory; }


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
    private Button addPartsaveBtn;

    @FXML
    private Button addPartcancelBtn;


//    @FXML
//    public void onActionCancel(ActionEvent event) throws IOException {
//
//
//    }


//    @FXML
//    void onActionSavePart(ActionEvent event) {
//
//        System.out.println("test");
//
//    }

//
//    @FXML
//    void addPartInhouseRBtnSelected(ActionEvent event){
//        isOutsourced = false;
//        addPartCnameLbl.setText("Machine ID");
//    }
//
//    @FXML
//    void addPartOutsourcedRBtnSelected(ActionEvent event){
//        isOutsourced = true;
//        addPartCnameLbl.setText("Company Name");
//    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

        //This method will update the radioButtonLabel when different radio button is pushed


//        if (this.toggleGroup.getSelectedToggle().equals(this.addPartOutsourcedRBtn))
//            addPartCnameLbl.setText("Company name");
//
//        if (this.toggleGroup.getSelectedToggle().equals(this.addPartInhouseRBtn))
//            addPartCnameLbl.setText("Machine Id");




            public void onActionSavePart (javafx.event.ActionEvent event) throws IOException {

                int id = Integer.parseInt(addPartIdTxt.getText());
                String name = addPartNameTxt.getText();
                int inv = Integer.parseInt(addPartInvTxt.getText());
                int max = Integer.parseInt(addPartMaxTxt.getText());
                int min = Integer.parseInt(addPartMinTxt.getText());
                double price = Double.parseDouble(addPartPriceTxt.getText());


                if (addPartInhouseRBtn.isSelected()) {
                    int machineId = Integer.parseInt(addPartMachineTxt.getText());
                    InHouse newInhousePart = new InHouse(id, name, price, inv, min, max, machineId);
                    Inventory.addPart(newInhousePart);
                }
                if (addPartOutsourcedRBtn.isSelected()) {
                    String Cname = addPartCnameTxt.getText();
                    Outsourced newOutsourcedPart = new Outsourced(id, name, price, inv, min, max, Cname);
                    Inventory.addPart(newOutsourcedPart);

                }
                onActionCancel(event);


            }


            public void onActionCancel (javafx.event.ActionEvent event) throws IOException {


                stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
                scene = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
                stage.setScene(new Scene((Parent) scene));
                stage.show();
            }


            private ToggleGroup getToggleGroup () {
                return toggleGroup;
            }

   @FXML
     void inhouseRadioButtonSelected(javafx.event.ActionEvent actionEvent) {
         isOutsourced = false;
         addPartCnameLbl.setText("Machine ID");
    }
    @FXML
     void outsourcedRadioButtonSelected(javafx.event.ActionEvent actionEvent) {
         isOutsourced = true;
         addPartCnameLbl.setText("Company Name");
    }
}
