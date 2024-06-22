package com.my.muhammadaliftajudin.application2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.my.muhammadaliftajudin.application2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    val requestCodeIntent = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.button.setOnClickListener {

            val intent = Intent()
            intent.action = "com.my.muhammadaliftajudin.application1.SecondActivity"
            intent.addCategory("android.intent.category.DEFAULT")

            try {
                startActivityForResult(intent, requestCodeIntent)
            }
            catch(e:Exception){
                Toast.makeText(this,"Permission not granted",Toast.LENGTH_LONG).show()
            }

        }
    }
}