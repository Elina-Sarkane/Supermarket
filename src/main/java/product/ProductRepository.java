package product;

import database.DatabaseHandler;

import java.sql.*;
import java.util.ArrayList;

public class ProductRepository {
    //repository is something that connects to database/storage
    private DatabaseHandler databaseHandler = new DatabaseHandler();

    public void addProduct(Product product) throws SQLException{
        Connection connection = databaseHandler.getConnection();
        String query = "INSERT INTO market(name, price, quantity) VALUES(?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, product.getProductName());
        preparedStatement.setFloat(2, product.getProductPrice());
        preparedStatement.setInt(3, product.getProductQuantity());

        preparedStatement.execute();
    }
    public ArrayList<Product> getAll() throws SQLException {
        Statement statement = databaseHandler.getConnection().createStatement();

        String query = "SELECT * FROM market";
        ResultSet results = statement.executeQuery(query);

        ArrayList<Product> products = new ArrayList<Product>();

        while(results.next()){
            int id = results.getInt("id");
            String name = results.getString("name");
            float price = results.getFloat("price");
            int quantity = results.getInt("quantity");


            products.add(new Product(id, name, price, quantity));
        }

        statement.close();
        return products;
    }
}
