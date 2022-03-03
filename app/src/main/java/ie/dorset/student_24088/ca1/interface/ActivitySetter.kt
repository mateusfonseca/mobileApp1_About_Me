package ie.dorset.student_24088.ca1.`interface`

import android.content.Context
import android.content.res.Resources
import android.icu.text.DisplayContext
import android.media.Image
import android.util.Log
import android.view.View
import android.view.View.GONE
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone
import androidx.viewbinding.ViewBinding
import com.google.android.material.button.MaterialButton
import ie.dorset.student_24088.ca1.*
import ie.dorset.student_24088.ca1.databinding.*
import ie.dorset.student_24088.ca1.model.Content
import javax.xml.transform.Source

interface ActivitySetter {
    fun setMeUp(
        TAG: String,
        view: View,
        resources: Resources,
        hasTopBar: Boolean,
        hasBottomBar: Boolean
    ) {
        if (hasTopBar) setTopBar(TAG, view, resources)
        if (hasBottomBar) setBottomBar(TAG, view, resources)
    }

    private fun setTopBar(TAG: String, view: View, resources: Resources) {
        lateinit var listOfIds: List<Int?>
        var i: Int = 0

        when (TAG) {
            "EducationActivity" -> listOfIds = listOf(
                R.drawable.ic_baseline_education,
                R.string.education
            )
            "SkillsActivity" -> listOfIds = listOf(
                R.drawable.ic_baseline_skills,
                R.string.skills
            )
            "HobbiesActivity" -> listOfIds = listOf(
                R.drawable.ic_baseline_hobbies,
                R.string.hobbies
            )
            "AchievementsActivity" -> listOfIds = listOf(
                R.drawable.ic_baseline_achievements,
                R.string.achievements
            )
            else -> listOfIds = listOf(
                null,
                R.string.home
            )
        }

        if (listOfIds[i] != null) {
            val topBarIcon: ImageView = view.findViewById(R.id.top_bar_icon)
            topBarIcon.setImageResource(listOfIds[i]!!)
        } else {
            val topBarIcon: ImageView = view.findViewById(R.id.top_bar_icon)
            topBarIcon.visibility = GONE
        }

        if (listOfIds[++i] != null) {
            val topBarText: TextView = view.findViewById(R.id.top_bar_text)
            topBarText.text = resources.getString(listOfIds[i]!!)
        }
    }

    private fun setBottomBar(TAG: String, view: View, resources: Resources) {
        lateinit var listOfIds: List<Int?>
        var i: Int = 0

        when (TAG) {
            "EducationActivity" -> listOfIds = listOf(
                null,
                null,
                R.drawable.ic_baseline_skills,
                R.string.skills
            )
            "SkillsActivity" -> listOfIds = listOf(
                R.drawable.ic_baseline_education,
                R.string.education,
                R.drawable.ic_baseline_hobbies,
                R.string.hobbies
            )
            "HobbiesActivity" -> listOfIds = listOf(
                R.drawable.ic_baseline_skills,
                R.string.skills,
                R.drawable.ic_baseline_achievements,
                R.string.achievements
            )
            "AchievementsActivity" -> listOfIds = listOf(
                R.drawable.ic_baseline_hobbies,
                R.string.hobbies,
                null,
                null
            )
        }

        if (listOfIds[i] != null) {
            val bottomBarPreviousButton: MaterialButton = view.findViewById(R.id.previous_button)
            bottomBarPreviousButton.setIconResource(listOfIds[i]!!)
            bottomBarPreviousButton.text = resources.getString(listOfIds[++i]!!)
        } else {
            val bottomBarPreviousButton: MaterialButton = view.findViewById(R.id.previous_button)
            bottomBarPreviousButton.visibility = GONE
        }

        i=+2
        if (listOfIds[i] != null) {
            val bottomBarNextButton: MaterialButton = view.findViewById(R.id.next_button)
            bottomBarNextButton.setIconResource(listOfIds[i]!!)
            bottomBarNextButton.text = resources.getString(listOfIds[++i]!!)
        } else {
            val bottomBarNextButton: MaterialButton = view.findViewById(R.id.next_button)
            bottomBarNextButton.visibility = GONE
        }
    }
}


//    fun superBinding() {
//        binding = ActivityEducationBinding.inflate(layoutInflater)
//        val view = binding.root
//        setContentView(view)
//    }
//
//    fun buildTopBar(binding: ViewBinding, resources: Resources, icon: Int?, text: Int) {
//        binding as BarTopBinding
//        if (icon != null) binding.topBarIcon.setImageResource(icon)
//        binding.topBarText.text = resources.getString(text)
//    }
//
//    fun buildBottomBar(binding: ViewBinding, resources: Resources, iconPrevious: Int?, textPrevious: Int?, iconNext: Int?, textNext: Int?) {
//        binding as BarBottomBinding
//        when {
//            (iconPrevious == null) or (textPrevious == null) -> {
//                binding.nextButton.setCompoundDrawablesWithIntrinsicBounds(
//                    0,
//                    iconNext!!, 0, 0
//                )
//                binding.nextButton.text = resources.getString(textNext!!)
//            }
//            (iconNext == null) or (textNext == null) -> {
//                binding.previousButton.setCompoundDrawablesWithIntrinsicBounds(
//                    0,
//                    iconPrevious!!, 0, 0
//                )
//                binding.previousButton.text = resources.getString(textPrevious!!)
//            }
//            else -> {
//                binding.previousButton.setCompoundDrawablesWithIntrinsicBounds(
//                    0,
//                    iconPrevious!!, 0, 0
//                )
//                binding.previousButton.text = resources.getString(textPrevious!!)
//
//                binding.nextButton.setCompoundDrawablesWithIntrinsicBounds(
//                    0,
//                    iconNext!!, 0, 0
//                )
//                binding.nextButton.text = resources.getString(textNext!!)
//            }
//        }
//    }
//}