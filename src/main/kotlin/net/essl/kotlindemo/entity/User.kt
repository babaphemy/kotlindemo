package com.technipfmc.dsi.cto.entity

import java.util.Date
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.OneToMany
import javax.persistence.Table
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users", schema = "dsi")
@Suppress("LongParameterList")

class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    var userId: Long? = null

    @Column(name = "employee_id")
    var employeeId: String? = null

    @Column(name = "user_status")
    var userStatus = false

    @Column(name = "user_name")
    var userName: String? = null

    @Column(name = "email")
    var email: String? = null

    @Column(name = "created_date")
    var createdDate: Date? = null

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "user_roles", schema = "dsi",
        joinColumns = [JoinColumn(name = "user_id", referencedColumnName = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "role_id", referencedColumnName = "role_id")]
    )
    var roles: MutableSet<Role> = HashSet()
}
