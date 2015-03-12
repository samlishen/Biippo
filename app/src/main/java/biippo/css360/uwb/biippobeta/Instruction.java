package biippo.css360.uwb.biippobeta;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import Source.SubCategory;


public class Instruction extends ActionBarActivity {

    private SubCategory toBeDisplayed;
    private TextView text1, text2, text3, text4, text5, text6, text7, text8, text9, text10, text11, text12;
    private ImageView image1, image2, image3, image4, image5, image6, image7, image8, image9, image10, image11, image12;
    private ImageButton home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction);
        toBeDisplayed = getIntent().getExtras().getParcelable("toBeDisplayed");

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.actionbar_layout);
        TextView actionbar_title = (TextView)findViewById(R.id.action_bar_title);
        actionbar_title.setText(toBeDisplayed.getSearchableName());
        actionBar.setDisplayHomeAsUpEnabled(true);
        home = (ImageButton)findViewById(R.id.bippo);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Instruction.this, SelectCategory.class));
            }
        });

        text1 = (TextView)findViewById(R.id.Instruction_textView_text1);
        text2 = (TextView)findViewById(R.id.Instruction_textView_text2);
        text3 = (TextView)findViewById(R.id.Instruction_textView_text3);
        text4 = (TextView)findViewById(R.id.Instruction_textView_text4);
        text5 = (TextView)findViewById(R.id.Instruction_textView_text5);
        text6 = (TextView)findViewById(R.id.Instruction_textView_text6);
        text7 = (TextView)findViewById(R.id.Instruction_textView_text7);
        text8 = (TextView)findViewById(R.id.Instruction_textView_text8);
        text9 = (TextView)findViewById(R.id.Instruction_textView_text9);
        text10 = (TextView)findViewById(R.id.Instruction_textView_text10);
        text11 = (TextView)findViewById(R.id.Instruction_textView_text11);
        text12 = (TextView)findViewById(R.id.Instruction_textView_text12);
        image1 = (ImageView)findViewById(R.id.Instruction_imageView_picture1);
        image2 = (ImageView)findViewById(R.id.Instruction_imageView_picture2);
        image3 = (ImageView)findViewById(R.id.Instruction_imageView_picture3);
        image4 = (ImageView)findViewById(R.id.Instruction_imageView_picture4);
        image5 = (ImageView)findViewById(R.id.Instruction_imageView_picture5);
        image6 = (ImageView)findViewById(R.id.Instruction_imageView_picture6);
        image7 = (ImageView)findViewById(R.id.Instruction_imageView_picture7);
        image8 = (ImageView)findViewById(R.id.Instruction_imageView_picture8);
        image9 = (ImageView)findViewById(R.id.Instruction_imageView_picture9);
        image10 = (ImageView)findViewById(R.id.Instruction_imageView_picture10);
        image11 = (ImageView)findViewById(R.id.Instruction_imageView_picture11);
        image12 = (ImageView)findViewById(R.id.Instruction_imageView_picture12);
        TextView[] text = {text1, text2, text3, text4, text5, text6, text7, text8, text9, text10, text11, text12};
        ImageView[] image = {image1, image2, image3, image4, image5, image6, image7, image8, image9, image10, image11, image12};
        setTitle(toBeDisplayed.getSearchableName());
        for (int i = 0; i < 12; i++){
            if (i < toBeDisplayed.getSteps()){
                if (toBeDisplayed.getText(i) != null && !toBeDisplayed.getText(i).equals("")) text[i].setText(toBeDisplayed.getText(i));
                else text[i].setVisibility(View.GONE);
                if (toBeDisplayed.getPicture(i) != 0) image[i].setImageResource(toBeDisplayed.getPicture(i));
                else image[i].setVisibility(View.GONE);
            } else {
                text[i].setVisibility(View.GONE);
                image[i].setVisibility(View.GONE);
            }
        }
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
