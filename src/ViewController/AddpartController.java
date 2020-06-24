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

public class AddpartController implements Initializable {

    Stage stage;
    Parent scene;


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



    @FXML public void onActionCancel(ActionEvent event) throws IOException {



    }


    @FXML
    void onActionSavePart(ActionEvent event) {

        System.out.println("test");

    }




    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void onActionSavePart(javafx.event.ActionEvent actionEvent) {
        int id = Integer.parseInt(addPartIdTxt.getText());
        String name = addPartNameTxt.getText();
        int stock = Integer.parseInt(addPartInvTxt.getText());
        String max = addPartMaxTxt.getText();
        String min = addPartMinTxt.getText();
        double price = Double.parseDouble(addPartPriceTxt.getText());


    }



    public void onActionCancel(javafx.event.ActionEvent event) throws IOException{


        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        stage.setScene(new Scene((Parent) scene));
        stage.show();
    }
}
