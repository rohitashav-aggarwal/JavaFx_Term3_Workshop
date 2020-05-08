// Author - Jared Bellamy

package sample;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class PackagesDB {

    // retrieve Packages into table data
    public static ArrayList<Packages> getPackages() throws SQLException {
        // make empty list
        ArrayList<Packages> myPackages = new ArrayList<>();

        // sql query
        String query = "SELECT * FROM packages";

        // execute query using DatabaseUtility 
        ResultSet results = DatabaseUtility.getResults(query);

        // store results in empty list
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

        // return populated list
        return myPackages;


    }

    // update packages table
    public static void UpdatePackages(Packages myPackage){
        try{
            // sql query for updating table
            String query = "UPDATE packages SET PkgName = ?, PkgStartDate = ?, " +
                    "PkgEndDate = ?, PkgDesc = ?, PkgBasePrice = ?, PkgAgencyCommission = ? " +
                    "WHERE PackageId = ?;";

            // prepared statement
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

    // insert new packages
    public static void InsertPackage(String pkgName){
        try{
            // sql query to insert packages
            String query = "INSERT INTO packages (PkgName, PkgStartDate, PkgEndDate, PkgDesc, " +
                    "PkgBasePrice, PkgAgencyCommission) " +
                    "VALUES (?, ?, ?, ?, ?, ?);";

            
            PreparedStatement statement = DatabaseUtility.updateDatabase(query);

            
            statement.setString(1, pkgName);
            statement.setString(2, pkgName);
            statement.setString(3, pkgName);
            statement.setString(4, pkgName);
            statement.setString(5, pkgName);
            statement.setString(6, pkgName);

            
            statement.executeUpdate();
        }
        catch (NullPointerException | SQLException ex){
            ex.printStackTrace();
        }
    }


}
