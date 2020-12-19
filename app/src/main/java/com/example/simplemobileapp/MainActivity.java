package com.example.simplemobileapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.simplemobileapp.addition.DatePickerDialogCustom;
import com.example.simplemobileapp.addition.ImageViewChange;
import com.example.simplemobileapp.addition.TextViewListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = findViewById(R.id.editText);
        TextView editTextView = findViewById(R.id.editTextView);
        TextView dateTextView = findViewById(R.id.dateTextView);

        setSinnerListener();

        dateTextView.setOnClickListener(v -> {
            DialogFragment datePicker = new DatePickerDialogCustom();
            datePicker.show(getSupportFragmentManager(), "date picker");
        });

        editText.addTextChangedListener(new TextViewListener(editTextView));
    }

    private void setSinnerListener() {
        ImageView imageView = findViewById(R.id.imageChoiceSpinner);
        Spinner spinner = findViewById(R.id.spinner);
        ImageViewChange changeImage = new ImageViewChange();

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent,
                                       View itemSelected, int selectedItemPosition, long selectedId) {

                String[] choose = getResources().getStringArray(R.array.spinnerList);
                changeImage.setImage(imageView, choose[selectedItemPosition]);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        int mYear = year;
        int mMonth = month;
        int mDay = dayOfMonth;
        String selectedDate = mDay + "." + (mMonth + 1) + "." + +mYear;

        TextView dateTextView = findViewById(R.id.dateTextView);
        dateTextView.setText(selectedDate);
    }

    public void clickSeeToast(View view) {

        EditText editText = findViewById(R.id.editText);

        if (editText.getText() != null) {
            String text = editText.getText().toString();
            if (!text.equals("")) {
                Toast toast = Toast.makeText(this, text, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP, 0, 0);
                toast.show();
            }
        }
    }
}