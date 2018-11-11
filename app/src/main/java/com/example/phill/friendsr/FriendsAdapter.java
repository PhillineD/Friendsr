package com.example.phill.friendsr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;




public class FriendsAdapter extends ArrayAdapter<Friend> {

    public TextView FriendName;
    public  ImageView FriendPhoto;
    //    the constructor that takes context, a resource id of type integer and a list of items
    public FriendsAdapter( Context context, int resource,  ArrayList<Friend> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    //    this method will be called every time a new grid item is to be displayed (for example, when scrolling)
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Friend friend = getItem(position);
        int ID = friend.getDrawableId();

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent, false);
        }

        FriendName = convertView.findViewById(R.id.textView);
        FriendPhoto = convertView.findViewById(R.id.ImageView);
        FriendPhoto.setImageDrawable(getContext().getResources().getDrawable(ID));
        FriendName.setText(friend.getName());

        return convertView;
    }
}
