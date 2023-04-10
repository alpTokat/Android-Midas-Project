package com.nexis.midasproject.ui.fragment


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.nexis.midasproject.R
import com.nexis.midasproject.data.Hisseler
import com.nexis.midasproject.databinding.FragmentAnasayfaBinding
import com.nexis.midasproject.ui.adapter.HisselerAdapter


class AnasayfaFragment : Fragment(){


    private lateinit var binding:FragmentAnasayfaBinding
    @SuppressLint("SetTextI18n")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_anasayfa,container, false)


        binding.rv.layoutManager = StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL)

        val hisselerListe = ArrayList<Hisseler>()

        val h1 = Hisseler(1,
            "goknurgida_logo",
            "GOKNR",
            "Göknür Gıda Maddeleri Enerji İmalat İthalat İhracat",
            1.66,
            17.80
        )
        val h2 = Hisseler(2,
            "astor_logo",
            "ASTOR",
            "Astor Enerji",
            -3.48,
            56.70
        )
        val h3 = Hisseler(3,
            "tupras_logo",
            "TUPRS",
            "Türkiye Petrol Rafinerileri",
            -1.09,
            76.75
        )
        val h4 = Hisseler(
            4,
            "akbank_logo",
            "AKBNK",
            "Akbank",
            1.09,
            16.83
        )


        hisselerListe.add(h1)
        hisselerListe.add(h2)
        hisselerListe.add(h3)
        hisselerListe.add(h4)

        val adapter = HisselerAdapter(requireContext(),hisselerListe)
        binding.rv.adapter = adapter
        binding.textView5.text = "${adapter.itemCount} Hisse" // font büyük ve biraz aşşağı margin ver yanınada hisse yaz


        return binding.root
    }

}