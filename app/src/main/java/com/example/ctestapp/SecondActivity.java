package com.example.ctestapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ctestapp.databinding.ActivityMainBinding;
import com.example.ctestapp.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {

    // Used to load the 'ctestapp' library on application startup.
    static {
        System.loadLibrary("ctestapp");
    }


    public native String stringFromJNI();
    public native double calculateSumOfSquares(double a, double b);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivitySecondBinding binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Example of a call to a native method
        TextView tv = findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());

        EditText editText = findViewById(R.id.editText); // replaces the need for: findViewById(R.id.editText); because of private binding earlier
        EditText editText2 = findViewById(R.id.editText2);
        TextView textViewResult = findViewById(R.id.textViewResult);

        Button buttonCalculate = findViewById(R.id.buttonCalculate);
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double num1, num2;
                try {
                    num1 = Double.parseDouble(editText.getText().toString());
                    num2 = Double.parseDouble(editText2.getText().toString());
                } catch (NumberFormatException e) {
                    textViewResult.setText(R.string.invalid_input);
                    return;
                }


                double result = calculateSumOfSquares(num1, num2);
                textViewResult.setText(String.valueOf(result));
            }
        });
    }

}
