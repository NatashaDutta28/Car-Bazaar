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


public class Usedcar extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usedcar);
        final String[] favoriteTVShows = {"City"};

        // A View is the generic term and class for every widget you put on your screen.
        // Views occupy a rectangular area and are responsible for handling events
        // and drawing the widget.

        // The ListAdapter acts as a bridge between the data and each ListItem
        // You fill the ListView with a ListAdapter. You pass it a context represented by
        // this.

        // A Context provides access to resources you need. It provides the current Context, or
        // facts about the app and the events that have occurred with in it.
        // android.R.layout.simple_list_item_1 is one of the resources needed.
        // It is a predefined layout provided by Android that stands in as a default

        //ListAdapter theAdapter = new ArrayAdapter<String>(this, R.layout.row_layout,
        // R.id.textView1, favoriteTVShows);

        // We point the ListAdapter to our custom adapter
        ListAdapter theAdapter = new MyAdapter3(this, favoriteTVShows);

        // Get the ListView so we can work with it
        ListView theListView = (ListView) findViewById(R.id.listView1);

        // Connect the ListView with the Adapter that acts as a bridge between it and the array
        theListView.setAdapter(theAdapter);

        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                String s = favoriteTVShows[i];

                try{
                    Class myClass = Class.forName("com.carbazaar.natasha.carbazaar."+s);
                    Intent myIntent = new Intent(Usedcar.this,myClass);
                    startActivity(myIntent);
                }
                catch(ClassNotFoundException e){
                    e.printStackTrace();
                }

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