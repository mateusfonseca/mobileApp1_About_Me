package ie.dorset.student_24088.ca1.data

import android.widget.ImageView
import ie.dorset.student_24088.ca1.R
import ie.dorset.student_24088.ca1.model.Content

class Datasource {
    fun loadContent(TAG: String): List<Content> {
        return when (TAG) {
            "EducationActivity" -> educationList()
            "SkillsActivity" -> skillsList()
            "HobbiesActivity" -> hobbiesList()
            else -> achievementsList()
        }
    }

    private fun educationList(): List<Content> {
        return listOf(
            Content(R.string.bachelors_title, R.string.bachelors_description, listOf<Int>(R.drawable.dorset_college)),
            Content(R.string.technicians_title, R.string.technicians_description, listOf<Int>(R.drawable.colegio_sao_miguel))
        )
    }

    private fun skillsList(): List<Content> {
        return listOf(
            Content(R.string.oop_title, R.string.oop_description, listOf<Int>(R.drawable.ic_python, R.drawable.ic_c_sharp, R.drawable.ic_cpp, R.drawable.ic_java, R.drawable.ic_kotlin)),
            Content(R.string.web_dev_title, R.string.web_dev_description, listOf<Int>(R.drawable.ic_html, R.drawable.ic_css, R.drawable.ic_javascript, R.drawable.ic_mysql, R.drawable.ic_nodejs)),
            Content(R.string.mobile_dev_title, R.string.mobile_dev_description, listOf<Int>(R.drawable.ic_android, R.drawable.ic_android_studio)),
            Content(R.string.languages_title, R.string.languages_description, listOf<Int>(R.drawable.ic_flag_brazil, R.drawable.ic_flag_usa))
        )
    }

    private fun hobbiesList(): List<Content> {
        return listOf(
            Content(R.string.music_title, R.string.music_description, listOf<Int>(R.drawable.images_and_words)),
            Content(R.string.tv_and_cinema_title, R.string.tv_and_cinema_description, listOf<Int>(R.drawable.star_wars)),
            Content(R.string.video_games_title, R.string.video_games_description, listOf<Int>(R.drawable.final_fantasy_8)),
            Content(R.string.sports_title, R.string.sports_description, listOf<Int>(R.drawable.vasco_da_gama)),
            Content(R.string.books_title, R.string.books_description, listOf<Int>(R.drawable.hobbit))
        )
    }

    private fun achievementsList(): List<Content> {
        return listOf(
            Content(R.string.app_name, R.string.achievements, listOf<Int>(R.drawable.profile_picture)),
            Content(R.string.app_name, R.string.achievements, listOf<Int>(R.drawable.profile_picture)),
            Content(R.string.app_name, R.string.achievements, listOf<Int>(R.drawable.profile_picture)),
            Content(R.string.app_name, R.string.achievements, listOf<Int>(R.drawable.profile_picture)),
            Content(R.string.app_name, R.string.achievements, listOf<Int>(R.drawable.profile_picture)),
            Content(R.string.app_name, R.string.achievements, listOf<Int>(R.drawable.profile_picture)),
            Content(R.string.app_name, R.string.achievements, listOf<Int>(R.drawable.profile_picture)),
            Content(R.string.app_name, R.string.achievements, listOf<Int>(R.drawable.profile_picture)),
            Content(R.string.app_name, R.string.achievements, listOf<Int>(R.drawable.profile_picture)),
            Content(R.string.app_name, R.string.achievements, listOf<Int>(R.drawable.profile_picture))
        )
    }
}