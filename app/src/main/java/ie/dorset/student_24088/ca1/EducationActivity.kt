package ie.dorset.student_24088.ca1

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.setPadding
import androidx.recyclerview.widget.RecyclerView
import ie.dorset.student_24088.ca1.`interface`.ActivitySetter
import ie.dorset.student_24088.ca1.adapter.ItemAdapter
import ie.dorset.student_24088.ca1.data.Datasource
import ie.dorset.student_24088.ca1.databinding.ActivityEducationBinding
import kotlin.math.abs

class EducationActivity : AppCompatActivity(), ActivitySetter {
    private lateinit var binding: ActivityEducationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate called!")

        binding = ActivityEducationBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setMeUp(TAG, view, resources, hasTopBar = true, hasBottomBar = true)

//        binding.topBar.topBarIcon.setImageResource(R.drawable.ic_baseline_education)
//        binding.topBar.topBarText.text = resources.getString(R.string.education)
//
//        binding.bottomBar.nextButton.setIconResource(R.drawable.ic_baseline_skills)
//        binding.bottomBar.nextButton.text = resources.getString(R.string.skills)

        // Initialize data.
        val myDataset = Datasource().loadContent(TAG)

        binding.itemRecyclerView.adapter = ItemAdapter(this, myDataset)

        binding.bottomBar.previousButton.isClickable = false

        binding.bottomBar.homeButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java).setFlags(FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }

        binding.bottomBar.nextButton.setOnClickListener {
            val intent = Intent(this, SkillsActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart called!")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart called!")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume called!")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause called!")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop called!")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy called!")
    }

    companion object {
        private const val TAG = "EducationActivity"
    }
}