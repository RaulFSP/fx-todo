package com.portfolio.fxtodo.controllers;

import com.portfolio.fxtodo.App;
import com.portfolio.fxtodo.StageManager;
import com.portfolio.fxtodo.entities.TODO;
import com.portfolio.fxtodo.utils.DataLists;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    private StageManager manager = App.getManager();

    @FXML
    private ListView<TODO> listView;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TextArea textArea;

    @FXML
    private Button mainButton;

    @FXML
    private Button secundaryButton;

    private ContextMenu contextMenuList;
    private MenuItem menuItemUpdate;
    private MenuItem menuItemRemove;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadListView();
        loadDefaultButtonConfig();
        setDateValue();
        menuItemUpdate.setOnAction(e->handleMenuItemUpdate());
    }

    private void loadListView(){
        listView.setItems(DataLists.getListTODO());
        contextMenuList = new ContextMenu();
        menuItemRemove = new MenuItem("Remover");
        menuItemUpdate = new MenuItem("Atualizar");
        contextMenuList.getItems().addAll(menuItemUpdate,menuItemRemove);
        listView.setContextMenu(contextMenuList);
    }

    private void loadDefaultButtonConfig(){
        mainButton.setText("Adicionar");
        mainButton.setOnAction(e->handleAddTODO());
        secundaryButton.setText("Limpar");
        secundaryButton.setOnAction(e->clearFields());
    }
    private void loadUpdateButtonConfig(TODO selectedTODO){
        mainButton.setText("Update");
        mainButton.setOnAction(e->handleUpdateConfirm(selectedTODO));
        secundaryButton.setText("Cancel");
        secundaryButton.setOnAction(e->loadDefaultButtonConfig());
    }

    private void handleMenuItemRemove(){
        if(!listView.getItems().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"Remover Item da Lista?",ButtonType.NO,ButtonType.YES);
            //TODO
            TODO selectedTODO = listView.getSelectionModel().getSelectedItem();
            datePicker.setValue(selectedTODO.getLocalDate());
            textArea.setText(selectedTODO.getContent());
            loadUpdateButtonConfig(selectedTODO);
        }
    }

    private void handleAddTODO(){
        if (datePicker.getValue() != null && !textArea.getText().trim().isEmpty()){
            TODO todo = new TODO(datePicker.getValue(),textArea.getText(),false);
            DataLists.getListTODO().add(todo);
            setDateValue();
            clearFields();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING,"Campos vazios",ButtonType.CLOSE);
            alert.setHeaderText("");
            alert.showAndWait();
        }

    }

    private void handleMenuItemUpdate(){

        if(!listView.getItems().isEmpty()){
            TODO selectedTODO = listView.getSelectionModel().getSelectedItem();
            datePicker.setValue(selectedTODO.getLocalDate());
            textArea.setText(selectedTODO.getContent());
            loadUpdateButtonConfig(selectedTODO);
        }

    }

    private void handleUpdateConfirm(TODO todo){
        if (datePicker.getValue() != null && !textArea.getText().trim().isEmpty()){
            DataLists.getListTODO().get(DataLists.getListTODO().indexOf(todo)).setContent(textArea.getText().trim());
            DataLists.getListTODO().get(DataLists.getListTODO().indexOf(todo)).setLocalDate(datePicker.getValue());
            setDateValue();
            clearFields();
            loadDefaultButtonConfig();
            refreshListView();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING,"Campos vazios",ButtonType.CLOSE);
            alert.setHeaderText("");
            alert.showAndWait();
        }
    }

    private void refreshListView() {
        Platform.runLater(() -> {
            listView.refresh();
        });
    }
    private void setDateValue(){
        datePicker.setValue(LocalDate.now());
    }
    private void clearFields(){
        textArea.clear();
    }

}
