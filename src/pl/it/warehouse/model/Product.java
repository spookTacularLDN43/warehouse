package pl.it.warehouse.model;

public class Product {
    private String size;
    private String name;
    private String color;
    private int pieces;

    public Product(String size, String name, String color, int pieces) {
        this.size = size;
        this.name = name;
        this.color = color;
        this.pieces = pieces;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPieces() {
        return pieces;
    }

    public void setPieces(int pieces) {
        this.pieces = pieces;
    }
}
