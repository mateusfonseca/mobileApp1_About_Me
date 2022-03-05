package ie.dorset.student_24088.ca1.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

// This class implements the blueprint for the basic Content objects used to feed the recycler views.
// Note that its third property is a list of image IDs, whose length may vary.
data class Content(
    @StringRes val contentTitleId: Int,
    @StringRes val contentDescriptionId: Int,
    @DrawableRes val contentImageId: List<Int>
)