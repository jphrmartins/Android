package br.com.galaga.calculadoraslp4

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_energia.*

class EnergiaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_energia)
    }

    fun calcular(view: View) {
        val potencia : Double? = potenciaEdt.text.toString().toDoubleOrNull()
        val corrente : Double? = correnteEdt.text.toString().toDoubleOrNull()
        val tensao : Double? = tensaoEdt.text.toString().toDoubleOrNull()

        if (potencia == null || corrente == null || tensao == null){
            if (potencia == null) {
                potenciaNula(corrente, tensao)
            } else if (corrente == null) {
                correnteNula(potencia, tensao)
            } else {
                tensaoNula(potencia, corrente)
            }
        } else {
            makeToast("Deixe algum campo vazio por favor")
        }
    }

    private fun tensaoNula(potencia: Double?, corrente: Double?) {
        if (potencia != null && corrente != null) {
            tensaoEdt.setText("${potencia/corrente}")
            makeToast("Ali o resultado ô")
        } else {
            tensaoEdt.error = setError("tensao")
            if (corrente == null) {
                correnteEdt.error = setError("tensao")
            }
            if (potencia == null) {
                potenciaEdt.error = setError("potencia")
            }
        }
    }

    private fun correnteNula(potencia: Double?, tensao: Double?) {
        if (potencia != null && tensao != null) {
            correnteEdt.setText("${potencia/tensao}")
            makeToast("Ali o resultado ô")
        } else {
            correnteEdt.error = setError("corrente")
            if (tensao == null) {
                tensaoEdt.error = setError("tensao")
            }
            if (potencia == null) {
                potenciaEdt.error = setError("potencia")
            }
        }
    }

    private fun potenciaNula(corrente: Double?, tensao: Double?) {
        if (corrente != null && tensao != null) {
            potenciaEdt.setText("${corrente*tensao}")
            makeToast("Ali o resultado ô")
        } else {
            potenciaEdt.error = setError("potencia")
            if (tensao == null) {
                tensaoEdt.error = setError("tensao")
            }
            if (corrente == null) {
                correnteEdt.error = setError("corrente")
            }
        }
    }

    private fun setError(type: String): CharSequence? {
        return "Por favor, insira um valor para $type válido"
    }

    private fun makeToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }
}
