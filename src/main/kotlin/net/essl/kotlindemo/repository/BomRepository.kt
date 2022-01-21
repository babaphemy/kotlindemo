package com.technipfmc.dsi.cto.repository

import com.technipfmc.dsi.cto.entity.BomUpload
import org.springframework.data.repository.CrudRepository

interface BomRepository: CrudRepository<BomUpload, Long> {
}