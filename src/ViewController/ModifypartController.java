package ViewController;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class ModifypartController implements Initializable {

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

        System.out.println("test");

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void modifyPartCancel(javafx.event.ActionEvent actionEvent) {

    }
}
