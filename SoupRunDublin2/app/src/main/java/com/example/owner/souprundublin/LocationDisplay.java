package com.example.owner.souprundublin;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class LocationDisplay extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    GPS gps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    //This method instantiates the GPS class and using it gets the users current location from which it
    //sets a marker on the map titled "You are here" and zooms the map so as the user can see the area
    //they are currently in at street view
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        addCurrentPos();
        addMarkers();
        addInchicoreMarker();
        addTrinityMarker();
        checkMarkers();

    }

    public void addCurrentPos()
    {
        gps = new GPS(LocationDisplay.this);
        LatLng currentPos = new LatLng(gps.findLatitude(), gps.findLongitude());
        float zoom = 15;
        mMap.addMarker(new MarkerOptions().position(currentPos).title("You are here").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentPos, zoom));

    }

    public void addMarkers()
    {
        LatLng meathStreet = new LatLng(53.341986, -6.279333);
        mMap.addMarker(new MarkerOptions().position(meathStreet).title("Guild of the Little Flower\n11 Meath Street"));

        LatLng merchantsQuay = new LatLng(53.344831, -6.273686);
        mMap.addMarker(new MarkerOptions().position(merchantsQuay).title("Extended Day Service\n13-14 Merchants Quay"));

        LatLng riverbank = new LatLng(53.346875, -6.307588);
        mMap.addMarker(new MarkerOptions().position(riverbank).title("Merchants Quay Ireland\nRiverbank"));

        LatLng islandStreet = new LatLng(53.345680, -6.282922);
        mMap.addMarker(new MarkerOptions().position(islandStreet).title("Mendicity Institution Trust\nIsland Street"));

        LatLng southCircularRoad = new LatLng(53.331598, -6.284990);
        mMap.addMarker(new MarkerOptions().position(southCircularRoad).title("Missionaries of Charity\n223 South Circular Road"));

        LatLng bowStreet = new LatLng(53.348158, -6.276485);
        mMap.addMarker(new MarkerOptions().position(bowStreet).title("Capuchin Day Centre\nBow Street"));

        LatLng portlandRow = new LatLng(53.356236, -6.248204);
        mMap.addMarker(new MarkerOptions().position(portlandRow).title("St Agatha’s Food Centre\n35 Portland Row"));

        LatLng avondaleHouse = new LatLng(53.353397, -6.257419);
        mMap.addMarker(new MarkerOptions().position(avondaleHouse).title("St.Joseph’s Penny Dinners\n67 Avondale House, North Cumberland Street"));

        LatLng eustaceStreet = new LatLng(53.345250, -6.264680);
        mMap.addMarker(new MarkerOptions().position(eustaceStreet).title("Focus Ireland Coffee Shop\n15 Eustace Street"));

        LatLng hollesRow = new LatLng(53.340323, -6.245260);
        mMap.addMarker(new MarkerOptions().position(hollesRow).title("St Brigid’s Food Centre\nHolles Row-"));
    }

    public Location setCurrentPos()
    {
        gps = new GPS(LocationDisplay.this);
        Location currentPos = new Location("Current Position");
        currentPos.setLatitude(gps.findLatitude());
        currentPos.setLongitude(gps.findLongitude());

        return currentPos;
    }

    public Location setMeathStreet()
    {
        Location meathStreet = new Location("Meath Street");
        meathStreet.setLatitude(53.341986);
        meathStreet.setLongitude(-6.279333);

        return meathStreet;
    }

    public Location setMerchantsQuay()
    {
        Location merchantsQuay = new Location("Merchants Street");
        merchantsQuay.setLatitude(53.344831);
        merchantsQuay.setLongitude(-6.273686);

        return merchantsQuay;
    }

    public Location setRiverbank()
    {
        Location riverbank = new Location("Riverbank");
        riverbank.setLatitude(53.346875);
        riverbank.setLongitude(-6.307588);

        return riverbank;
    }

    public Location setIslandStreet()
    {
        Location islandStreet = new Location("Island Street");
        islandStreet.setLatitude(53.345680);
        islandStreet.setLongitude(-6.282922);

        return islandStreet;
    }

    public Location setSouthCircularRoad()
    {
        Location southCircularRoad = new Location("South Circular Road");
        southCircularRoad.setLatitude(53.331598);
        southCircularRoad.setLongitude(-6.284990);

        return southCircularRoad;
    }

    public Location setBowStreet()
    {
        Location bowStreet = new Location("Bow Street");
        bowStreet.setLatitude(53.348158);
        bowStreet.setLongitude(-6.276485);

        return bowStreet;
    }

    public Location setPortlandRow()
    {
        Location portlandRow = new Location("Portland Row");
        portlandRow.setLatitude(53.356236);
        portlandRow.setLongitude(-6.248204);

        return portlandRow;
    }

    public Location setAvondaleHouse()
    {
        Location avondaleHouse = new Location("Avondale Street");
        avondaleHouse.setLatitude(53.353397);
        avondaleHouse.setLongitude(-6.257419);

        return avondaleHouse;
    }

    public Location setEustaceStreet()
    {
        Location eustaceStreet = new Location("Eustace Street");
        eustaceStreet.setLatitude(53.345250);
        eustaceStreet.setLongitude(-6.264680);

        return eustaceStreet;
    }

    public Location setHollesRow()
    {
        Location hollesRow = new Location("Holles Row");
        hollesRow.setLatitude(53.340323);
        hollesRow.setLongitude(-6.245260);

        return hollesRow;
    }

    public void checkMarkers()
    {
        EnterChoices enterChoices = new EnterChoices();
        float distance = 1000;
        String location;
        String sentence = "You are within 500m of ";
        Location currentPosition = setCurrentPos();
        Location inchicore = setInchicoreLocation();
        Location meathStreet = setMeathStreet();
        Location merchantsQuay = setMerchantsQuay();
        Location riverbank = setRiverbank();
        Location islandStreet = setIslandStreet();
        Location southCircularRoad = setSouthCircularRoad();
        Location bowStreet = setBowStreet();
        Location portlandRow = setPortlandRow();
        Location avondaleHouse = setAvondaleHouse();
        Location eustaceStreet = setEustaceStreet();
        Location hollesRow = setHollesRow();

        distance = inchicore.distanceTo(currentPosition);
        if(distance < 500)
        {
            location = "Inchicore";
            LatLng inchicoreLatLng = new LatLng(inchicore.getLatitude(),inchicore.getLongitude());
            Marker inchicoreMarker = mMap.addMarker(new MarkerOptions().position(inchicoreLatLng).title(location).snippet(sentence + location));
            inchicoreMarker.showInfoWindow();
        }

        distance = meathStreet.distanceTo(currentPosition);
        if(distance < 500)
        {
            location = "Guild of the Little Flower";
            LatLng meathStreetLatLng = new LatLng(meathStreet.getLatitude(),meathStreet.getLongitude());
            Marker meathStreetMarker = mMap.addMarker(new MarkerOptions().position(meathStreetLatLng).title(location).snippet(sentence + location));
            meathStreetMarker.showInfoWindow();
        }

        distance = merchantsQuay.distanceTo(currentPosition);
        if(distance < 500)
        {
            location = "Extended Day Service";
            LatLng merchantsQuayLatLng = new LatLng(merchantsQuay.getLatitude(),merchantsQuay.getLongitude());
            Marker merchantsQuayMarker = mMap.addMarker(new MarkerOptions().position(merchantsQuayLatLng).title(location).snippet(sentence + location));
            merchantsQuayMarker.showInfoWindow();
        }

        distance = riverbank.distanceTo(currentPosition);
        if(distance < 500)
        {
            location = "Merchants Quay Ireland";
            LatLng riverbankLatLng = new LatLng(riverbank.getLatitude(),riverbank.getLongitude());
            Marker riverbankMarker = mMap.addMarker(new MarkerOptions().position(riverbankLatLng).title(location).snippet(sentence + location));
            riverbankMarker.showInfoWindow();
        }

        distance = islandStreet.distanceTo(currentPosition);
        if(distance < 500)
        {
            location = "Mendicity Institution Trust";
            LatLng islandStreetLatLng = new LatLng(islandStreet.getLatitude(),islandStreet.getLongitude());
            Marker islandStreetMarker = mMap.addMarker(new MarkerOptions().position(islandStreetLatLng).title(location).snippet(sentence + location));
            islandStreetMarker.showInfoWindow();
        }

        distance = southCircularRoad.distanceTo(currentPosition);
        if(distance < 500)
        {
            location = "Missionaries of Charity";
            LatLng southCircularRoadLatLng = new LatLng(southCircularRoad.getLatitude(),southCircularRoad.getLongitude());
            Marker southCircularRoadMarker = mMap.addMarker(new MarkerOptions().position(southCircularRoadLatLng).title(location).snippet(sentence + location));
            southCircularRoadMarker.showInfoWindow();
        }

        distance = bowStreet.distanceTo(currentPosition);
        if(distance < 500)
        {
            location = "Capuchin Day Centre";
            LatLng bowStreetLatLng = new LatLng(bowStreet.getLatitude(),bowStreet.getLongitude());
            Marker bowStreetMarker = mMap.addMarker(new MarkerOptions().position(bowStreetLatLng).title(location).snippet(sentence + location));
            bowStreetMarker.showInfoWindow();
        }

        distance = portlandRow.distanceTo(currentPosition);
        if(distance < 500)
        {
            location = "St Agatha’s Food Centre";
            LatLng portlandRowLatLng = new LatLng(portlandRow.getLatitude(),portlandRow.getLongitude());
            Marker portlandRowMarker = mMap.addMarker(new MarkerOptions().position(portlandRowLatLng).title(location).snippet(sentence + location));
            portlandRowMarker.showInfoWindow();
        }

        distance = avondaleHouse.distanceTo(currentPosition);
        if(distance < 500)
        {
            location = "St.Joseph’s Penny Dinners";
            LatLng avondaleHouseLatLng = new LatLng(avondaleHouse.getLatitude(),avondaleHouse.getLongitude());
            Marker avondaleHouseMarker = mMap.addMarker(new MarkerOptions().position(avondaleHouseLatLng).title(location).snippet(sentence + location));
            avondaleHouseMarker.showInfoWindow();
        }

        distance = eustaceStreet.distanceTo(currentPosition);
        if(distance < 500)
        {
            location = "Focus Ireland Coffee Shop";
            LatLng eustaceStreetLatLng = new LatLng(eustaceStreet.getLatitude(),eustaceStreet.getLongitude());
            Marker eustaceStreetMarker = mMap.addMarker(new MarkerOptions().position(eustaceStreetLatLng).title(location).snippet(sentence + location));
            eustaceStreetMarker.showInfoWindow();
        }

        distance = hollesRow.distanceTo(currentPosition);
        if(distance < 500)
        {
            location = "St Brigid’s Food Centre";
            LatLng hollesRowLatLng = new LatLng(hollesRow.getLatitude(),hollesRow.getLongitude());
            Marker hollesRowMarker = mMap.addMarker(new MarkerOptions().position(hollesRowLatLng).title(location).snippet(sentence + location));
            hollesRowMarker.showInfoWindow();
        }
    }



    public void addInchicoreMarker()
    {
        LatLng inchicore = new LatLng(53.34174, -6.323186);
        mMap.addMarker(new MarkerOptions().position(inchicore).title("Van Yard").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
    }

    public Location setInchicoreLocation()
    {
        Location location = new Location("Inchicore");
        location.setLatitude(53.34174);
        location.setLongitude(-6.323186);

        return location;
    }

    private void addTrinityMarker()
    {
        LatLng hamilton = new LatLng(53.343330, -6.250792);
        mMap.addMarker(new MarkerOptions().position(hamilton).title("Bank of Ireland").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
    }

    private Location setTrinityLocation()
    {
        Location hamilton = new Location("Hamilton");
        hamilton.setLatitude(53.343330);
        hamilton.setLongitude(-6.250792);

        return hamilton;
    }




}
