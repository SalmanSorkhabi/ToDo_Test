package com.example.todo_test

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todo_test.model.Task

class TaskAdapter():RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    val tasks:MutableList<Task> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_task,parent,false))
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bindTask(tasks[position])
    }

    fun addItem(task: Task){
        tasks.add(0,task)
        notifyItemInserted(0)
    }

    fun deleteAll(){
        this.tasks.clear()
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = tasks.size


    class TaskViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val txtTitle : TextView = itemView.findViewById(R.id.txt_taskTitle)

        fun bindTask(task: Task){
            txtTitle.text = task.taskTitle
        }
    }

}