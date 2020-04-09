// Author: Steven Hillman
// class for grabbing data and creating customer objects with that data

package sample;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDB {

    // grab all data from the customers table and initialize the data as customer objects
    public static ArrayList<Customer> getCustomers() throws SQLException {
        // declare an empty array list of type customer
        ArrayList<Customer> customerList = new ArrayList<>();

        // query to get all data from the customers table
        String query = "SELECT * FROM customers";

        // get the result set by executing the query and calling the database utilities
        ResultSet results = DatabaseUtility.getResults(query);

        // create new customer objects and add them to the customerList
        while(results.next()){
            Customer newCustomer= new Customer(
                    (int)results.getObject(1),
                    (String)results.getObject(2),
                    (String)results.getObject(3),
                    (String)results.getObject(4),
                    (String)results.getObject(5),
                    (String)results.getObject(6),
                    (String)results.getObject(7),
                    (String)results.getObject(8),
                    (String)results.getObject(9),
                    (String)results.getObject(10),
                    (String)results.getObject(11),
                    (int)results.getObject(12));
            customerList.add(newCustomer);
        }

        // return the customerList
        return customerList;
    }

    public static void updateCustomers(Customer customer){
        try{
            // sql query to update table
            String query = "UPDATE customers SET CustFirstName =?, CustLastName =? WHERE CustomerId = ?";

            // create prepared statement
            PreparedStatement statement = DatabaseUtility.updateDatabase(query);

            // set the values to update

            statement.setString(1, customer.getCustFirstName());
            statement.setString(2, customer.getCustLastName());
            statement.setInt(3, customer.getCustomerId());

            // execute the update statement
            statement.executeUpdate();
        }
        catch (NullPointerException | SQLException ex) {
            ex.printStackTrace();
        }
    }

    // insert a new customer with the given name, default values are added to avoid using multiple event listeners, the customer can be updated at anytime anyways
    public static void insertCustomer(String firstName){
        try{
            // sql query to insert data
            String query = "INSERT INTO customers (CustFirstName, CustLastName, CustAddress, CustCity, CustProv, CustPostal, " +
                    "CustCountry, CustHomePhone, CustBusPhone, CustEmail, AgentId) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

            //create prepared statement
            PreparedStatement statement = DatabaseUtility.updateDatabase(query);

            // set the values to insert
            statement.setString(1, firstName);
            statement.setString(2, firstName);
            statement.setString(3, firstName);
            statement.setString(4, firstName);
            statement.setString(5, "AB");
            statement.setString(6, firstName);
            statement.setString(7, firstName);
            statement.setString(8, firstName);
            statement.setString(9, firstName);
            statement.setString(10, firstName);
            statement.setInt(11, 1);

            // execute the update statement
            statement.executeUpdate();
        }
        catch (NullPointerException | SQLException ex){
            ex.printStackTrace();
        }
    }

}
