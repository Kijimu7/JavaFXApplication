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

    public static Part lookupPart(int partId) {
        for (Part part : allParts) {
            if (part.getId() == partId) {
                return part;
            }
        }
        return null;
    }

    public static Product lookupProduct(int productId)
    {
        for(Product product : allProducts){
            if(product.getId() == productId){
                return product;
            }
        }
        return null;
    }

    public static ObservableList<Part> lookupPart(String partName)
    {
    ObservableList<Part> foundParts = FXCollections.observableArrayList();
    for(int i = 0; i < allParts.size(); i++){
        if(allParts.get(i).getName().toLowerCase().contains(partName.toLowerCase())){
            foundParts.add(allParts.get(i));
        }
           }
    return foundParts;
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
    public static boolean deletePart(Part selectedPart){
        allParts.remove(selectedPart);
        return true;
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
