package skycloud.stu.seg2105b2022w.simplecalculator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.Objects;


public class CalculatorLayout extends Fragment {


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
        ((TextView)(requireView().findViewById(R.id.displayer))).setText(getString(R.string.initialize_welcome));


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }



}