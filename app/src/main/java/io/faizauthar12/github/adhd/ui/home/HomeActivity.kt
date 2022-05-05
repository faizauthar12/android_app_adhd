package io.faizauthar12.github.adhd.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.faizauthar12.github.adhd.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}