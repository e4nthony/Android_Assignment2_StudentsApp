package com.example.android_assignment2_studentsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    View my_XML_converted_to_View;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

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
         *
         * @param position - row number
         * @param convertView
         * @param parent
         * @return
         */
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {

                // get Inflater
                LayoutInflater inflater = getLayoutInflater();

                // xml >> view , using inflater
                my_XML_converted_to_View = inflater.inflate(R.layout.slist_row, null);
            }

            // name references to fields in xml
            TextView name_tv = my_XML_converted_to_View.findViewById(R.id.slist_row_name_tv); //reference
            TextView id_tv = my_XML_converted_to_View.findViewById(R.id.slist_row_id_tv);

            // initialize the fields in view
            name_tv.setText("examleName " + position);
            id_tv.setText("examleID " + position);

            return my_XML_converted_to_View;
        }
    }
}