package pl.it.warehouse.model;

public class Bed extends Product{
    String type;

    public Bed(String size, String name, String color, int pieces, String type) {
        super(size, name, color, pieces);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
