package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnMultiPlayer: Button =findViewById<Button>(R.id.btnMultiplayer)
        val  btnSinglePlayer=findViewById<Button>(R.id.btnSinglePlayer)
        btnMultiPlayer.setOnClickListener(View.OnClickListener {
            val intent1=Intent(this@MainActivity,MultiPlayer::class.java)
            startActivity(intent1)
        })
        btnSinglePlayer.setOnClickListener {
            val intent2=Intent(this,SinglePlayerActivity::class.java)
            startActivity(intent2)
        }
    }
}