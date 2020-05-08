package sample;
import java.sql.*;

public class DatabaseUtility {
    /*
     * @Author - Rohit Aggarwal
     * @Database connection
     * Javafx workshop 6
     * */
    // connection to travel experts database
    public static Connection getConnectionString() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/travelexperts",
                    "root", "test");
            System.out.println("********Database connection established.********");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("********Database connection could not be established********");
        }
        return conn;
    }

    /*
     * @Author - Rohit Aggarwal
     * @executing query with travel exerts connection written above
     * Javafx workshop 6
     * */
    public static ResultSet getResults(String query) {
        return getResults(query, getConnectionString());
    }

    /*
     * @Author - Rohit Aggarwal
     * @executing query with overloaded method without connection (option to pass your connection
     * Javafx workshop 6
     * */
    public static ResultSet getResults(String query, Connection connection){
        ResultSet rSet = null;
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            rSet = stmt.executeQuery();
            System.out.println("********" + query +" Executed.********");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("********Query cannot be Executed.********");
        }
        return rSet;
    }

    /*
     * @Author - Rohit Aggarwal
     * @update (insert/update/delete) any database table
     * Javafx workshop 6
     * */
    public static PreparedStatement updateDatabase(String query){
        Connection conn = getConnectionString();
        PreparedStatement stmt = null;
        try
        {
            stmt = conn.prepareStatement(query);
        }
        catch (Exception e)
        {
            System.err.println("********Query cannot be Executed.********");
            System.err.println(e.getMessage());
        }
        return stmt;
    }
}
