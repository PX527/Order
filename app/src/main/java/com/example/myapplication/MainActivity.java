package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int qtt=1;
    int basePrice=5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMinus=findViewById(R.id.minus);
        Button btnPlus=findViewById(R.id.plus);
        final TextView qtty=findViewById(R.id.qty);
        final CheckBox cbCream=findViewById(R.id.cream);
        final CheckBox cbChocChip=findViewById(R.id.chocChip);
        final CheckBox cbVanilla=findViewById(R.id.vanilla);
        Button btnOrder=findViewById(R.id.order);
        final TextView tvtq=findViewById(R.id.tq);

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Do stuff
                if (qtt > 1) {
                    qtt--;
                    qtty.setText(Integer.toString(qtt));
                }
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Do stuff
                qtt++;
                qtty.setText(Integer.toString(qtt));
            }
        });

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int finalPrice=basePrice;
                if(cbCream.isChecked()){
                    finalPrice+=1;

                }

                if(cbChocChip.isChecked()){
                    finalPrice+=2;

                }

                if(cbVanilla.isChecked()){
                    finalPrice+=3;

                }

                finalPrice*=qtt;

                Log.d("Final Price",Integer.toString(finalPrice));

                tvtq.setText("Thank you for your order. \nThe Total price is $"+Integer.toString(finalPrice));
            }
        });
    }
}
