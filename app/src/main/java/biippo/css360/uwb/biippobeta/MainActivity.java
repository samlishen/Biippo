package biippo.css360.uwb.biippobeta;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import Source.Category;
import Source.Searchable;


public class MainActivity extends ActionBarActivity {

    ArrayList<Searchable> searchableList;
    ArrayList<Searchable> categoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        searchableList = getIntent().getParcelableArrayListExtra("searchableList");
        categoryList = getIntent().getParcelableArrayListExtra("categoryList");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
