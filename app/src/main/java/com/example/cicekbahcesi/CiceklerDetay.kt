package com.example.cicekbahcesi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import kotlinx.android.synthetic.main.activity_cicekler_detay.*

class CiceklerDetay : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cicekler_detay)

        //MainActivityden gelen verileri alma islemleri
        var bundle : Bundle? = intent.extras
        var adi : String ?= bundle?.getString("constAdi")
        var aciklama :String ?= bundle?.getString("constAciklama")
        var resim : Int = bundle!!.getInt("constResim")

        //MainActivityden alinan verileri CiceklerDetay sayfasinda bulunan textviewlere ve image ekleme islemleri
        detayAdi.text = adi
        detayAciklama.text = aciklama
        detayResim.setImageResource(resim)


    }
}