package com.example.lab9

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.lab9.Database.AppDatabase
import com.example.lab9.Entities.Note
import com.example.lab9.databinding.ActivityMainBinding
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "notes"
        ).fallbackToDestructiveMigration().allowMainThreadQueries().build()
        
	val recyclerView: RecyclerView = binding.placesRecycler
        recyclerView.layoutManager = LinearLayoutManager(this)

        binding.button2.setOnClickListener {
            val notes: List<Note> = db.noteDao().getAll()
            val noteAdapter: NoteAdapter = NoteAdapter(notes) { note ->
                db.noteDao().delete(note)
		updateRecyclerView(db)
            }
            recyclerView.adapter = noteAdapter
        }

        binding.button.setOnClickListener {
            val note = Note(
                text = binding.textEdit.text.toString(),
                date = LocalDateTime.parse(binding.dateEdit.text.toString(), DateTimeFormatter.ofPattern("yyyy/MM/dd"))
            )
            db.noteDao().insert(note)
            updateRecyclerView()
        }

	binding.dateEdit.setOnClickListener {
            showDatePickerDialog()
        }

        val currentDateFormatted = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"))
        binding.dateEdit.setText(currentDateFormatted)
    }


    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            { _, selectedYear, selectedMonth, selectedDay ->
                // Formatting the selected date
                val selectedDate = LocalDateTime.of(selectedYear, selectedMonth + 1, selectedDay, 0, 0)
                val formattedDate = selectedDate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"))
                binding.dateEdit.setText(formattedDate)
            },
            year, month, day
        )
        datePickerDialog.show()
    }
}