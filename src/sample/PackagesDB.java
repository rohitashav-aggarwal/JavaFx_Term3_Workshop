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
import java.sql.Date;

public class PackagesDB {

    // retrieve products table data
    public static ArrayList<Packages> getPackages() throws SQLException {
        // declare an empty list
        ArrayList<Packages> myPackages = new ArrayList<>();

        // SQL query
        String query = "SELECT * FROM packages";

        // execute Query using DatabaseUtility class
        ResultSet results = DatabaseUtility.getResults(query);

        // store results in the empty list
        while(results.next()){
            Packages myPackage = new Packages(
                (int)results.getObject(1),
                (String)results.getObject(2),
                (Date)results.getObject(3),
                (Date)results.getObject(4),
                (String)results.getObject(5),
                (int)results.getObject(6),
                (int)results.getObject(7));
            myPackages.add(myPackage);
        }

        // return the list
        return myPackages;
    }

    // Update products table
    public static void UpdatePackages(Packages myPackage){
        try{
            // sql query to update table
            String query = "UPDATE packages SET PkgName = ?, PkgStartDate = ?, " +
                    "PkgEndDate = ?, PkgDesc = ?, PkgBasePrice = ?, PkgAgencyCommission = ? " +
                    "WHERE PackageId = ?;";

            // create prepared statement
            PreparedStatement statement = DatabaseUtility.updateDatabase(query);

            // set the values to update
            statement.setString(1, myPackage.getPkgName());
            statement.setDate(2, myPackage.getPkgStartDate());
            statement.setDate(3, myPackage.getPkgEndDate());
            statement.setString(4, myPackage.getPkgDesc());
            statement.setInt(5, myPackage.getPkgBasePrice());
            statement.setInt(6, myPackage.getPkgAgencyCom());
            statement.setInt(7, myPackage.getPackageID());

            // execute the update statement
            statement.executeUpdate();
        }
        catch (NullPointerException | SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Insert new products
    //STOPPPPPEDD HERE LASTTT
    public static void postInsertProducts(String name, Date pkgStart, Date pkgEnd, String pkgDes, int){
        try{
            // sql query to insert data
            String query = "INSERT INTO packages (PkgName, PkgStartDate, PkgEndDate, PkgDesc, " +
                    "PkgBasePrice, PkgAgencyCommission) " +
                    "VALUES (?, ?, ?, ?, ?, ?);";

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
