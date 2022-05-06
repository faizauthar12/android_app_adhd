package io.faizauthar12.github.adhd.ui.kuisioner.assignment

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import io.faizauthar12.github.adhd.BuildConfig
import io.faizauthar12.github.adhd.R
import io.faizauthar12.github.adhd.databinding.ActivityKuisionerAssignmentBinding
import io.faizauthar12.github.adhd.databinding.ContentKuisionerAssignmentBinding

class KuisionerAssignmentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityKuisionerAssignmentBinding
    private lateinit var contentDetail: ContentKuisionerAssignmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityKuisionerAssignmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        contentDetail = binding.contentDetail

        supportActionBar()
        PopulateContent()
        onRadioButtonClicked(contentDetail.radioGroup)
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

    private fun PopulateContent() {
        contentDetail.tvKodeGejala.text = "Kode Gejala: G001"
        contentDetail.tvIndikator.text = "1 / 35"
        contentDetail.tvDeskripsiGejala.text = "Gagal memberikan perhatian penuh pada detail"
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