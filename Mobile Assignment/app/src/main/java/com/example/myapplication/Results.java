package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Results extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);

        getSupportActionBar().setTitle("Equated Monthly Installment (EMI)"); //set title

        Intent intent = getIntent();  //get intent contents, for this app it is the input of values for mortgage, interest, and tenure
        String mortgage_string = intent.getStringExtra("Mortgage");
        String interest_string = intent.getStringExtra("Interest");
        String tenure_string = intent.getStringExtra("Tenure");

        Double mortgage_value = Double.parseDouble(mortgage_string); //the data is sent in string so we have to convert to double
        Double interest_value = Double.parseDouble(interest_string);
        Double tenure_value = Double.parseDouble(tenure_string);
        interest_value = interest_value/12/100; //in the EMI formula we need monthly rate of interest and also divide by 100 to get the percentage value
        Double calculated_emi = mortgage_value*interest_value*(Math.pow(1+interest_value,tenure_value)/(Math.pow(1+interest_value,tenure_value)-1));
        calculated_emi = Math.round(calculated_emi * 100.0) / 100.0; //round to two decimal places
        TextView result = (TextView) findViewById(R.id.result);
        result.setText("EMI: $" + calculated_emi.toString()); //set result view to the calculated EMI
        Button Return_button = (Button)findViewById(R.id.return_button);

        //on click event
        Return_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i); //return to the main activity on click of the return button
            }
        });
    }

}