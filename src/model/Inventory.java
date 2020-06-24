package model;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventory {

    private static ObservableList<Part> allParts = FXCollections.observableArrayList();
    private static ObservableList<Product> allProducts = FXCollections.observableArrayList();

        //add

        public static void addPart(Part newPart)
        {

            allParts.add(newPart);
        }

        public static void addProduct(Product newProduct)
        {

            allProducts.add(newProduct);
        }

        //lookup

    public static void lookupPart(int partId)
    {
       //part
    }

    public static void lookupProduct(int productID)
    {
        //product
    }

    public static void lookupPart(String partName)
    {
    //ObservableList<Part>
    }
    public static void lookupProduct(String productName)
    {
        //ObservableList<Product>
    }


    //update

    public static void updatePart(int index, Part selectedPart){

    }

    public static void updateProduct(int index, Product newProduct){

    }

    //delete
    public static void deletePart(Part selectedPart){
        //boolean
    }

    public static void deleteProduct(Product selectedProduct){
        //boolean
    }


        //get

        public static ObservableList<Part> getAllParts()
        {

            return allParts;
        }

        public static ObservableList<Product> getAllProducts()
        {
            return allProducts;
        }
}
