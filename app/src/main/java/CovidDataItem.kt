
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CovidDataItem(
    @SerializedName("attributes")
    val attributes: Attributes
): Serializable