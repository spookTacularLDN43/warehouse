package pl.it.warehouse.repository;

import org.w3c.dom.css.CSSUnknownRule;
import pl.it.warehouse.model.Bed;
import pl.it.warehouse.model.Product;
import pl.it.warehouse.model.Table;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private List<Product> products = new ArrayList<>();
    private static final ProductRepository productRepository = new ProductRepository();

    private ProductRepository() {
        this.products.add(new Bed("large", "Sofia", "blue", 23, "double"));
        this.products.add(new Bed("king-size", "Emoll", "white", 15, "double"));
        this.products.add(new Bed("small", "Chase", "yellow", 12, "single"));
        this.products.add(new Table("large", "Teo", "brown", 10, "wood"));
        this.products.add(new Table("medium", "Ipo", "black", 32, "metal"));
        this.products.add(new Table("small", "Glas", "transparent", 23, "glass"));
    }

    public static ProductRepository getInstance() {
        return productRepository;
    }

    public List<Product> getAllProducts() {
        return this.products;
    }

    public boolean deliverProductFromDB(String productName, int pieces) {
        for (Product currentProduct : this.products) {
            if (currentProduct.getName().equals(productName) && currentProduct.getPieces() >= pieces) {
                currentProduct.setPieces(currentProduct.getPieces() - pieces);
                return true;
            }
        }
        return false;
    }

    public Product findProduct(String productName) {
        for (Product currentProduct : this.products) {
            if (currentProduct.getName().equals(productName)) {
                return currentProduct;
            }
        }
        return null;
    }

    public void addProductToDB(Product product) {
        this.products.add(product);
    }
}