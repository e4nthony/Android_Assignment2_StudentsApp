package com.example.android_assignment2_studentsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set reference to main_list_view in activity_main.xml
        ListView listView = findViewById(R.id.main_list_view);

        // initialize adapter
        MyAdapter adapter = new MyAdapter();

        // connect adapter with listView
        listView.setAdapter(adapter);

        //----------

        // Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /***
             * @param parent
             * @param view
             * @param position - clicked row number
             * @param id -  [ getting from MyAdapter.getItemId() ]
             */
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("TAG", "Row clicked: " + position);
            }
        });

    }//onCreate end


    /***
     * returns to list every prepared row including element's params.
     */
    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            //return 0;
            return 15;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        /***
         * @param position - row number
         * @param convertView - old view to reuse if possible
         * @param parent
         * @return
         */
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {

                // get Inflater
                LayoutInflater inflater = getLayoutInflater();

                // xml >> view , using inflater
                //(my_XML_converted_to_View)
                convertView = inflater.inflate(R.layout.slist_row, null);
            }

            // set references to fields in xml
            TextView name_tv = convertView.findViewById(R.id.slist_row_name_tv); //reference
            TextView id_tv = convertView.findViewById(R.id.slist_row_id_tv);

            // initialize the fields in view
            name_tv.setText("examleName " + position);
            id_tv.setText("examleID " + position);

            return convertView;
        }
    }
}