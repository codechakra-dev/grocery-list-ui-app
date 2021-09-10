package com.codechakra.grocerylist.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.recyclerview.widget.RecyclerView;

import com.codechakra.grocerylist.GroceryItemActivity;
import com.codechakra.grocerylist.R;
import com.codechakra.grocerylist.models.exclusiveItem;

import java.util.List;

import static com.codechakra.grocerylist.NeededVariables.mdrawable;

public class GroceryRecycleAdapter extends RecyclerView.Adapter<GroceryRecycleAdapter.GroceryViewHolder> {
    List<exclusiveItem> exclusiveItems;
    boolean checkItem=true;
    public GroceryRecycleAdapter(List<exclusiveItem> exclusiveItems) {
        this.exclusiveItems = exclusiveItems;
    }

    @NonNull
    @Override
    public GroceryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.groceryitem,parent,false);

        return new GroceryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GroceryViewHolder holder, int position) {
      holder.groceryitemImage.setImageDrawable(exclusiveItems.get(position).getDrawable());
      holder.groceryItemName.setText(exclusiveItems.get(position).getItemName());

      if (checkItem){
          holder.grocery_bg_lay.setBackground( AppCompatResources.getDrawable(holder.grocery_bg_lay.getContext(),R.drawable.grocery_item_color1));
          checkItem=false;
      }
      else {
          holder.grocery_bg_lay.setBackground( AppCompatResources.getDrawable(holder.grocery_bg_lay.getContext(),R.drawable.grocery_item_color2));
          checkItem=true;
      }
      holder.itemView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent =new Intent(v.getContext(), GroceryItemActivity.class);

              intent.putExtra("itemname",exclusiveItems.get(position).getItemName());
              intent.putExtra("itempiece",exclusiveItems.get(position).getItem_piece());
              intent.putExtra("itemprice",exclusiveItems.get(position).getItem_price());
              mdrawable= exclusiveItems.get(position).getDrawable();
              //intent.putExtra("drawable", (Parcelable) (Bitmap) exclusiveItems.get(position).getDrawable());
              v.getContext().startActivity(intent);
          }
      });
    }

    @Override
    public int getItemCount() {
        return exclusiveItems.size();
    }

    public static class GroceryViewHolder extends RecyclerView.ViewHolder {
        ImageView groceryitemImage;
        TextView groceryItemName;
        View view;
        RelativeLayout grocery_bg_lay;
        public GroceryViewHolder(@NonNull View itemView) {
            super(itemView);
            groceryitemImage=itemView.findViewById(R.id.groceryitemImage);
            groceryItemName=itemView.findViewById(R.id.groceryItemName);
            grocery_bg_lay=itemView.findViewById(R.id.grocery_bg_lay);
            view=itemView;
        }
    }
}
