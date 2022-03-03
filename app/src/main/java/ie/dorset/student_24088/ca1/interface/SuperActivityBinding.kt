//package ie.dorset.student_24088.ca1.`interface`
//
//import android.content.res.Resources
//import android.os.Bundle
//import android.util.Log
//import android.view.LayoutInflater
//import androidx.appcompat.app.AppCompatActivity
//import androidx.viewbinding.ViewBinding
//import ie.dorset.student_24088.ca1.MainActivity
//import ie.dorset.student_24088.ca1.R
//import ie.dorset.student_24088.ca1.databinding.ActivityMainBinding
//import ie.dorset.student_24088.ca1.databinding.BarTopBinding
//
//abstract class SuperActivityBinding<Super: ViewBinding>(val superBinding: (LayoutInflater) -> Super) : AppCompatActivity() {
//    private lateinit var binding: Super
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = superBinding(layoutInflater)
//        setContentView(binding.root)
//
//        (binding as Super).topBar
//
////        if (icon != null) (binding as BarTopBinding).topBarIcon.setImageResource(icon)
////        binding.topBar.topBarText.text = resources.getString(text)
//    }
//
//    private fun superTopBar(binding: Super, resources: Resources, icon: Int?, text: Int) {
//        if (icon != null) binding.topBar.topBarIcon.setImageResource(icon)
//        binding.topBar.topBarText.text = resources.getString(text)
//    }
//
//    fun getBinding() : Super {
//        return binding
//    }
//}