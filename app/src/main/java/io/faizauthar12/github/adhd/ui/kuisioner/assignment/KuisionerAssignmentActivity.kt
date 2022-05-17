package io.faizauthar12.github.adhd.ui.kuisioner.assignment

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import io.faizauthar12.github.adhd.BuildConfig
import io.faizauthar12.github.adhd.R
import io.faizauthar12.github.adhd.data.local.entity.AssignmentEntity
import io.faizauthar12.github.adhd.databinding.ActivityKuisionerAssignmentBinding
import io.faizauthar12.github.adhd.databinding.ContentKuisionerAssignmentBinding

class KuisionerAssignmentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityKuisionerAssignmentBinding
    private lateinit var contentDetail: ContentKuisionerAssignmentBinding
    private var assignmentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityKuisionerAssignmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        contentDetail = binding.contentDetail

        val viewModel =
            ViewModelProvider(this).get(KuisionerAssignmentViewModel::class.java)
        val assignments = viewModel.getAssignemnt()

        supportActionBar()
        PopulateContent(assignments)
        onRadioButtonClicked(contentDetail.radioGroup)

        contentDetail.btPrevious.setOnClickListener {
            assignmentIndex -= 1
            PopulateContent(assignments)
            contentDetail.radioGroup.clearCheck()
            BuildConfig.DEBUG.apply { Log.d(TAG, "onCreate: assignmentIndex: ${assignmentIndex}") }
        }

        contentDetail.btNext.setOnClickListener {
            assignmentIndex += 1
            PopulateContent(assignments)
            contentDetail.radioGroup.clearCheck()
            BuildConfig.DEBUG.apply { Log.d(TAG, "onCreate: assignmentIndex: ${assignmentIndex}") }
        }
    }

    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            val checked = view.isChecked
            if (checked) {
                contentDetail.btNext.isEnabled = checked
            }
            when (view.getId()) {
                R.id.rb_1 ->
                    if (checked) {
                        BuildConfig.DEBUG.apply { Log.d(TAG, "onRadioButtonClicked: Ya") }
                    }
                R.id.rb_2 ->
                    if (checked) {
                        BuildConfig.DEBUG.apply { Log.d(TAG, "onRadioButtonClicked: Mungkin") }
                    }
                R.id.rb_3 -> {
                    if (checked) {
                        BuildConfig.DEBUG.apply { Log.d(TAG, "onRadioButtonClicked: Tidak") }
                    }
                }
            }
        }
    }

    private fun PopulateContent(assignments: List<AssignmentEntity>) {
        if (assignmentIndex == 0) {
            contentDetail.btPrevious.visibility = View.INVISIBLE
        } else {
            contentDetail.btPrevious.visibility = View.VISIBLE
        }

        contentDetail.tvKodeGejala.text =
            "Kode Gejala: ${assignments[assignmentIndex].assignmentCode}"
        contentDetail.tvIndikator.text = "${assignmentIndex + 1} / ${assignments.size}"
        contentDetail.tvDeskripsiGejala.text = assignments[assignmentIndex].assignmentDesc
        contentDetail.rb1.text = "Ya"
        contentDetail.rb2.text = "Mungkin"
        contentDetail.rb3.text = "Tidak"
        contentDetail.btNext.isEnabled = false
    }

    private fun supportActionBar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    companion object {
        const val TAG = "Kuisioner Assignment"
    }
}