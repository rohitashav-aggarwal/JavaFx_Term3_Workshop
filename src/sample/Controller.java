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
    private Label title;

    @FXML
    private TableView tableView;

    @FXML
    private TableColumn columnOne;

    @FXML
    private TableColumn columnTwo;

    @FXML
    private TableColumn columnThree;

    @FXML
    private TableColumn columnFour;

    @FXML
    private TableColumn columnFive;

    @FXML
    private TableColumn columnSix;

    @FXML
    private TableColumn columnSeven;

    @FXML
    private TableColumn columnEight;

    @FXML
    private TableColumn columnNine;

    @FXML
    private TableColumn columnTen;

    @FXML
    private TableColumn columnEleven;

    @FXML
    private TableColumn columnTwelve;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnUpdate;

    private SelectedView selectedView;

    /*
     * @Author - Rohit Aggarwal
     * @add new product
     * Javafx workshop 6
     * */
    @FXML
    void addproducts(MouseEvent event) {
        if (selectedView == SelectedView.Products) {
            columnTwo.setEditable(true);
            tableView.getItems().add(null);
            columnTwo.setCellFactory(TextFieldTableCell.forTableColumn());
            columnTwo.setOnEditCommit(
                    (EventHandler<TableColumn.CellEditEvent<Products, String>>) t -> {
                        ProductsDB.postInsertProducts(t.getNewValue());
                        populateTableForProducts();
                        columnTwo.setEditable(false);
                    }
            );
        }
        // Author: Steven Hillman
        else if (selectedView == SelectedView.Customers) {
            columnTwo.setEditable(true);
            tableView.getItems().add(null);
            columnTwo.setCellFactory(TextFieldTableCell.forTableColumn());
            columnTwo.setOnEditCommit(
                    (EventHandler<TableColumn.CellEditEvent<Products, String>>) t -> {
                        CustomerDB.insertCustomer(t.getNewValue());
                        populateTableForCustomers();
                        columnTwo.setEditable(false);
                    }
            );
        }
    }

    /*
     * @Author - Rohit Aggarwal
     * @Update products
     * Javafx workshop 6
     * */
    @FXML
    void updateProducts(MouseEvent event) {

        if (selectedView == SelectedView.Products) {
            columnTwo.setEditable(true);
            columnTwo.setCellFactory(TextFieldTableCell.forTableColumn());
            columnTwo.setOnEditCommit(
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
                        columnTwo.setEditable(false);
                    }
            );
        }
        // Author: Steven Hillman
        else if (selectedView == SelectedView.Customers) {
            columnTwo.setEditable(true);
            columnTwo.setCellFactory(TextFieldTableCell.forTableColumn());
            columnTwo.setOnEditCommit(
                    (EventHandler<TableColumn.CellEditEvent<Customer, String>>) t -> {
                        (t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setCustFirstName(t.getNewValue());
                        System.out.println(t.getNewValue());

                        Customer currentCustomer = t.getTableView().getItems().get(
                                t.getTablePosition().getRow());
                        Customer updatedCustomer = new Customer(currentCustomer.getCustomerId(), t.getNewValue(), currentCustomer.getCustLastName(), currentCustomer.getCustAddress(),
                                currentCustomer.getCustCity(), currentCustomer.getCustProv(), currentCustomer.getCustPostal(), currentCustomer.getCustCountry(),
                                 currentCustomer.getCustHomePhone(), currentCustomer.getCustBusPhone(), currentCustomer.getCustEmail(), currentCustomer.getAgentId());
                        CustomerDB.updateCustomers(updatedCustomer);
                        populateTableForCustomers();
                        columnTwo.setEditable(false);
                    }
            );

            columnThree.setEditable(true);
            columnThree.setCellFactory(TextFieldTableCell.forTableColumn());
            columnThree.setOnEditCommit(
                    (EventHandler<TableColumn.CellEditEvent<Customer, String>>) t -> {
                        (t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setCustFirstName(t.getNewValue());
                        System.out.println(t.getNewValue());

                        Customer currentCustomer = t.getTableView().getItems().get(
                                t.getTablePosition().getRow());
                        Customer updatedCustomer = new Customer(currentCustomer.getCustomerId(), currentCustomer.getCustFirstName(), t.getNewValue(), currentCustomer.getCustAddress(),
                                currentCustomer.getCustCity(), currentCustomer.getCustProv(), currentCustomer.getCustPostal(), currentCustomer.getCustCountry(),
                                currentCustomer.getCustHomePhone(), currentCustomer.getCustBusPhone(), currentCustomer.getCustEmail(), currentCustomer.getAgentId());
                        CustomerDB.updateCustomers(updatedCustomer);
                        populateTableForCustomers();
                        columnThree.setEditable(false);
                    }
            );

            columnFour.setEditable(true);
            columnFour.setCellFactory(TextFieldTableCell.forTableColumn());
            columnFour.setOnEditCommit(
                    (EventHandler<TableColumn.CellEditEvent<Customer, String>>) t -> {
                        (t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setCustFirstName(t.getNewValue());
                        System.out.println(t.getNewValue());

                        Customer currentCustomer = t.getTableView().getItems().get(
                                t.getTablePosition().getRow());
                        Customer updatedCustomer = new Customer(currentCustomer.getCustomerId(), currentCustomer.getCustFirstName(), currentCustomer.getCustLastName(), t.getNewValue(),
                                currentCustomer.getCustCity(), currentCustomer.getCustProv(), currentCustomer.getCustPostal(), currentCustomer.getCustCountry(),
                                currentCustomer.getCustHomePhone(), currentCustomer.getCustBusPhone(), currentCustomer.getCustEmail(), currentCustomer.getAgentId());
                        CustomerDB.updateCustomers(updatedCustomer);
                        populateTableForCustomers();
                        columnThree.setEditable(false);
                    }
            );

        }
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
        selectedView = SelectedView.Products;
        ArrayList<Products> products = null;

        try {
            products = ProductsDB.getProducts();

            ObservableList<Products> oProducts = FXCollections.observableArrayList(products);

            columnOne.setText("Product ID");
            columnTwo.setText("Product Name");
            tableView.getColumns().setAll(columnOne, columnTwo);

            columnOne.setCellValueFactory(new PropertyValueFactory("productID"));
            columnTwo.setCellValueFactory(new PropertyValueFactory("productName"));

            tableView.setItems(oProducts);

            title.setText("Products");

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

    // Author: Steven Hillman
    // on btnCustomers mouse click, populate the table view
    @FXML
    void loadCustomers(MouseEvent event) {
        populateTableForCustomers();
    }

    // Author: Steven Hillman
    // get the observable list of Customer objects from the database using CustomerDB and populate the table view
    private void populateTableForCustomers() {
        selectedView = SelectedView.Customers;
        ArrayList<Customer> customerList = null;

        try {
            customerList = CustomerDB.getCustomers();

            ObservableList<Customer> oListCustomers = FXCollections.observableArrayList(customerList);

            columnOne.setText("Customer ID");
            columnTwo.setText("First Name");
            columnThree.setText("Last Name");
            columnFour.setText("Address");
            columnFive.setText("City");
            columnSix.setText("Province");
            columnSeven.setText("Postal Code");
            columnEight.setText("Country");
            columnNine.setText("Home Phone");
            columnTen.setText("Business Phone");
            columnEleven.setText("Email");
            columnTwelve.setText("Agent ID");

            tableView.getColumns().setAll(columnOne, columnTwo, columnThree, columnFour, columnFive,
                    columnSix, columnSeven, columnEight, columnNine, columnTen, columnEleven, columnTwelve);

            columnOne.setCellValueFactory(new PropertyValueFactory("CustomerId"));
            columnTwo.setCellValueFactory(new PropertyValueFactory("CustFirstName"));
            columnThree.setCellValueFactory(new PropertyValueFactory("CustLastName"));
            columnFour.setCellValueFactory(new PropertyValueFactory("CustAddress"));
            columnFive.setCellValueFactory(new PropertyValueFactory("CustCity"));
            columnSix.setCellValueFactory(new PropertyValueFactory("CustProv"));
            columnSeven.setCellValueFactory(new PropertyValueFactory("CustPostal"));
            columnEight.setCellValueFactory(new PropertyValueFactory("CustCountry"));
            columnNine.setCellValueFactory(new PropertyValueFactory("CustHomePhone"));
            columnTen.setCellValueFactory(new PropertyValueFactory("CustBusPhone"));
            columnEleven.setCellValueFactory(new PropertyValueFactory("CustEmail"));
            columnTwelve.setCellValueFactory(new PropertyValueFactory("AgentId"));

            tableView.setItems(oListCustomers);

            title.setText("Customers");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
