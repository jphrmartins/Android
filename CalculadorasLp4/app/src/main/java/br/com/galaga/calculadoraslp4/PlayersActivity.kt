package br.com.galaga.calculadoraslp4

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_players.*
import kotlinx.android.synthetic.main.content_players.*

class PlayersActivity : AppCompatActivity() {

    var jogadores = ArrayList<Jogador>()

    companion object {
        val NEWJOGADOR = 1
        val EDITJOGADOR = 2
        val DELETEJOGADOR = 4545
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_players)
        setSupportActionBar(toolbar)

        fab.setOnClickListener {
            detail()
        }
        val adapter = ArrayAdapter<Jogador>(baseContext, android.R.layout.simple_list_item_1, jogadores)
        listView.adapter = adapter
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        listView.setOnItemClickListener { parent, view, position, id ->
            val jogador = jogadores.get(position)
            jogador.position = position
            Log.d("JOGADOR SELECIONADO ->", "$jogador")
            detail(jogador)
        }


        listView.setOnItemLongClickListener { parent, view, position, id ->
            val jogador = jogadores.get(position)
            Snackbar.make(view, "Jogador ${jogador.nome} selecionado", Snackbar.LENGTH_LONG)
                    .setAction("DELETE", View.OnClickListener {
                        val jogador = jogadores.get(position)
                        jogadores.remove(jogador)
                        val adapter = ArrayAdapter<Jogador>(baseContext, android.R.layout.simple_list_item_1, jogadores)
                        listView.adapter = adapter

                    }).show()
            true
        }
    }
    fun detail(jogador: Jogador? = null) {
        val intent = Intent(baseContext, PlayersDetailActivity::class.java)
        if (jogador != null){
            intent.putExtra("nome", jogador.nome)
            intent.putExtra("quedas", jogador.quedas)
            intent.putExtra("gols", jogador.gols)
            intent.putExtra("editable", true)
            intent.putExtra("requestCode", EDITJOGADOR)
            intent.putExtra("position", jogador.position)
            startActivityForResult(intent, EDITJOGADOR)
            return
        }
        startActivityForResult(intent, NEWJOGADOR)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data != null){
            if (resultCode == NEWJOGADOR){
                addNewJogador(data)
            } else if (resultCode == EDITJOGADOR) {
                editJogador(data)
            } else if (requestCode == NEWJOGADOR && resultCode == DELETEJOGADOR){
                Toast.makeText(baseContext, "Acho que ta faltando um botão de voltar..", Toast.LENGTH_LONG).show()
            } else if (resultCode == DELETEJOGADOR){
                deletJogador(data)
            }
        }
    }

    private fun deletJogador(data: Intent) {
        val position = data.getIntExtra("position", 0)
        jogadores.removeAt(position)
        val adapter = ArrayAdapter<Jogador>(baseContext, android.R.layout.simple_list_item_1, jogadores)
        listView.adapter = adapter
    }

    private fun editJogador(data: Intent) {
        val nome = data.getStringExtra("nome")
        val gols = data.getStringExtra("gols")
        val quedas = data.getStringExtra("quedas")
        val jogador = Jogador(nome, gols, quedas)
        jogadores.set(data.getIntExtra("position", 0), jogador)
        val adapter = ArrayAdapter<Jogador>(baseContext, android.R.layout.simple_list_item_1, jogadores)
        listView.adapter = adapter
    }

    private fun addNewJogador(data: Intent) {
        val nome = data.getStringExtra("nome")
        val gols = data.getStringExtra("gols")
        val quedas = data.getStringExtra("quedas")
        val jogador = Jogador(nome, gols, quedas)
        jogadores.add(jogador)
        val adapter = ArrayAdapter<Jogador>(baseContext, android.R.layout.simple_list_item_1, jogadores)
        listView.adapter = adapter
    }
}
