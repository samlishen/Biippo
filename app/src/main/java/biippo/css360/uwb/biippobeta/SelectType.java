package biippo.css360.uwb.biippobeta;

import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import Source.SubCategory;


public class SelectType extends ActionBarActivity implements View.OnClickListener{

    Button instruction, video;
    SubCategory toBeDisplaied;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_type);
        toBeDisplaied = getIntent().getExtras().getParcelable("toBeDisplaied");
        instruction = (Button)findViewById(R.id.SelectType_button_instruction);
        video = (Button)findViewById(R.id.SelectType_button_video);
        if(toBeDisplaied.getVideo() == "") video.setVisibility(View.INVISIBLE);
        instruction.setOnClickListener(this);
        video.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.SelectType_button_instruction:
                Intent intent = new Intent(SelectType.this, Instruction.class);
                Bundle bundle = new Bundle();
                bundle.putParcelable("toBeDisplaied", toBeDisplaied);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.SelectType_button_video:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(toBeDisplaied.getVideo())));
                Log.i("Video", "Video Playing....");
                break;
        }
    }
}
