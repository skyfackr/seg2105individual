package skycloud.stu.seg2105b2022w.simplecalculator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


public class CalculatorLayout extends Fragment {
    private CalculatorLogic logic;

    public CalculatorLayout() {
        logic = new CalculatorLogic(this);
    }

    //private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        //binding = FragmentFirstBinding.inflate(inflater, container, false);
        //return binding.getRoot();
        return inflater.inflate(R.layout.calculator_main, container, false);

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    public void onNumberPadClick(View view) {
        int id = view.getId();
        switch (id)
        {
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
                //.
                break;
            case R.id.btn44:
                logic.onOperationClick("*");
                break;
            case R.id.btn5:
                logic.onEqualClick();
                break;
        }
    }
    public void updateDisplay(String text)
    {
        TextView display = (TextView) getView().findViewById(R.id.displayer);
        display.setText(text);
    }

}