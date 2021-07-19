package menu;

import product.Product;
import product.ProductController;

import java.util.ArrayList;
import java.util.Scanner;

public class OwnerMenu {
    Scanner scanner = new Scanner(System.in);
    ProductController productController = new ProductController();
    private ArrayList<Product> products = new ArrayList<>();

    public void addProduct() {
        Product newProduct = new Product();
            System.out.println("Add new Product");
            System.out.println("Enter product name: ");
            newProduct.setProductName(scanner.nextLine());
            System.out.println("Enter product price: ");
            newProduct.setProductPrice(Float.parseFloat(scanner.nextLine()));
            System.out.println("Enter product quantity: ");
            newProduct.setProductQuantity(Integer.parseInt(scanner.nextLine()));

        System.out.println(productController.createProduct(newProduct));
    }

    public void updateProducts() {

    }

    public void viewAllProducts() {
        System.out.println("All products in shop: ");
        System.out.println("ID | Name | Price | Quantity");
        ArrayList<Product> products = productController.getAllProducts();
        for (Product currentProducts: products){
            System.out.println(currentProducts.getId() + "\t "+
                    currentProducts.getProductName() + "\t " +
                    currentProducts.getProductPrice() + "\t " +
                    currentProducts.getProductQuantity() + "\n");
        }
    }

    public ArrayList<Product> removeProduct(int id) {
        //id = Integer.parseInt(scanner.nextLine());
        try {
            this.products.remove(id);
        }catch (IndexOutOfBoundsException e){
            System.out.println("Sorry, product not found!\n");
        }
        return products;
    }

    public void viewSalesHistory() {
    }
}
