package com.postmyth.a14viewmapclonevs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.postmyth.a14viewmapclonevs.databinding.ActivityMainBinding

private lateinit var binding : ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        try {
            val myDatabase = this.openOrCreateDatabase("Musicians", MODE_PRIVATE, null)
            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS musicians(id INTEGER PRIMARY KEY ,name VARCHAR, age INT)")
            //myDatabase.execSQL("INSERT INTO musicians (name,age) VALUES ('Kirk',55)")
            //myDatabase.execSQL("INSERT INTO musicians (name,age) VALUES ('JAMES',50)")
            //myDatabase.execSQL("UPDATE musicians SET age =62 WHERE name = 'Kirk'")
            //myDatabase.execSQL("DELETE FROM musicians WHERE age=62")
            //testbir

            val cursor = myDatabase.rawQuery("SELECT * FROM musicians",null)

            val nameIx = cursor.getColumnIndex("name")
            val ageIx = cursor.getColumnIndex("age")
            val idIx = cursor.getColumnIndex("id")

            while (cursor.moveToNext()) {
                println("Name  " + cursor.getString(nameIx))
                println("Age  " + cursor.getInt(ageIx))
                println("ID  " + cursor.getInt(idIx))
            }
            cursor.close()

    } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}