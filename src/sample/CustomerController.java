package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerController {

    @FXML
    private Button btnSave;

    @FXML
    private Button btnCancel;

    @FXML
    private VBox vbLabels;

    @FXML
    private VBox vbInputs;

    @FXML
    private TextField tfCustomerId;

    @FXML
    private TextField tfCustFirstName;

    @FXML
    private TextField tfCustLastName;

    @FXML
    private TextField tfCustAddress;

    @FXML
    private TextField tfCustCity;

    @FXML
    private TextField tfCustProv;

    @FXML
    private TextField tfCustPostal;

    @FXML
    private VBox vbLabels2;

    @FXML
    private VBox vbInputs2;

    @FXML
    private TextField tfCustCountry;

    @FXML
    private TextField tfCustHomePhone;

    @FXML
    private TextField tfCustBusPhone;

    @FXML
    private TextField tfCustEmail;

    @FXML
    private ComboBox<Integer> cbAgentId;

    private ObservableList<Integer> agentIdObservableList = FXCollections.observableArrayList();

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
        Customer cu = new Customer();
        cu.setCustFirstName(tfCustFirstName.getText());
        cu.setCustLastName(tfCustLastName.getText());
        cu.setCustAddress(tfCustAddress.getText());
        cu.setCustCity(tfCustCity.getText());
        cu.setCustProv(tfCustProv.getText());
        cu.setCustPostal(tfCustPostal.getText());
        cu.setCustCountry(tfCustCountry.getText());
        cu.setCustHomePhone(tfCustHomePhone.getText());
        cu.setCustBusPhone(tfCustBusPhone.getText());
        cu.setCustEmail(tfCustEmail.getText());
        cu.setAgentId(cbAgentId.getSelectionModel().getSelectedItem());

        if (id != null) {
            cu.setCustomerId(Integer.valueOf(tfCustomerId.getText()));
            CustomerDB.updateCustomers(cu);
        } else {
            CustomerDB.insertCustomer(cu);
        }
        clickCancel(event);
    }

    @FXML
    void initialize() throws SQLException {
        id = Controller.getId();

        setCbAgentId();

        if (id != null) {
            new Customer();
            Customer customer;
            customer = CustomerDB.getCustomer(id);
            tfCustomerId.setText(String.valueOf(customer.getCustomerId()));
            tfCustFirstName.setText(customer.getCustFirstName());
            tfCustLastName.setText(customer.getCustLastName());
            tfCustAddress.setText(customer.getCustAddress());
            tfCustCity.setText(customer.getCustCity());
            tfCustPostal.setText(customer.getCustPostal());
            tfCustProv.setText(customer.getCustProv());
            tfCustCountry.setText(customer.getCustCountry());
            tfCustHomePhone.setText(customer.getCustHomePhone());
            tfCustBusPhone.setText(customer.getCustBusPhone());
            tfCustEmail.setText(customer.getCustEmail());
            if (customer.getAgentId() != null)
                cbAgentId.setValue(Integer.valueOf(customer.getAgentId()));
        }
    }

    void setCbAgentId() {
        Connection conn = DatabaseUtility.getConnectionString();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select AgentId from Agents");
            agentIdObservableList.add(null);
            while (rs.next()) {
                agentIdObservableList.add(Integer.valueOf(rs.getString(1)));
            }
            cbAgentId.setItems(agentIdObservableList);
            cbAgentId.setValue(agentIdObservableList.get(0));

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
