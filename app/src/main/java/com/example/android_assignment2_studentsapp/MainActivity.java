package com.example.android_assignment2_studentsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import com.example.android_assignment2_studentsapp.model.Model;

import java.util.LinkedList;
import java.util.List;

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
            return Model.getInstance().getSize();
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
            TextView name_tv;
            TextView id_tv;
            CheckBox checkBox;

            if (convertView == null) {

                // get Inflater
                LayoutInflater inflater = getLayoutInflater();

                // xml >> view , using inflater
                //(my_XML_converted_to_View)
                convertView = inflater.inflate(R.layout.slist_row, null);

                checkBox = convertView.findViewById(R.id.slist_row_checkbox_cb);
                // checkBox Listener
                checkBox.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String cb_StringTag = checkBox.getTag().toString();
                        Log.d("TAG", "checkBox clicked on row: " + cb_StringTag);

                        int checkBox_position = Integer.parseInt(cb_StringTag);
                        Student student =  Model.getInstance().getData().get(checkBox_position); //get linked student

                        student.setCbChecked(checkBox.isChecked());
                    }
                });
            }
            else{
                checkBox = convertView.findViewById(R.id.slist_row_checkbox_cb);
            }
            checkBox.setTag(position);

            // set references to fields in xml
            name_tv = convertView.findViewById(R.id.slist_row_name_tv); //reference
            id_tv = convertView.findViewById(R.id.slist_row_id_tv);

            // initialize the fields in view for specific student
            Student student = Model.getInstance().getData().get(position);
            name_tv.setText(student.getName());
            id_tv.setText(Integer.toString(student.getId()));
            checkBox.setChecked(student.isCbChecked());

            return convertView;
        }
    }
}