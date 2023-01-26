package com.itproger.calculator2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_0.setOnClickListener{ setTextFields("0") }
        btn_1.setOnClickListener{ setTextFields("1") }
        btn_2.setOnClickListener{ setTextFields("2") }
        btn_3.setOnClickListener{ setTextFields("3") }
        btn_4.setOnClickListener{ setTextFields("4") }
        btn_5.setOnClickListener{ setTextFields("5") }
        btn_6.setOnClickListener{ setTextFields("6") }
        btn_7.setOnClickListener{ setTextFields("7") }
        btn_8.setOnClickListener{ setTextFields("8") }
        btn_9.setOnClickListener{ setTextFields("9") }
        btn_minus.setOnClickListener{ setTextFields("-") }
        btn_plus.setOnClickListener{ setTextFields("+") }
        btn_mult.setOnClickListener{ setTextFields("*") }
        btn_division.setOnClickListener{ setTextFields("/") }
        btn_lbracket.setOnClickListener{ setTextFields("(") }
        btn_rbracket.setOnClickListener{ setTextFields(")") }
        btn_AC.setOnClickListener {
            math_operation.text = ""
            text_result.text = ""
        }
        btn_back.setOnClickListener {
            val str = math_operation.text.toString()
            if(str.isNotEmpty())
                math_operation.text = str.substring(0, str.length - 1)
            text_result.text = ""
        }
        btn_equals.setOnClickListener {
            try {

                val ex = ExpressionBuilder(math_operation.text.toString()).build()
                val result = ex.evaluate()

                val longRes = result.toLong()
                if(result == longRes.toDouble())
                    text_result.text = longRes.toString()
                else text_result.text = result.toString()
            } catch (e:Exception) {
                Log.d("Ошибка", "Сообщение: ${e.message}")
            }
        }
    }

    fun setTextFields(str: String) {
        if(text_result.text != "") {
            math_operation.text = text_result.text
            text_result.text = ""
        }
        math_operation.append(str)
    }

}