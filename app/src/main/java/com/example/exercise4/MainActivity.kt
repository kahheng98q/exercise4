package com.example.exercise4

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit  var calButton: Button
    lateinit  var reButton: Button
    lateinit  var ageView: TextView
    lateinit  var savingView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var cal = Calendar.getInstance()
        val today = Calendar.getInstance()

        calButton=findViewById(R.id.dateButton)
        reButton=findViewById(R.id.resetButton)
        ageView=findViewById(R.id.textAge)
        savingView=findViewById(R.id.textSaving)

        // Reference : https://www.tutorialkart.com/kotlin-android/android-datepicker-kotlin-example/
        val datePicker = object : DatePickerDialog.OnDateSetListener{

            override fun onDateSet(view : DatePicker, year : Int, month: Int, day: Int){


                cal.set(year, month, day)

                val dateFormat = "dd/MM/yyyy"
                val sdf = SimpleDateFormat(dateFormat, Locale.UK)

                // Get age
                val age =  today.get(Calendar.YEAR) - cal.get(Calendar.YEAR)
                ageView.setText("Age: " + age.toString())
                var saving : Int

                if(age in 16..20)
                    saving = 5000
                else if(age in 21..25)
                    saving = 14000
                else if(age in 26..30)
                    saving = 29000
                else if(age in 31..35)
                    saving = 50000
                else if(age in 36..40)
                    saving = 78000
                else if(age in 41..45)
                    saving = 116000
                else if(age in 46..50)
                    saving = 165000
                else if (age in 51..55)
                    saving = 228000
                else
                    saving = 0

                savingView.setText ("Min Saving: " + saving.toString())

            }
        }

        calButton.setOnClickListener{
            val datePickerDialog = DatePickerDialog(this, datePicker, cal.get(Calendar.YEAR), cal.get(
                Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH)).show()
        }

        reButton.setOnClickListener{
            ageView.text = "Age:"
            savingView.text = "Min Saving:"
        }

    }

}


