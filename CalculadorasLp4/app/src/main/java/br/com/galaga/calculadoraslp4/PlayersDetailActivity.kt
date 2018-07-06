package br.com.galaga.calculadoraslp4

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log

import kotlinx.android.synthetic.main.activity_players_detail.*
import kotlinx.android.synthetic.main.content_players_detail.*

class PlayersDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_players_detail)
        setSupportActionBar(toolbar)
        fab.setOnClickListener {
                val intentResult = Intent()
                intentResult.putExtra("nome", edtNome.text.toString())
                intentResult.putExtra("quedas", edtQuedas.text.toString())
                intentResult.putExtra("gols", edtGols.text.toString())
                intentResult.putExtra("position", intent.getIntExtra("position", 0))
                setResult(intent.getIntExtra("requestCode", PlayersActivity.NEWJOGADOR), intentResult)
                finish()
        }
        edtNome.setText(intent.getStringExtra("nome"))
        edtQuedas.setText(intent.getStringExtra("quedas"))
        edtGols.setText(intent.getStringExtra("gols"))
    }

}
