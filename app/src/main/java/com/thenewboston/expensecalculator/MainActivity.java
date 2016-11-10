package com.thenewboston.expensecalculator;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

    EditText food;
    EditText shopping;
    EditText fuel;
    EditText telephone;
    TextView previousExpense;
    Button calculate;
    SharedPreferences sharedPreferences;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

          food = (EditText) findViewById(R.id.etFood);
          shopping = (EditText) findViewById(R.id.etShopping);
          fuel = (EditText) findViewById(R.id.etFuel);
          telephone = (EditText) findViewById(R.id.etTelephone);

          previousExpense = (TextView) findViewById(R.id.prevExpense);

          calculate = (Button) findViewById(R.id.btnCalculate);

         sharedPreferences = getSharedPreferences("EXPENCES", Context.MODE_PRIVATE);
          previousExpense.setText(String.valueOf(sharedPreferences.getInt("EXP", 0)));

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int expense = Integer.valueOf(fuel.getText().toString()) + Integer.valueOf(shopping.getText().toString())
                        + Integer.valueOf(fuel.getText().toString()) + Integer.valueOf(telephone.getText().toString());

                Toast.makeText(MainActivity.this, "your total expense is: " + String.valueOf(expense),Toast.LENGTH_LONG).show();

                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putInt("EXP",expense);
                edit.apply();

                previousExpense.setText("your Previous expense was: " + String.valueOf(expense));

            }
        });
        }

    }