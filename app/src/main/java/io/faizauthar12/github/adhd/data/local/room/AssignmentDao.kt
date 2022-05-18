package io.faizauthar12.github.adhd.data.local.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import io.faizauthar12.github.adhd.data.local.entity.AssignmentEntity

@Dao
interface AssignmentDao {

    @Query("SELECT * FROM AssignmentEntity where assignmentId = :assignmentId")
    fun getAssignmentById(assignmentId: Int): LiveData<List<AssignmentEntity>>
}