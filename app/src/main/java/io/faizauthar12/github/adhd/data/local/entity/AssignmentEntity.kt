package io.faizauthar12.github.adhd.data.local.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AssignmentEntity(
    val assignmentId: Int,
    val assignmentCode: String,
    val assignmentDesc: String,
    var assignmentAnswer: String? = null,
) : Parcelable