/*
 * @Author - Rohit Aggarwal
 * @Product class: Declare fields, constructors and getters and setters
 * Javafx workshop 6
 * */

package sample;

public class Products {
    private int productID;
    private String productName;

    public Products(int id, String name) {
        productID = id;
        productName = name;
    }

    public Products(){};

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
