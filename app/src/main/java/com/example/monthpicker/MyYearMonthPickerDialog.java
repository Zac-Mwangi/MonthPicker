package com.example.monthpicker;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class MyYearMonthPickerDialog extends DialogFragment {

    private static final int MAX_YEAR = 2100;
    private static final int MIN_YEAR = 2020;

    private DatePickerDialog.OnDateSetListener listener;
    public Calendar cal = Calendar.getInstance();

    public void setListener(DatePickerDialog.OnDateSetListener listener) {
        this.listener = listener;
    }

    Button btnConfirm;
    Button btnCancel;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View dialog = inflater.inflate(R.layout.activity_year_month_picker, null);

        btnConfirm = dialog.findViewById(R.id.btn_confirm);
        //btnCancel = dialog.findViewById(R.id.btn_cancel);

        final NumberPicker monthPicker = dialog.findViewById(R.id.picker_month);
        final NumberPicker yearPicker = dialog.findViewById(R.id.picker_year);

//        btnCancel.setOnClickListener(view ->
//                MyYearMonthPickerDialog.this.getDialog().cancel());

        btnConfirm.setOnClickListener(view -> {
            listener.onDateSet(null, yearPicker.getValue(), monthPicker.getValue(), 0);
            MyYearMonthPickerDialog.this.getDialog().cancel();
            String year = yearPicker.getValue()+"";
            String month = monthPicker.getValue()+"";
            Toast.makeText(getActivity(), month+" "+year, Toast.LENGTH_SHORT).show();
        });

        monthPicker.setMinValue(1);
        monthPicker.setMaxValue(12);
        monthPicker.setValue(cal.get(Calendar.MONTH) + 1);

        int year = cal.get(Calendar.YEAR);
        yearPicker.setMinValue(MIN_YEAR);
        yearPicker.setMaxValue(MAX_YEAR);
        yearPicker.setValue(year);

        builder.setView(dialog)
/*
        .setPositiveButton("confirm", (dialog1, id) ->
                listener.onDateSet(null, yearPicker.getValue(), monthPicker.getValue(), 0))
        .setNegativeButton("cancel", (dialog12, id) ->
                MyYearMonthPickerDialog.this.getDialog().cancel())
*/
        ;

        return builder.create();
    }
}
