package com.geeks.project_6;

import android.os.Bundle;
import android.widget.RatingBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.geeks.project_6.databinding.ActivityMainBinding;
import com.geeks.project_6.databinding.ActivityMenuBinding;

import java.util.ArrayList;
import java.util.List;

public class Menu extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ctAdapter ctAdapter;
    private typeAdapter typeAdapter;

    private ActivityMenuBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<ctItemGray> item = new ArrayList<>();
        item.add(new ctItemGray(R.drawable.ct_bg_gray, R.drawable.ct_burger_gray, "Burger"));
        item.add(new ctItemGray(R.drawable.ct_bg_gray, R.drawable.ct_pizza_gray, "Pizza"));
        item.add(new ctItemGray(R.drawable.ct_bg_gray, R.drawable.ct_salad_gray, "Salad"));
        item.add(new ctItemGray(R.drawable.ct_bg_gray, R.drawable.ct_drink_gray, "Drink"));

        recyclerView = findViewById(R.id.ct_rv);
        ctAdapter = new ctAdapter(item);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(ctAdapter);

        ArrayList<typeItemGray> item1 = new ArrayList<>();
        item1.add(new typeItemGray(R.drawable.type_mix, "XL Combo", 5.0f, "25$"));
        item1.add(new typeItemGray(R.drawable.type_cheeseburger, "Cheeseburger", 4.5f, "12$"));
        item1.add(new typeItemGray(R.drawable.type_pizza, "Mexican Pizza", 4.7f, "17$"));
        item1.add(new typeItemGray(R.drawable.type_salad, "Salad", 4.0f, "6$"));
        item1.add(new typeItemGray(R.drawable.type_cocacola, "Coca-Cola", 4.4f, "2$"));

        recyclerView = findViewById(R.id.type_rv);
        typeAdapter = new typeAdapter(item1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(typeAdapter);
    }
}