package com.codechakra.grocerylist.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codechakra.grocerylist.R;
import com.codechakra.grocerylist.models.parentItem;

import java.util.List;

public class ParentRecyclerAdapter extends RecyclerView.Adapter<ParentRecyclerAdapter.ParentViewHolder> {
    List<parentItem> mList;
    ExclusiveItemRecyclerAdapter exclusiveItemRecyclerAdapter;
    ExclusiveItemRecyclerAdapter bestItemAdapter;
    GroceryRecycleAdapter groceryRecycleAdapter;

    public ParentRecyclerAdapter(List<parentItem> mList) {
        this.mList = mList;
    }

    @NonNull
    @Override
    public ParentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.parent_recyclerview_item, parent, false);
        return new ParentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ParentViewHolder holder, int position) {
        holder.item_name.setText(mList.get(position).getItemname());
        holder.childRecyclerView.setLayoutManager(new LinearLayoutManager(holder.childRecyclerView.getContext(),LinearLayoutManager.HORIZONTAL, false));
        if (position==0){
            exclusiveItemRecyclerAdapter=new ExclusiveItemRecyclerAdapter(mList.get(position).getItemsList());
            holder.childRecyclerView.setAdapter(exclusiveItemRecyclerAdapter);
        }
        else if (position==1){
            groceryRecycleAdapter=new GroceryRecycleAdapter(mList.get(position).getItemsList());
            holder.childRecyclerView.setAdapter(groceryRecycleAdapter);
        }
        else {
            bestItemAdapter=new ExclusiveItemRecyclerAdapter(mList.get(position).getItemsList());
            holder.childRecyclerView.setAdapter(bestItemAdapter);
        }

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class ParentViewHolder extends RecyclerView.ViewHolder {
        TextView item_name;
        TextView see_all_button;
        RecyclerView childRecyclerView;

        public ParentViewHolder(@NonNull View itemView) {
            super(itemView);
            item_name = itemView.findViewById(R.id.item_name);
            see_all_button = itemView.findViewById(R.id.See_all_button);
            childRecyclerView = itemView.findViewById(R.id.child_Recyclerview);
        }
    }
}
