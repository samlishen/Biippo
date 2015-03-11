package biippo.css360.uwb.biippobeta;

import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import Source.SubCategory;


public class SelectType extends ActionBarActivity implements View.OnClickListener{

    ImageButton instruction, video;
    SubCategory toBeDisplayed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_type);
        toBeDisplayed = getIntent().getExtras().getParcelable("toBeDisplayed");
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
}
