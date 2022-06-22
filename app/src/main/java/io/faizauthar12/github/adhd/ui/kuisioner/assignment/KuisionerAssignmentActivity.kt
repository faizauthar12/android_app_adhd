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
    private var mAssignmentAnswer: String? = null
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
            BuildConfig.DEBUG.apply {
                Log.d(
                    TAG,
                    "btPrevious: assignmentIndex: ${assignmentIndex}"
                )
                Log.d(TAG, "btnPrevious: mAssignmentAnswer: " + mAssignmentAnswer)
            }
        }

        contentDetail.btNext.setOnClickListener {
            assignments[assignmentIndex].assignmentAnswer = mAssignmentAnswer
            assignmentIndex += 1
            PopulateContent(assignments)
            BuildConfig.DEBUG.apply {
                Log.d(TAG, "btNext: assignmentIndex: ${assignmentIndex}")
                Log.d(TAG, "btnNext: mAssignmentAnswer: " + mAssignmentAnswer)
            }
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
                        mAssignmentAnswer = "Ya"
                        BuildConfig.DEBUG.apply {
                            Log.d(TAG, "onRadioButtonClicked: Ya")
                            Log.d(TAG, "mAssignmentAnswer: " + mAssignmentAnswer)
                        }
                    }
                R.id.rb_2 ->
                    if (checked) {
                        mAssignmentAnswer = "Mungkin"
                        BuildConfig.DEBUG.apply {
                            Log.d(TAG, "onRadioButtonClicked: Mungkin")
                            Log.d(TAG, "mAssignmentAnswer: " + mAssignmentAnswer)
                        }
                    }
                R.id.rb_3 -> {
                    if (checked) {
                        mAssignmentAnswer = "Tidak"
                        BuildConfig.DEBUG.apply {
                            Log.d(TAG, "onRadioButtonClicked: Tidak")
                            Log.d(TAG, "mAssignmentAnswer: " + mAssignmentAnswer)
                        }
                    }
                }
            }
        }
    }

    private fun PopulateContent(assignments: List<AssignmentEntity>) {
        checkFirstQuestion()
        checkAnswerIsNull(assignments)
        assignPreviousAnswer(assignments)

        contentDetail.tvKodeGejala.text =
            "Kode Gejala: ${assignments[assignmentIndex].assignmentCode}"
        contentDetail.tvIndikator.text = "${assignmentIndex + 1} / ${assignments.size}"
        contentDetail.tvDeskripsiGejala.text = assignments[assignmentIndex].assignmentDesc
        contentDetail.rb1.text = "Ya"
        contentDetail.rb2.text = "Mungkin"
        contentDetail.rb3.text = "Tidak"
    }

    private fun checkFirstQuestion() {
        if (assignmentIndex == 0) {
            contentDetail.btPrevious.visibility = View.INVISIBLE
        } else {
            contentDetail.btPrevious.visibility = View.VISIBLE
        }
    }

    private fun checkAnswerIsNull(assignments: List<AssignmentEntity>) {
        contentDetail.btNext.isEnabled = assignments[assignmentIndex].assignmentAnswer != null

        if (assignments[assignmentIndex].assignmentAnswer == null) {
            contentDetail.radioGroup.clearCheck()
        }
    }

    private fun assignPreviousAnswer(assignments: List<AssignmentEntity>) {
        when (assignments[assignmentIndex].assignmentAnswer) {
            "Ya" -> {
                contentDetail.rb1.isChecked = true
                mAssignmentAnswer = "Ya"
            }
            "Mungkin" -> {
                contentDetail.rb2.isChecked = true
                mAssignmentAnswer = "Mungkin"
            }
            "Tidak" -> {
                contentDetail.rb3.isChecked = true
                mAssignmentAnswer = "Tidak"
            }
        }
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