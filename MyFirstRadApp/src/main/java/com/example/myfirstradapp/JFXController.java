package com.example.myfirstradapp;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.File;
import java.io.*;

public class JFXController{
  public Button buttonSave;
  @FXML
  MenuButton priorityDropdown;
  @FXML
  MenuItem Priority1Button;
  @FXML
  MenuItem Priority2Button;
  @FXML
  MenuItem Priority3Button;
  @FXML
  Button deleteItem;

  @FXML
  TextField itemName;
  boolean namePickedBoolean;
  @FXML
  DatePicker itemDate;
  boolean datePickedBoolean;
  @FXML
  Button addItem;
  @FXML
  Button finishItem;
  @FXML
  Button restoreItem;
  @FXML
  ListView toDoList;
  @FXML
  ListView finishedList;
  @FXML
  Button restoreSave;

  public void initialize() {
    addItem.setDisable(true);
    namePickedBoolean = false;
    datePickedBoolean = false;
  }
public void namePicked(ActionEvent event){
      if (datePickedBoolean){
          addItem.setDisable(false);
      }
      itemName.setDisable(true);
      namePickedBoolean = true;
  }
  public void datePicked(ActionEvent event){
    if (namePickedBoolean){
      addItem.setDisable(false);
    }
    itemDate.setDisable(true);
    datePickedBoolean = true;
  }
  public void addItemEvent(ActionEvent event){
      toDoList.getItems().add(priorityDropdown.getText()+" "+itemName.getText()+" "+itemDate.getValue());
      priorityDropdown.setText("Priority [0]");
      itemName.setText(null);
      itemDate.setValue(null);
      addItem.setDisable(true);
      datePickedBoolean=false;
      namePickedBoolean=false;
      itemDate.setDisable(false);
      itemName.setDisable(false);
  }


  public void finishItemEvent(ActionEvent event) throws Exception {
    ObservableList selectedIndices = toDoList.getSelectionModel().getSelectedItems();
    for(Object o : selectedIndices){
      finishedList.getItems().add(o);
      toDoList.getItems().remove(o);
      this.saveData();
    }
  }

  public void restoreItemEvent(ActionEvent event) {
    ObservableList selectedIndices = finishedList.getSelectionModel().getSelectedItems();
    for(Object o : selectedIndices){
      toDoList.getItems().add(o);
      finishedList.getItems().remove(o);
    }
  }

  public void deleteItemEvent(ActionEvent event) {
    ObservableList selectedIndices = finishedList.getSelectionModel().getSelectedItems();
    for(Object o : selectedIndices){
      toDoList.getItems().remove(o);
      finishedList.getItems().remove(o);
    }
    ObservableList selectedIndices1 = toDoList.getSelectionModel().getSelectedItems();
    for(Object O : selectedIndices1){
      toDoList.getItems().remove(O);
      finishedList.getItems().remove(O);
    }
  }


  public void priorityDropdownEvent(ActionEvent event) {

  }

  public void Priority1ButtonEvent(ActionEvent event) {
    priorityDropdown.setText("Priority [1]");
  }

  public void Priority2ButtonEvent(ActionEvent event) {
    priorityDropdown.setText("Priority [2]");
  }

  public void Priority3ButtonEvent(ActionEvent event) {
    priorityDropdown.setText("Priority [3]");
  }
  
  public void saveData()throws Exception{
      File fileForData = new File("Keith");
      FileOutputStream outputStream = new FileOutputStream(fileForData);
      ObjectOutputStream objOutputStream = new ObjectOutputStream(outputStream);
      objOutputStream.writeObject(toDoList);
      objOutputStream.writeObject(finishedList);
      objOutputStream.flush();
    }

    @FXML
    void restoreData() throws Exception {
      File fileForData = new File("Keith");
      FileInputStream inputStream = new FileInputStream(fileForData);
      ObjectInputStream objInputStream = new ObjectInputStream(inputStream);


      }
     


    }

