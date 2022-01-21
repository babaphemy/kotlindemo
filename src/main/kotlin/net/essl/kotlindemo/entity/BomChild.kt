package com.technipfmc.dsi.cto.entity

import lombok.Data
import javax.persistence.*

@Data
@Entity
@Table(name = "bomchild")
class BomChild {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val bid: Long = -1;
    var proposed: String? = null
    var part: String? = null
    var rev: String? = null
    var level = 0
    var sequence: String? = null
    var description: String? = null
    var qty = 0.0
    var model: String? = null
    var bomSection: String? = null
    var stockingStrategy: String? = null
    var bomNote: String? = null
    @OneToMany(cascade = arrayOf(CascadeType.ALL))
    var children: MutableList<BomChild>? = null
}