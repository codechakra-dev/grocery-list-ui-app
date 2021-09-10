package com.codechakra.grocerylist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ActionBar;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

import static com.codechakra.grocerylist.NeededVariables.mdrawable;

public class GroceryItemActivity extends AppCompatActivity {
ImageView ItemImage;
TextView item_name;
TextView item_pieces;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grocery_item);

//        Window w = getWindow();
//        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        Objects.requireNonNull(getSupportActionBar()).setHomeAsUpIndicator(R.drawable.ic_home_button);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setBackgroundDrawable(getDrawable(R.drawable.bgfortoolbar));

        getSupportActionBar().setElevation(0);


//        intent.putExtra("itemname",exclusiveItems.get(position).getItemName());
//        intent.putExtra("itempiece",exclusiveItems.get(position).getItem_piece());
//        intent.putExtra("itemprice",exclusiveItems.get(position).getItem_price());
//        mdrawable= exclusiveItems.get(position).getDrawable();
        ItemImage=findViewById(R.id.ItemImage);
        item_name=findViewById(R.id.item_name);
        item_pieces=findViewById(R.id.item_pieces);

      String itemname=  getIntent().getStringExtra("itemname");
        String itempiece=    getIntent().getStringExtra("itempiece");
        String itemprice=     getIntent().getStringExtra("itemprice");
        ItemImage.setImageDrawable(mdrawable);
        item_name.setText(itemname);
        item_pieces.setText(itempiece);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_file, menu);
        return true;
    }
}