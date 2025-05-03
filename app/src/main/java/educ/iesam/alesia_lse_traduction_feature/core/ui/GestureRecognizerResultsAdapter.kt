package educ.iesam.alesia_lse_traduction_feature.core.ui

import android.annotation.SuppressLint
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.mediapipe.tasks.components.containers.Category
import educ.iesam.alesia_lse_traduction_feature.databinding.ItemGestureRecognizerResultBinding
import java.util.Locale
import kotlin.math.min

class GestureRecognizerResultsAdapter :
    RecyclerView.Adapter<GestureRecognizerResultsAdapter.ViewHolder>() {

    companion object {
        private const val NO_VALUE = "--"
        private const val DEFAULT_DETECTION_DELAY_MS : Long = 1500 // 1.5 segundos de delay entre detecciones
        private const val CONFIDENCE_THRESHOLD = 0.7f // Umbral de confianza para aceptar una detección
    }

    private var adapterCategories: MutableList<Category?> = mutableListOf()
    private var adapterSize: Int = 0

    // Variables para acumular letras y formar palabras
    private val currentWord = StringBuilder()
    private var isProcessingGesture = false
    private val handler = Handler(Looper.getMainLooper())

    // Variable para el delay configurable (en milisegundos)
    private var detectionDelayMs: Long = DEFAULT_DETECTION_DELAY_MS

    // Interfaz para comunicar la palabra formada a la actividad/fragmento
    interface OnWordUpdateListener {
        fun onWordUpdated(currentWord: String)
    }

    private var wordUpdateListener: OnWordUpdateListener? = null

    fun setOnWordUpdateListener(listener: OnWordUpdateListener) {
        wordUpdateListener = listener
    }

    // Método para establecer el delay de detección
    fun setDetectionDelay(delaySeconds: Float) {
        detectionDelayMs = (delaySeconds * 1000).toLong()
    }
    // Método para obtener el delay actual en segundos
    fun getDetectionDelaySeconds(): Float {
        return detectionDelayMs / 1000f
    }

    // Método para limpiar la palabra actual
    fun clearCurrentWord() {
        currentWord.clear()
        notifyWordUpdate()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateResults(categories: List<Category>?) {
        adapterCategories = MutableList(adapterSize) { null }

        if (categories != null && !isProcessingGesture) {
            val sortedCategories = categories.sortedByDescending { it.score() }
            val min = min(sortedCategories.size, adapterCategories.size)

            for (i in 0 until min) {
                adapterCategories[i] = sortedCategories[i]
            }

            // Procesamos la mejor categoría si supera el umbral de confianza
            if (sortedCategories.isNotEmpty() && sortedCategories[0].score() > CONFIDENCE_THRESHOLD) {
                processBestCategory(sortedCategories[0])
            }

            notifyDataSetChanged()
        }
    }

    private fun processBestCategory(category: Category) {
        // Evitar procesamiento durante el delay
        if (isProcessingGesture) return

        isProcessingGesture = true

        // Añadir la letra detectada a la palabra actual
        val letter = category.categoryName()
        if (!letter.isNullOrEmpty()) {
            currentWord.append(letter)
            notifyWordUpdate()

            // Solo aplicar delay si es mayor que 0
            if (detectionDelayMs > 0) {
                // Delay para la próxima detección
                handler.postDelayed({
                    isProcessingGesture = false
                }, detectionDelayMs.toLong())
            } else {
                // Sin delay
                isProcessingGesture = false
            }
        } else {
            isProcessingGesture = false
        }
    }

    private fun notifyWordUpdate() {
        wordUpdateListener?.onWordUpdated(currentWord.toString())
    }

    fun updateAdapterSize(size: Int) {
        adapterSize = size
    }

    // Método para obtener la palabra actual
    fun getCurrentWord(): String {
        return currentWord.toString()
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding = ItemGestureRecognizerResultBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        adapterCategories[position].let { category ->
            holder.bind(category?.categoryName(), category?.score())
        }
    }

    override fun getItemCount(): Int = adapterCategories.size

    inner class ViewHolder(private val binding: ItemGestureRecognizerResultBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(label: String?, score: Float?) {
            with(binding) {
                tvLabel.text = label ?: NO_VALUE
                tvScore.text = if (score != null) String.format(
                    Locale.US,
                    "%.2f",
                    score
                ) else NO_VALUE
            }
        }
    }
}