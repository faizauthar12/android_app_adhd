package io.faizauthar12.github.adhd.data.local.entity

data class AssignmentEntity(
    val assignmentId: Int,
    val assignmentCode: String,
    val assignmentDesc: String,
    var assignmentAnswer: String? = null,
)