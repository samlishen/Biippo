package biippo.css360.uwb.biippobeta;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import Source.Category;


public class SelectSubCategory extends ActionBarActivity implements View.OnClickListener{

    Category passedCategory;
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
        switch (v.getId()){
            case R.id.SelectSubCategory_button_category1:
                Intent intent = new Intent(SelectSubCategory.this, SelectType.class);
                Bundle bundle = new Bundle();
                bundle.putParcelable("toBeDisplaied",passedCategory.getItem(0));
                intent.putExtras(bundle);
                startActivity(intent);
        }
    }
}