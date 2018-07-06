package br.com.galaga.calculadoraslp4

import java.text.FieldPosition

class Jogador ( val nome:String, val gols:String, val quedas:String, var position: Int? = null) {
    override fun toString(): String {
        return "nome: $nome, gols: $gols, quedas: $quedas"
    }
}