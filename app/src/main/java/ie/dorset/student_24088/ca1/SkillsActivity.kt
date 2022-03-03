package ie.dorset.student_24088.ca1

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import ie.dorset.student_24088.ca1.`interface`.ActivitySetter
import ie.dorset.student_24088.ca1.adapter.ItemAdapter
import ie.dorset.student_24088.ca1.data.Datasource
import ie.dorset.student_24088.ca1.databinding.ActivitySkillsBinding

class SkillsActivity : AppCompatActivity(), ActivitySetter {
    private lateinit var binding: ActivitySkillsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(Companion.TAG, "onCreate called!")

        binding = ActivitySkillsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setMeUp(TAG, view, resources, hasTopBar = true, hasBottomBar = true)

//        binding.topBar.topBarIcon.setImageResource(R.drawable.ic_baseline_skills)
//        binding.topBar.topBarText.text = resources.getString(R.string.skills)
//
//        binding.bottomBar.previousButton.setIconResource(R.drawable.ic_baseline_education)
//        binding.bottomBar.previousButton.text = resources.getString(R.string.education)
//
//        binding.bottomBar.nextButton.setIconResource(R.drawable.ic_baseline_hobbies)
//        binding.bottomBar.nextButton.text = resources.getString(R.string.hobbies)

        // Initialize data.
        val myDataset = Datasource().loadContent(TAG)

        binding.itemRecyclerView.adapter = ItemAdapter(this, myDataset)

        // Use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        binding.itemRecyclerView.setHasFixedSize(true)

        binding.bottomBar.previousButton.setOnClickListener {
            val intent = Intent(this, EducationActivity::class.java)
            startActivity(intent)
        }

        binding.bottomBar.homeButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java).setFlags(FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }

        binding.bottomBar.nextButton.setOnClickListener {
            val intent = Intent(this, HobbiesActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(Companion.TAG, "onRestart called!")
    }

    override fun onStart() {
        super.onStart()
        Log.d(Companion.TAG, "onStart called!")
    }

    override fun onResume() {
        super.onResume()
        Log.d(Companion.TAG, "onResume called!")
    }

    override fun onPause() {
        super.onPause()
        Log.d(Companion.TAG, "onPause called!")
    }

    override fun onStop() {
        super.onStop()
        Log.d(Companion.TAG, "onStop called!")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(Companion.TAG, "onDestroy called!")
    }

    companion object {
        private const val TAG = "SkillsActivity"
    }
}