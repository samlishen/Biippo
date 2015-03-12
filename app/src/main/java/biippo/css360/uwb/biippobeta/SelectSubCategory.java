package biippo.css360.uwb.biippobeta;

import android.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import Source.Category;
import Source.SubCategory;


public class SelectSubCategory extends ActionBarActivity implements View.OnClickListener{

    private Category passedCategory;
    private SubCategory toBeDisplayed;
    private ImageButton cate1, cate2, cate3, cate4, cate5;
    private ImageButton home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_sub_category);


        Bundle bundle = getIntent().getExtras();
        passedCategory = bundle.getParcelable("passedCategory");
        setTitle(passedCategory.getSearchableName());

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.actionbar_layout);
        TextView actionbar_title = (TextView)findViewById(R.id.action_bar_title);
        actionbar_title.setText(passedCategory.getSearchableName());
        actionBar.setDisplayHomeAsUpEnabled(true);
        home = (ImageButton)findViewById(R.id.bippo);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SelectSubCategory.this, SelectCategory.class));
            }
        });

        cate1 = (ImageButton)findViewById(R.id.SelectSubCategory_button_category1);
        cate2 = (ImageButton)findViewById(R.id.SelectSubCategory_button_category2);
        cate3 = (ImageButton)findViewById(R.id.SelectSubCategory_button_category3);
        cate4 = (ImageButton)findViewById(R.id.SelectSubCategory_button_category4);
        cate5 = (ImageButton)findViewById(R.id.SelectSubCategory_button_category5);
        ImageButton array[] = {cate1, cate2, cate3, cate4, cate5};
        for(int i = 0; i < 5; i++){
            if(i < passedCategory.getCount()){
                array[i].setImageResource(passedCategory.getItem(i).getIcon());
                array[i].setOnClickListener(this);
            } else {
                array[i].setVisibility(View.GONE);
            }
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(SelectSubCategory.this, SelectType.class);
        Bundle bundle = new Bundle();
        switch (v.getId()){
            case R.id.SelectSubCategory_button_category1:
                toBeDisplayed = passedCategory.getItem(0);
                break;
            case R.id.SelectSubCategory_button_category2:
                toBeDisplayed = passedCategory.getItem(1);
                break;
            case R.id.SelectSubCategory_button_category3:
                toBeDisplayed = passedCategory.getItem(2);
                break;
            case R.id.SelectSubCategory_button_category4:
                toBeDisplayed = passedCategory.getItem(3);
                break;
            case R.id.SelectSubCategory_button_category5:
                toBeDisplayed = passedCategory.getItem(4);
                break;
        }
        bundle.putParcelable("toBeDisplayed", toBeDisplayed);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
