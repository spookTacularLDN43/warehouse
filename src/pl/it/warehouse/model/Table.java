package pl.it.warehouse.model;

public class Table extends Product{

    String material;

    public Table(String size, String name, String color, int pieces, String material) {
        super(size, name, color, pieces);
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "Table - " +
                "material='" + material + '\'' +
                ", " + super.toString();
    }
}
