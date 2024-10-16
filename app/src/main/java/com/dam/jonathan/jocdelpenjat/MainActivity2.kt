package com.dam.jonathan.jocdelpenjat

import SingertonJoc
import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    private lateinit var nom: TextView
    private lateinit var m1: ImageView
    private lateinit var m2: ImageView
    private lateinit var m3: ImageView
    private lateinit var m4: ImageView
    private lateinit var m5: ImageView
    private lateinit var m6: ImageView
    private lateinit var pista: TextView
    private lateinit var t: TextView
    private lateinit var pt: TextView
    private lateinit var lt: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        nom = findViewById(R.id.nom2)
        pista = findViewById(R.id.pista2)
        pt = findViewById(R.id.probaText)
        lt = findViewById(R.id.lt)

        t = findViewById(R.id.t)
        t.text = SingertonJoc.partida.paraulaDisplayed
        nom.text = SingertonJoc.partida.nom
        pista.text = SingertonJoc.partida.pista

        m1 = findViewById(R.id.m1)
        m2 = findViewById(R.id.m2)
        m3 = findViewById(R.id.m3)
        m4 = findViewById(R.id.m4)
        m5 = findViewById(R.id.m5)
        m6 = findViewById(R.id.m6)




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun renicia(view: View) {
        SingertonJoc.partida = Partida(SingertonJoc.partida.paraula,SingertonJoc.partida.nom,SingertonJoc.partida.pista)
        var i = Intent(AActivity@this, MainActivity2::class.java)
        startActivity(i)
        finish()

    }
    fun sortir(view: View) {
        finish()

    }
    fun a(view: View)  {
        if(!SingertonJoc.partida.comproba(pt.text.toString())){
            when (SingertonJoc.partida.index) {
                0 -> {
                    m1.alpha = 0f
                    m2.alpha = 1f
                }
                1 -> {
                    m2.alpha = 0f
                    m3.alpha = 1f
                }
                2 -> {
                    m3.alpha = 0f
                    m4.alpha = 1f                }
                3 -> {
                    m4.alpha = 0f
                    m5.alpha = 1f                }
                4 -> {
                    m5.alpha = 0f
                    m6.alpha = 1f
                }
                5 -> {
                    var i = Intent(AActivity@this, MainActivity3::class.java)
                    startActivity(i)
                }
                else -> {

                }
            }
            SingertonJoc.partida.index++
        }
        t.text = SingertonJoc.partida.paraulaDisplayed
        lt.text = lt.text.toString() + "," + pt.text.toString()
        if(SingertonJoc.partida.miraGuanyador()) {
            var i = Intent(AActivity@this, MainActivity4::class.java)
            startActivity(i)
        }


    }
}