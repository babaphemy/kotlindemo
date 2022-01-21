
import com.technipfmc.dsi.cto.entity.BomUpload
import com.technipfmc.dsi.cto.service.BomService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.util.*

@RestController
@RequestMapping(value = ["/api/upload/*"])
class UploadCon(private val bomService: BomService) {
    @PostMapping("bom")
    @ResponseStatus(HttpStatus.OK)
    fun doUpload(@RequestParam file: MultipartFile){
        bomService.doUpload(file);
    }
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    fun abom(@PathVariable id: Long): Optional<BomUpload>{
        return bomService.bomById(id);
    }
}