package com.example.linuxquiz.Quiz.data.room.Repository

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
import com.example.linuxquiz.Quiz.data.room.Question
import kotlinx.coroutines.flow.Flow

@Dao
interface QuizDao {
    @Query("SELECT * FROM Quiz_table WHERE id = :quizId")
    fun getQuiz(quizId: Int): Flow<List<Question>>

    @Query("SELECT * FROM Quiz_table")
    fun getAllQuizzes(): Flow<List<Question>>

    @Update
    suspend fun update(question: Question)
}