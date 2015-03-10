package biippo.css360.uwb.biippobeta;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.ImageButton;

import java.util.ArrayList;

import Source.Category;
import Source.Searchable;
import Source.SubCategory;


public class SelectCategory extends ActionBarActivity implements View.OnClickListener{

    ImageButton cate1, cate2, cate3, cate4, cate5;
    ArrayList<Category> categoryList;
    Category passedCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_category);

        categoryList = getIntent().getExtras().getParcelableArrayList("categoryList");

        cate1 = (ImageButton)findViewById(R.id.SelectCategory_button_category1);
        cate2 = (ImageButton)findViewById(R.id.SelectCategory_button_category2);
        cate3 = (ImageButton)findViewById(R.id.SelectCategory_button_category3);
        cate4 = (ImageButton)findViewById(R.id.SelectCategory_button_category4);
        cate5 = (ImageButton)findViewById(R.id.SelectCategory_button_category5);
        ImageButton array[] = {cate1, cate2, cate3, cate4, cate5};
        for(int i = 0; i < 5; i++){
            if(i < categoryList.size()){
                array[i].setImageResource(categoryList.get(i).getIcon());
                array[i].setOnClickListener(this);
            } else {
                array[i].setVisibility(View.GONE);
            }
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(SelectCategory.this, SelectSubCategory.class);
        Bundle bundle = new Bundle();
        switch (v.getId()){
            case R.id.SelectCategory_button_category1:
                passedCategory = categoryList.get(0);
                break;
            case R.id.SelectCategory_button_category2:
                passedCategory = categoryList.get(1);
                break;
            case R.id.SelectCategory_button_category3:
                passedCategory = categoryList.get(2);
                break;
            case R.id.SelectCategory_button_category4:
                passedCategory = categoryList.get(3);
                break;
            case R.id.SelectCategory_button_category5:
                passedCategory = categoryList.get(4);
                break;
        }
        bundle.putParcelable("passedCategory", passedCategory);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
