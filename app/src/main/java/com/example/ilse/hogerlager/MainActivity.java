package com.example.ilse.hogerlager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    EditText editUsername;
    public static final String DEFAULT ="N/A";


    //    code for highscore list
//    ListView listView;
//    ArrayAdapter<String> adapter;
//    String[] highscores = {"player1", "player2", "player3", "player4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editUsername = (EditText) findViewById(R.id.editUsername);

        //code for highscore list
//        listView = (ListView)findViewById(R.id.highScore);
//        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,highscores);
//        listView.setAdapter(adapter);
    }
    public void startGame(View view){
        SharedPreferences sharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username",editUsername.getText().toString());
        editor.commit();
        Button button = (Button) view;
        startActivity(new Intent(getApplicationContext(),game.class));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}
