package com.geeks.project_6

import android.os.Bundle
import android.widget.SearchView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.geeks.project_6.databinding.ActivityMenuBinding
import java.util.Locale

class Menu : AppCompatActivity() {
    private val recyclerView: RecyclerView? = null
    private var ctAdapter: ctAdapter? = null
    private var typeAdapter: typeAdapter? = null
    private var searchView: SearchView? = null
    private var ctRecyclerView: RecyclerView? = null
    private var typeRecyclerView: RecyclerView? = null
    private var binding: ActivityMenuBinding? = null
    private var originalTypeItemList: ArrayList<typeItemGray>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.enableEdgeToEdge()
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        searchView = findViewById(R.id.searchView)
        searchView.clearFocus()
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(s: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filterList(newText)
                return true
            }
        })

        val item = ArrayList<ctItemGray>()
        item.add(ctItemGray(R.drawable.ct_burger_gray, "Burger"))
        item.add(ctItemGray(R.drawable.ct_pizza_gray, "Pizza"))
        item.add(ctItemGray(R.drawable.ct_salad_gray, "Salad"))
        item.add(ctItemGray(R.drawable.ct_drink_gray, "Drink"))

        ctRecyclerView = findViewById(R.id.ct_rv)
        ctAdapter = ctAdapter(item)
        ctRecyclerView.setLayoutManager(
            LinearLayoutManager(
                this,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        )
        ctRecyclerView.setAdapter(ctAdapter)

        originalTypeItemList = ArrayList()
        originalTypeItemList!!.add(typeItemGray(R.drawable.type_mix, "XL Combo", 5.0f, "25$"))
        originalTypeItemList!!.add(
            typeItemGray(
                R.drawable.type_cheeseburger,
                "Cheeseburger",
                4.5f,
                "12$"
            )
        )
        originalTypeItemList!!.add(
            typeItemGray(
                R.drawable.type_pizza,
                "Mexican Pizza",
                4.7f,
                "17$"
            )
        )
        originalTypeItemList!!.add(
            typeItemGray(
                R.drawable.type_pizza1,
                "Pepperoni Pizza",
                4.5f,
                "14$"
            )
        )
        originalTypeItemList!!.add(typeItemGray(R.drawable.type_salad, "Salad", 4.0f, "6$"))
        originalTypeItemList!!.add(typeItemGray(R.drawable.type_salad1, "Orange Salad", 4.2f, "5$"))
        originalTypeItemList!!.add(typeItemGray(R.drawable.type_cocacola, "Coca-Cola", 4.4f, "2$"))
        originalTypeItemList!!.add(
            typeItemGray(
                R.drawable.type_bubble_tea,
                "Bubble Tea",
                3.0f,
                "4$"
            )
        )

        typeRecyclerView = findViewById(R.id.type_rv)
        typeAdapter = typeAdapter(originalTypeItemList)
        typeRecyclerView.setLayoutManager(
            LinearLayoutManager(
                this,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        )
        typeRecyclerView.setAdapter(typeAdapter)
    }

    private fun filterList(text: String) {
        val filteredList = ArrayList<typeItemGray>()
        var foundPosition = -1

        for (i in originalTypeItemList!!.indices) {
            val item = originalTypeItemList!![i]
            if (item.tv_type_name.lowercase(Locale.getDefault())
                    .contains(text.lowercase(Locale.getDefault()))
            ) {
                filteredList.add(item)
                if (foundPosition == -1) {
                    foundPosition = i
                }
            }
        }

        typeAdapter!!.updateList(filteredList)

        if (!text.isEmpty() && foundPosition != -1) {
            typeAdapter!!.moveItemToTop(foundPosition)
            typeRecyclerView!!.scrollToPosition(0)
        }
    }

    fun onItemMovedTop() {
        typeRecyclerView!!.scrollToPosition(0)
    }
}