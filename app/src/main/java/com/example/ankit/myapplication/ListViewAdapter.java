package com.example.ankit.myapplication;

/**
 * Created by ankit on 06-07-2017.
 */
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

public class ListViewAdapter extends ArrayAdapter<Get_Set_Go> {
    // Declare Variables
    Context context;
    LayoutInflater inflater;
    List<Get_Set_Go> Get_Set_Golist;
    private SparseBooleanArray mSelectedItemsIds;

    public ListViewAdapter(Context context, int resourceId,
                           List<Get_Set_Go> Get_Set_Golist) {
        super(context, resourceId, Get_Set_Golist);
        mSelectedItemsIds = new SparseBooleanArray();
        this.context = context;
        this.Get_Set_Golist = Get_Set_Golist;
        inflater = LayoutInflater.from(context);
    }

    private class ViewHolder {
        TextView rank;
        ImageView img;
    }

    public View getView(int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.listview_item, null);
            // Locate the TextViews in listview_item.xml

            holder.rank = (TextView) view.findViewById(R.id.rank);

            // Locate the ImageView in listview_item.xml
            holder.img = (ImageView) view.findViewById(R.id.img);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Capture position and set to the TextViews

        holder.rank.setText(Get_Set_Golist.get(position).getRank());


        // Capture position and set to the ImageView
        holder.img.setImageResource(Get_Set_Golist.get(position)
                .getImg());
        return view;
    }

    @Override
    public void remove(Get_Set_Go object) {
        Get_Set_Golist.remove(object);
        notifyDataSetChanged();
    }

    public List<Get_Set_Go> getGet_Set_Go() {
        return Get_Set_Golist;
    }

    public void toggleSelection(int position) {
        selectView(position, !mSelectedItemsIds.get(position));
    }

    public void removeSelection() {
        mSelectedItemsIds = new SparseBooleanArray();
        notifyDataSetChanged();
    }

    public void selectView(int position, boolean value) {
        if (value)
            mSelectedItemsIds.put(position, value);
        else
            mSelectedItemsIds.delete(position);
        notifyDataSetChanged();
    }

    public int getSelectedCount() {
        return mSelectedItemsIds.size();
    }

    public SparseBooleanArray getSelectedIds() {
        return mSelectedItemsIds;
    }
}