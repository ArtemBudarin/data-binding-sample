package ru.madbrains.databindingsample.data

import ru.madbrains.databindingsample.data.db.model.ProductLocal

object DataEntity {

    fun populateData(): List<ProductLocal> {
        return mutableListOf<ProductLocal>().apply {
            add(ProductLocal(1, "Печенька",  "Вкусная печенька", 10, 12, 2))
            add(ProductLocal(2, "Clean Code", "Even bad code can function. But if code isn’t clean, it can bring a development organization to its knees. Every year, countless hours and significant resources are lost because of poorly written code. But it doesn’t have to be that way.", 440, 2, 1))
            add(ProductLocal(3, "Телевизор", "", 29999, 0, 3))
            add(ProductLocal(4, "Кресло Red Square", "Кресло с широкой спинкой обеспечит максимальный комфорт пользователю практически любого роста, веса, комплекции.", 16700, 1, 0))
        }
    }
}