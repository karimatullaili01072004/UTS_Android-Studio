package com.example.datasuhu

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var layoutLogin: LinearLayout
    private lateinit var layoutData: LinearLayout
    private lateinit var tableSuhu: TableLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        layoutLogin = findViewById(R.id.layoutLogin)
        layoutData = findViewById(R.id.layoutData)
        tableSuhu = findViewById(R.id.tableSuhu)

        val etUsername = findViewById<EditText>(R.id.etUsername)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            if (username == "admin" && password == "12345") {
                Toast.makeText(this, "Login berhasil", Toast.LENGTH_SHORT).show()
                layoutLogin.visibility = LinearLayout.GONE
                layoutData.visibility = LinearLayout.VISIBLE
                tampilkanDataSuhu()
            } else {
                Toast.makeText(this, "Username atau password salah", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun tampilkanDataSuhu() {
        // Contoh data suhu (bisa diganti sesuai kebutuhan)
        val dataSuhu = listOf(10.0, 20.0, 30.0, 40.0, 50.0)

        for ((index, celsius) in dataSuhu.withIndex()) {
            val row = TableRow(this)

            val no = TextView(this)
            no.text = (index + 1).toString()
            no.setPadding(8, 8, 8, 8)

            val celsiusText = TextView(this)
            celsiusText.text = String.format("%.1f", celsius)
            celsiusText.setPadding(8, 8, 8, 8)

            val fahrenheitText = TextView(this)
            val fahrenheit = (celsius * 9 / 5) + 32
            fahrenheitText.text = String.format("%.1f", fahrenheit)
            fahrenheitText.setPadding(8, 8, 8, 8)

            row.addView(no)
            row.addView(celsiusText)
            row.addView(fahrenheitText)

            tableSuhu.addView(row)
        }
    }
}
