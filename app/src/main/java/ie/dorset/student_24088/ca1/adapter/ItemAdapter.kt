package ie.dorset.student_24088.ca1.adapter

import android.content.Context
import android.view.*
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ie.dorset.student_24088.ca1.R
import ie.dorset.student_24088.ca1.model.Content

// This class implements an adapter for a recycler view in the layout.
// It is a recycler view of card views with a second recycler view of images nested in it.
// The nested recycler view is handled by another adapter called from this one.
class ItemAdapter(
    private var context: Context,
    private var dataset: List<Content>
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title: TextView = view.findViewById(R.id.item_title)
        var description: TextView = view.findViewById(R.id.item_description)
        var image: RecyclerView = view.findViewById(R.id.image_recycler_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.title.text = context.resources.getString(item.contentTitleId)
        holder.description.text = context.resources.getString(item.contentDescriptionId)

        // Calls nested adapter to handle the recycler view with images
        holder.image.adapter = ImageAdapter(item.contentImageId)
    }

    override fun getItemCount() = dataset.size
}