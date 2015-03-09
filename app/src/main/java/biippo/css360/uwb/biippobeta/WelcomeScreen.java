package biippo.css360.uwb.biippobeta;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.os.Handler;

import java.util.ArrayList;

import Source.Category;
import Source.SubCategory;


public class WelcomeScreen extends ActionBarActivity {
    private static int TIME_OUT=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(WelcomeScreen.this, MainActivity.class);
                WelcomeScreen.this.finish();
                startActivity(intent);
            }
        },TIME_OUT*1000);
    }
}
