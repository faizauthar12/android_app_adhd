package io.faizauthar12.github.adhd.ui.kuisioner.result

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.faizauthar12.github.adhd.R
import io.faizauthar12.github.adhd.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}