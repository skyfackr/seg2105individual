package skycloud.stu.seg2105b2022w.simplecalculator;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import skycloud.stu.seg2105b2022w.simplecalculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private CalculatorLogic logic;

    public MainActivity() {
        logic = new CalculatorLogic(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void onNumberPadClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btn11:
                logic.onNumberClick(1);
                break;
            case R.id.btn12:
                logic.onNumberClick(2);
                break;
            case R.id.btn13:
                logic.onNumberClick(3);
                break;
            case R.id.btn21:
                logic.onNumberClick(4);
                break;
            case R.id.btn22:
                logic.onNumberClick(5);
                break;
            case R.id.btn23:
                logic.onNumberClick(6);
                break;
            case R.id.btn31:
                logic.onNumberClick(7);
                break;
            case R.id.btn32:
                logic.onNumberClick(8);
                break;
            case R.id.btn33:
                logic.onNumberClick(9);
                break;
            case R.id.btn14:
                logic.onOperationClick("+");
                break;
            case R.id.btn24:
                logic.onOperationClick("-");
                break;
            case R.id.btn34:
                logic.onOperationClick("/");
                break;
            case R.id.btn41:
                logic.onClearClick();
                break;
            case R.id.btn42:
                logic.onNumberClick(0);
                break;
            case R.id.btn43:
                logic.onPointClick();
                break;
            case R.id.btn44:
                logic.onOperationClick("*");
                break;
            case R.id.btn5:
                logic.onEqualClick();
                break;
        }
    }

    public void updateDisplay(String text) {
        TextView display = findViewById(R.id.displayer);
        display.setText(text);
    }
}