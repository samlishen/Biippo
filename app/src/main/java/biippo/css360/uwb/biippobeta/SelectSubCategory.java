package biippo.css360.uwb.biippobeta;

import android.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import Source.Category;
import Source.SubCategory;


public class SelectSubCategory extends ActionBarActivity implements View.OnClickListener{

    private Category passedCategory;
    private SubCategory toBeDisplaied;
    private ImageButton cate1, cate2, cate3, cate4, cate5;

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
                toBeDisplaied = passedCategory.getItem(0);
                break;
            case R.id.SelectSubCategory_button_category2:
                toBeDisplaied = passedCategory.getItem(1);
                break;
            case R.id.SelectSubCategory_button_category3:
                toBeDisplaied = passedCategory.getItem(2);
                break;
            case R.id.SelectSubCategory_button_category4:
                toBeDisplaied = passedCategory.getItem(3);
                break;
            case R.id.SelectSubCategory_button_category5:
                toBeDisplaied = passedCategory.getItem(4);
                break;
        }
        bundle.putParcelable("toBeDisplaied", toBeDisplaied);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
