package ViewController;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.InHouse;
import model.Inventory;
import model.Outsourced;
import sun.plugin.dom.html.HTMLBodyElement;

import java.io.IOException;
import java.net.URL;
import java.util.Random;

public class AddpartController implements Initializable {
    Inventory inventory;
    private boolean isOutsourced = true;


    Stage stage;
    Parent scene;
    private Object ResourceBundle;
    private HTMLBodyElement addPartDynamicTxt;
    private Object ActionEvent;

    @Override
    public void initialize(URL location, java.util.ResourceBundle resources) {

    }

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


    @FXML
    void inhouseRadioButtonSelected(javafx.event.ActionEvent event){
        isOutsourced = false;
        addPartCnameLbl.setText("Machine ID");
    }
    @FXML
    void outsourcedRadioButtonSelected(javafx.event.ActionEvent event){
        isOutsourced = true;
        addPartCnameLbl.setText("Company Name");
    }

    public void onActionCancel (javafx.event.ActionEvent event) throws IOException {

        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        stage.setScene(new Scene((Parent) scene));
        stage.show();
    }



    void onActionSavePart(ActionEvent event) throws IOException {



            //Create auto Ids
            Random random = new Random();
            int id = random.nextInt(50);


            if (isOutsourced == false) {

                InHouse newInHouse = new InHouse(0, "", 0, 0, 0, 0, 0);

                if (isValid(addPartNameTxt.getText(), addPartPriceTxt.getText(), addPartInvTxt.getText(), addPartMinTxt.getText(),
                        addPartMaxTxt.getText(), addPartDynamicTxt.getText())) {

                    newInHouse.setId(id);
                    if (!addPartNameTxt.getText().isEmpty()) {
                        newInHouse.setName(addPartNameTxt.getText());
                    }
                    if (!addPartPriceTxt.getText().isEmpty()) {
                        newInHouse.setName(addPartPriceTxt.getText());
                    }
                    if (!addPartInvTxt.getText().isEmpty()) {
                        newInHouse.setName(addPartInvTxt.getText());
                    }
                    if (!addPartMinTxt.getText().isEmpty()) {
                        newInHouse.setName(addPartMinTxt.getText());
                    }
                    if (!addPartMaxTxt.getText().isEmpty()) {
                        newInHouse.setName(addPartMaxTxt.getText());
                    }
                    if (!addPartDynamicTxt.getText().isEmpty()) {
                        newInHouse.setName(addPartDynamicTxt.getText());
                    }

                    inventory.addPart(newInHouse);
                    System.out.println("Part Added");

                    Stage stage;
                    Parent root;
                    stage = (Stage) addPartsaveBtn.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/ViewController/MainScreen.fxml"));
                    root = loader.load();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();


                }else{
                    Outsourced newOutsourced = new Outsourced(0, "", 0, 0, 0, 0, "");

                    if (isValid(addPartNameTxt.getText(), addPartPriceTxt.getText(), addPartInvTxt.getText(), addPartMinTxt.getText(),
                            addPartMaxTxt.getText(), addPartDynamicTxt.getText())) {

                        newOutsourced.setId(id);
                        if (!addPartNameTxt.getText().isEmpty()) {
                            newOutsourced.setName(addPartNameTxt.getText());
                        }
                        if (!addPartPriceTxt.getText().isEmpty()) {
                            newOutsourced.setName(addPartPriceTxt.getText());
                        }
                        if (!addPartInvTxt.getText().isEmpty()) {
                            newOutsourced.setName(addPartInvTxt.getText());
                        }
                        if (!addPartMinTxt.getText().isEmpty()) {
                            newOutsourced.setName(addPartMinTxt.getText());
                        }
                        if (!addPartMaxTxt.getText().isEmpty()) {
                            newOutsourced.setName(addPartMaxTxt.getText());
                        }
                        if (!addPartDynamicTxt.getText().isEmpty()) {
                            newOutsourced.setName(addPartDynamicTxt.getText());
                        }

                        inventory.addPart(newOutsourced);
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

                public boolean isValid(String partName, String partStock, String partPrice, String partMax, String partMin, String partOrigin) throws IOException {
                    String errorMessage = "";
                    Integer intMin = null, intMax = null;
                    boolean isValid;

                    if (partName == null || addPartNameTxt.isEmpty()){
                        errorMessage += ("Need to input part name\n");
                    }

                }













//                    int id = Integer.parseInt(addPartIdTxt.getText());
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
                  


                }





            }


