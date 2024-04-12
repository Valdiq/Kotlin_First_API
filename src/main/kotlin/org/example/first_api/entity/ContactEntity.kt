package org.example.first_api.entity

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor

@Entity
@Table(name = "contacts")
@AllArgsConstructor
@NoArgsConstructor
@Data
class ContactEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    var name: String = ""

    var age: Int = 0

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    var address: AddressEntity? = null
}