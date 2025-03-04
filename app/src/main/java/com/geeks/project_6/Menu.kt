package com.geeks.project_6;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.SearchView;

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
    private SearchView searchView;
    private RecyclerView ctRecyclerView;
    private RecyclerView typeRecyclerView;
    private ActivityMenuBinding binding;
    private ArrayList<typeItemGray> originalTypeItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        searchView = findViewById(R.id.searchView);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });

        ArrayList<ctItemGray> item = new ArrayList<>();
        item.add(new ctItemGray(R.drawable.ct_burger_gray, "Burger"));
        item.add(new ctItemGray(R.drawable.ct_pizza_gray, "Pizza"));
        item.add(new ctItemGray(R.drawable.ct_salad_gray, "Salad"));
        item.add(new ctItemGray(R.drawable.ct_drink_gray, "Drink"));

        ctRecyclerView = findViewById(R.id.ct_rv);
        ctAdapter = new ctAdapter(item);
        ctRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ctRecyclerView.setAdapter(ctAdapter);

        originalTypeItemList = new ArrayList<>();
        originalTypeItemList.add(new typeItemGray(R.drawable.type_mix, "XL Combo", 5.0f, "25$"));
        originalTypeItemList.add(new typeItemGray(R.drawable.type_cheeseburger, "Cheeseburger", 4.5f, "12$"));
        originalTypeItemList.add(new typeItemGray(R.drawable.type_pizza, "Mexican Pizza", 4.7f, "17$"));
        originalTypeItemList.add(new typeItemGray(R.drawable.type_pizza1, "Pepperoni Pizza", 4.5f, "14$"));
        originalTypeItemList.add(new typeItemGray(R.drawable.type_salad, "Salad", 4.0f, "6$"));
        originalTypeItemList.add(new typeItemGray(R.drawable.type_salad1, "Orange Salad", 4.2f, "5$"));
        originalTypeItemList.add(new typeItemGray(R.drawable.type_cocacola, "Coca-Cola", 4.4f, "2$"));
        originalTypeItemList.add(new typeItemGray(R.drawable.type_bubble_tea, "Bubble Tea", 3.0f, "4$"));

        typeRecyclerView = findViewById(R.id.type_rv);
        typeAdapter = new typeAdapter(originalTypeItemList);
        typeRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        typeRecyclerView.setAdapter(typeAdapter);
    }

    private void filterList(String text) {
        ArrayList<typeItemGray> filteredList = new ArrayList<>();
        int foundPosition = -1;

        for (int i = 0; i < originalTypeItemList.size(); i++) {
            typeItemGray item = originalTypeItemList.get(i);
            if (item.getTv_type_name().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
                if (foundPosition == -1) {
                    foundPosition = i;
                }
            }
        }

        typeAdapter.updateList(filteredList);

        if (!text.isEmpty() && foundPosition != -1) {
            typeAdapter.moveItemToTop(foundPosition);
            typeRecyclerView.scrollToPosition(0);
        }
    }

    public void onItemMovedTop() {
        typeRecyclerView.scrollToPosition(0);
    }
}