package com.nency.insertwithfirebase.model

class DataModel {

    lateinit var key:String
    lateinit var title:String
    lateinit var desc:String
    lateinit var price:String
    lateinit var extra:String

    constructor()

    constructor(key: String, title: String, desc: String, price: String, extra: String) {
        this.key = key
        this.title = title
        this.desc = desc
        this.price = price
        this.extra = extra
    }
}