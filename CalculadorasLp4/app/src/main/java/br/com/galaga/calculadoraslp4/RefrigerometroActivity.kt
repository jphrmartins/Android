package br.com.galaga.calculadoraslp4

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_refrigerometro.*


class RefrigerometroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_refrigerometro)
        btnCalcular.setOnClickListener {calcular()}
    }

    private fun calcular() {
        val valor : Double? = valorEdit.text.toString().toDoubleOrNull()
        val mls : Double? = mlsEdit.text.toString().toDoubleOrNull()

        if (valor != null && mls != null){
            val valorPorLitro:Double = valor/(mls/1000)
            btnCalcular.text = "R$: $valorPorLitro por litro"
        } else {
            if(valor == null) valorEdit.error = "Insira um valor válido"
            if (mls == null) mlsEdit.error = "Insiro um mililitro válido"

        }

    }
}
