package com.gmail.amansighr884.beeradviser

class BeerExpert {
    fun getBrands(color:String):List<String>{
        val brands = mutableListOf<String>()
        if(color.equals("amber")){
            brands.add("Jack Amber")
            brands.add("Red Moose")
        }else{
            brands.add("Jail Pale Ale");
            brands.add("Gout Stout");
        }
        return brands
    }
}