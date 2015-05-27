package kz.aibol.schoolfeed;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import kz.aibol.schoolfeed.adapters.RecycleViewAdapter;
import kz.aibol.schoolfeed.db.SQLiteHandler;
import kz.aibol.schoolfeed.helper.Post;


public class FeedActivity extends Activity {

    private RecyclerView rv;
    private LinearLayoutManager llm;
    private ArrayList<Post> posts;
    private SQLiteHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        db = new SQLiteHandler(getApplicationContext());
        onFirstOpen();

        posts = new ArrayList<>();
        posts = db.getPosts();

        rv = (RecyclerView) findViewById(R.id.posts);

        llm = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(llm);

        RecycleViewAdapter adapter = new RecycleViewAdapter(posts);
        rv.setAdapter(adapter);
    }

    /*private void fillData() {
        posts.add(new Post("Anuar Teacher", "May 15, 8:15pm", "Hello, guys. The class tomorrow is cancelled.\nThanks"));
        posts.add(new Post("Don Aiden", "May 16, 9:15am", "Due date of Essay Project 2 is 8th June.\nDon't be late"));
        posts.add(new Post("Kim Yu Min", "May 18, 1:30pm", "Office hours change\nMy office hours now: Thursday, 1-4pm"));
        posts.add(new Post("Bilal Arslan", "May 20, 00:15am", "Midterm exam will be hold on 28.06, Wednesday\\nVenue: EB204"));
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_feed, menu);
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

    public void onFirstOpen() {
        SharedPreferences pref = FeedActivity.this.getSharedPreferences("schoolfeed", Context.MODE_PRIVATE);
        boolean dbFilled = pref.getBoolean("databaseFilled", false);
        if(!dbFilled) {
            db.addPost("Anuar Teacher", "May 15, 8:15pm", "Hello, guys. The class tomorrow is cancelled.\nThanks");
            db.addPost("Don Aiden", "May 16, 9:15am", "Due date of Essay Project 2 is 8th June.\nDon't be late");
            db.addPost("Kim Yu Min", "May 18, 1:30pm", "Office hours change\nMy office hours now: Thursday, 1-4pm");
            db.addPost("Bilal Arslan", "May 20, 00:15am", "Midterm exam will be hold on 28.06, Wednesday\\nVenue: EB204");
            SharedPreferences.Editor editor = pref.edit();
            editor.putBoolean("databaseFilled", true);
            editor.apply();
        }
    }

}
