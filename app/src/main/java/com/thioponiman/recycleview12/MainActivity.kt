package com.thioponiman.recycleview12

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.thioponiman.recycleview12.adapter.AdapterBuah
import com.thioponiman.recycleview12.databinding.ActivityMainBinding
import com.thioponiman.recycleview12.model.Buah

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listBuah = ArrayList<Buah>()
        listBuah.add(Buah("anggur",R.drawable.anggur,"10gram", "ungu atau hijau", "ungu atau hijau"))
        listBuah.add(Buah("jeruk",R.drawable.jeruk,"200gram", "orange", "orange"))
        listBuah.add(Buah("alpukat",R.drawable.alpukat,"200gram", "hijau", "ungu atau hijau"))
        listBuah.add(Buah("apel",R.drawable.apel,"300gram", "putih", "merah"))
        listBuah.add(Buah("mangga",R.drawable.mangga,"400gram", "orange", "hijau"))
        listBuah.add(Buah("melon",R.drawable.melon,"3kg", "hijau", "hijau"))
        listBuah.add(Buah("pisang",R.drawable.pisang,"200gram", "kuning", "kuning"))
        listBuah.add(Buah("salak",R.drawable.salak,"50gram", "putih", "coklat"))
        listBuah.add(Buah("semangka",R.drawable.semangka,"3kg", "merah", "hijau"))
        val add = listBuah.add(Buah("strawbery", R.drawable.strawbery, "10gram", "merah", "merah"))

        binding.list.adapter = AdapterBuah(this,listBuah,object : AdapterBuah.OnclickListener {
            override fun detailData(item: Buah?) {
                Dialog( this@MainActivity).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.detail_data_buah)

                    val image = this.findViewById<ImageView>(R.id.image_Buah)
                    val nama = this.findViewById<TextView>(R.id.txtnamabuah)

                    val berat = this.findViewById<TextView>(R.id.txtberat)
                    val warnadalam = this.findViewById<TextView>(R.id.txtwarnadalam)
                    val warnaluar = this.findViewById<TextView>(R.id.txtwarnaluar)
                    val btn = this.findViewById<Button>(R.id.btnClose)

                    image.setImageResource(item?.foto ?:0)
                    nama.text = "${item?.nama}"
                    nama.text = "${item?.berat}"
                    nama.text = "${item?.warnadalam}"
                    nama.text = "${item?.warnaluar}"

                    btn.setOnClickListener {
                        this.dismiss()
    }
}