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
import model.Outsourced;
import model.Product;

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
    public void start(Stage primaryStage) throws Exception {

        Inventory inventory = new Inventory();
        addTestData(inventory);

        Parent root = FXMLLoader.load(getClass().getResource("/ViewController/MainScreen.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }





    void addTestData(Inventory inv) {

        //Add InHouse Parts
        InHouse part1 = new InHouse(1, "part1", 5.00, 10, 1, 100, 101);
        InHouse part2 = new InHouse(2, "part2", 6.00, 20, 1, 100, 102);
        InHouse part3 = new InHouse(3, "part3", 7.00, 30, 1, 100, 103);


        Inventory.addPart(part1);
        Inventory.addPart(part2);
        Inventory.addPart(part3);


        //Outsourced parts
        Outsourced part6 = new Outsourced(6, "part6", 10.00, 60, 1, 100, "company1");
        Outsourced part7 = new Outsourced(7, "part7", 11.00, 70, 1, 100, "company2");
        Outsourced part8 = new Outsourced(8, "part8", 12.00, 80, 1, 100, "company3");



        Inventory.addPart(part6);
        Inventory.addPart(part7);
        Inventory.addPart(part8);


        //Products

        Product product1 = new Product(1, "product1", 6.00, 20, 1, 100);
        Product product2 = new Product(2, "product2", 5.00, 10, 1, 100);
        Product product3 = new Product(3, "product3", 7.00, 30, 1, 100);
        Product product4 = new Product(4, "product4", 8.00, 40, 1, 100);
        Product product5 = new Product(5, "product5", 9.00, 50, 1, 100);

        Inventory.addProduct(product1);
        Inventory.addProduct(product2);
        Inventory.addProduct(product3);
        Inventory.addProduct(product4);
        Inventory.addProduct(product5);




    }


    
}
