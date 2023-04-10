package com.nexis.midasproject.ui.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nexis.midasproject.data.Hisseler
import com.nexis.midasproject.databinding.CardTasarimBinding

class HisselerAdapter(var mContext:Context,var  hisselerListe:List<Hisseler>): RecyclerView.Adapter<HisselerAdapter.HolderClass>() {

    inner class HolderClass(var binding:CardTasarimBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderClass {
        var binding = CardTasarimBinding.inflate(LayoutInflater.from(mContext), parent,false)
        return HolderClass(binding)
    }

    override fun getItemCount(): Int {
        return hisselerListe.size
    }

    override fun onBindViewHolder(holder: HolderClass, position: Int) {
        var color:Int
        var gunlukDegisim:String
        var hisse = hisselerListe.get(position)
        var t = holder.binding
        t.imageView2.setImageResource(
            mContext.resources.getIdentifier(hisse.resimAdi,"drawable", mContext.packageName))
        t.textViewHisseKodu.text = hisse.hisseKodu
        t.textViewHisseIsmi.text = hisse.hisseIsmi
        if(hisse.gunlukDegisim > 0){
            gunlukDegisim = "+${hisse.gunlukDegisim.toString()}%"
            color = Color.rgb(0, 151, 1)
        }else{
            gunlukDegisim = "${hisse.gunlukDegisim.toString()}%"
            color = Color.rgb(255, 0, 1)
        }
        t.textViewGunlukDegisim.text =gunlukDegisim
        t.textViewGunlukDegisim.setTextColor(color)


        t.textViewHisseFiyat.text = "₺${hisse.hisseFiyat.toString()}"
    }
}