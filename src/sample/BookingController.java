package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.*;

public class BookingController {

    @FXML
    private Button btnSave;

    @FXML
    private Button btnCancel;

    @FXML
    private VBox vbLabels;

    @FXML
    private VBox vbInputs;

    @FXML
    private TextField tfBookingId;

    @FXML
    private DatePicker dpBookingDate;

    @FXML
    private TextField tfBookingNo;

    @FXML
    private TextField tfTravelerCount;

    @FXML
    private ComboBox<Integer> cbCustomerId;

    private ObservableList<Integer> customerIdObservableList = FXCollections.observableArrayList();

    @FXML
    private ComboBox<String> cbTripTypeId;

    private ObservableList<String> tripTypeIdObservableList = FXCollections.observableArrayList();

    @FXML
    private ComboBox<Integer> cbPackageId;

    private ObservableList<Integer> packageIdObservableList = FXCollections.observableArrayList();

    private Integer id;

    @FXML
    void clickCancel(MouseEvent event) {
        // getting a handle to the stage
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        // shutting down the stage
        stage.close();
    }

    @FXML
    void clickSave(MouseEvent event) {
        System.out.println(dpBookingDate.getValue().toString());
        Booking bk = new Booking();
        bk.setBookingDate(dpBookingDate.getValue().toString());
        bk.setBookingNo(tfBookingNo.getText());
        bk.setTravelerCount(Double.valueOf(tfTravelerCount.getText()));
        bk.setCustomerId(cbCustomerId.getSelectionModel().getSelectedItem());
        bk.setTripTypeId(cbTripTypeId.getSelectionModel().getSelectedItem());
        bk.setPackageId(cbPackageId.getSelectionModel().getSelectedItem());

        if (id != null) {
            bk.setBookingId(Integer.valueOf(tfBookingId.getText()));
            BookingDB.updateBooking(bk);
        } else {
            BookingDB.insertBooking(bk);
        }
        clickCancel(event);
    }

    @FXML
    void initialize() throws SQLException {
        id = Controller.getId();
        System.out.println("The fetched id is: " + id);

        setCbCustomerId();
        setCbTripTypeId();
        setCbPackageId();

        if (id != null) {
            new Booking();
            Booking booking;
            booking = BookingDB.getBooking(id);
            tfBookingId.setText(String.valueOf(booking.getBookingId()));
            dpBookingDate.setValue(Timestamp.valueOf(booking.getBookingDate()).toLocalDateTime().toLocalDate());
            tfBookingNo.setText(String.valueOf(booking.getBookingNo()));
            tfTravelerCount.setText(String.format("%.0f", booking.getTravelerCount()));
            cbCustomerId.setValue(Integer.valueOf(booking.getCustomerId()));
            cbTripTypeId.setValue(booking.getTripTypeId());
            if (booking.getPackageId() != null)
                cbPackageId.setValue(Integer.valueOf(booking.getPackageId()));
        }
    }

    void setCbCustomerId() {
        Connection conn = DatabaseUtility.getConnectionString();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select CustomerId from Customers");
            while (rs.next()) {
                customerIdObservableList.add(Integer.valueOf(rs.getString(1)));
            }
            cbCustomerId.setItems(customerIdObservableList.sorted());
            cbCustomerId.setValue(customerIdObservableList.get(0));

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void setCbTripTypeId() {
        Connection conn = DatabaseUtility.getConnectionString();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select TripTypeId from TripTypes");
            while (rs.next()) {
                tripTypeIdObservableList.add(rs.getString(1));
            }
            cbTripTypeId.setItems(tripTypeIdObservableList);
            cbTripTypeId.setValue(tripTypeIdObservableList.get(0));

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void setCbPackageId() {
        Connection conn = DatabaseUtility.getConnectionString();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select PackageId from Packages");
            packageIdObservableList.add(null);
            while (rs.next()) {
                packageIdObservableList.add(Integer.valueOf(rs.getString(1)));
            }
            cbPackageId.setItems(packageIdObservableList);
            cbPackageId.setValue(packageIdObservableList.get(0));

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
