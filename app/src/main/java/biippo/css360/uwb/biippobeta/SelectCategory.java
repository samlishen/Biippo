package biippo.css360.uwb.biippobeta;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

import java.util.ArrayList;

import Source.Category;
import Source.Searchable;


public class SelectCategory extends ActionBarActivity implements View.OnClickListener{

    Button cate1, cate2, cate3, cate4, cate5;
    ArrayList<Category> categoryList;
    Category passedCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_category);
        categoryList = getIntent().getParcelableArrayListExtra("categoryList");
        cate1 = (Button)findViewById(R.id.SelectCategory_button_category1);
        cate2 = (Button)findViewById(R.id.SelectCategory_button_category2);
        cate3 = (Button)findViewById(R.id.SelectCategory_button_category3);
        cate4 = (Button)findViewById(R.id.SelectCategory_button_category4);
        cate5 = (Button)findViewById(R.id.SelectCategory_button_category5);
        Button array[] = {cate1, cate2, cate3, cate4, cate5};
        for(int i = 0; i < 5; i++){
            if(i < categoryList.size()){
                array[i].setText(((Searchable)(categoryList.get(i))).getSearchableName());
                array[i].setOnClickListener(this);
            } else {
                array[i].setVisibility(View.INVISIBLE);
            }
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.SelectCategory_button_category1:
                passedCategory =categoryList.get(0);
                Intent intent = new Intent(SelectCategory.this, SelectSubCategory.class);
                intent.putExtra("passedCategory", passedCategory);
                startActivity(intent);
        }
    }
}
