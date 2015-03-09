package biippo.css360.uwb.biippobeta;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.VideoView;

import java.util.ArrayList;

import Source.Category;
import Source.Searchable;

public class MainActivity extends ActionBarActivity {

    Button about, selectCategory, search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        selectCategory = (Button)findViewById(R.id.main_button_selectCategory);
        selectCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SelectCategory.class);
                startActivity(intent);
            }
        });
    }
}
