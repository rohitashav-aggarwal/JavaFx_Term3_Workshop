/*
 * @Author - Rohit Aggarwal
 * @products data access class
 * Javafx workshop 6
 * */

package sample;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

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
                (Timestamp) results.getObject(3),
                (Timestamp)results.getObject(4),
                (String)results.getObject(5),
                (BigDecimal) results.getObject(6),
                (BigDecimal)results.getObject(7));

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
            statement.setTimestamp(2, myPackage.getPkgStartDate());
            statement.setTimestamp(3, myPackage.getPkgEndDate());
            statement.setString(4, myPackage.getPkgDesc());
            statement.setBigDecimal(5, myPackage.getPkgBasePrice());
            statement.setBigDecimal(6, myPackage.getPkgAgencyCom());
            statement.setInt(7, myPackage.getPackageID());

            // execute the update statement
            statement.executeUpdate();
        }
        catch (NullPointerException | SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Insert new product
    public static void InsertPackage(String pkgName, Timestamp pkgStart, Timestamp pkgEnd,
                                     String pkgDes, BigDecimal pkgPrice, BigDecimal pkgAgencyCom){
        try{
            // sql query to insert data
            String query = "INSERT INTO packages (PkgName, PkgStartDate, PkgEndDate, PkgDesc, " +
                    "PkgBasePrice, PkgAgencyCommission) " +
                    "VALUES (?, ?, ?, ?, ?, ?);";

            //create prepared statement
            PreparedStatement statement = DatabaseUtility.updateDatabase(query);

            // set the values to insert
            statement.setString(1, pkgName);
            statement.setTimestamp(2, pkgStart);
            statement.setTimestamp(3, pkgEnd);
            statement.setString(4, pkgDes);
            statement.setBigDecimal(5, pkgPrice);
            statement.setBigDecimal(6, pkgAgencyCom);

            // execute the update statement
            statement.executeUpdate();
        }
        catch (NullPointerException | SQLException ex){
            ex.printStackTrace();
        }
    }


}
