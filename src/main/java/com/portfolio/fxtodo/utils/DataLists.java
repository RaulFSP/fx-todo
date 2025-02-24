package com.portfolio.fxtodo.utils;

import com.portfolio.fxtodo.entities.TODO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataLists {
    private static ObservableList<TODO> listTODO;

    private DataLists(){}

    public static ObservableList<TODO> getListTODO() {
        if (listTODO == null){
            listTODO = FXCollections.observableArrayList();
        }
        return listTODO;
    }


}
