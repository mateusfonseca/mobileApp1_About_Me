package ie.dorset.student_24088.ca1.`interface`

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP
import android.content.res.Resources
import android.view.View
import android.view.View.GONE
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.getColor
import com.google.android.material.button.MaterialButton
import ie.dorset.student_24088.ca1.*

// This interface implements methods that are shared by all activities in the application.
// The goal here is to avoid code repetition and promote reusability.
interface ActivitySetter {

    // The setMeUp method can be called by any one of the activities.
    // It allows for the activities to request setup of:
    // Top bar;
    // Bottom bar;
    // Floating buttons,
    // all of which are laid out by the same layout resources.
    fun setMeUp(
        TAG: String,
        view: View,
        resources: Resources,
        hasTopBar: Boolean,
        hasBottomBar: Boolean,
        hasFloatingButtons: Boolean,
        context: Context
    ) {
        if (hasTopBar) setTopBar(TAG, view, resources)
        if (hasBottomBar) setBottomBar(TAG, view, resources, context)
        if (hasFloatingButtons) setFloatingButtons(TAG, view, resources, context)
    }

    private fun setTopBar(TAG: String, view: View, resources: Resources) {
        lateinit var listOfIds: List<Int?>
        var i = 0

        when (TAG) {
            "EducationActivity" -> listOfIds = listOf(
                R.id.top_bar_icon,
                R.drawable.ic_baseline_education,
                R.id.top_bar_text,
                R.string.education
            )
            "SkillsActivity" -> listOfIds = listOf(
                R.id.top_bar_icon,
                R.drawable.ic_baseline_skills,
                R.id.top_bar_text,
                R.string.skills
            )
            "HobbiesActivity" -> listOfIds = listOf(
                R.id.top_bar_icon,
                R.drawable.ic_baseline_hobbies,
                R.id.top_bar_text,
                R.string.hobbies
            )
            "AchievementsActivity" -> listOfIds = listOf(
                R.id.top_bar_icon,
                R.drawable.ic_baseline_achievements,
                R.id.top_bar_text,
                R.string.achievements
            )
            "MainActivity" -> listOfIds = listOf(
                R.id.top_bar_icon,
                null, // No icon at Home
                R.id.top_bar_text,
                R.string.home
            )
        }

        while (i < listOfIds.size) {
            if (listOfIds[i + 1] == null) {
                val topBarIcon: ImageView = view.findViewById(listOfIds[i]!!)
                topBarIcon.visibility = GONE // No icon at Home
                i++
            } else {
                val topBarIcon: ImageView = view.findViewById(listOfIds[i]!!)
                topBarIcon.setImageResource(listOfIds[++i]!!)
            }
            val topBarText: TextView = view.findViewById(listOfIds[++i]!!)
            topBarText.text = resources.getString(listOfIds[++i]!!)
            i++
        }
    }

    private fun setBottomBar(TAG: String, view: View, resources: Resources, context: Context) {
        lateinit var intent: Intent
        lateinit var listOfIds: MutableList<Int?>
        var i = 0

        when (TAG) {
            "EducationActivity" -> listOfIds = mutableListOf(
                R.id.previous_button,
                null, // No previous button at Education
                null,
                R.id.next_button,
                R.drawable.ic_baseline_skills,
                R.string.skills
            )
            "SkillsActivity" -> listOfIds = mutableListOf(
                R.id.previous_button,
                R.drawable.ic_baseline_education,
                R.string.education,
                R.id.next_button,
                R.drawable.ic_baseline_hobbies,
                R.string.hobbies
            )
            "HobbiesActivity" -> listOfIds = mutableListOf(
                R.id.previous_button,
                R.drawable.ic_baseline_skills,
                R.string.skills,
                R.id.next_button,
                R.drawable.ic_baseline_achievements,
                R.string.achievements
            )
            "AchievementsActivity" -> listOfIds = mutableListOf(
                R.id.previous_button,
                R.drawable.ic_baseline_hobbies,
                R.string.hobbies,
                R.id.next_button,
                null, // No next button at Achievements
                null
            )
        }

        // Home button is present in all secondary activities
        listOfIds.addAll(
            arrayOf(
                R.id.home_button,
                R.drawable.ic_baseline_home,
                null
            )
        )

        while (i < listOfIds.size) {
            if (listOfIds[i + 1] == null) {
                val button: MaterialButton = view.findViewById(listOfIds[i]!!)
                button.visibility = GONE // No previous/next button at Education/Achievements
                i += 3
            } else {
                val button: MaterialButton = view.findViewById(listOfIds[i]!!)
                button.setIconResource(listOfIds[++i]!!)
                listOfIds[++i]?.let {
                    button.text = resources.getString(it)
                } // No text for home button
                button.setOnClickListener {
                    intent = when (button.text) {
                        "Education" -> Intent(context, EducationActivity::class.java)
                        "Skills" -> Intent(context, SkillsActivity::class.java)
                        "Hobbies" -> Intent(context, HobbiesActivity::class.java)
                        "Achievements" -> Intent(context, AchievementsActivity::class.java)
                        else -> Intent(context, MainActivity::class.java).setFlags(
                            FLAG_ACTIVITY_CLEAR_TOP
                        ) // clear back stack when back at Home
                    }
                    (context as Activity).startActivity(intent)
                }
                i++
            }
        }
    }

    private fun setFloatingButtons(
        TAG: String,
        view: View,
        resources: Resources,
        context: Context
    ) {
        lateinit var intent: Intent
        lateinit var listOfIds: List<Int?>
        var i = 0

        when (TAG) {
            "EducationActivity" -> { /* No buttons, do nothing */
            }
            "SkillsActivity" -> { /* No buttons, do nothing */
            }
            "HobbiesActivity" -> { /* No buttons, do nothing */
            }
            "AchievementsActivity" -> { /* No buttons, do nothing */
            }
            // The above was left so that it can be easily implemented if, eventually, floating buttons are added to other screens.
            // Below is for the Home screen only.
            else -> listOfIds = listOf(
                R.id.education_button,
                R.string.education,
                R.id.skills_button,
                R.string.skills,
                R.id.hobbies_button,
                R.string.hobbies,
                R.id.achievements_button,
                R.string.achievements,
                R.id.exit_button,
                R.string.exit
            )
        }

        while (i < listOfIds.size - 1) {
            if (listOfIds[i] != null) {
                val button: MaterialButton = view.findViewById(listOfIds[i]!!)
                button.text = resources.getString(listOfIds[++i]!!)
                if (button.id == R.id.exit_button) {
                    // Exit button to look different from the others
                    button.setBackgroundColor(getColor(context, R.color.primaryColor))
                    button.setTextColor(getColor(context, R.color.primaryTextColor))
                }
                button.setOnClickListener {
                    if (button.id == R.id.exit_button) {
                        // Exit button finishes application
                        (context as Activity).finish()
                    } else {
                        when (button.id) {
                            R.id.education_button -> intent =
                                Intent(context, EducationActivity::class.java)
                            R.id.skills_button -> intent =
                                Intent(context, SkillsActivity::class.java)
                            R.id.hobbies_button -> intent =
                                Intent(context, HobbiesActivity::class.java)
                            R.id.achievements_button -> intent =
                                Intent(context, AchievementsActivity::class.java)
                        }
                        (context as Activity).startActivity(intent)
                    }
                }
            }
            i++
        }
    }
}