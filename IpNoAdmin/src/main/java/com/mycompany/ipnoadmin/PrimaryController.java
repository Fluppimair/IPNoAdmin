package com.mycompany.ipnoadmin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.DragEvent;

public class PrimaryController implements Initializable{

    @FXML
    private Label lblName;
    @FXML
    private Label lblIp;
    @FXML
    private Label lblSubnet;
    @FXML
    private Label lblGateway;
    @FXML
    private TextField txtIp;
    @FXML
    private TextField txtSubnet;
    @FXML
    private TextField txtGateway;
    
    @FXML
    ToggleGroup tGroup;
    @FXML
    private RadioButton tglDhcp;
    @FXML
    private RadioButton tglStatic;
    @FXML
    private ChoiceBox<String> chbNetworkAdapter;

    @FXML
    private void ipChange(ActionEvent event) {
        
        String data = txtIp.getText()+";"+txtSubnet.getText();
        Client.send(data);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String[]test =IpConfig.getIpConfig();
        txtIp.setText(test[0]);
        txtGateway.setText(test[1]);
        txtSubnet.setText(IpConfig.getDhcp());
        tglDhcp.setToggleGroup(tGroup);
        tglStatic.setToggleGroup(tGroup);
        
    }

    @FXML
    private void setNetworkAdapter(DragEvent event) {
    }
}
