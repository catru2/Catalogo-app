import com.example.catalogoapp.src.viewCatalogo.data.model.ViewCatalogoDTO
import retrofit2.http.GET

interface ViewCatalogoService {
    @GET("ropa/")
    suspend fun viewTasks(): List<ViewCatalogoDTO>
}
