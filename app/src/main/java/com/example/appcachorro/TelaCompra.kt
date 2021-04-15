package com.example.appcachorro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class TelaCompra : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_compra)

        val id1 = intent.getStringExtra("id1")
        val id2 = intent.getStringExtra("id2")
        val mensagem = intent.getStringExtra("mensagem")

        val tvResposta:TextView = findViewById(R.id.tv_resposta)

        tvResposta.text = mensagem

    }
}