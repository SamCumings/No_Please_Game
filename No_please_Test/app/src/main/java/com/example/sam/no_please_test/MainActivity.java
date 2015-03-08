package com.example.sam.no_please_test;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.EditText;
// this is a another test comment by olaf (3/7/2015)

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    /*Called to go to options (isn't working yet) */
    public void go_to_options(View view){
        //do something in response to button
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        startActivity(intent);
    }
    /*should go to player select activity*/
    public void Player_Select(View view){
        //do something in response to button
        Intent intent = new Intent(this, Player_Select.class);
        startActivity(intent);
    }
    /*should go to player select activity*/
    public void Tutorial(View view){
        //do something in response to button
        Intent intent = new Intent(this, Tutorial.class);
        startActivity(intent);
    }

}
