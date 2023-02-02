package pl.it.warehouse.gui;

import pl.it.warehouse.model.Bed;
import pl.it.warehouse.model.Product;
import pl.it.warehouse.model.Table;
import pl.it.warehouse.repository.ProductRepository;

import java.util.List;
import java.util.Scanner;

public class GUI {

    private static Scanner scanner = new Scanner(System.in);

    public static void showMainMenu() {
        System.out.println("1. Add the product");
        System.out.println("2. Deliver the product");
        System.out.println("3. Show all products");
        System.out.println("4. Exit");

        switch (scanner.nextLine()) {
            case "1":
                addProduct();
                showMainMenu();
                break;
            case "2":
                deliverProduct();
                showMainMenu();
                break;
            case "3":
                showAllProducts();
                showMainMenu();
                break;
            case "4":
                System.exit(0);
            default:
                System.out.println("Incorrect input. Try again!");
                showMainMenu();
        }
    }

    private static void showAllProducts() {
        List<Product> products = ProductRepository.getInstance().getAllProducts();
        for (Product currentProduct : products) {
            System.out.println(currentProduct);
        }
        System.out.println();
    }

    private static void deliverProduct() {
        System.out.println("Enter the product name:");
        String productToDeliver = scanner.nextLine();
        System.out.println("Enter number of pieces:");
        int piecesToDeliver = Integer.parseInt(scanner.nextLine());
        boolean success = ProductRepository.getInstance().deliverProductFromDB(productToDeliver, piecesToDeliver);
        if (success) {
            System.out.println("Delivered!");
        } else {
            System.out.println("Try again!");
        }
    }

    private static void addProduct() {
        System.out.println("Enter the name of the product:");
        String productName = scanner.nextLine();
        Product productFromDatabase = ProductRepository.getInstance().findProduct(productName);
        if (productFromDatabase != null) {
            System.out.println("Enter number of pieces:");
            int piecesToAdd = Integer.parseInt(scanner.nextLine());
            productFromDatabase.setPieces(productFromDatabase.getPieces() + piecesToAdd);
            System.out.println("Added!");
        } else {
            addNewProduct(productName);
        }
    }

    private static void addNewProduct(String productName) {
        System.out.println("1. Bed");
        System.out.println("2. Table");
        DataWrapper wrapper;
        switch (scanner.nextLine()) {
            case "1":
                wrapper = readCommonData();
                System.out.println("Enter the type:");
                String type = scanner.nextLine();
                Bed bed = new Bed(wrapper.size, productName, wrapper.color, wrapper.pieces, type);
                ProductRepository.getInstance().addProductToDB(bed);
                System.out.println("Added!");
                break;
            case "2":
                wrapper = readCommonData();
                System.out.println("Enter material:");
                String material = scanner.nextLine();
                Table table = new Table(wrapper.size, productName, wrapper.color, wrapper.pieces, material);
                ProductRepository.getInstance().addProductToDB(table);
                System.out.println("Added!");
                break;
            default:
                System.out.println("Incorrect input. Try again!");
                addNewProduct(productName);
        }
    }

    private static DataWrapper readCommonData() {
        System.out.println("Enter the size:");
        String size = scanner.nextLine();
        System.out.println("Enter the color:");
        String color = scanner.nextLine();
        System.out.println("Enter the pieces:");
        int pieces = Integer.parseInt(scanner.nextLine());
        return new DataWrapper(size, color, pieces);
    }

    static class DataWrapper {
        String size;
        String color;
        int pieces;

        public DataWrapper(String size, String color, int pieces) {
            this.size = size;
            this.color = color;
            this.pieces = pieces;
        }
    }
}
