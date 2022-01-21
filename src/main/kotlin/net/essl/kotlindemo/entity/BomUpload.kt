package com.technipfmc.dsi.cto.entity

import javax.persistence.*

@Entity
@Table(name = "bomload")
class BomUpload {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val bomId: Long = -1;
    var environment: String? = null
    var id = 0
    var revision = 0
    var status: String? = null
    var part: String? = null
    var description: String? = null
    var proposal_OpportunityNumber: String? = null
    var customer_OpportunityName: String? = null
    var caseNumber: String? = null
    var userEmail: String? = null
    @OneToOne(cascade = arrayOf(CascadeType.ALL))
    var bom: Bom? = null
}