import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.technipfmc.dsi.cto.entity.BomUpload
import com.technipfmc.dsi.cto.repository.BomRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.multipart.MultipartFile
import java.io.ByteArrayInputStream
import java.io.InputStream
import java.util.*

@Suppress("TooManyFunctions", "MaxLineLength")
@Service
class BomService(private val bomRepo: BomRepository) {
    @Transactional
    fun doUpload(file: MultipartFile) {
        val instream: InputStream = ByteArrayInputStream(file.bytes)
        //val jsonString: String = File(file).readText(Charsets.UTF_8);
//        println(jsonString)
        val mapper = ObjectMapper()
        val bomUpload = mapper.readValue<BomUpload>(instream)
//    println(obj.bom?.children?.size)
        bomRepo.save(bomUpload);
    }
    fun bomById(id: Long): Optional<BomUpload>{
        return bomRepo.findById(id);
    }


}