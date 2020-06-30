/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author pinko
 */
public abstract class Part {

   //Declare field
   private int id;
   private String name;
   private double price;
   private int  inv;
   private int min;
   private int max;
   private int machineId;


   //Constructors
   public Part(int id, String name, double price, int inv, int min, int max) {
      this.id = id;
      this.name = name;
      this.price = price;
      this.inv = inv;
      this.min = min;
      this.max = max;
   }


//Declare methods

   //getters
   public int getId(){
      return id;
   }
   public String getName(){
      return name;
   }
   public double getPrice(){
      return price;
   }
   public int getInv(){
      return inv;
   }
   public int getMin(){
      return min;
   }
   public int getMax(){
      return max;
   }
   public int getMachineId(){
      return machineId;
   }

   //setters
   public void setId(int id){
      //this refereeing set object
      this.id = id;
   }

   public void setName(String name){

      this.name = name;
   }

   public void setPrice(double price){

      this.price = price;
   }

   public void setInv(int inv){

      this.inv = inv;
   }

   public void setMin(int min){

      this.min = min;
   }

   public void setMax(int max){

      this.max = max;
   }


   public void setMachineId(int machineId) {
      this.machineId = machineId;
   }
}
