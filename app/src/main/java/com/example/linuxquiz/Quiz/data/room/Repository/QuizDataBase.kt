package com.example.linuxquiz.Quiz.data.room.Repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.linuxquiz.Quiz.data.room.Converters
import com.example.linuxquiz.Quiz.data.room.Question

@Database(entities = [Question::class], exportSchema = false, version = 1)
@TypeConverters(Converters::class)
abstract class QuizDataBase : RoomDatabase() {
    abstract fun quizDao(): QuizDao

    companion object {
        @Volatile
        private var INSTANCE: QuizDataBase? = null

        fun getDatabase(context: Context): QuizDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    QuizDataBase::class.java,
                    "todo_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}