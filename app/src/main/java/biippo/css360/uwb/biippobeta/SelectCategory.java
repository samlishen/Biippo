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
        tireRotation.addPicture(1, R.drawable.tirerotation2);
        SubCategory tireChange = new SubCategory("Tire Change", 12);
        tireChange.addText(0, "Step 1: Place a heavy object (e.g., rock, concrete, spare wheel, etc.) in front of the front and back tires. ");
        tireChange.addPicture(0, R.drawable.changetire1);
        tireChange.addText(1, "Step 2: Take out the spare tire and the jack. Place the jack under the frame near the tire that you are going to change. Ensure that the jack is in contact with the metal portion of your car's frame.Many cars have molded plastic along the bottom. If you don't place the jack in the right spot, it will crack the plastic when you start lifting. If you're not sure about the right place to put the jack, read your owner's manual.     For most modern uni-body cars, there is a small notch or mark just behind the front wheel wells, or in front of the rear wheel wells where the jack is intended to be placed.     For most trucks or older cars that have a frame, look to place the jack on one of the beams of the frame just behind the front tire or in front of the rear tire.");
        tireChange.addPicture(1, R.drawable.changetire2);
        tireChange.addText(2, "Step 3: Raise the jack until it is supporting (but not lifting) the car. The jack should be firmly in place against the underside of the vehicle. Check to make sure that the jack is perpendicular to the ground.");
        tireChange.addPicture(2, R.drawable.changetire3);
        tireChange.addText(3, "Step 4: Remove the hub cap and loosen the nuts by turning counterclockwise. Don't take them all the way off; just break the resistance. By keeping the wheel on the ground when you first loosen the nuts, you'll make that you're turning the nuts instead of the wheel. Use the wrench that came with your car or a standard cross wrench. It can take quite a lot of force to break your lug nuts free.");
        tireChange.addPicture(3, R.drawable.changetire4);
        tireChange.addText(4, "Step 5: Pump or crank the jack to lift the tire off the ground. You need to lift it high enough to remove the flat tire and replace it with a spare. As you lift, make sure that the car is stable. If you notice any instability, lower the jack and fix the problem before fully lifting the car.    ");
        tireChange.addPicture(4, R.drawable.changetire5);
        tireChange.addText(5, "Step 6: Remove the nuts the rest of the way. Turn them counterclockwise until they are loose. Repeat with all lug nuts, then remove the nuts completely.");
        tireChange.addPicture(5, R.drawable.changetire6);
        tireChange.addText(6, "Step 7: Remove the tire. Place the flat tire under the vehicle so in the event of a jack failure the vehicle will fall on the old wheel, hopefully preventing injury. If the jack is placed on a flat, solid base, you shouldn't have any problems. The tire might be stuck due to rust. You could try hitting the inside half of the tire with a rubber mallet to loosen the tire, or use the spare tire to hit the outside half.");
        tireChange.addPicture(6, R.drawable.changetire7);
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
