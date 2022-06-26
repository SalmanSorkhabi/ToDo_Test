package com.example.todo_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todo_test.databinding.ActivityMainBinding
import com.example.todo_test.model.Task

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val taskAdapter = TaskAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener {
            insertDataToDatabase()
        }

        binding.btnDeleteAll.setOnClickListener {
            taskAdapter.deleteAll()
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)
        binding.recyclerView.adapter = taskAdapter

    }

    private fun insertDataToDatabase() {
        val taskTitle = binding.etTaskTitle.text.toString()

        if (binding.etTaskTitle.length()>0){
            val task = Task(taskTitle)
            taskAdapter.addItem(task)
            binding.etTaskTitle.text.clear()
            Toast.makeText(this,"Successfully",Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show()
            binding.etTaskTitle.error = "لطفا عنوان را وارد کنید"
        }
    }
}