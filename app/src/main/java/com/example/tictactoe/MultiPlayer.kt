package com.example.tictactoe

import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MultiPlayer : AppCompatActivity() {
    private lateinit var tvPlayer1:TextView
    private lateinit var tvPlayer2:TextView
    private lateinit var btn1:Button
    private lateinit var btn2:Button
    private lateinit var btn3:Button
    private lateinit var btn4:Button
    private lateinit var btn5:Button
    private lateinit var btn6:Button
    private lateinit var btn7:Button
    private lateinit var btn8:Button
    private lateinit var btn9:Button
    private lateinit var btnRestart:Button
    private lateinit var btnQuit:Button
    private  var player1Cells = arrayListOf<Button>()
    private  var player2Cells = arrayListOf<Button>()
    private lateinit var emptyCells : ArrayList<Button>
    private lateinit var alertDialogPlayer1:AlertDialog
    private lateinit var alertDialogPlayer2:AlertDialog
    private var count:Int=0
    private var player1Count=0
    private var player2Count=0
    private lateinit var mpScribble:MediaPlayer
    private lateinit var mpWinner:MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multi_player)



        btn1=findViewById(R.id.btn1)
        btn2=findViewById(R.id.btn2)
        btn3=findViewById(R.id.btn3)
        btn4=findViewById(R.id.btn4)
        btn5=findViewById(R.id.btn5)
        btn6=findViewById(R.id.btn6)
        btn7=findViewById(R.id.btn7)
        btn8=findViewById(R.id.btn8)
        btn9=findViewById(R.id.btn9)

        btnQuit=findViewById(R.id.btnQuit)
        btnRestart=findViewById(R.id.btnRestart)
        //mpScribble=MediaPlayer.create(this,R.raw.scribble)
        //mpWinner=MediaPlayer.create(this,R.raw.won)

        setEmptyCells()
        Toast.makeText(this,"Player 1's turn",Toast.LENGTH_SHORT).show()

        alertDialogPlayer1=AlertDialog.Builder(this).setTitle("Player 1 Won !!").setIcon(R.drawable.ic_win2_foreground).setMessage("Do you want to restart the game?").setCancelable(false)
            .setPositiveButton("Yes",
            DialogInterface.OnClickListener { dialogInterface, i ->
                resetAllButtons()
            }).setNegativeButton("No",
            DialogInterface.OnClickListener { dialogInterface, i ->
                resetAllButtons()
                goBackToMainActivity()
            }).create()

        alertDialogPlayer2=AlertDialog.Builder(this).setTitle("Player 2 Won !!").setIcon(R.drawable.ic_win3_foreground).setMessage("Do you want to restart the game?").setCancelable(false)
            .setPositiveButton("Yes",
                DialogInterface.OnClickListener { dialogInterface, i ->
                    resetAllButtons()
                }).setNegativeButton("No",
                DialogInterface.OnClickListener { dialogInterface, i ->
                    resetAllButtons()
                    goBackToMainActivity()
                }).create()




        btnRestart.setOnClickListener {
            resetAllButtons()
        }
        btnQuit.setOnClickListener {
            resetAllButtons()
            goBackToMainActivity()
        }

        btn1.setOnClickListener{
            buttonOnClicked(btn1)
            val ans:Int=check()
            if(ans==1){
                alertDialogPlayer1.show()
            }
            if(ans==2){
                alertDialogPlayer2.show()
            }
        }
        btn2.setOnClickListener{
            buttonOnClicked(btn2)
            val ans:Int=check()
            if(ans==1){
                alertDialogPlayer1.show()
            }
            if(ans==2){
                alertDialogPlayer2.show()
            }

        }
        btn3.setOnClickListener{
            buttonOnClicked(btn3)
            val ans:Int=check()
            if(ans==1){
                alertDialogPlayer1.show()
            }
            if(ans==2){
                alertDialogPlayer2.show()
            }
        }
        btn4.setOnClickListener{
            buttonOnClicked(btn4)
            val ans:Int=check()
            if(ans==1){
                alertDialogPlayer1.show()
            }
            if(ans==2){
                alertDialogPlayer2.show()
            }
        }
        btn5.setOnClickListener{
            buttonOnClicked(btn5)
            val ans:Int=check()
            if(ans==1){
                alertDialogPlayer1.show()
            }
            if(ans==2){
                alertDialogPlayer2.show()

            }
        }
        btn6.setOnClickListener{
            buttonOnClicked(btn6)
            val ans:Int=check()
            if(ans==1){
                alertDialogPlayer1.show()

            }
            if(ans==2){
                alertDialogPlayer2.show()

            }
        }
        btn7.setOnClickListener{
            buttonOnClicked(btn7)
            val ans:Int=check()
            if(ans==1){
                alertDialogPlayer1.show()

            }
            if(ans==2){
                alertDialogPlayer2.show()
            }
        }
        btn8.setOnClickListener{
            buttonOnClicked(btn8)
            val ans:Int=check()
            if(ans==1){
                alertDialogPlayer1.show()
            }
            if(ans==2){
                alertDialogPlayer2.show()
            }
        }
        btn9.setOnClickListener{
            buttonOnClicked(btn9)
            val ans:Int=check()
            if(ans==1){
                alertDialogPlayer1.show()

            }
            if(ans==2){
                alertDialogPlayer2.show()
            }
        }

    }

    private fun goBackToMainActivity() {
        val i=Intent(this,MainActivity::class.java)
        startActivity(i)
    }
    private fun check(): Int {
        if(count<5){
            return -1
        }
        if(checkPlayer1Cells()){
            return 1
        }
        if(checkPlayer2Cells()){
            return 2
        }
        return -1
    }
    private fun checkPlayer1Cells(): Boolean {
        if(player1Cells.contains(btn1) && player1Cells.contains(btn2) && player1Cells.contains(btn3)){
            return true
        }
        if(player1Cells.contains(btn1) && player1Cells.contains(btn4) && player1Cells.contains(btn7)){
            return true
        }
        if(player1Cells.contains(btn1) && player1Cells.contains(btn5) && player1Cells.contains(btn9)){
            return true
        }
        if(player1Cells.contains(btn2) && player1Cells.contains(btn5) && player1Cells.contains(btn8)){
            return true
        }
        if(player1Cells.contains(btn3) && player1Cells.contains(btn5) && player1Cells.contains(btn7)){
            return true
        }
        if(player1Cells.contains(btn3) && player1Cells.contains(btn6) && player1Cells.contains(btn9)){
            return true
        }
        if(player1Cells.contains(btn4) && player1Cells.contains(btn5) && player1Cells.contains(btn6)){
            return true
        }
        if(player1Cells.contains(btn7) && player1Cells.contains(btn8) && player1Cells.contains(btn9)){
            return true
        }
        return false
    }
    private fun checkPlayer2Cells(): Boolean {
        if(player2Cells.contains(btn1) && player2Cells.contains(btn2) && player2Cells.contains(btn3)){
            return true
        }
        if(player2Cells.contains(btn1) && player2Cells.contains(btn4) && player2Cells.contains(btn7)){
            return true
        }
        if(player2Cells.contains(btn1) && player2Cells.contains(btn5) && player2Cells.contains(btn9)){
            return true
        }
        if(player2Cells.contains(btn2) && player2Cells.contains(btn5) && player2Cells.contains(btn8)){
            return true
        }
        if(player2Cells.contains(btn3) && player2Cells.contains(btn5) && player2Cells.contains(btn7)){
            return true
        }
        if(player2Cells.contains(btn3) && player2Cells.contains(btn6) && player2Cells.contains(btn9)){
            return true
        }
        if(player2Cells.contains(btn4) && player2Cells.contains(btn5) && player2Cells.contains(btn6)){
            return true
        }
        if(player2Cells.contains(btn7) && player2Cells.contains(btn8) && player2Cells.contains(btn9)){
            return true
        }
        return false
    }
    private fun buttonOnClicked(btn: Button) {

        if(isFull()){
            Toast.makeText(this,"Match Draw Please Restart",Toast.LENGTH_SHORT).show()
            return
        }
        if(checkButton(btn)){
            if(count%2==0){
                btn.setTextColor(Color.BLACK)
                btn.setText("X")
                player1Cells.add(btn)
            }else{
                btn.setTextColor(Color.RED)
                btn.setText("O")
                player2Cells.add(btn)

            }
            emptyCells.remove(btn)
            count++
            return
        }
        return
    }
    private fun isFull(): Boolean {
        Log.d("deBug","isFull checked")
        return (count==9)
    }
    private fun checkButton(btn: Button): Boolean {
        Log.d("deBug","checkButton checked")
        return emptyCells.contains(btn)
    }
    private fun resetAllButtons() {
        for(i in 1..9){
            when(i){
                1->{btn1.setText("")}
                2->{btn2.setText("")}
                3->{btn3.setText("")}
                4->{btn4.setText("")}
                5->{btn5.setText("")}
                6->{btn6.setText("")}
                7->{btn7.setText("")}
                8->{btn8.setText("")}
                9->{btn9.setText("")}
                else->{

                }
            }
        }
        count=0
        setEmptyCells()
        clearPlayerCells()
        player1Count=0
        player2Count=0

    }
    private fun clearPlayerCells() {
        player1Cells.clear()
        player2Cells.clear()
    }
    private fun setEmptyCells() {
        emptyCells= arrayListOf(btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9)

    }
}