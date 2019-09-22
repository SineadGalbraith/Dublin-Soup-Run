package com.example.owner.souprundublin;

import android.location.Location;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Owner on 22/03/2018.
 */
public class LocationInfo {

    private long homelessEstimate;
    private Location coords;


    FirebaseDatabase database = FirebaseDatabase.getInstance();

    public LocationInfo() {
        // ---
    }

    public LocationInfo(Location coords, long homelessEstimate) {
        this.coords = coords;
        this.homelessEstimate = homelessEstimate;
    }

    public long getHomeless() {
        return homelessEstimate;
    }

    public Location getCoords() {
        return coords;
    }
    //_________________________________________________________________________
    //_________________________________________________________________________

    public static void addData(Location coords, long estimate) {

        LocationInfo info = new LocationInfo(coords, estimate);

        String locationID = "loc";

        DatabaseReference dbRef= FirebaseDatabase.getInstance().getReference("souprunstats");
        dbRef.child("location data").child(locationID).setValue(info);

    }
}
