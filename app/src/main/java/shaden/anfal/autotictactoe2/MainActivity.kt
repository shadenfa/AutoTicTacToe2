package shaden.anfal.autotictactoe2

import android.os.Build.VERSION_CODES.N
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import java.util.ArrayList
import kotlinx.android.synthetic.main.activity_main.*
import shaden.anfal.autotictactoe2.R.id.*
import java.util.*




class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun bselect(view: View) {
        val bChoise = view as Button
        var cellID = 0;
        when (bChoise.id) {
            R.id.b00 -> cellID = 1
            R.id.b01 -> cellID = 2
            R.id.b02 -> cellID = 3
            R.id.b10 -> cellID = 4
            R.id.b11 -> cellID = 5
            R.id.b12 -> cellID = 6
            R.id.b20 -> cellID = 7
            R.id.b21 -> cellID = 8
            R.id.b22 -> cellID = 9
        }
        Log.d("cellID:", cellID.toString())
        playGame(cellID, bChoise)

    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var PlayerTurn = 1;

    fun playGame(cellID: Int, bChoise: Button) {
        if (PlayerTurn == 1) {
            bChoise.text = "X"
            player1.add(cellID)
            PlayerTurn = 2
            Auto()
        } else {
            bChoise.text = "O"
            player2.add(cellID)
            PlayerTurn = 1
        }
        bChoise.isEnabled = false
        checkWinner()
    }

    fun checkWinner() {
        var winner = -1

        //row1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2
        }
        //row2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 1
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner = 2
        }
        //row3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 2
        }

        //col1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 2
        }
        //col2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner = 2
        }
        //col3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 2
        }

        //left dio
        if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(5) && player2.contains(9)) {
            winner = 2
        }

        //Right dio
        if (player1.contains(3) && player1.contains(5) && player1.contains(7)) {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(5) && player2.contains(7)) {
            winner = 2
        }






        if (winner != -1) {
            if (winner == 1) {
                Toast.makeText(this, "player1 win.", Toast.LENGTH_LONG).show()
                EndGame()

            } else {
                Toast.makeText(this, "player2 win.", Toast.LENGTH_LONG).show()
                EndGame()

            }
        }
    }

    fun Auto() {
        val emptyCells = ArrayList<Int>()
        for (cellID in 1..9) {
            if (!(player1.contains(cellID) || player2.contains(cellID))) {
                emptyCells.add(cellID)
            }
        }
        val r = Random()
        val randIndex = r.nextInt(emptyCells.size - 0) + 0
        val CellID = emptyCells[randIndex]
        var bSelect: Button?
        when (CellID) {
            1 -> bSelect = b00
            2 -> bSelect = b01
            3 -> bSelect = b02
            4 -> bSelect = b10
            5 -> bSelect = b11
            6 -> bSelect = b12
            7 -> bSelect = b20
            8 -> bSelect = b21
            9 -> bSelect = b22
            else -> {
                bSelect = b00
            }
        }
        playGame(CellID, bSelect)
    }

    fun EndGame()
    {
        b00.isEnabled=false
        b01.isEnabled=false
        b02.isEnabled=false
        b10.isEnabled=false
        b11.isEnabled=false
        b12.isEnabled=false
        b20.isEnabled=false
        b21.isEnabled=false
        b22.isEnabled=false
    }



}
