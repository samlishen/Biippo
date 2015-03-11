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

        categoryList = new ArrayList<Category>();
        //Tire
        Category tire = new Category("Tire");
        tire.setIcon(R.drawable.button_tire);
        //Tire Pressure
        SubCategory tirePressure = new SubCategory("Check Tire Pressure", 2);
        tirePressure.setIcon(R.drawable.button_tire_pressure);
        tirePressure.addText(0, "Step 1: Find the operating tire pressure on the sticker that located on the side of your driver's door");
        tirePressure.addPicture(0, 0);
        tirePressure.addText(1, "Step 2: Use a tire gauge that can be purchased at local department store and auto part store to check tires' pressure. Place your tire gauge onto the tire's valve stem and read the output. You should always check the pressure when the tire is cold, which means the car has not been driven within 3 hours or a mile.");
        tirePressure.addPicture(1, R.drawable.tirepressure2);
        tirePressure.setVideo("https://www.youtube.com/watch?v=QTst6ZdlVtg");
        //Tire Rotation
        SubCategory tireRotation = new SubCategory("Tire Rotation", 2);
        tireRotation.setIcon(R.drawable.button_tire_rotation);
        tireRotation.addText(0, "Four Wheel Rotation: 4-Wheel Drive Vehicles equipped with permanent 4-Wheel Drive and those with \"on Command\" 4-Wheel Drive and driven mainly in 4-Wheel mode, are best suited to a four tire cross rotation. With this pattern, tires from both axles are crossed and installed on the opposing axle. ");
        tireRotation.addText(1, "Straight Rotation: Straight Rotation was developed in the early years of radial tires. This rotation method simply replaces the front to rear and rear to front and is used for directional tread patterns.");
        tireRotation.addPicture(1, R.drawable.tirerotation2);
        tireRotation.setVideo("https://www.youtube.com/watch?v=Elr8aki-TlQ");
        //Change Tire
        SubCategory tireChange = new SubCategory("Tire Change", 12);
        tireChange.setIcon(R.drawable.button_tire_change);
        tireChange.addText(0, "Step 1: Place a heavy object (e.g., rock, concrete, spare wheel, etc.) in front of the front and back tires. ");
        tireChange.addPicture(0, R.drawable.changetire1);
        tireChange.addText(1, "Step 2: Take out the spare tire and the jack. Place the jack under the frame near the tire that you are going to change. Ensure that the jack is in contact with the metal portion of your car's frame.Many cars have molded plastic along the bottom. If you don't place the jack in the right spot, it will crack the plastic when you start lifting. If you're not sure about the right place to put the jack, read your owner's manual.     For most modern uni-body cars, there is a small notch or mark just behind the front wheel wells, or in front of the rear wheel wells where the jack is intended to be placed.     For most trucks or older cars that have a frame, look to place the jack on one of the beams of the frame just behind the front tire or in front of the rear tire.");
        tireChange.addPicture(1, R.drawable.changetire2);
        tireChange.addText(2, "Step 3: Raise the jack until it is supporting (but not lifting) the car. The jack should be firmly in place against the underside of the vehicle. Check to make sure that the jack is perpendicular to the ground.");
        tireChange.addPicture(2, R.drawable.changetire3);
        tireChange.addText(3, "Step 4: Remove the hub cap and loosen the nuts by turning counterclockwise. Don't take them all the way off; just break the resistance. By keeping the wheel on the ground when you first loosen the nuts, you'll make that you're turning the nuts instead of the wheel. Use the wrench that came with your car or a standard cross wrench. It can take quite a lot of force to break your lug nuts free.");
        tireChange.addPicture(3, R.drawable.changetire4);
        tireChange.addText(4, "Step 5: Pump or crank the jack to lift the tire off the ground. You need to lift it high enough to remove the flat tire and replace it with a spare. As you lift, make sure that the car is stable. If you notice any instability, lower the jack and fix the problem before fully lifting the car.");
        tireChange.addPicture(4, R.drawable.changetire5);
        tireChange.addText(5, "Step 6: Remove the nuts the rest of the way. Turn them counterclockwise until they are loose. Repeat with all lug nuts, then remove the nuts completely.");
        tireChange.addPicture(5, R.drawable.changetire6);
        tireChange.addText(6, "Step 7: Remove the tire. Place the flat tire under the vehicle so in the event of a jack failure the vehicle will fall on the old wheel, hopefully preventing injury. If the jack is placed on a flat, solid base, you shouldn't have any problems. The tire might be stuck due to rust. You could try hitting the inside half of the tire with a rubber mallet to loosen the tire, or use the spare tire to hit the outside half.");
        tireChange.addPicture(6, R.drawable.changetire7);
        tireChange.addText(7, "Step 8: Place the spare tire on the hub. Take care to align the rim of the spare tire with the wheel bolts, then pu on the lug nuts");
        tireChange.addPicture(7, R.drawable.changetire8);
        tireChange.addText(8, "Step 9: Tighten the nuts by hand until they are all snug. They should turn easily at first. Avoid using so much force that you risk upsetting the jack. You will tighten the lug nuts again once the car is down and there is no risk of it falling.");
        tireChange.addPicture(8, R.drawable.changetire9);
        tireChange.addText(9, "Step 10: Lower the car without applying full weight on the tire. Tighten the nuts as much as possible.");
        tireChange.addPicture(9, R.drawable.changetire10);
        tireChange.addText(10, "Step 11: Lower the car to the ground fully and remove the jack. Finish tightening the nuts and replace the hubcap.");
        tireChange.addPicture(10, R.drawable.changetire11);
        tireChange.addText(11, "Step 12: Put the old tire in your trunk and take it to a mechanic. Get an estimate for the cost of repair. Small punctures can usually be repaired for less than $15. If the tire is not repairable, tehy can dipose of it properly and sell you a replacement.");
        tireChange.addPicture(11, R.drawable.changetire12);
        tireChange.setVideo("https://www.youtube.com/watch?v=joBmbh0AGSQ");
        tire.addItem(tirePressure);
        tire.addItem(tireChange);
        tire.addItem(tireRotation);
        categoryList.add(tire);

        //Oil
        Category oil = new Category("Oil");
        oil.setIcon(R.drawable.button_oil);

        SubCategory oilChange=new SubCategory("Oil Change",8);

        oilChange.addPicture(0,R.drawable.oil1);
        oilChange.addText(0,"Step 1: Drive your 8th generation Civic onto ramps, or use a car-jack to lift your vehicle a few feet off of the ground ");

        oilChange.addPicture(0,R.drawable.oil2);
        oilChange.addText(1,"Step 2: Open your hood and remove the oil cap\n");

        oilChange.addPicture(0,R.drawable.oil3);
        oilChange.addText(2,"Step 3: Locate the drain plug underneath your vehicle. It looks like a bolt and should be labeled");

        oilChange.addPicture(0,R.drawable.oil4);
        oilChange.addText(3,"Step 4: Place a drain-pan underneath the plug, and remove the bolt with a 17mm wrench.\n");

        oilChange.addPicture(0,R.drawable.oil5);
        oilChange.addText(4,"Step 5: Wait for the oil to finish draining into the pan.");

        oilChange.addPicture(0,0);
        oilChange.addText(5,"Using the 17mm wrench, tighten the drain-bolt back on");

        oilChange.addPicture(0,R.drawable.oil6);
        oilChange.addText(6,"Step 6: With 4 quarts of 5W-20 synthetic oil, pour the oil into the hole where you first removed the oil cap\n");

        oilChange.addPicture(0,R.drawable.oil7);
        oilChange.addText(7,"Step 7: Screw the oil cap back on. Your car now has new oil!\n");

        oil.addItem(oilChange);
        categoryList.add(oil);

        //Emergency
        Category emergency = new Category("Emergency");
        emergency.setIcon(R.drawable.button_emer);
        SubCategory jumpStart = new SubCategory("Jump Start", 8);
        jumpStart.addText(0, "Step 1: Move both cars next to each other and turn off both cars.");
        jumpStart.addPicture(0, R.drawable.jump1);
        jumpStart.addText(1, "Step 2: Have your booster cables ready.");
        jumpStart.addPicture(1, R.drawable.jump2);
        jumpStart.addText(2, "Step 3: Connect red positive cable to dead car’s red positive terminal.");
        jumpStart.addPicture(2, R.drawable.jump3);









        SubCategory fluid=new SubCategory("Fluid Change", 6);

        fluid.addPicture(0,R.drawable.leak1);
        fluid.addText(0,"Step 1: Antifreeze Leak Antifreeze is one of the most common leaks on cars. It's not a serious leak to have,\n" +
                "but you should get it fixed as soon as possible. Coolant (or antifreeze) usually has a greenish color.\n" +
                "Sometimes it's bright orange or pink. But, usually it's green. It has a bit of a sticky, viscous feel to it.\n");

        fluid.addPicture(1,R.drawable.leak2);
        fluid.addText(1,"2.Gasoline Leak \n If you have a puddle of gas near the rear of the car, it probably means you have a leaky\n" +
                "gas tank. If the puddle is near the front, something is probably wrong with the fuel pump. Also, check the\n" +
                "fuel lines for the source of the leak.\n");

        fluid.addPicture(2,R.drawable.leak3);
        fluid.addText(2,"Step 3: Oil Leak  Another common fluid to drip from your car is good ol' engine oil. If your car leaks oil in\n" +
                "drips while your car is parked and leaves a puddle on your garage's floor, take it into a mechanic and\n" +
                "get it fixed ASAP. An oil leak can adversely affect oil levels in your car, and if left left unchecked,\n" +
                "can cause engine damage. New oil has a yellowish brown color, while older oil looks dark brown or black.\n");

        fluid.addPicture(3,R.drawable.leak4);
        fluid.addText(3,"Step 4: Brake Fluid \n Brake fluid is clear to yellowish in color and has a medium thickness and a slightly oily\n" +
                "feel. If you see a puddle of liquid with these properties under your car, have your car towed to a mechanic\n" +
                "immediately. Get your car towed even if you just suspect you're leaking brake fluid.\n");

        fluid.addPicture(4,R.drawable.leak5);
        fluid.addText(4,"Step 5: Automatic Transmission Fluid \n Automatic transmission fluid has sort of a light red color when it is new\n" +
                "and a dark red or brownish color when it is old. It's thick and has an almost oil-like feel. Transmission\n" +
                "fluid serves as a lubricant in your car's transmission so that your car shifts gears smoothly and correctly.\n" +
                "The fluid also serves as a coolant in the transmission. If your car gets low on transmission fluid, you run\n" +
                "the risk of grinding or burning your transmission to destruction.\n");

        fluid.addPicture(5,R.drawable.leak6);
        fluid.addText(5,"Step 6: Windshield Wiper Solvent \n Windshield wiper fluid is usually blue, but sometimes green or orange. It's\n" +
                "really thin and feels almost like water. Check the windshield wiper fluid reservoir and the tubes that\n" +
                "carry fluid for any leaks. This isn't a serious leak.");


        emergency.addItem(fluid);
        categoryList.add(emergency);




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
