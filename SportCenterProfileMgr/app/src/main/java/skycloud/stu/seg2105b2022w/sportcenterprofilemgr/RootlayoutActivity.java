package skycloud.stu.seg2105b2022w.sportcenterprofilemgr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class RootlayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rootlayout);
        findViewById(R.id.mapBtn).setOnClickListener(v -> {
            EditText address = (EditText) findViewById(R.id.teamZIPInput);
            Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + address.getText().toString());
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        });
        findViewById(R.id.avator).setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
            startActivity(intent);
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED) return;

//Getting the Avatar Image we show to our users
        ImageView avatarImage = (ImageView) findViewById(R.id.avator);

//Figuring out the correct image
        String drawableName = "ic_logo_00";

        int resID = getResources().getIdentifier(getResources().getResourceName(data.getIntExtra("imageID", R.id.pic11)), "drawable", getPackageName());
        avatarImage.setImageResource(resID);
    }


}