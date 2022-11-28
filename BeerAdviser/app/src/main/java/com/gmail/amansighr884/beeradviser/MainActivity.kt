package com.gmail.amansighr884.beeradviser

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    var beerType:String = ""
    var expert:BeerExpert = BeerExpert()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val color = findViewById<Spinner>(R.id.color);
        color.onItemSelectedListener = this
    }

    fun onClickFindBeer(view: View) {
        val brands = findViewById<TextView>(R.id.brands)

        //Get recommendations from the BeerExpert class
        val brandsList: List<String> = expert.getBrands(beerType)
        val brandsFormated:StringBuilder = StringBuilder();
        for(brand in brandsList){
            brandsFormated.append(brand).append('\n')
        }
        brands.setText(brandsFormated)
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        beerType = parent?.getItemAtPosition(position).toString()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}