package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.SQLException;

public class ProductController {

    @FXML
    private Button btnSave;

    @FXML
    private Button btnCancel;

    @FXML
    private VBox vbLabels;

    @FXML
    private VBox vbInputs;

    @FXML
    private TextField tfProductId;

    @FXML
    private TextField tfProdName;

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
        Products pr = new Products();
        pr.setProductName(tfProdName.getText());

        if (id != null) {
            pr.setProductID(Integer.valueOf(tfProductId.getText()));
            ProductsDB.postUpdateProducts(pr);
        } else {
            ProductsDB.postInsertProducts(pr.getProductName());
        }
        clickCancel(event);
    }

    @FXML
    void initialize() throws SQLException {
        id = Controller.getId();

        if (id != null) {
            new Products();
            Products product;
            product = ProductsDB.getProduct(id);
            tfProductId.setText(String.valueOf(product.getProductID()));
            tfProdName.setText(product.getProductName());
        }
    }

}
