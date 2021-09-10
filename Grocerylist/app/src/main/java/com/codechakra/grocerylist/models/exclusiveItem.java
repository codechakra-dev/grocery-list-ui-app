package com.codechakra.grocerylist.models;

import android.graphics.drawable.Drawable;

public class exclusiveItem {
    //this model class is used for every type of product
    private Drawable drawable;
    private String itemName;
    private String item_piece;
    private String item_price;
    private int item_counter;

    public exclusiveItem() {
    }

    public exclusiveItem(Drawable drawable, String itemName, String item_piece, String item_price, int item_counter) {
        this.drawable = drawable;
        this.itemName = itemName;
        this.item_piece = item_piece;
        this.item_price = item_price;
        this.item_counter = item_counter;
    }

    public Drawable getDrawable() {
        return drawable;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItem_piece() {
        return item_piece;
    }

    public void setItem_piece(String item_piece) {
        this.item_piece = item_piece;
    }

    public String getItem_price() {
        return item_price;
    }

    public void setItem_price(String item_price) {
        this.item_price = item_price;
    }

    public int getItem_counter() {
        return item_counter;
    }

    public void setItem_counter(int item_counter) {
        this.item_counter = item_counter;
    }
}
