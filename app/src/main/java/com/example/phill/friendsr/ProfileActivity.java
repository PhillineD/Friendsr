package com.example.phill.friendsr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    RatingBar stars;
    TextView Biografie;
    TextView name;
    ImageView picture;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent intent = getIntent();

        //  holds a reference to the parent view with all the items, give you what item is present on that position in the parent layout
        Friend retrievedFriend = (Friend) intent.getSerializableExtra("clicked_friend_key");
        Log.d("ProfileActivity.java", "Friend: " + retrievedFriend.getName());

//         place name
        name= findViewById(R.id.secondtextview);
        name.setText(retrievedFriend.getName());

        // place bio
        Biografie = findViewById(R.id.thirdtextview);
        Biografie.setText(retrievedFriend.getBio());

        // place picture
        picture = findViewById(R.id.secondimageview);
        picture.setImageDrawable(getResources().getDrawable(retrievedFriend.getDrawableId()));

        // For ranking
        SharedPreferences.Editor editor = getSharedPreferences("ratings", MODE_PRIVATE).edit();

        // retrieve sharedpreferences
        SharedPreferences prefs = getSharedPreferences("ratings", MODE_PRIVATE);

        // retrieve the data you stored
        Float ranking = prefs.getFloat(retrievedFriend.getName(),0);
        stars = findViewById(R.id.ratingbar);

        //  check whether there is any saved data, because i
        if (ranking != null){

            // we have something stored under "example_key"
            stars.setRating(prefs.getFloat(retrievedFriend.getName(),0.0f));
        }
        else{

            // there is nothing stored under "example_key", the rating bar can stay blank
            stars.setRating(0.0f);
        }

    //  to save the changes
        editor.apply();

    }






}
