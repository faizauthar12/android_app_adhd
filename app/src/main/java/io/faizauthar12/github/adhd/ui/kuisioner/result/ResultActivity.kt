package io.faizauthar12.github.adhd.ui.kuisioner.result

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.faizauthar12.github.adhd.R
import io.faizauthar12.github.adhd.data.local.entity.AssignmentEntity
import io.faizauthar12.github.adhd.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    private var data: AssignmentEntity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val answer = intent.extras
        if (answer != null) {
            data = intent.getParcelableExtra(EXTRA_RESULT)
        }
    }

    companion object {
        const val EXTRA_RESULT = "extra_result"
    }
}