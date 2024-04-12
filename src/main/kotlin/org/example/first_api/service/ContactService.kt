package org.example.first_api.service

import org.example.first_api.entity.ContactEntity
import org.example.first_api.repository.ContactRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ContactService @Autowired constructor(private val repository: ContactRepository) {


    fun getById(id: Long): ContactEntity {
        val contactToGet = repository.findById(id)
        if (contactToGet.isEmpty) {
            throw RuntimeException("Contact Not Found!")
        }
        return repository.findById(id).orElseThrow {
            RuntimeException("Contact With ID: $id Not Found!")
        }
    }

    fun getAll(): List<ContactEntity> {
        return repository.findAll()
    }

    fun create(contact: ContactEntity): ContactEntity {
        return repository.save(contact)
    }

    fun update(id:Long, contact: ContactEntity): ContactEntity {
        val oldContact = repository.findById(id).orElseThrow {
            RuntimeException("Contact With ID: $id Not Found!")
        }

        val oldAddress = oldContact.address

        oldContact.id = id
        oldContact.name = contact.name
        oldContact.age = contact.age
        oldContact.address = contact.address
        if (oldAddress != null) {
            oldContact.address?.id = oldAddress.id
        }


        return repository.save(oldContact)
    }

    fun deleteById(id: Long) {
        val contactToDelete = repository.findById(id)
        if (contactToDelete.isEmpty) {
            throw RuntimeException("Contact Not Found!")
        }
        repository.deleteById(id)
    }

}
