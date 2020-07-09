package model;

public class Outsourced extends Part {

    private String companyName;

    public Outsourced(int id, String name, double price, int inv, int min, int max, String companyName) {
        super(id, name, price, inv, min, max);
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
