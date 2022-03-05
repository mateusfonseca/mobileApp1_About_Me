package ie.dorset.student_24088.ca1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import ie.dorset.student_24088.ca1.R

// This class implements an adapter for a recycler view in the layout.
// It is a recycler view of images.
class ImageAdapter(
    private var dataset: List<Int>,
) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    class ImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var image: ImageView = view.findViewById(R.id.image_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_image, parent, false)

        return ImageViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.image.setImageResource(dataset[position])
    }

    override fun getItemCount() = dataset.size
}