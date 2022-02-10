package com.example.cicekbahcesi

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.cicek_karti.view.*

class MainActivity : AppCompatActivity() {

    var constList = ArrayList<Cicekler>()
    var adapter : CiceklerAdapter ?= null //bilgi aktarimi yapmak icin adapter olusturuldu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //yukarida olusturulan dizi icine cicekler eklendi
        constList.add(Cicekler("Gül","Açıklama",R.drawable.gul))
        constList.add(Cicekler("Kasımpatı","Açıklama",R.drawable.kasimpati))
        constList.add(Cicekler("Lale","Açıklama",R.drawable.lale))
        constList.add(Cicekler("Menekse","Açıklama",R.drawable.menekse))
        constList.add(Cicekler("Nergiz","Açıklama",R.drawable.nergiz))
        constList.add(Cicekler("Orkide","Açıklama",R.drawable.orkide))
        constList.add(Cicekler("Ortanca","Açıklama",R.drawable.ortanca))
        constList.add(Cicekler("Papatya","Açıklama",R.drawable.papatya))

        adapter = CiceklerAdapter(this,constList)
        listView.adapter = adapter

    }

    class CiceklerAdapter: BaseAdapter{

        var constList = ArrayList<Cicekler>()
        var context : Context ?= null

        constructor(context : Context, constList : ArrayList<Cicekler>):super(){

            this.constList = constList
            this.context = context
        }

        override fun getCount(): Int {
           return constList.size
        }

        //ConstListin posizyonunu(konumunu) verir
        override fun getItem(position: Int): Any {
            return constList[position]
        }

        //Dosyalarin idlerinin posizyonunu(konumunu)veriri
        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

            var posCicekler : Cicekler  = constList[position]

            //cicek_karti.xml sayafasina erisim saglama islemleri
            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var cicekKarti = inflator.inflate(R.layout.cicek_karti,null)

            //cicekler_karti.xml de olusturulan textview ve imagelere gerekli bilgileri ekleme islemleri
            cicekKarti.kartAdi.text = posCicekler.constAdi
            cicekKarti.kartAciklama.text = posCicekler.constAciklama
            cicekKarti.kartResim.setImageResource(posCicekler.constResim!!)

            // Listview deki imagelere tiklayinca yapilmasi gerekenler
            cicekKarti.kartResim.setOnClickListener {

                var intent = Intent(context,CiceklerDetay::class.java)
                //activitiler arasi bilgi aktarimi
                intent.putExtra("constAdi",posCicekler.constAdi)
                intent.putExtra("constAciklama",posCicekler.constAciklama)
                intent.putExtra("constResim",posCicekler.constResim!!)
                context!!.startActivity(intent)
            }
            return cicekKarti

        }

    }
}