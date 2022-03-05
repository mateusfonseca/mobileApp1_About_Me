package ie.dorset.student_24088.ca1

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import ie.dorset.student_24088.ca1.`interface`.ActivitySetter
import ie.dorset.student_24088.ca1.databinding.ActivityMainBinding

// This class implements one of the secondary activities in the application.
// Notice that it extends the ActivitySetter interface.
class MainActivity : AppCompatActivity(), ActivitySetter {
    private lateinit var bindingMain: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate called!") // Only for debugging purposes

        // Inflates the associated layout via view binding
        bindingMain = ActivityMainBinding.inflate(layoutInflater)
        val view = bindingMain.root
        setContentView(view)

        // Calls ActivitySetter's setMeUp.
        // Main Activity has a top bar and floating buttons, but no bottom bar.
        setMeUp(TAG, view, resources, hasTopBar = true, hasBottomBar = false, true, this)
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
        private const val TAG = "MainActivity"
    }
}