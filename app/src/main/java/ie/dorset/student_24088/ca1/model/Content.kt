package ie.dorset.student_24088.ca1.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Content(
    @StringRes val contentTitleId: Int,
    @StringRes val contentDescriptionId: Int,
    @DrawableRes val contentImageId: List<Int>
)