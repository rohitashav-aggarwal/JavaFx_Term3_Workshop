package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
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
    public static Integer ID;

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
    void clickAdd(MouseEvent event) throws IOException {
        ID = null;
        launchPopup();
    }

    @FXML
    void clickUpdate(MouseEvent event) {
        setId();
        launchPopup();
    }

    void launchPopup() {
        String viewName = new String();
        if (selectedView == SelectedView.Products)
            viewName = "productView.fxml";
        else if (selectedView == SelectedView.Bookings)
            viewName = "bookingView.fxml";
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(viewName));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void setId() {
        if (selectedView == SelectedView.Products) {
            Products selectedProduct = (Products) tableView.getSelectionModel().getSelectedItem();
            ID = selectedProduct.getProductID();
        } else if (selectedView == SelectedView.Bookings) {
            Booking selectedBooking = (Booking) tableView.getSelectionModel().getSelectedItem();
            ID = selectedBooking.getBookingId();
        }
        System.out.println("Set ID to: " + ID);
    }

    public static Integer getId() {
        Integer id = ID;
        System.out.println("The id is: " + id);
        return id;
    }

//    void clickAdd(MouseEvent event) {
//        if (selectedView == SelectedView.Products) {
//            columnTwo.setEditable(true);
//            tableView.getItems().add(null);
//            columnTwo.setCellFactory(TextFieldTableCell.forTableColumn());
//            columnTwo.setOnEditCommit(
//                    (EventHandler<TableColumn.CellEditEvent<Products, String>>) t -> {
//                        ProductsDB.postInsertProducts(t.getNewValue());
//                        populateTableForProducts();
//                        columnTwo.setEditable(false);
//                    }
//            );
//        }
//        // Author: Steven Hillman
//        else if (selectedView == SelectedView.Customers) {
//            columnTwo.setEditable(true);
//            tableView.getItems().add(null);
//            columnTwo.setCellFactory(TextFieldTableCell.forTableColumn());
//            columnTwo.setOnEditCommit(
//                    (EventHandler<TableColumn.CellEditEvent<Products, String>>) t -> {
//                        CustomerDB.insertCustomer(t.getNewValue());
//                        populateTableForCustomers();
//                        columnTwo.setEditable(false);
//                    }
//            );
//        }
//    }

    /*
     * @Author - Rohit Aggarwal
     * @Update products
     * Javafx workshop 6
     * */
