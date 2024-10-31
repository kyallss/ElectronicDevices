package org.example.electronicdevices;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {

    @FXML private RadioButton smartphoneRadio;
    @FXML private RadioButton laptopRadio;
    @FXML private RadioButton tabletRadio;

    @FXML private TextField nameField;
    @FXML private TextField priceField;
    @FXML private TextField weightField;

    @FXML private TextField screenSizeField;
    @FXML private TextField cameraResolutionField;

  
    @FXML private TextField ramSizeField;
    @FXML private TextField processorTypeField;

   
    @FXML private TextField batteryLifeField;
    @FXML private CheckBox hasStylusCheckBox;

    @FXML private ListView<Device> deviceListView;

    private ToggleGroup deviceGroup;

    @FXML
    public void initialize() {
        deviceGroup = new ToggleGroup();
        smartphoneRadio.setToggleGroup(deviceGroup);
        laptopRadio.setToggleGroup(deviceGroup);
        tabletRadio.setToggleGroup(deviceGroup);
    }

    @FXML
    private void handleAdd() {
        try {
            String name = nameField.getText();
            double price = Double.parseDouble(priceField.getText());
            double weight = Double.parseDouble(weightField.getText());

            // Check selected device type and validate the relevant fields
            Device newDevice = null;

            if (smartphoneRadio.isSelected()) {
                // Smartphone-specific validations
                if (screenSizeField.getText().isEmpty() || cameraResolutionField.getText().isEmpty()) {
                    showError("Please fill in all fields for the Smartphone.");
                    return;
                }

                double screenSize = Double.parseDouble(screenSizeField.getText());
                double cameraResolution = Double.parseDouble(cameraResolutionField.getText());

                newDevice = new Smartphone(name, price, weight, screenSize, cameraResolution);

            } else if (laptopRadio.isSelected()) {
                // Laptop-specific validations
                if (ramSizeField.getText().isEmpty() || processorTypeField.getText().isEmpty()) {
                    showError("Please fill in all fields for the Laptop.");
                    return;
                }

                int ramSize = Integer.parseInt(ramSizeField.getText());
                String processorType = processorTypeField.getText();

                newDevice = new Laptop(name, price, weight, ramSize, processorType);

            } else if (tabletRadio.isSelected()) {
                // Tablet-specific validations
                if (batteryLifeField.getText().isEmpty()) {
                    showError("Please fill in all fields for the Tablet.");
                    return;
                }

                double batteryLife = Double.parseDouble(batteryLifeField.getText());

                newDevice = new Tablet(name, price, weight, batteryLife, hasStylusCheckBox.isSelected());
            }

            if (newDevice != null) {
                deviceListView.getItems().add(newDevice);
                clearFields(); // Clear fields after adding
            }

        } catch (NumberFormatException e) {
            showError("Invalid input. Please enter numeric values where required.");
        }
    }

    @FXML
    private void handleRemove() {
        Device selectedDevice = deviceListView.getSelectionModel().getSelectedItem();
        if (selectedDevice != null) {
            deviceListView.getItems().remove(selectedDevice);
        }
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR, message);
        alert.showAndWait();
    }

    // Clear input fields after adding a device
    private void clearFields() {
        nameField.clear();
        priceField.clear();
        weightField.clear();
        screenSizeField.clear();
        cameraResolutionField.clear();
        ramSizeField.clear();
        processorTypeField.clear();
        batteryLifeField.clear();
        hasStylusCheckBox.setSelected(false);
        deviceGroup.selectToggle(null); // Deselect any selected radio button
    }
}
