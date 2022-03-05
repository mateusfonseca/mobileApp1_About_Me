package ie.dorset.student_24088.ca1

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import ie.dorset.student_24088.ca1.`interface`.ActivitySetter
import ie.dorset.student_24088.ca1.adapter.ItemAdapter
import ie.dorset.student_24088.ca1.data.Datasource
import ie.dorset.student_24088.ca1.databinding.ActivityAchievementsBinding

// This class implements one of the secondary activities in the application.
// Notice that it extends the ActivitySetter interface.
class AchievementsActivity : AppCompatActivity(), ActivitySetter {
    private lateinit var binding: ActivityAchievementsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate called!") // Only for debugging purposes

        // Inflates the associated layout via view binding
        binding = ActivityAchievementsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Calls ActivitySetter's setMeUp.
        // Achievements Activity has both a top bar and a bottom bar, but no floating buttons.
        setMeUp(TAG, view, resources, hasTopBar = true, hasBottomBar = true, false, this)

        // Loads content from datasource
        val myDataset = Datasource().loadContent(TAG)

        // Calls the adapter to lay out the recycler view
        binding.itemRecyclerView.adapter = ItemAdapter(this, myDataset)
    }

    // Only for debugging purposes
    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart called!")
    }

    // Only for debugging purposes
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart called!")
    }

    // Only for debugging purposes
    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume called!")
    }

    // Only for debugging purposes
    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause called!")
    }

    // Only for debugging purposes
    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop called!")
    }

    // Only for debugging purposes
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy called!")
    }

    // TAG used to identify the activity.
    // Debugging purposes and on ActivitySetter call
    companion object {
        private const val TAG = "AchievementsActivity"
    }
}