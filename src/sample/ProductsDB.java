/*
 * @Author - Rohit Aggarwal
 * @products data access class
 * Javafx workshop 6
 * */

package sample;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductsDB {

    // retrieve products table data
    public static ArrayList<Products> getProducts() throws SQLException {
        // declare an empty list
        ArrayList<Products> products = new ArrayList<>();

        // SQL query
        String query = "SELECT * FROM products";

        // execute Query using DatabaseUtility class
        ResultSet results = DatabaseUtility.getResults(query);

        // store results in the empty list
        while(results.next()){
            Products product= new Products(
                    (int)results.getObject(1),
                    (String)results.getObject(2));
            products.add(product);
        }

        // return the list
        return products;
    }

    public static Products getProduct(Integer id) throws SQLException {
        // declare an empty list
        Products product = new Products();

        // SQL query
        String query = "SELECT * FROM products where ProductId = " + id;

        // execute Query using DatabaseUtility class
        ResultSet results = DatabaseUtility.getResults(query);

        // store results in the empty list
        while(results.next()){
            product= new Products(
                    (int)results.getObject(1),
                    (String)results.getObject(2));
        }

        // return the list
        return product;
    }

    // Update products table
    public static void postUpdateProducts(Products product){
        try{
            // sql query to update table
            String query = "UPDATE products SET ProdName =? WHERE ProductID = ?";

            // create prepared statement
            PreparedStatement statement = DatabaseUtility.updateDatabase(query);

            // set the values to update
            statement.setString(1, product.getProductName());
            statement.setInt(2, product.getProductID());

            // execute the update statement
            statement.executeUpdate();
        }
        catch (NullPointerException | SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Insert new products
    public static void postInsertProducts(String name){
        try{
            // sql query to insert data
            String query = "INSERT INTO products (ProdName) VALUES (?)";

            //create prepared statement
            PreparedStatement statement = DatabaseUtility.updateDatabase(query);

            // set the values to insert
            statement.setString(1, name);

            // execute the update statement
            statement.executeUpdate();
        }
        catch (NullPointerException | SQLException ex){
            ex.printStackTrace();
        }
    }
}
