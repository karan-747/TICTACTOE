package com.example.tictactoe

import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlin.ranges.random as random1

class SinglePlayerActivity : AppCompatActivity() {
    private lateinit var btn01:Button
    private lateinit var btn02:Button
    private lateinit var btn03:Button
    private lateinit var btn04:Button
    private lateinit var btn05:Button
    private lateinit var btn06:Button
    private lateinit var btn07:Button
    private lateinit var btn08:Button
    private lateinit var btn09:Button

    private lateinit var adPlayerWon: AlertDialog
    private lateinit var adCPUWon: AlertDialog

    private var playerWon:Boolean=false
    private var cpuwon:Boolean=false
    private var  playerActive:Boolean = true
    private lateinit var emptyCells:ArrayList<Int>
    private lateinit var btnQuit01:Button
    private lateinit var btnRestart01:Button
    private var count =0

    private lateinit var playerArray:ArrayList<Int>
    private lateinit  var cpuArray: ArrayList<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_player)
        btn01=findViewById(R.id.btn01)
        btn02=findViewById(R.id.btn02)
        btn03=findViewById(R.id.btn03)
        btn04=findViewById(R.id.btn04)
        btn05=findViewById(R.id.btn05)
        btn06=findViewById(R.id.btn06)
        btn07=findViewById(R.id.btn07)
        btn08=findViewById(R.id.btn08)
        btn09=findViewById(R.id.btn09)

        btnQuit01=findViewById(R.id.btnQuit01)
        btnRestart01=findViewById(R.id.btnRestart01)

        adPlayerWon=AlertDialog.Builder(this).setTitle("Player Won!!").setIcon(R.drawable.ic_win2_foreground)
            .setMessage("Do you want to restart?").setCancelable(false)
            .setPositiveButton("Yes",
                DialogInterface.OnClickListener { dialogInterface, i ->
                    resetEverything()
                })
            .setNegativeButton("No",
            DialogInterface.OnClickListener { dialogInterface, i ->
                quitAction()
            })
            .create()

        adCPUWon=AlertDialog.Builder(this).setTitle("CPU Won!!").setIcon(R.drawable.ic_win3_foreground)
            .setMessage("Do you want to restart?").setCancelable(false)
            .setPositiveButton("Yes",
                DialogInterface.OnClickListener { dialogInterface, i ->
                    resetEverything()
                })
            .setNegativeButton("No",
            DialogInterface.OnClickListener { dialogInterface, i ->
                quitAction()
            })
            .create()


        btnQuit01.setOnClickListener {
            quitAction()
        }
        setEmptyCells()
        setArray()
        btnRestart01.setOnClickListener { 
            resetEverything()
        }
        btn01.setOnClickListener {
            if(playerWon || cpuwon){
                //alert dialog
                Toast.makeText(this,"Please Restart game",Toast.LENGTH_SHORT).show()
            }
            else{
                if(playerActive){
                    buttonOnClicked(btn01)
                }

            }
        }
        btn02.setOnClickListener {
            if(playerWon || cpuwon){
                //alert dialog
                Toast.makeText(this,"Please Restart game",Toast.LENGTH_SHORT).show()
            }
            else{
                if(playerActive){
                    buttonOnClicked(btn02)
                }
            }
        }
        btn03.setOnClickListener {
            if(playerWon || cpuwon){
                //alert dialog
                Toast.makeText(this,"Please Restart game",Toast.LENGTH_SHORT).show()
            }
            else{
                if(playerActive){
                    buttonOnClicked(btn03)
                }

            }

        }
        btn04.setOnClickListener {
            if(playerWon || cpuwon){
                //alert dialog
                Toast.makeText(this,"Please Restart game",Toast.LENGTH_SHORT).show()
            }
            else{
                if(playerActive){
                    buttonOnClicked(btn04)
                }

            }
        }
        btn05.setOnClickListener {
            if(playerWon || cpuwon){
                //alert dialog
                Toast.makeText(this,"Please Restart game",Toast.LENGTH_SHORT).show()
            }
            else{
                if(playerActive){
                    buttonOnClicked(btn05)
                }

            }
        }
        btn06.setOnClickListener {
            if(playerWon || cpuwon){
                //alert dialog
                Toast.makeText(this,"Please Restart game",Toast.LENGTH_SHORT).show()
            }
            else{
                if(playerActive){
                    buttonOnClicked(btn06)
                }

            }
        }
        btn07.setOnClickListener {
            if(playerWon || cpuwon){
                //alert dialog
                Toast.makeText(this,"Please Restart game",Toast.LENGTH_SHORT).show()
            }
            else{
                if(playerActive){
                    buttonOnClicked(btn07)
                }

            }
        }
        btn08.setOnClickListener {
            if(playerWon || cpuwon){
                //alert dialog
                Toast.makeText(this,"Please Restart game",Toast.LENGTH_SHORT).show()
            }
            else{
                if(playerActive){
                    buttonOnClicked(btn08)
                }
            }
        }
        btn09.setOnClickListener {
            if(playerWon || cpuwon){
                //alert dialog
                Toast.makeText(this,"Please Restart game",Toast.LENGTH_SHORT).show()
            }
            else{
                if(playerActive){
                    buttonOnClicked(btn09)
                }

            }
        }
    }

    private fun quitAction() {
        val intent3= Intent(this,MainActivity::class.java)
        startActivity(intent3)
    }

    private fun resetEverything() {
        resetAllButtons()
        count=0
        emptyCells.clear()
        setEmptyCells()
        playerArray.clear()
        cpuArray.clear()
        playerWon=false
        cpuwon=false
    }

    private fun resetAllButtons() {
        for(i in 1..9){
            when(i){
                1->btn01.setText("")
                2->btn02.setText("")
                3->btn03.setText("")
                4->btn04.setText("")
                5->btn05.setText("")
                6->btn06.setText("")
                7->btn07.setText("")
                8->btn08.setText("")
                9->btn09.setText("")
                else->btn01.setText("")
            }
        }
    }

    private fun buttonOnClicked(btn: Button) {
        if(playerWon || cpuwon){
            return
        }
        if(checkButtonAvailibilty(btn)){
            playerPlay(btn)
            count++
            if(checkPlayerWinner()){
                playerWon=true
                adPlayerWon.show()
                return
            }
            if(count<9){
                cpuPlay()
                count++
            }


        }
    }

    private fun checkCPUWinner(): Boolean {
        if(count<5){
            return false
        }
        if(cpuArray.contains(1) && cpuArray.contains(2) && cpuArray.contains(3)){
            return true
        }
        if(cpuArray.contains(1) && cpuArray.contains(4) && cpuArray.contains(7)){
            return true
        }

        if(cpuArray.contains(1) && cpuArray.contains(5) && cpuArray.contains(9)){
            return true
        }
        if(cpuArray.contains(2) && cpuArray.contains(5) && cpuArray.contains(8)){
            return true
        }
        if(cpuArray.contains(3) && cpuArray.contains(5) && cpuArray.contains(7)){
            return true
        }
        if(cpuArray.contains(3) && cpuArray.contains(6) && cpuArray.contains(9)){
            return true
        }
        if(cpuArray.contains(4) && cpuArray.contains(5) && cpuArray.contains(6)){
            return true
        }
        if(cpuArray.contains(7) && cpuArray.contains(8) && cpuArray.contains(9)){
            return true
        }
        return false

    }

    private fun cpuPlay() {
        playerActive=false
        val  handler= Handler().postDelayed(Runnable {
            robotPlay()
            if(cpuwon){
                adCPUWon.show()
            }
            playerActive=true
        },500)
    }

    private fun robotPlay() {
       var cpuBtnNumber=(1..9).random1()
       if(!emptyCells.contains(cpuBtnNumber)){
           robotPlay()
           return
       }
        val cpuBtn=when(cpuBtnNumber){
           1->btn01
           2->btn02
           3->btn03
           4->btn04
           5->btn05
           6->btn06
           7->btn07
           8->btn08
           9->btn09
           else-> btn01
       }
        cpuBtn.setTextColor(Color.RED)
        cpuBtn.setText("O")
        emptyCells.remove(cpuBtnNumber)
        cpuArray.add(cpuBtnNumber)
        if(checkCPUWinner()){
            cpuwon=true
            Toast.makeText(this,"CPU Won",Toast.LENGTH_SHORT).show()
        }

        return
    }

    private fun checkPlayerWinner(): Boolean {
        if(count<5){
            return false
        }
        if(playerArray.contains(1) && playerArray.contains(2) && playerArray.contains(3)){
            return true
        }
        if(playerArray.contains(1) && playerArray.contains(4) && playerArray.contains(7)){
            return true
        }

        if(playerArray.contains(1) && playerArray.contains(5) && playerArray.contains(9)){
            return true
        }
        if(playerArray.contains(2) && playerArray.contains(5) && playerArray.contains(8)){
            return true
        }
        if(playerArray.contains(3) && playerArray.contains(5) && playerArray.contains(7)){
            return true
        }
        if(playerArray.contains(3) && playerArray.contains(6) && playerArray.contains(9)){
            return true
        }
        if(playerArray.contains(4) && playerArray.contains(5) && playerArray.contains(6)){
            return true
        }
        if(playerArray.contains(7) && playerArray.contains(8) && playerArray.contains(9)){
            return true
        }
        return false
    }

    private fun playerPlay(btn: Button) {
        val btnNumber = when(btn) {
            btn01 -> {
                1
            }
            btn02 -> {
                2
            }
            btn03 -> {
                3
            }
            btn04 -> {
                4
            }
            btn05 -> {
                5
            }
            btn06 -> {
                6
            }
            btn07 -> {
                7
            }
            btn08 -> {
                8
            }
            btn09 -> {
                9
            }
            else -> {
                1
            }
        }
        btn.setTextColor(Color.BLACK)
        btn.setText("X")
        playerArray.add(btnNumber)
        emptyCells.remove(btnNumber)

    }

    private fun checkButtonAvailibilty(btn: Button): Boolean {
        if(count==9){
            return false
        }
        val btnNumber = when(btn){
            btn01->{
                1
            }
            btn02->{
                2
            }
            btn03->{
                3
            }
            btn04->{
                4
            }
            btn05->{
                5
            }
            btn06->{
                6
            }
            btn07->{
                7
            }
            btn08->{
                8
            }
            btn09->{
                9
            }
            else->{
                1
            }
        }
        return emptyCells.contains(btnNumber)
    }

    private fun setArray() {
        playerArray= arrayListOf()
        cpuArray= arrayListOf()
    }

    private fun setEmptyCells() {
        var btn:Button
        emptyCells= arrayListOf()
        for(i in 1..9){
            emptyCells.add(i)
        }
        return
    }
}