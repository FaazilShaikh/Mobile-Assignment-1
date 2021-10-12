package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Calculate EMI"); //set title

        Button CalculateButton= (Button)findViewById(R.id.calculate);

        EditText MortgageAmount = findViewById(R.id.mortgage);
        EditText IntRate =  findViewById(R.id.rate);
        EditText TenureAmount = findViewById(R.id.tenure);

        //on click event
        CalculateButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Results.class); //create intent for the results
                //get the input in string
                String mortgage_string = MortgageAmount.getText().toString();
                String interest_string = IntRate.getText().toString();
                String tenure_string = TenureAmount.getText().toString();
                //check for invalid input
                if (mortgage_string.matches("") || interest_string.matches("") || tenure_string.matches("") ){
                    Toast.makeText(getApplicationContext(), "Please enter values in all fields", Toast.LENGTH_SHORT).show();
                    return;
                }
                //put input data in the intent to pass it over to the next activity
                i.putExtra("Mortgage",mortgage_string);
                i.putExtra("Interest",interest_string);
                i.putExtra("Tenure",tenure_string);
                startActivity(i);

            }
        });

    }
}