//    @FXML
//    void clickUpdate(MouseEvent event) {
//
//        if (selectedView == SelectedView.Products) {
//            columnTwo.setEditable(true);
//            columnTwo.setCellFactory(TextFieldTableCell.forTableColumn());
//            columnTwo.setOnEditCommit(
//                    (EventHandler<TableColumn.CellEditEvent<Products, String>>) t -> {
//                        ((Products) t.getTableView().getItems().get(
//                                t.getTablePosition().getRow())
//                        ).setProductName(t.getNewValue());
//                        System.out.println(t.getNewValue());
//
//                        Products products = t.getTableView().getItems().get(
//                                t.getTablePosition().getRow());
//                        Products updatedProduct = new Products(products.getProductID(), t.getNewValue());
//                        ProductsDB.postUpdateProducts(updatedProduct);
//                        populateTableForProducts();
//                        columnTwo.setEditable(false);
//                    }
//            );
//        }
//        // Author: Steven Hillman
//        else if (selectedView == SelectedView.Customers) {
//            columnTwo.setEditable(true);
//            columnTwo.setCellFactory(TextFieldTableCell.forTableColumn());
//            columnTwo.setOnEditCommit(
//                    (EventHandler<TableColumn.CellEditEvent<Customer, String>>) t -> {
//                        (t.getTableView().getItems().get(
//                                t.getTablePosition().getRow())
//                        ).setCustFirstName(t.getNewValue());
//                        System.out.println(t.getNewValue());
//
//                        Customer currentCustomer = t.getTableView().getItems().get(
//                                t.getTablePosition().getRow());
//                        Customer updatedCustomer = new Customer(currentCustomer.getCustomerId(), t.getNewValue(), currentCustomer.getCustLastName(), currentCustomer.getCustAddress(),
//                                currentCustomer.getCustCity(), currentCustomer.getCustProv(), currentCustomer.getCustPostal(), currentCustomer.getCustCountry(),
//                                 currentCustomer.getCustHomePhone(), currentCustomer.getCustBusPhone(), currentCustomer.getCustEmail(), currentCustomer.getAgentId());
//                        CustomerDB.updateCustomers(updatedCustomer);
//                        populateTableForCustomers();
//                        columnTwo.setEditable(false);
//                    }
//            );
//
//            columnThree.setEditable(true);
//            columnThree.setCellFactory(TextFieldTableCell.forTableColumn());
//            columnThree.setOnEditCommit(
//                    (EventHandler<TableColumn.CellEditEvent<Customer, String>>) t -> {
//                        (t.getTableView().getItems().get(
//                                t.getTablePosition().getRow())
//                        ).setCustFirstName(t.getNewValue());
//                        System.out.println(t.getNewValue());
//
//                        Customer currentCustomer = t.getTableView().getItems().get(
//                                t.getTablePosition().getRow());
//                        Customer updatedCustomer = new Customer(currentCustomer.getCustomerId(), currentCustomer.getCustFirstName(), t.getNewValue(), currentCustomer.getCustAddress(),
//                                currentCustomer.getCustCity(), currentCustomer.getCustProv(), currentCustomer.getCustPostal(), currentCustomer.getCustCountry(),
//                                currentCustomer.getCustHomePhone(), currentCustomer.getCustBusPhone(), currentCustomer.getCustEmail(), currentCustomer.getAgentId());
//                        CustomerDB.updateCustomers(updatedCustomer);
//                        populateTableForCustomers();
//                        columnThree.setEditable(false);
//                    }
//            );
//
//            columnFour.setEditable(true);
//            columnFour.setCellFactory(TextFieldTableCell.forTableColumn());
//            columnFour.setOnEditCommit(
//                    (EventHandler<TableColumn.CellEditEvent<Customer, String>>) t -> {
//                        (t.getTableView().getItems().get(
//                                t.getTablePosition().getRow())
//                        ).setCustFirstName(t.getNewValue());
//                        System.out.println(t.getNewValue());
//
//                        Customer currentCustomer = t.getTableView().getItems().get(
//                                t.getTablePosition().getRow());
//                        Customer updatedCustomer = new Customer(currentCustomer.getCustomerId(), currentCustomer.getCustFirstName(), currentCustomer.getCustLastName(), t.getNewValue(),
//                                currentCustomer.getCustCity(), currentCustomer.getCustProv(), currentCustomer.getCustPostal(), currentCustomer.getCustCountry(),
//                                currentCustomer.getCustHomePhone(), currentCustomer.getCustBusPhone(), currentCustomer.getCustEmail(), currentCustomer.getAgentId());
//                        CustomerDB.updateCustomers(updatedCustomer);
//                        populateTableForCustomers();
//                        columnThree.setEditable(false);
//                    }
//            );
//
//        }
//        // Author: Elias Nahas
//        else if (selectedView == SelectedView.Bookings) {
//            columnTwo.setEditable(true);
//            columnTwo.setCellFactory(TextFieldTableCell.forTableColumn());
//            columnTwo.setOnEditCommit(
//                    (EventHandler<TableColumn.CellEditEvent<Booking, String>>) t -> {
//                        (t.getTableView().getItems().get(
//                                t.getTablePosition().getRow())
//                        ).setBookingDate(String.valueOf(t.getNewValue()));
//                        System.out.println(t.getNewValue());
//
//                        Booking currentBooking = t.getTableView().getItems().get(
//                                t.getTablePosition().getRow());
//                        Booking updatedBooking = new Booking(currentBooking.getBookingId(),
//                                String.valueOf(t.getNewValue()), currentBooking.getBookingNo(), currentBooking.getTravelerCount(),
//                                currentBooking.getCustomerId(), currentBooking.getTripTypeId(), currentBooking.getPackageId());
//                        BookingDB.updateBooking(updatedBooking);
//                        populateTableForBookings();
//                        columnTwo.setEditable(false);
//                    }
//            );
//
//            columnThree.setEditable(true);
//            columnThree.setCellFactory(TextFieldTableCell.forTableColumn());
//            columnThree.setOnEditCommit(
//                    (EventHandler<TableColumn.CellEditEvent<Booking, String>>) t -> {
//                        (t.getTableView().getItems().get(
//                                t.getTablePosition().getRow())
//                        ).setBookingNo(t.getNewValue());
//                        System.out.println(t.getNewValue());
//
//                        Booking currentBooking = t.getTableView().getItems().get(
//                                t.getTablePosition().getRow());
//                        Booking updatedBooking = new Booking(currentBooking.getBookingId(),
//                                currentBooking.getBookingDate(), t.getNewValue(), currentBooking.getTravelerCount(),
//                                currentBooking.getCustomerId(), currentBooking.getTripTypeId(), currentBooking.getPackageId());
//                        BookingDB.updateBooking(updatedBooking);
//                        populateTableForBookings();
//                        columnThree.setEditable(false);
//                    }
//            );
//
//            columnFour.setEditable(true);
//            columnFour.setCellFactory(TextFieldTableCell.forTableColumn());
//            columnFour.setOnEditCommit(
//                    (EventHandler<TableColumn.CellEditEvent<Booking, String>>) t -> {
//                        (t.getTableView().getItems().get(
//                                t.getTablePosition().getRow())
//                        ).setTravelerCount(Double.valueOf(t.getNewValue()));
//                        System.out.println(t.getNewValue());
//
//                        Booking currentBooking = t.getTableView().getItems().get(
//                                t.getTablePosition().getRow());
//                        Booking updatedBooking = new Booking(currentBooking.getBookingId(),
//                                currentBooking.getBookingDate(), currentBooking.getBookingNo(), Double.valueOf(t.getNewValue()),
//                                currentBooking.getCustomerId(), currentBooking.getTripTypeId(), currentBooking.getPackageId());
//                        BookingDB.updateBooking(updatedBooking);
//                        populateTableForBookings();
//                        columnFour.setEditable(false);
//                    }
//            );
//
//            columnFive.setEditable(true);
//            columnFive.setCellFactory(TextFieldTableCell.forTableColumn());
//            columnFive.setOnEditCommit(
//                    (EventHandler<TableColumn.CellEditEvent<Booking, String>>) t -> {
//                        (t.getTableView().getItems().get(
//                                t.getTablePosition().getRow())
//                        ).setCustomerId(Integer.valueOf(t.getNewValue()));
//                        System.out.println(t.getNewValue());
//
//                        Booking currentBooking = t.getTableView().getItems().get(
//                                t.getTablePosition().getRow());
//                        Booking updatedBooking = new Booking(currentBooking.getBookingId(),
//                                currentBooking.getBookingDate(), currentBooking.getBookingNo(), currentBooking.getTravelerCount(),
//                                Integer.valueOf(t.getNewValue()), currentBooking.getTripTypeId(), currentBooking.getPackageId());
//                        BookingDB.updateBooking(updatedBooking);
//                        populateTableForBookings();
//                        columnFive.setEditable(false);
//                    }
//            );
//
//            columnSix.setEditable(true);
//            columnSix.setCellFactory(TextFieldTableCell.forTableColumn());
//            columnSix.setOnEditCommit(
//                    (EventHandler<TableColumn.CellEditEvent<Booking, String>>) t -> {
//                        (t.getTableView().getItems().get(
//                                t.getTablePosition().getRow())
//                        ).setTripTypeId(t.getNewValue());
//                        System.out.println(t.getNewValue());
//
//                        Booking currentBooking = t.getTableView().getItems().get(
//                                t.getTablePosition().getRow());
//                        Booking updatedBooking = new Booking(currentBooking.getBookingId(),
//                                currentBooking.getBookingDate(), currentBooking.getBookingNo(), currentBooking.getTravelerCount(),
//                                currentBooking.getCustomerId(), t.getNewValue(), currentBooking.getPackageId());
//                        BookingDB.updateBooking(updatedBooking);
//                        populateTableForBookings();
//                        columnSix.setEditable(false);
//                    }
//            );
//
//            columnSeven.setEditable(true);
//            columnSeven.setCellFactory(TextFieldTableCell.forTableColumn());
//            columnSeven.setOnEditCommit(
//                    (EventHandler<TableColumn.CellEditEvent<Booking, String>>) t -> {
//                        (t.getTableView().getItems().get(
//                                t.getTablePosition().getRow())
//                        ).setPackageId(Integer.valueOf(t.getNewValue()));
//                        System.out.println(t.getNewValue());
//
//                        Booking currentBooking = t.getTableView().getItems().get(
//                                t.getTablePosition().getRow());
//                        Booking updatedBooking = new Booking(currentBooking.getBookingId(),
//                                currentBooking.getBookingDate(), currentBooking.getBookingNo(), currentBooking.getTravelerCount(),
//                                currentBooking.getCustomerId(), currentBooking.getTripTypeId(), Integer.valueOf(t.getNewValue()));
//                        BookingDB.updateBooking(updatedBooking);
//                        populateTableForBookings();
//                        columnSeven.setEditable(false);
//                    }
//            );
//
//        }
//    }

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

    // Author: Elias Nahas
    // Populate table view when Bookings button is clicked
    @FXML
    void loadBookings(MouseEvent event) {
        populateTableForBookings();
    }

    // Author: Elias Nahas
    // Create and populate an ObservableList of Bookings from the database using BookingDB
    private void populateTableForBookings() {
        selectedView = SelectedView.Bookings;
        ArrayList<Booking> bookingList = null;

        try {
            bookingList = BookingDB.getBookings();

            ObservableList<Booking> oListBookings = FXCollections.observableArrayList(bookingList);

            columnOne.setText("Booking ID");
            columnTwo.setText("Booking Date");
            columnThree.setText("Booking #");
            columnFour.setText("Traveler Count");
            columnFive.setText("Customer ID");
            columnSix.setText("Trip Type ID");
            columnSeven.setText("Package ID");

            tableView.getColumns().setAll(columnOne, columnTwo, columnThree, columnFour, columnFive, columnSix, columnSeven);

            columnOne.setCellValueFactory(new PropertyValueFactory("BookingId"));
            columnTwo.setCellValueFactory(new PropertyValueFactory("BookingDate"));
            columnThree.setCellValueFactory(new PropertyValueFactory("BookingNo"));
            columnFour.setCellValueFactory(new PropertyValueFactory("TravelerCount"));
            columnFive.setCellValueFactory(new PropertyValueFactory("CustomerId"));
            columnSix.setCellValueFactory(new PropertyValueFactory("TripTypeId"));
            columnSeven.setCellValueFactory(new PropertyValueFactory("PackageId"));

            tableView.setItems(oListBookings);

            title.setText("Bookings");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
