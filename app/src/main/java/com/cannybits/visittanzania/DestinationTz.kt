package com.cannybits.visittanzania

class DestinationTz {
    var name: String? = null
    var description: String? = null
    var image: Int? = null
    var isNationalPark: Boolean? = null

    constructor(nm: String, desc: String, img: Int, isNationalPark: Boolean){
        this.name = nm
        this.description = desc
        this.image = img
        this.isNationalPark = isNationalPark
    }
}
