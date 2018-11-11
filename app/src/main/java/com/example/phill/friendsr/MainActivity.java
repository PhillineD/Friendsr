package com.example.phill.friendsr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    ArrayList<Friend> friends = new ArrayList<>();

    // make all friends
    Friend actor1 = new Friend("Arya","Third Child", getResources().getIdentifier("arya","drawable",MainActivity.this.getPackageName()));
    Friend actor2 = new Friend("Cersei"," Child", getResources().getIdentifier("cersei","drawable",MainActivity.this.getPackageName()));
    Friend actor3 = new Friend("Jaime","Third Child", getResources().getIdentifier("jaime","drawable",MainActivity.this.getPackageName()));
    Friend actor4 = new Friend("Jon","Third ", getResources().getIdentifier("jon","drawable",MainActivity.this.getPackageName()));
    Friend actor5 = new Friend("Jorah","JA? ", getResources().getIdentifier("jorah","drawable",MainActivity.this.getPackageName()));
    Friend actor6 = new Friend("Margaery","Nee", getResources().getIdentifier("margaery","drawable",MainActivity.this.getPackageName()));
    Friend actor7 = new Friend("Melisandre","Third Child", getResources().getIdentifier("melisandre","drawable",MainActivity.this.getPackageName()));
    Friend actor8 = new Friend("Sansa","Third Child", getResources().getIdentifier("sansa","drawable",MainActivity.this.getPackageName()));
    Friend actor9 = new Friend("Tyrion","Third Child", getResources().getIdentifier("tyrion","drawable",MainActivity.this.getPackageName()));

    // adding al friends
    friends.add(actor1);
    friends.add(actor2);
    friends.add(actor3);
    friends.add(actor4);
    friends.add(actor5);
    friends.add(actor6);
    friends.add(actor7);
    friends.add(actor8);
    friends.add(actor9);

    //    instantiate your adapter
    FriendsAdapter adapter = new FriendsAdapter(this,R.layout.grid_item, friends   );

    // attach the adapter to GridVie
    GridView gridView = findViewById(R.id.gridView);
    gridView.setAdapter(adapter);
    gridView.setOnItemClickListener(new GridItemClickListener());

    }

    private class GridItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long ID){

//            connect this listener to the GridView
            Friend clickedFriend = (Friend) adapterView.getItemAtPosition(position);
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("clicked_friend", clickedFriend);
            startActivity(intent);
        }

    }
}
