package com.needham.crowdplay;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class StudentActivity extends AppCompatActivity {

    private Spinner topicsSpinner;
    private String currentlySelectedFeedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        topicsSpinner = (Spinner) findViewById(R.id.spinnerDropdown);
        List<String> topics = new ArrayList<String>();
        topics.add("Supply");
        topics.add("Demand");
        topics.add("Elasticity");
        topics.add("Consumer Surplus");
        topics.add("Scarcity");
        topics.add("Game Theory");
        topics.add("Nash Equilibrium");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, topics);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        topicsSpinner.setAdapter(dataAdapter);

    }

    public void sendFeedback(View v) {
        String selectedTopic = topicsSpinner.getSelectedItem().toString();
        System.out.println(selectedTopic);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_student, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
