package mx.edu.itson.potros.calculadora_juliovalenzuela_216774

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    var numeroActual: String = ""
    var nuevoNumero: String = ""
    lateinit var tvOperacion: TextView
    lateinit var tvError: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cero: Button = findViewById(R.id.btn0)
        val uno: Button = findViewById(R.id.btn1)
        val dos: Button = findViewById(R.id.btn2)
        val tres: Button = findViewById(R.id.btn3)
        val cuatro: Button = findViewById(R.id.btn4)
        val cinco: Button = findViewById(R.id.btn5)
        val seis: Button = findViewById(R.id.btn6)
        val siete: Button = findViewById(R.id.btn7)
        val ocho: Button = findViewById(R.id.btn8)
        val nueve: Button = findViewById(R.id.btn9)
        val borrar: Button = findViewById(R.id.btnDelete)
        val resultado: Button = findViewById(R.id.btnResult)

        val suma: Button = findViewById(R.id.btnAdd)
        val multiplica: Button = findViewById(R.id.btnMultiply)
        val resta: Button = findViewById(R.id.btnSubtract)
        val division: Button = findViewById(R.id.btnDivision)

        val tvResultado: TextView = findViewById(R.id.tvResultado)

        var operacionActual: String = ""
        tvOperacion = findViewById(R.id.tvOperacion)
        tvError = findViewById(R.id.tvError)

        cero.setOnClickListener {
            numeroActual += "0"
            tvOperacion.setText(numeroActual)
        }

        uno.setOnClickListener {
            numeroActual += "1"
            tvOperacion.setText(numeroActual)
        }

        dos.setOnClickListener {
            numeroActual += "2"
            tvOperacion.setText(numeroActual)
        }

        tres.setOnClickListener {
            numeroActual += "3"
            tvOperacion.setText(numeroActual)
        }

        cuatro.setOnClickListener {
            numeroActual += "4"
            tvOperacion.setText(numeroActual)
        }

        cinco.setOnClickListener {
            numeroActual += "5"
            tvOperacion.setText(numeroActual)
        }

        seis.setOnClickListener {
            numeroActual += "6"
            tvOperacion.setText(numeroActual)
        }

        siete.setOnClickListener {
            numeroActual += "7"
            tvOperacion.setText(numeroActual)
        }

        ocho.setOnClickListener {
            numeroActual += "8"
            tvOperacion.setText(numeroActual)
        }

        nueve.setOnClickListener {
            numeroActual += "9"
            tvOperacion.setText(numeroActual)
        }

        borrar.setOnClickListener {
            if(numeroActual == ""){
                nuevoNumero = ""
                tvResultado.setText("")
            }

            numeroActual = ""
            tvOperacion.setText(numeroActual)

        }

        suma.setOnClickListener {
            resetearNumero()
            tvResultado.setText(nuevoNumero + "+")
            operacionActual = "+"
        }

        division.setOnClickListener {
            resetearNumero()
            tvResultado.setText(nuevoNumero + "/")
            operacionActual = "/"
        }

        resta.setOnClickListener {
            resetearNumero()
            tvResultado.setText(nuevoNumero + "-")
            operacionActual = "-"
        }

        multiplica.setOnClickListener {
            resetearNumero()
            tvResultado.setText(nuevoNumero + "*")
            operacionActual = "*"
        }

        resultado.setOnClickListener {
            tvError.setText("")

            if(operacionActual == "+"){
                tvResultado.setText(suma(nuevoNumero.toInt(), numeroActual.toInt()).toString())
                reiniciarValores()
            }

            if(operacionActual == "/"){
                tvResultado.setText(division(nuevoNumero.toInt(), numeroActual.toInt()).toString())
                reiniciarValores()
            }

            if (operacionActual == "-"){
                tvResultado.setText(resta(nuevoNumero.toInt(), numeroActual.toInt()).toString())
                reiniciarValores()
            }

            if(operacionActual == "*"){
                tvResultado.setText(multiply(nuevoNumero.toInt(), numeroActual.toInt()).toString())
                reiniciarValores()
            }

        }

    }

    private fun reiniciarValores(){
        tvOperacion.setText("")
        nuevoNumero = ""
    }

    private fun resetearNumero(){
        nuevoNumero = numeroActual
        numeroActual = ""
        tvOperacion.setText(numeroActual)
    }

    fun suma(a: Int, b: Int): Int{
        return a + b
    }

    fun resta(a: Int, b: Int): Int{
        return a - b
    }

    fun division(a: Int, b: Int): Int{
        try {
            return a / b
        }catch (e: Exception){
            tvError.setText(e.message)
            return 0
        }
    }

    fun multiply(a: Int, b: Int): Int{
        return a * b
    }

}