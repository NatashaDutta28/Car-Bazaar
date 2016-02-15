package com.carbazaar.natasha.carbazaar;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class CRV extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crv);
        String[] favoriteTVShows = {"CRV 2.0L 2WD MT\nRs. 21.09 Lakh","CRV 2.0L 2WD AT \nRs. 22.85 Lakh", "CRV 2.4L 4WD AVN \nRs. 25.09 Lakh"};

        ListAdapter theAdapter = new MyAdapter3(this, favoriteTVShows);

        // Get the ListView so we can work with it
        ListView theListView = (ListView) findViewById(R.id.listView1);

        // Connect the ListView with the Adapter that acts as a bridge between it and the array
        theListView.setAdapter(theAdapter);

        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String carPicked = "You selected " +

                        String.valueOf(adapterView.getItemAtPosition(i));

                Toast.makeText(CRV.this, carPicked, Toast.LENGTH_SHORT).show();
                //String s = favoriteTVShows[i];

            }
        });
    }



    /*public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() { }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_display_message,
                    container, false);
            return rootView;
        }
    }*/


  /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}