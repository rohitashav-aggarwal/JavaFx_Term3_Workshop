package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;

public class PackageController {

    @FXML
    private Button btnSave;

    @FXML
    private Button btnCancel;

    @FXML
    private VBox vbLabels;

    @FXML
    private VBox vbInputs;

    @FXML
    private TextField tfPackageId;

    @FXML
    private TextField tfPkgName;

    @FXML
    private DatePicker dpPkgStartDate;

    @FXML
    private DatePicker dpPkgEndDate;

    @FXML
    private TextField tfPkgDesc;

    @FXML
    private TextField tfPkgBasePrice;

    @FXML
    private TextField tfPkgAgencyCommission;

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
        Package pk = new Package();
        pk.setPkgName(tfPkgName.getText());
        pk.setPkgStartDate(dpPkgStartDate.getValue().toString());
        pk.setPkgEndDate(dpPkgEndDate.getValue().toString());
        pk.setPkgDesc(tfPkgDesc.getText());
        BigDecimal basePrice = new BigDecimal(tfPkgBasePrice.getText());
        System.out.println(basePrice);
        pk.setPkgBasePrice(basePrice);
        BigDecimal agencyComm = new BigDecimal(tfPkgAgencyCommission.getText());
        pk.setPkgAgencyCommission(agencyComm);

        if (id != null) {
            pk.setPackageId(Integer.valueOf(tfPackageId.getText()));
            PackageDB.updatePackage(pk);
        } else {
            PackageDB.insertPackage(pk);
        }

        clickCancel(event);
    }

    @FXML
    void initialize() throws SQLException {
        id = Controller.getId();

        if (id != null) {
            new Package();
            Package pkg;
            pkg = PackageDB.getPackage(id);
            tfPackageId.setText(String.valueOf(pkg.getPackageId()));
            tfPkgName.setText(pkg.getPkgName());
            dpPkgStartDate.setValue(Timestamp.valueOf(pkg.getPkgStartDate()).toLocalDateTime().toLocalDate());
            dpPkgEndDate.setValue(Timestamp.valueOf(pkg.getPkgEndDate()).toLocalDateTime().toLocalDate());
            tfPkgDesc.setText(String.valueOf(pkg.getPkgDesc()));
            tfPkgBasePrice.setText(String.format("%.2f", pkg.getPkgBasePrice()));
            tfPkgAgencyCommission.setText(String.format("%.2f", pkg.getPkgAgencyCommission()));
        }
    }

}