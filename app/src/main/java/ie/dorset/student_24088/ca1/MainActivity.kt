package ie.dorset.student_24088.ca1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import ie.dorset.student_24088.ca1.`interface`.ActivitySetter
import ie.dorset.student_24088.ca1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ActivitySetter {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(Companion.TAG, "onCreate called!")

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setMeUp(TAG, view, resources, hasTopBar = true, hasBottomBar = false)

//        binding.topBar.topBarIcon.setImageResource(R.drawable.ic_baseline_home)
//        binding.topBar.topBarText.text = resources.getString(R.string.home)

        binding.educationButton.setOnClickListener {
            val intent = Intent(this, EducationActivity::class.java)
            startActivity(intent)
        }

        binding.skillsButton.setOnClickListener {
            val intent = Intent(this, SkillsActivity::class.java)
            startActivity(intent)
        }

        binding.hobbiesButton.setOnClickListener {
            val intent = Intent(this, HobbiesActivity::class.java)
            startActivity(intent)
        }

        binding.achievementsButton.setOnClickListener {
            val intent = Intent(this, AchievementsActivity::class.java)
            startActivity(intent)
        }

        binding.exitButton.setOnClickListener {
            finish()
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
        private const val TAG = "MainActivity"
    }
}