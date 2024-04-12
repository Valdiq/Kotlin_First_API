package org.example.first_api.controller

import org.example.first_api.entity.ContactEntity
import org.example.first_api.service.ContactService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/contact")
class MyController @Autowired constructor(private val service: ContactService) {

    @GetMapping("/get/{id}")
    fun getById(@PathVariable id: Long): ContactEntity = service.getById(id)


    @GetMapping("/get")
    fun getAll(): List<ContactEntity> = service.getAll()


    @PostMapping("/")
    fun createContact(@RequestBody contact: ContactEntity): ContactEntity = service.create(contact)


    @PutMapping("/{id}")
    fun updateContact(@PathVariable id: Long, @RequestBody contact: ContactEntity): ContactEntity = service.update(id, contact)


    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long) = service.deleteById(id)

}