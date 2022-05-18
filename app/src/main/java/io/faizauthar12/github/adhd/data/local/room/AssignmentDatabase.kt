package io.faizauthar12.github.adhd.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import io.faizauthar12.github.adhd.data.local.entity.AssignmentEntity

@Database(entities = [AssignmentEntity::class], version = 1, exportSchema = false)
abstract class AssignmentDatabase : RoomDatabase() {
    abstract fun academyDao(): AssignmentDao

    companion object {

        @Volatile
        private var INSTANCE: AssignmentDatabase? = null

        fun getInstance(context: Context): AssignmentDatabase =
            INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    AssignmentDatabase::class.java,
                    "Assignments.db"
                ).build().apply {
                    INSTANCE = this
                }
            }
    }
}