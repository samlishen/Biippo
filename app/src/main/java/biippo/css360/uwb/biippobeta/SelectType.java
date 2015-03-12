package biippo.css360.uwb.biippobeta;

import android.app.ActionBar;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import Source.SubCategory;


public class SelectType extends ActionBarActivity implements View.OnClickListener{

    private ImageButton instruction, video;
    private SubCategory toBeDisplayed;
    private ImageButton home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_type);
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
                startActivity(new Intent(SelectType.this, SelectCategory.class));
            }
        });

        instruction = (ImageButton)findViewById(R.id.SelectType_button_instruction);
        video = (ImageButton)findViewById(R.id.SelectType_button_video);
        if(toBeDisplayed.getVideo().equals("") || toBeDisplayed.getVideo() == null) video.setVisibility(View.GONE);
        instruction.setOnClickListener(this);
        video.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.SelectType_button_instruction:
                Intent intent = new Intent(SelectType.this, Instruction.class);
                Bundle bundle = new Bundle();
                bundle.putParcelable("toBeDisplayed", toBeDisplayed);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.SelectType_button_video:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(toBeDisplayed.getVideo())));
                Log.i("Video", "Video Playing....");
                break;
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
