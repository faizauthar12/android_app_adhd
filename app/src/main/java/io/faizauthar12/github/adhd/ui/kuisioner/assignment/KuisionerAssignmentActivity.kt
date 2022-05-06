package io.faizauthar12.github.adhd.ui.kuisioner.assignment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.faizauthar12.github.adhd.databinding.ActivityKuisionerAssignmentBinding

class KuisionerAssignmentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityKuisionerAssignmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityKuisionerAssignmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar()
    }

    private fun supportActionBar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}