package com.codechakra.grocerylist.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.recyclerview.widget.RecyclerView;

import com.codechakra.grocerylist.GroceryItemActivity;
import com.codechakra.grocerylist.R;
import com.codechakra.grocerylist.models.exclusiveItem;

import java.util.List;

import static com.codechakra.grocerylist.NeededVariables.mdrawable;

public class ExclusiveItemRecyclerAdapter extends RecyclerView.Adapter<ExclusiveItemRecyclerAdapter.ExclusiveViewHolder> {
    List<exclusiveItem> exclusiveItems;
    public ExclusiveItemRecyclerAdapter( List<exclusiveItem> exclusiveItems) {
        this.exclusiveItems=exclusiveItems;
    }

    @NonNull
    @Override
    public ExclusiveViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.exclusivefferitem,parent,false);

        return new ExclusiveViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExclusiveViewHolder holder, int position) {

           holder.exclusive_item_image.setImageDrawable(exclusiveItems.get(position).getDrawable());
           holder.exclusive_item_name.setText(exclusiveItems.get(position).getItemName());
           holder.exclusive_item_pieces.setText(exclusiveItems.get(position).getItem_piece());
           holder.exclusive_item_price.setText(exclusiveItems.get(position).getItem_price());
           holder.button_add.setBackground( AppCompatResources.getDrawable(holder.button_add.getContext(), R.drawable.bgteal));
           holder.button_add.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   holder.button_add.setBackground( AppCompatResources.getDrawable(holder.button_add.getContext(), R.drawable.bgright));
                   holder.buttonlayout.setBackground(AppCompatResources.getDrawable(holder.button_add.getContext(), R.drawable.bgteal));
                 int c=  exclusiveItems.get(position).getItem_counter()+1;
                 holder.item_text_counter.setText(""+c);
                 holder.item_text_counter.setVisibility(View.VISIBLE);
                 exclusiveItems.get(position).setItem_counter(c);
                   holder.button_sub.setVisibility(View.VISIBLE);
               }
           });
           holder.button_sub.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   if (holder.button_sub.getVisibility()==View.VISIBLE){
                       int c=  exclusiveItems.get(position).getItem_counter();
                       if (c>0){
                           c-=1;
                           holder.item_text_counter.setText(""+c);
                           exclusiveItems.get(position).setItem_counter(c);
                       }

                   }
               }
           });
           holder.view.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent intent =new Intent(v.getContext(), GroceryItemActivity.class);
//                   private Drawable drawable;
//                   private String itemName;
//                   private String item_piece;
//                   private String item_price;
//                   private int item_counter;

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

    public static class ExclusiveViewHolder extends RecyclerView.ViewHolder{
        ImageView exclusive_item_image;
        TextView exclusive_item_name;
        TextView exclusive_item_pieces;
        TextView exclusive_item_price;
        LinearLayout buttonlayout;
        ImageView button_add;
        ImageView button_sub;
        TextView item_text_counter;
        View view;
        public ExclusiveViewHolder(@NonNull View itemView) {
            super(itemView);
            view=itemView;
            exclusive_item_image=itemView.findViewById(R.id.exclusive_item_image);
            exclusive_item_name=itemView.findViewById(R.id.exclusive_item_name);
            exclusive_item_pieces=itemView.findViewById(R.id.exclusive_item_pieces);
            exclusive_item_price=itemView.findViewById(R.id.exclusive_item_price);

            button_add=itemView.findViewById(R.id.button_add);
            button_sub=itemView.findViewById(R.id.button_sub);
            item_text_counter=itemView.findViewById(R.id.item_text_counter);
            buttonlayout=itemView.findViewById(R.id.buttonlayout);


        }
    }
}
