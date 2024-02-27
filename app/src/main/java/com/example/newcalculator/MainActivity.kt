package com.example.newcalculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import net.objecthunter.exp4j.ExpressionBuilder

class Calculatoractiviy : AppCompatActivity() {
    lateinit var one:TextView
    lateinit var two:TextView
    lateinit var three:TextView
    lateinit var four:TextView
    lateinit var five:TextView
    lateinit var six:TextView
    lateinit var seven:TextView
    lateinit var eight:TextView
    lateinit var nine:TextView
    lateinit var zero:TextView


    lateinit var divisin:TextView
    lateinit var addition:TextView
    lateinit var multiplication:TextView
    lateinit var expresion:TextView
    lateinit var subtraction:TextView
    lateinit var remainder:TextView
    lateinit var result:TextView
    lateinit var decimal:TextView
    lateinit var changesign:TextView
    lateinit var back:ImageView
    lateinit var AC:TextView
    lateinit var equal:TextView
    @SuppressLint("MissingInflatedId", "SuspiciousIndentation", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        one= findViewById(R.id.one)
        two= findViewById(R.id.two)
        three= findViewById(R.id.three)
        four= findViewById(R.id.four)
        five= findViewById(R.id.five)
        six= findViewById(R.id.six)
        seven= findViewById(R.id.seven)
        eight= findViewById(R.id.eight)
        nine= findViewById(R.id.nine)
        zero= findViewById(R.id.zera)


        AC= findViewById(R.id.ac)
        back= findViewById(R.id.backspace)
        divisin= findViewById(R.id.division)
        multiplication= findViewById(R.id.multiplicatin)
        subtraction= findViewById(R.id.subtraction)
        addition= findViewById(R.id.addition)
        remainder= findViewById(R.id.remainder)
        changesign= findViewById(R.id.changesign)
        equal= findViewById(R.id.equal)
        decimal= findViewById(R.id.decimal)

        result= findViewById(R.id.result)
        expresion= findViewById(R.id.expresion)

        one.setOnClickListener{
            Appendtext("1",true)
        }
        two.setOnClickListener{
            Appendtext("2",true)
        }
        three.setOnClickListener{
            Appendtext("3",true)
        }
        four.setOnClickListener{
            Appendtext("4",true)
        }
        five.setOnClickListener{
            Appendtext("5",true)
        }
        six.setOnClickListener{
            Appendtext("6",true)
        }
        seven.setOnClickListener{
            Appendtext("7",true)
        }
        eight.setOnClickListener{
            Appendtext("8",true)
        }
        nine.setOnClickListener{
            Appendtext("9",true)
        }
        zero.setOnClickListener {
            Appendtext("0", true)
        }
        addition.setOnClickListener{
            Appendtext("+",false)
        }
        subtraction.setOnClickListener{
            Appendtext("-",false)
        }
        multiplication.setOnClickListener{
            Appendtext("*",false)
        }

        equal.setOnClickListener{
            try {
                val answer = ExpressionBuilder(expresion.text.toString()).build().evaluate()
                //  var answer = expr.evaluate()
                result.text  = answer.toString()
            }
            catch (e:Exception){
                result.text= e.message
            }
            AC.setOnClickListener{
                expresion.text = ""
                result.hint = ""
                result.text = ""
            }


            back.setOnClickListener {
                result.text = ""
                result.hint = ""
                val value = expresion.text
                if(value.isNotEmpty())
                    expresion.text = value.substring(0,value.length-1)
            }
        }
        remainder.setOnClickListener {
            Appendtext("%",false)
        }
        changesign.setOnClickListener {
            expresion.text = ""
            result.text  = ""
            if(expresion.text.isNotEmpty() && expresion.text[0]=='-'){
                expresion.text = expresion.text.substring(1)
            }
            else
                expresion.text = "-" + expresion.text
        }
    }

    fun Appendtext(value: String, tobecleared: Boolean)
    {
        if (result.text != "")
            expresion.text = ""
        if (tobecleared)//if value is number
        {
            result.text = ""
            expresion.append(value)
        }else //if value is an operator
        {
            expresion.append(result.text)
            expresion.append(value)
            result.text = ""
        }
        result.hint = expresion.text

        decimal.setOnClickListener {

            Appendtext(".",true)
        }
    }


}