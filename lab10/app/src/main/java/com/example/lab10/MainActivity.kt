package com.example.lab10

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.lab10.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getTodos()

        binding.button.setOnClickListener {
            addTodo()
        }
    }

    private fun getTodos(){
        val retrofit = RetrofitClient.getInstance()
        val apiInterface = retrofit.create(ApiInterface::class.java)
        lifecycleScope.launch {
            val response = apiInterface.getTodos()
            binding.txtData.text = response.body()?.title
            print(response.body()?.title)
        }
    }

    private fun addTodo(){
        val retrofit = RetrofitClient.getInstance()
        val apiInterface = retrofit.create(ApiInterface::class.java)
        lifecycleScope.launch {
            try {
                val todo = Todo(
                    userId = 999,
                    id = 999,
                    title = "new todo",
                    completed = false,
                )
                val response = apiInterface.addTodo(todo)
                if (response.isSuccessful && response.body() != null) {
                    Toast.makeText(applicationContext, "new todo with id ${response.body()?.id} created", Toast.LENGTH_SHORT).show()
                }
            } catch (Ex: Exception) {
                Toast.makeText(applicationContext, "error", Toast.LENGTH_SHORT).show()
            }
        }
    }
}