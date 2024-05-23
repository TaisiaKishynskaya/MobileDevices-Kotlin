package com.example.lab9

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab9.Entities.Note

class NoteAdapter(
    private val notes: List<Note>,
    private val onItemClicked: (Note) -> Unit
) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    class NoteViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textTextView: TextView = view.findViewById(R.id.noteText)
	val dateTextView: TextView = view.findViewById(R.id.noteDate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_item, parent, false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notes[position]
        holder.textTextView.text = note.text
        holder.dateTextView.text = note.date

        holder.itemView.setOnClickListener {
            onItemClicked(note)
        }
    }

    override fun getItemCount(): Int = notes.size
}
