// Philline Dikker: 12317608
// Week 3: Friendsr

package com.example.phill.friendsr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    RatingBar stars;
    Friend retrievedFriend;
    TextView Biografie;
    TextView name;
    ImageView picture;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

         SharedPreferences.Editor editor;
         Intent intent = getIntent();
         retrievedFriend = (Friend) intent.getSerializableExtra("clicked_friend_key");

        //  holds a reference to the parent view with all the items, give you what item is present on that position in the parent layout

        Log.d("main acitivy", "onCreate: ");
//        place name
        name = findViewById(R.id.secondtextview);
        name.setText(retrievedFriend.getName());

        // place bio
        Biografie = findViewById(R.id.thirdtextview);
        Biografie.setText(retrievedFriend.getBio());

        // place picture
        picture = findViewById(R.id.secondimageview);
        picture.setImageDrawable(getResources().getDrawable(retrievedFriend.getDrawableId()));

        // save the ratingbar
        stars = (RatingBar) findViewById(R.id.ratingbar);

        // function from ratingbar is retrieved
        stars.setOnRatingBarChangeListener(new RatingChangeListener());

        // For ranking generate an Editor
        editor = getSharedPreferences("ratings", MODE_PRIVATE).edit();

        // retrieve sharedpreferences
        SharedPreferences prefs = getSharedPreferences("ratings", MODE_PRIVATE);

        // retrieve the data you stored
        Float ranking = prefs.getFloat(retrievedFriend.getName(), 0);

        //  check whether there is any saved data, because i
        if (ranking != 0) {

            // we have something stored under "example_key"
            stars.setRating(prefs.getFloat(retrievedFriend.getName(), 0.0f));
        } else {

            // there is nothing stored under "example_key", the rating bar can stay blank
            stars.setRating(0.0f);
        }

        //  to save the changes
        editor.apply();

    }

    private class RatingChangeListener implements RatingBar.OnRatingBarChangeListener {
        @Override
        public void onRatingChanged(RatingBar ratingBar, float r, boolean b) {

            // retrieve SharedPrefences
            SharedPreferences prefs = getSharedPreferences("ratings", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();

            // put rating from retrievedFriend in r
            editor.putFloat(retrievedFriend.getName(), r);


            // save changes
            editor.apply();

            // set rating from retrieved friend r
            retrievedFriend.setRating(r);
        }

    }

}




