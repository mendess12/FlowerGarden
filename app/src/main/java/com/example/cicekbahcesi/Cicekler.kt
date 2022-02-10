package com.example.cicekbahcesi

class  Cicekler {

    /*
        Bir constructor siniftan uretilmis nesnelerin degiskenlerin baslangic degerlerini
       belirlemek icin kullanilan ozel bir metodtur.

        Her sinfin bir kurucu metoda (constructor) sahip olmasi gerekir.
        Sinifin icinde herhangi bir constructor belirtmez isek , derleyici bunu bizim
       için otomatik yapar

        Neden constructor metodu kullaniriz;
        Nesneye ilk deger  atamasi yapabilmek icin,
        Nesne kullanicisini, belli degerleri vermesi konusunda zorlamak icin,
        Nesne olusurken ekstra isleri kodlamak icin kullaniriz.

   */


    var constAdi : String ?= null
    var constAciklama : String ?= null
    var constResim : Int ?= null

    constructor(constAdi : String, constAciklama : String, constResim : Int){
        this.constAdi = constAdi
        this.constAciklama = constAciklama
        this.constResim = constResim
    }

}