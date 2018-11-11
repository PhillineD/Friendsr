package com.example.phill.friendsr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    ArrayList<Friend> friends = new ArrayList<>();

    Friend actor1 = new Friend("Arya","Third Child", getResources().getIdentifier("arya","drawable",MainActivity.this.getPackageName()));
    Friend actor2 = new Friend("Cersei"," Child", getResources().getIdentifier("cersei","drawable",MainActivity.this.getPackageName()));
    Friend actor3 = new Friend("Jaime","Third Child", getResources().getIdentifier("jaime","drawable",MainActivity.this.getPackageName()));
    Friend actor4 = new Friend("Jon","Third ", getResources().getIdentifier("jon","drawable",MainActivity.this.getPackageName()));
    Friend actor5 = new Friend("Jorah","JA? ", getResources().getIdentifier("jorah","drawable",MainActivity.this.getPackageName()));
    Friend actor6 = new Friend("Margaery","Nee", getResources().getIdentifier("margaery","drawable",MainActivity.this.getPackageName()));
    Friend actor7 = new Friend("Melisandre","Third Child", getResources().getIdentifier("melisandre","drawable",MainActivity.this.getPackageName()));
    Friend actor8 = new Friend("Sansa","Third Child", getResources().getIdentifier("sansa","drawable",MainActivity.this.getPackageName()));
    Friend actor9 = new Friend("Tyrion","Third Child", getResources().getIdentifier("tyrion","drawable",MainActivity.this.getPackageName()));


}
