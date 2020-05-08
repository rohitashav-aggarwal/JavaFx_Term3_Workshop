package sample;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

public class PackageDB {
    public static ArrayList<Package> getPackages() throws SQLException {
        ArrayList<Package> packageList = new ArrayList<>();

        String query = "SELECT * FROM packages";

        ResultSet results = DatabaseUtility.getResults(query);

        while (results.next()) {
            Package pkg = new Package(
                    (int)results.getObject(1),
                    (String)results.getObject(2),
                    String.valueOf((Timestamp) results.getObject(3)),
                    String.valueOf((Timestamp) results.getObject(4)),
                    (String)results.getObject(5),
                    (BigDecimal)results.getObject(6),
                    (BigDecimal)results.getObject(7));
            packageList.add(pkg);
        }

        return packageList;
    }

    public static Package getPackage(int id) throws SQLException {
        Package pkg = new Package();

        String query = "Select * from Packages where PackageId = " + id;

        ResultSet results = DatabaseUtility.getResults(query);

        while(results.next()) {
            pkg = new Package(
                    (int)results.getObject(1),
                    (String)results.getObject(2),
                    String.valueOf((Timestamp) results.getObject(3)),
                    String.valueOf((Timestamp) results.getObject(4)),
                    (String)results.getObject(5),
                    (BigDecimal)results.getObject(6),
                    (BigDecimal)results.getObject(7));
        }
        return pkg;
    }

    public static void updatePackage(Package pkg){
        try{
            // SQL query to update bookings table
            String query = "UPDATE packages SET PkgName = ?, PkgStartDate = ?, PkgEndDate = ?, PkgDesc = ?, " +
                    "PkgBasePrice = ?, PkgAgencyCommission = ? WHERE PackageId = ?";

            // Create a prepared statement
            PreparedStatement statement = DatabaseUtility.updateDatabase(query);

            // Set the values in the statement
            statement.setString(1, String.valueOf(pkg.getPkgName()));
            statement.setString(2, pkg.getPkgStartDate());
            statement.setString(3, pkg.getPkgEndDate());
            statement.setString(4, pkg.getPkgDesc());
            statement.setBigDecimal(5, pkg.getPkgBasePrice());
            statement.setBigDecimal(6, pkg.getPkgAgencyCommission());
            statement.setInt(7, pkg.getPackageId());
            // Execute update statement
            statement.executeUpdate();
        }
        catch (NullPointerException | SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void insertPackage(Package pkg){
        try{
            // sql query to insert data
            String query = "INSERT INTO packages (PkgName, PkgStartDate, PkgEndDate, PkgDesc, PkgBasePrice, PkgAgencyCommission " +
                    "VALUES (?,?,?,?,?,?)";

            //create prepared statement
            PreparedStatement statement = DatabaseUtility.updateDatabase(query);

            // set the values to insert
            statement.setString(1, pkg.getPkgName());
            statement.setString(2, pkg.getPkgStartDate());
            statement.setString(3, pkg.getPkgEndDate());
            statement.setString(4, pkg.getPkgDesc());
            statement.setBigDecimal(5, pkg.getPkgBasePrice());
            statement.setBigDecimal(6, pkg.getPkgAgencyCommission());

            // execute the update statement
            statement.executeUpdate();
        }
        catch (NullPointerException | SQLException ex){
            ex.printStackTrace();
        }
    }
}
