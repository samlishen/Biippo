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
import Source.SubCategory;


public class SelectCategory extends ActionBarActivity implements View.OnClickListener{

    Button cate1, cate2, cate3, cate4, cate5;
    ArrayList<Category> categoryList;
    Category passedCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_category);

        categoryList = new ArrayList<Category>();
        //Tire
        Category tire = new Category("Tire");
        //Tire Pressure
        SubCategory tirePressure = new SubCategory("Check Tire Pressure", 2);
        tirePressure.addText(0, "Step 1: Find the operating tire pressure on the sticker that located on the side of your driver's door");
        tirePressure.addPicture(0, 0);
        tirePressure.addText(1, "Step 2: Use a tire gauge that can be purchased at local department store and auto part store to check tires' pressure. Place your tire gauge onto the tire's valve stem and read the output. You should always check the pressure when the tire is cold, which means the car has not been driven within 3 hours or a mile.");
        tirePressure.addPicture(1, R.drawable.tirepressure2);
        tirePressure.setVideo("https://www.youtube.com/watch?v=QTst6ZdlVtg");
        //Tire Rotation
        SubCategory tireRotation = new SubCategory("Tire Rotation", 2);
        tireRotation.addText(0, "Four Wheel Rotation: 4-Wheel Drive Vehicles equipped with permanent 4-Wheel Drive and those with \"on Command\" 4-Wheel Drive and driven mainly in 4-Wheel mode, are best suited to a four tire cross rotation. With this pattern, tires from both axles are crossed and installed on the opposing axle. ");
        tireRotation.addText(1, "Straight Rotation: Straight Rotation was developed in the early years of radial tires. This rotation method simply replaces the front to rear and rear to front and is used for directional tread patterns.");
        tireRotation.addPicture(1, );
        SubCategory tireChange = new SubCategory("Tire Change", 1);
        tire.addItem(tirePressure);
        tire.addItem(tireChange);
        tire.addItem(tireRotation);
        categoryList.add(tire);

        //Oil
        Category oil = new Category("Oil");
        categoryList.add(oil);

        //Emergency
        Category emergency = new Category("Emergency");

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

        cate1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.SelectCategory_button_category1:
                passedCategory =categoryList.get(0);
                Intent intent = new Intent(SelectCategory.this, SelectSubCategory.class);

                Bundle bundle = new Bundle();
                bundle.putParcelable("passedCategory", passedCategory);
                intent.putExtras(bundle);

                startActivity(intent);
        }
    }
}
