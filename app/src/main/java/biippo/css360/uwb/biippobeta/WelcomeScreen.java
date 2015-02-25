package biippo.css360.uwb.biippobeta;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.os.Handler;

import java.util.ArrayList;

import Source.Category;
import Source.Searchable;
import Source.SubCategory;


public class WelcomeScreen extends ActionBarActivity {
    private static int TIME_OUT=5;

    //Create a list of Searchable object
    private ArrayList<Searchable> searchableList;
    private ArrayList<Searchable> categoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
//------------------------------------------------------------------------------------------------
        //Creating all categories and sub categories and put them in lists so can be used later
        //TODO
        Category tire = new Category("Tire");
        SubCategory tirePressure = new SubCategory("Check Tire Pressure");
        SubCategory tireRotation = new SubCategory("Tire Rotation");
        SubCategory tireChange = new SubCategory("Tire Change");
        tire.addItem(tirePressure);
        tire.addItem(tireChange);
        tire.addItem(tireRotation);
        categoryList.add(tire);
        Category oil = new Category("Oil");
        categoryList.add(oil);
        Category emergency = new Category("Emergency");
        categoryList.add(emergency);
//------------------------------------------------------------------------------------------------
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(WelcomeScreen.this, MainActivity.class);
                intent.putExtra("categoryList", categoryList);
                intent.putExtra("searchableList", categoryList);
                startActivity(intent);
                WelcomeScreen.this.finish();
            }
        },TIME_OUT*1000);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_welcome_screen, menu);
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
