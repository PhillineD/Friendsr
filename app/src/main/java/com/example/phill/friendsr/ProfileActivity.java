package com.example.phill.friendsr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    RatingBar stars;
    TextView Biografie;
    TextView name;
    ImageView picture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        Friend retrievedFriend = (Friend) intent.getSerializableExtra("clicked_friend_key");

        // place bio
        Biografie = findViewById(R.id.thirdtextview);
        Biografie.setText(retrievedFriend.getBio());

        // place name
        name= findViewById(R.id.secondtextview);
        name.setText(retrievedFriend.getName());

        // place picture
        picture = findViewById(R.id.secondimageview);
        picture.setImageDrawable(getResources().getDrawable(retrievedFriend.getDrawableId()));


        // For ranking
        SharedPreferences.Editor editor = getSharedPreferences("ratings", MODE_PRIVATE).edit();
        SharedPreferences prefs = getSharedPreferences("ratings", MODE_PRIVATE);

        Float ranking = prefs.getFloat(retrievedFriend.getName(),0);
        stars = findViewById(R.id.ratingbar);


        if (ranking != null){
            stars.setRating(prefs.getFloat(retrievedFriend.getName(),0.0f));
        }
        else{
            stars.setRating(0.0f);
        }
        editor.apply();

    }






}
