package product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductController {
    //controller creates business related stuff, like find products, create products, etc.
    ProductRepository productRepository = new ProductRepository();
    private ArrayList<Product> products = new ArrayList<>();

    public String createProduct(Product product){
        //Product product = collectProductInfo();
        try {
            productRepository.addProduct(product);
        }catch (SQLException e){
            e.printStackTrace();
            return "error with creating product";
        }
        return "Product created successfully!\n";
    }

    public ArrayList<Product> getAllProducts() {
        ArrayList<Product> products = new ArrayList<Product>();
        try {
            products = productRepository.getAll();
        }catch (SQLException e){
            System.out.println(e);
        }

        return products;
    }

}
