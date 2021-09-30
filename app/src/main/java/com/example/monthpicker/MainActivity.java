package com.example.monthpicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

public class MainActivity extends AppCompatActivity {
    Button btnYearMonthPicker;

    DatePickerDialog.OnDateSetListener d = (view, year, monthOfYear, dayOfMonth) ->
            Log.d("YearMonthPickerTest", "year = " + year + ", month = " + monthOfYear + ", day = " + dayOfMonth);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnYearMonthPicker = findViewById(R.id.btn_year_month_picker);

        btnYearMonthPicker.setOnClickListener(view -> {
            MyYearMonthPickerDialog pd = new MyYearMonthPickerDialog();
            pd.setListener(d);
            pd.show(getSupportFragmentManager(), "YearMonthPickerTest");
        });
    }
}
