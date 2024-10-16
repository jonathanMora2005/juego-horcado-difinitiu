package com.dam.jonathan.jocdelpenjat

import SingertonJoc
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var facil = true
    private lateinit var nom: TextView
    private lateinit var paraula: TextView
    private lateinit var pista: TextView
    private lateinit var t1: TextView
    private lateinit var t2: TextView
    private lateinit var ff: FrameLayout
    private lateinit var df: FrameLayout
    private lateinit var c: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.newmain)
        nom = findViewById(R.id.nom)
        paraula = findViewById(R.id.paraula)
        pista = findViewById(R.id.pista)
        ff = findViewById(R.id.ff)
        df = findViewById(R.id.df)
        t1 = findViewById(R.id.t1)
        t2 = findViewById(R.id.tt2)
        c = findViewById(R.id.c)


    }
    fun f(view: View){
        ff.setBackgroundColor(Color.parseColor("#FF0000"))
        df.setBackgroundColor(Color.parseColor("#FFFFFF"))
        t1.setTextColor(Color.parseColor("#FFFFFF"))
        t2.setTextColor(Color.parseColor("#000000"))
        c.alpha = 0f

        facil = true
    }
    fun d(view: View){
        df.setBackgroundColor(Color.parseColor("#FF0000"))
        ff.setBackgroundColor(Color.parseColor("#FFFFFF"))
        t2.setTextColor(Color.parseColor("#FFFFFF"))
        t1.setTextColor(Color.parseColor("#000000"))
        c.alpha = 1f
        facil = false
    }
    fun comensa(view: View) {
        if (facil){
            SingertonJoc.partida = Partida(paraula.text.toString(),nom.text.toString())
        }else{
            SingertonJoc.partida = Partida(paraula.text.toString(),nom.text.toString(),pista.text.toString())

        }
       var i = Intent(AActivity@this, MainActivity2::class.java)
       startActivity(i)
    }
}