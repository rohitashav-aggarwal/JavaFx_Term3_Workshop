package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

/*
 * @Author - Rohit Aggarwal
 * @Controller class (Table View for products)
 * Javafx workshop 6
 * */
public class Controller implements Initializable {

    @FXML
    private Button btnCustomers;

    @FXML
    private Button btnBookings;

    @FXML
    private Button btnPackages;

    @FXML
    private Button btnProducts;

    @FXML
    private Button btnClose;

    @FXML
    private Label lblTest;

    @FXML
    private TableView<Products> productsView;

    @FXML
    private TableColumn productIdColumn;

    @FXML
    private TableColumn productNameColumn;

    @FXML
    private Button btnAddProduct;

    @FXML
    private Button btnUpdateProduct;

    /*
     * @Author - Rohit Aggarwal
     * @add new product
     * Javafx workshop 6
     * */
    @FXML
    void addproducts(MouseEvent event) {
        productsView.getItems().add(null);
        productNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        productNameColumn.setOnEditCommit(
                (EventHandler<TableColumn.CellEditEvent<Products, String>>) t -> {
                    ProductsDB.postInsertProducts(t.getNewValue());
                    populateTableForProducts();
                }
        );
    }

    /*
     * @Author - Rohit Aggarwal
     * @Update products
     * Javafx workshop 6
     * */
    @FXML
    void updateProducts(MouseEvent event) {

        productNameColumn.setEditable(true);
        productNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        productNameColumn.setOnEditCommit(
                (EventHandler<TableColumn.CellEditEvent<Products, String>>) t -> {
                    ((Products) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setProductName(t.getNewValue());
                    System.out.println(t.getNewValue());

                    Products products = t.getTableView().getItems().get(
                            t.getTablePosition().getRow());
                    Products updatedProduct = new Products(products.getProductID(), t.getNewValue());
                    ProductsDB.postUpdateProducts(updatedProduct);
                    populateTableForProducts();
                    productNameColumn.setEditable(false);
                }
        );

    }

    /*
     * @Author - Rohit Aggarwal
     * @Load products table view
     * Javafx workshop 6
     * */
    @FXML
    void loadProducts(MouseEvent event) {

        populateTableForProducts();
    }

    /*
     * @Author - Rohit Aggarwal
     * @load products table view
     * Javafx workshop 6
     * */
    private void populateTableForProducts() {
        ArrayList<Products> products = null;

        try {
            products = ProductsDB.getProducts();

            ObservableList<Products> oProducts = FXCollections.observableArrayList(products);

            productIdColumn.setText("Product ID");
            productNameColumn.setText("Product Name");
            productsView.getColumns().setAll(productIdColumn, productNameColumn);

            productIdColumn.setCellValueFactory(new PropertyValueFactory("productID"));
            productNameColumn.setCellValueFactory(new PropertyValueFactory("productName"));

            productsView.setItems(oProducts);

            lblTest.setText("Products");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    /*
     * @Author - Rohit Aggarwal
     * @custom close button
     * Javafx workshop 6
     * */
    @FXML
    void closeWindow(MouseEvent event) {
        // getting a handle to the stage
        Stage stage = (Stage) btnClose.getScene().getWindow();
        // shutting down the stage
        stage.close();
    }
}
