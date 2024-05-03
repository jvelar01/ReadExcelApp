package com.example.excelleernocsv;

import android.os.Bundle;
import android.util.Pair;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        List<Pair<String, String>> dataList = ExcelReader.readExcel("direccionarchivo");

        // Aquí puedes utilizar la lista de tuplas como desees
        for (Pair<String, String> pair : dataList) {
            String name = pair.first;
            String content = pair.second;
            // Haz lo que necesites con name y content
        }
    }
}