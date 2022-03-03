package ie.dorset.student_24088.ca1.adapter

import android.content.Context
import android.content.res.Resources
import android.util.Log
import android.view.*
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.view.setPadding
import androidx.recyclerview.widget.RecyclerView
import ie.dorset.student_24088.ca1.R
import ie.dorset.student_24088.ca1.model.Content
import kotlin.math.abs
import kotlin.math.log

/**
 * Adapter for the [RecyclerView] in [MainActivity]. Displays [Affirmation] data object.
 */
class ItemAdapter(
    private var context: Context,
    private var dataset: List<Content>
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just an Affirmation object.
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        var title: TextView = view.findViewById(R.id.item_title)
        var description: TextView = view.findViewById(R.id.item_description)
        var image: RecyclerView = view.findViewById(R.id.image_recycler_view)
    }

    /**
     * Create new views (invoked by the layout manager)
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // create a new view
        var adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        val screenSize = Resources.getSystem().displayMetrics.widthPixels
        val dpToPx = Resources.getSystem().displayMetrics.density
        val paddingHorizontal = abs(((screenSize / 2) - ((100 + 20 + 4) * dpToPx + 0.5f)).toInt())

        for (datum in dataset) {
            if (datum.contentImageId.size > 1) {
                adapterLayout.findViewById<RecyclerView>(R.id.image_recycler_view)
                    .setPaddingRelative(
                        paddingHorizontal,
                        0,
                        paddingHorizontal,
                        0
                    )
            }
        }

        return ItemViewHolder(adapterLayout)
    }

    /**
     * Replace the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        var item = dataset[position]
        holder.title.text = context.resources.getString(item.contentTitleId)
        holder.description.text = context.resources.getString(item.contentDescriptionId)
        holder.image.adapter = ImageAdapter(context, item.contentImageId)
    }

    /**
     * Return the size of your dataset (invoked by the layout manager)
     */
    override fun getItemCount() = dataset.size

    companion object {
        private const val TAG = "ItemAdapter"
    }
}
