package model;

public class InHouse extends Part {
    private int machineId;

    public InHouse(int id, String name, double price, int inv, int min, int max, int machineId) {
        super(id,name ,price ,inv ,min, max);
        this.machineId = machineId;
    }

    public int getMachineId() {
        return machineId;
    }

    public void setMachineId(int machineId) {
        this.machineId = machineId;
    }






    }

