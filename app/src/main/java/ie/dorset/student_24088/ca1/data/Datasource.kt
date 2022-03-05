package ie.dorset.student_24088.ca1.data

import ie.dorset.student_24088.ca1.R
import ie.dorset.student_24088.ca1.model.Content

// This class implements a source for the data content used to feed the recycler views.
class Datasource {

    // Main function loadContent returns a list of objects of type Content.
    // The contents of this list vary depending on which activity called the method.
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
            Content(
                R.string.bachelors_title,
                R.string.bachelors_description,
                listOf(R.drawable.dorset_college)
            ),
            Content(
                R.string.technicians_title,
                R.string.technicians_description,
                listOf(R.drawable.colegio_sao_miguel)
            )
        )
    }

    private fun skillsList(): List<Content> {
        return listOf(
            Content(
                R.string.oop_title,
                R.string.oop_description,
                listOf(
                    R.drawable.ic_python,
                    R.drawable.ic_c_sharp,
                    R.drawable.ic_cpp,
                    R.drawable.ic_java,
                    R.drawable.ic_kotlin
                )
            ),
            Content(
                R.string.web_dev_title,
                R.string.web_dev_description,
                listOf(
                    R.drawable.ic_html,
                    R.drawable.ic_css,
                    R.drawable.ic_javascript,
                    R.drawable.ic_mysql,
                    R.drawable.ic_nodejs
                )
            ),
            Content(
                R.string.mobile_dev_title,
                R.string.mobile_dev_description,
                listOf(R.drawable.ic_android, R.drawable.ic_android_studio)
            ),
            Content(
                R.string.languages_title,
                R.string.languages_description,
                listOf(R.drawable.ic_flag_brazil, R.drawable.ic_flag_usa)
            )
        )
    }

    private fun hobbiesList(): List<Content> {
        return listOf(
            Content(
                R.string.music_title,
                R.string.music_description,
                listOf(
                    R.drawable.images_and_words,
                    R.drawable.still_life,
                    R.drawable.twilight_in_olympus,
                    R.drawable.rebirth
                )
            ),
            Content(
                R.string.tv_and_cinema_title,
                R.string.tv_and_cinema_description,
                listOf(
                    R.drawable.star_wars,
                    R.drawable.lord_of_the_rings,
                    R.drawable.ergo_proxy,
                    R.drawable.avatar
                )
            ),
            Content(
                R.string.video_games_title,
                R.string.video_games_description,
                listOf(
                    R.drawable.final_fantasy_8,
                    R.drawable.heroes,
                    R.drawable.super_metroid,
                    R.drawable.mega_man_x
                )
            ),
            Content(
                R.string.sports_title,
                R.string.sports_description,
                listOf(R.drawable.vasco_da_gama, R.drawable.chelsea)
            ),
            Content(
                R.string.books_title,
                R.string.books_description,
                listOf(R.drawable.hobbit, R.drawable.neuromancer, R.drawable.call_of_cthulhu)
            )
        )
    }

    private fun achievementsList(): List<Content> {
        return listOf(
            Content(
                R.string.oops_title,
                R.string.oops_description,
                listOf(R.drawable.not_found, R.drawable.loading, R.drawable.blue_screen_of_death)
            )
        )
    }
}