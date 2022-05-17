package io.faizauthar12.github.adhd.ui.kuisioner.assignment

import androidx.lifecycle.ViewModel
import io.faizauthar12.github.adhd.data.local.entity.AssignmentEntity
import io.faizauthar12.github.adhd.utils.dummy.AssignmentDummy

class KuisionerAssignmentViewModel : ViewModel() {

    fun getAssignemnt(): List<AssignmentEntity> = AssignmentDummy.generateAssignmentDummy()
}