package com.codechakra.grocerylist.models;

import com.codechakra.grocerylist.models.exclusiveItem;

import java.util.List;

public class parentItem {
    private String itemname;
    private List<exclusiveItem> itemsList;

    public parentItem(String itemname, List<exclusiveItem> itemsList) {
        this.itemname = itemname;
        this.itemsList = itemsList;
    }

    public parentItem(String itemname) {
        this.itemname = itemname;
    }

    public List<exclusiveItem> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<exclusiveItem> itemsList) {
        this.itemsList = itemsList;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }


}
