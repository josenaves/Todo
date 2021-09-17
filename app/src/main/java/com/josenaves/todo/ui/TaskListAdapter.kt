package com.josenaves.todo.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.josenaves.todo.R
import com.josenaves.todo.model.Task

class TaskListAdapter(private val taskList: List<Task> = mutableListOf()) : RecyclerView.Adapter<TaskListAdapter.TodoItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.task_item_layout, parent, false)
        return TodoItemViewHolder(itemView)
    }

    override fun getItemCount(): Int = taskList.size

    override fun onBindViewHolder(holder: TodoItemViewHolder, position: Int) {
        holder.bind(taskList[position])
    }

    class TodoItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val checkDone: CheckBox = view.findViewById(R.id.checkbox_done)
        private val taskTitle: TextView = view.findViewById(R.id.task_title)

        private var currentTask: Task? = null

        fun bind(task: Task) {
            currentTask = task
            task.run {
                checkDone.isChecked = task.done
                taskTitle.text = task.description
            }
        }
    }
}