package org.example.first_api.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor

@Entity
@Table(name = "contact_adress")
@AllArgsConstructor
@NoArgsConstructor
@Data
class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    var city: String = ""

    var street: String = ""

    var building: String = ""

    var apartment: String = ""

    @OneToOne(mappedBy = "address")
    @JsonIgnore
    var contact: ContactEntity? = null
}