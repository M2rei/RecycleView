package com.example.recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recycleview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapterDisaster = DisasterAdapter(generateDummy()){disaster ->
        Toast.makeText(this@MainActivity, "This name ${disaster.nameDisaster}",
            Toast.LENGTH_SHORT).show()
        }
        with(binding){
            rvDisaster.apply {
                adapter = adapterDisaster
                layoutManager = GridLayoutManager(this@MainActivity, 2)
            }
        }
    }
    fun generateDummy(): List<Disaster> {
        return listOf(
            Disaster(nameDisaster = "Tsunami", typeDisaster = "Natural"),
            Disaster(nameDisaster = "Volcanic Eruption", typeDisaster = "Natural"),
            Disaster(nameDisaster = "Earthquake", typeDisaster = "Natural"),
            Disaster(nameDisaster = "Flood", typeDisaster = "Natural"),
            Disaster(nameDisaster = "Fire", typeDisaster = "Natural"),
            Disaster(nameDisaster = "Nuclear Accident", typeDisaster = "Man-made"),
            Disaster(nameDisaster = "Terrorist Attack", typeDisaster = "Man-made"),
            Disaster(nameDisaster = "War", typeDisaster = "Man-made")
        )
    }

}