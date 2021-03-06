package com.searcharchitect.common.repositiry

import com.searcharchitect.common.database.dao.IContactDao
import com.searcharchitect.common.model.Contact
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface IDatabaseRepository {

    suspend fun removeAllContacts()
    suspend fun addContacts(contacts: List<Contact>)
    suspend fun getNumberOfContacts(): Int
    suspend fun getContactList(): List<Contact>

}

class DatabaseRepository @Inject constructor(
    private val contactDao: IContactDao
) : IDatabaseRepository {

    override suspend fun removeAllContacts() {
        withContext(Dispatchers.IO) {
            contactDao.deleteAll()
        }
    }

    override suspend fun addContacts(contacts: List<Contact>) {
        withContext(Dispatchers.IO) {
            contactDao.insertContacts(contacts)
        }
    }

    override suspend fun getNumberOfContacts(): Int {
        return withContext(Dispatchers.IO) {
            contactDao.getNumberOfContacts()
        }
    }

    override suspend fun getContactList(): List<Contact> {
        return withContext(Dispatchers.IO) {
            contactDao.getContactList()
        }
    }

}