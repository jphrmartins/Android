package br.com.galaga.calculadoraslp4

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.Toast

class PrincipalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)
    }

    fun mapa(view: View){
        val intent = Intent(baseContext, MapsActivity::class.java)
        startActivity(intent)
    }

    fun refri(view:View){
        val intent = Intent(baseContext, RefrigerometroActivity::class.java)
        startActivity(intent)
    }

    fun energia(view: View){
        val intent = Intent(baseContext, EnergiaActivity::class.java)
        startActivity(intent)
    }

    fun players(view: View){
        val intent = Intent(baseContext, PlayersActivity::class.java)
        startActivity(intent)
    }
}
