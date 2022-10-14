package skycloud.stu.seg2105b2022w.sportcenterprofilemgr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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

}