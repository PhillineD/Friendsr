// Philline Dikker: 12317608
// Week 3: Friendsr

package com.example.phill.friendsr;

import java.io.Serializable;
public class Friend implements Serializable{
    private String name, bio;
    private int drawableId;
    private float rating;


    // Constructor  for  class Friend
    public Friend(String name, String bio, int drawableId){
        this.name = name;
        this.bio = bio;
        this.drawableId = drawableId;
        this.rating = 0;
    }

    // Getter for name
    public String getName(){
        return this.name;
    }

    // Getter for bio
    public String getBio(){
        return this.bio;
    }

    // Getter for drawableID
    public int getDrawableId(){
        return this.drawableId;
    }

    // Setter for rating
    public float getRating(float Rating) {
        return this.rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}

