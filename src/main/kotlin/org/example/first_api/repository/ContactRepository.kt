package org.example.first_api.repository

import org.example.first_api.entity.ContactEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ContactRepository : JpaRepository<ContactEntity, Long>
