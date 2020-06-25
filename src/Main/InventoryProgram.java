/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.InHouse;
import model.Inventory;
import model.Part;

/**
 *
 * @author pinko
 */
public class

InventoryProgram extends Application {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception {

        Inventory inventory = new Inventory();
        addTestData(inventory);

        Parent root = FXMLLoader.load(getClass().getResource("../ViewController/MainScreen.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



    void addTestData(Inventory inv) {

        //Add InHouse Parts
        Part part1 = new InHouse(1, "InPart1", 5.00, 10, 1, 100, 101);
        Part part2 = new InHouse(2, "InPart2", 6.00, 20, 1, 100, 102);
        Part part3 = new InHouse(3, "InPart3", 7.00, 30, 1, 100, 103);
        Part part4 = new InHouse(4, "InPart4", 8.00, 40, 1, 100, 104);
        Part part5 = new InHouse(5, "InPart4", 8.00, 40, 1, 100, 105);

        Inventory.addPart(part1);
        Inventory.addPart(part2);
        Inventory.addPart(part3);
        Inventory.addPart(part4);
        Inventory.addPart(part5);



    }


    
}
