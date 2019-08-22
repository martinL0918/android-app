package com.example.FirstApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.FirstApp.R
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ed_name = findViewById<EditText>(R.id.username)
        val tv_text = findViewById<TextView>(R.id.name)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val btn_scissor = findViewById<RadioButton>(R.id.btn_scissor)
        val btn_stone = findViewById<RadioButton>(R.id.btn_stone)
        val btn_paper = findViewById<RadioButton>(R.id.btn_paper)
        val btn_result = findViewById<Button>(R.id.bnt_result)
        val tv_name = findViewById<TextView>(R.id.text_name)
        val tv_winner = findViewById<TextView>(R.id.text_winner)
        val tv_myMove = findViewById<TextView>(R.id.text_myMove)
        val tv_compMove = findViewById<TextView>(R.id.text_compMove)
        radioGroup.setOnCheckedChangeListener { group, checkedAId -> }
        btn_result.setOnClickListener {
            if (ed_name.length() < 1)
                tv_text.text = "請輸入玩家姓名"
            else {
                tv_name.text = "名字\n${ed_name.text}"
                tv_myMove.text =
                    "我方出拳\n${if (btn_scissor.isChecked) "剪刀" else if (btn_stone.isChecked) "石頭" else "布"}"
                val computer = (Math.random() * 3).toInt()
                tv_compMove.text =
                    "電腦出拳\n${if (computer == 0) "剪刀" else if (computer == 1) "石頭" else "布"}"

                when {
                btn_scissor.isChecked && computer == 2 || btn_stone.isChecked && computer == 0 || btn_paper.isChecked && computer == 1 -> {
                    tv_winner.text = "勝利者\n${ed_name.text}"
                    tv_text.text = "你獲勝了"
                }
                btn_scissor.isChecked && computer == 1 || btn_stone.isChecked && computer == 0 || btn_paper.isChecked && computer == 2 -> {
                    tv_winner.text = "勝利者\n電腦"
                    tv_text.text = "電腦獲勝了"
                }
                else -> {
                    tv_winner.text = "勝利者\n平手"
                    tv_text.text = "平局，請再試一次"
                    }
                }
            }
        }
    }
}
