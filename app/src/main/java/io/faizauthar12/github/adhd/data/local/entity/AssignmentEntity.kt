package io.faizauthar12.github.adhd.data.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "AssignmentEntity")
data class AssignmentEntity(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "assignmentId")
    val assignmentId: Int,

    @ColumnInfo(name = "assignmentCode")
    val assignmentCode: String,

    @ColumnInfo(name = "assignmentDesc")
    val assignmentDesc: String,
)