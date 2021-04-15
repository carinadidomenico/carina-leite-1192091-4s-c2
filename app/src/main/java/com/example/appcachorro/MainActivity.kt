package com.example.appcachorro

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun comprar(view: View) {
        val etId1:EditText = findViewById(R.id.et_id1)
        val etId2:EditText = findViewById(R.id.et_id2)

        val id1 = etId1.text.toString().toInt()
        val id2 = etId2.text.toString().toInt()



        val apiCachorro = ConexaoApiCachorros.criar()

        var mensagem:String = ""
        val telaCompra = Intent(this, TelaCompra::class.java)

        apiCachorro.get(id1).enqueue(object : Callback<Cachorro> {
            override fun onResponse(call: Call<Cachorro>, response: Response<Cachorro>) {
                val cachorro = response.body()
                if(cachorro != null) {
                    mensagem += "Raça: ${cachorro.raca} - Preço: ${cachorro.precoMedio}"
                    telaCompra.putExtra("idCachorro1", id1)
                } else {
                    mensagem = "Deu ruim... Nenhum cachorro encontrado."
                }
            }

            override fun onFailure(call: Call<Cachorro>, t: Throwable) {
                mensagem = "Deu ruim... Nenhum cachorro encontrado."
            }
        })

        apiCachorro.get(id2).enqueue(object : Callback<Cachorro> {
            override fun onResponse(
                call: Call<Cachorro>,
                response: Response<Cachorro>
            ) {
                val cachorro = response.body()
                if(cachorro != null) {
                    mensagem += "Raça: ${cachorro.raca} - Preço: ${cachorro.precoMedio}"
                    telaCompra.putExtra("idCachorro2", id2)
                } else {
                    mensagem = "Deu ruim... Nenhum cachorro encontrado."
                }
            }

            override fun onFailure(call: Call<Cachorro>, t: Throwable) {
                mensagem = "Deu ruim... Nenhum cachorro encontrado."
            }
        })

        telaCompra.putExtra("mensagem", mensagem)
        startActivity(telaCompra)

    }

}

