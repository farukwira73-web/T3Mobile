package com.example.t3mobile

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ⚠️ Pastikan ID ini sama dengan XML kamu
        val etNama = findViewById<EditText>(R.id.etNama)
        val rgGender = findViewById<RadioGroup>(R.id.rgGender)

        val cbMakan = findViewById<CheckBox>(R.id.cbMakan)
        val cbTidur = findViewById<CheckBox>(R.id.cbTidur)
        val cbNgoding = findViewById<CheckBox>(R.id.cbNgoding)

        val btnTampil = findViewById<Button>(R.id.btnTampil)
        val tvHasil = findViewById<TextView>(R.id.tvHasil)

        btnTampil.setOnClickListener {

            val nama = etNama.text.toString()

            // ✅ Validasi nama
            if (nama.isEmpty()) {
                tvHasil.text = "Nama belum diisi!"
                return@setOnClickListener
            }

            // ✅ Gender
            val gender = when (rgGender.checkedRadioButtonId) {
                R.id.rbLaki -> "Laki-laki"
                R.id.rbPerempuan -> "Perempuan"
                else -> "Belum dipilih"
            }

            // ✅ Hobi
            val hobiList = mutableListOf<String>()
            if (cbMakan.isChecked) hobiList.add("Makan")
            if (cbTidur.isChecked) hobiList.add("Tidur")
            if (cbNgoding.isChecked) hobiList.add("Ngoding")

            val hobi = if (hobiList.isNotEmpty()) {
                hobiList.joinToString(", ")
            } else {
                "Tidak ada"
            }

            // ✅ Output
            val hasil = """
Nama : $nama
Gender : $gender
Hobi : $hobi
            """.trimIndent()

            tvHasil.text = hasil
        }
    }
}