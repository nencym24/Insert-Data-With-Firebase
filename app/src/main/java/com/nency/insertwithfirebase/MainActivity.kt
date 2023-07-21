package com.nency.insertwithfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.nency.insertwithfirebase.databinding.ActivityMainBinding
import com.nency.insertwithfirebase.model.DataModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var dbRef : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dbRef = FirebaseDatabase.getInstance().reference

        binding.cardSubmit.setOnClickListener {

            var title = binding.edtTitle.text.toString()
            var description = binding.edtDesc.text.toString()
            var price = binding.edtPrice.text.toString()
            var extra = binding.edtExtra.text.toString()
            var key = dbRef.root.push().key

            if (title.isNotEmpty() || description.isNotEmpty() || price.isNotEmpty() || extra.isNotEmpty()){
                var data = DataModel(key!!,title,description,price, extra)
                dbRef.root.child("Products").child(key).setValue(data)
            }else{
                Toast.makeText(this, "Enter the Empty details!!", Toast.LENGTH_SHORT).show()
            }
        }


    }
}