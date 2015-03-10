package biippo.css360.uwb.biippobeta;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import Source.Category;
import Source.SubCategory;


public class SelectSubCategory extends ActionBarActivity implements View.OnClickListener{

    Category passedCategory;
    SubCategory toBeDisplaied;
    Button cate1, cate2, cate3, cate4, cate5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_sub_category);

        Bundle bundle = getIntent().getExtras();
        passedCategory = bundle.getParcelable("passedCategory");

        cate1 = (Button)findViewById(R.id.SelectSubCategory_button_category1);
        cate2 = (Button)findViewById(R.id.SelectSubCategory_button_category2);
        cate3 = (Button)findViewById(R.id.SelectSubCategory_button_category3);
        cate4 = (Button)findViewById(R.id.SelectSubCategory_button_category4);
        cate5 = (Button)findViewById(R.id.SelectSubCategory_button_category5);
        Button array[] = {cate1, cate2, cate3, cate4, cate5};
        for(int i = 0; i < 5; i++){
            if(i < passedCategory.getCount()){
                array[i].setText(passedCategory.getItem(i).getSearchableName());
                array[i].setOnClickListener(this);
            } else {
                array[i].setVisibility(View.INVISIBLE);
            }
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(SelectSubCategory.this, SelectType.class);
        Bundle bundld = new Bundle();
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
        bundld.putParcelable("toBeDisplaied", toBeDisplaied);
        intent.putExtras(bundld);
        startActivity(intent);
    }
}
