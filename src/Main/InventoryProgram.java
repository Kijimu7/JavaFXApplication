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

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../ViewController/MainScreen.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //InHouse
        Part part1 = new InHouse(1, "Part1", 5.00, 3, 100, 200);
        Part part2 = new InHouse(2, "Part2", 6.00, 3, 100, 250);
        Part part3 = new InHouse(3, "Part3", 7.00, 3, 100, 300);



        Inventory.addPart(part1);
        Inventory.addPart(part2);
        Inventory.addPart(part3);




        launch(args);
    }
    
}
