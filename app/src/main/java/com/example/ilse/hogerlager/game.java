package com.example.ilse.hogerlager;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class game extends AppCompatActivity {

    public static final String DEFAULT ="N/A";
    TextView viewUsername;
    TextView numberview;
    TextView highscoreview;
    String number;
    Integer highscorecount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        numberview = (TextView) findViewById(R.id.numberview);
        viewUsername = (TextView) findViewById(R.id.viewUsername);
        highscoreview = (TextView) findViewById(R.id.highscoreview);
        SharedPreferences sharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", DEFAULT);
        String number = sharedPreferences.getString("number", DEFAULT);
        String highscorecount = sharedPreferences.getString("highscorecount", DEFAULT);
        if (number.equals(DEFAULT)){
            Integer randomnumber = random();
            number = randomnumber.toString();
            numberview.setText(number);
        }
        else{
            numberview.setText(number);
        }

        if (username.equals(DEFAULT)){
            viewUsername.setText("no Data");
        }
        else{
            viewUsername.setText(username);
        }
        if (highscorecount.equals(DEFAULT)){
            highscoreview.setText("0");
        }
        else{
            highscoreview.setText(highscorecount);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game, menu);
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

    public int random(){
        Random rand = new Random();
        int rnumber = rand.nextInt(11);

        return rnumber;

    }
    public void low(View view) {
        TextView numberview = (TextView) findViewById(R.id.numberview);

        String text = numberview.getText().toString();
        int oldnumber = Integer.parseInt(text);
        Integer randomnumber = random();
        String number = randomnumber.toString();

        numberview.setText(number);
        if (oldnumber > randomnumber){
            View someView = findViewById(R.id.layout);
            View root = someView.getRootView();
            root.setBackgroundColor(Color.GREEN);
//            SharedPreferences sharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
//            SharedPreferences.Editor editor = sharedPreferences.edit();
//            editor.putString("number",number.toString());
//            editor.commit();
        }
        else{
            View someView = findViewById(R.id.layout);
            View root = someView.getRootView();
            root.setBackgroundColor(Color.RED);

        }


    }

    public void equal(View view) {
        TextView numberview = (TextView) findViewById(R.id.numberview);

        String text = numberview.getText().toString();
        int oldnumber = Integer.parseInt(text);
        Integer randomnumber = random();
        String number = randomnumber.toString();

        numberview.setText(number);
        if (oldnumber == randomnumber){
            View someView = findViewById(R.id.layout);
            View root = someView.getRootView();
            root.setBackgroundColor(Color.GREEN);

        }
        else{
            View someView = findViewById(R.id.layout);
            View root = someView.getRootView();
            root.setBackgroundColor(Color.RED);

        }
    }

    public void high(View view) {
        TextView numberview = (TextView) findViewById(R.id.numberview);

        String text = numberview.getText().toString();
        int oldnumber = Integer.parseInt(text);
        Integer randomnumber = random();

        String number = randomnumber.toString();
        numberview.setText(number);
        if (oldnumber < randomnumber){
            View someView = findViewById(R.id.layout);
            View root = someView.getRootView();
            root.setBackgroundColor(Color.GREEN);

        }
        else{
            View someView = findViewById(R.id.layout);
            View root = someView.getRootView();
            root.setBackgroundColor(Color.RED);

        }
    }
    public void previous(View view){
        finish();
    }

}
