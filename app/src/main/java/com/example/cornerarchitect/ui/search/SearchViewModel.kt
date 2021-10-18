package com.example.cornerarchitect.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import com.example.cornerarchitect.base.BaseViewModel
import com.example.cornerarchitect.manager.IContactManager
import com.example.cornerarchitect.navigation.INavigator
import com.example.cornerarchitect.utility.extension.combine
import com.example.cornerarchitect.utility.log
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val navigator: INavigator,
    private val contactManager: IContactManager
) : BaseViewModel() {

    val city = MutableLiveData("")

    val specialization = MutableLiveData("")

    val name = MutableLiveData("")


    // todo Сделать запрос списка через менеджер с показом лоадера
    // todo При повторном запросе отменять предыдущий
    val searchItems = combine(
        contactManager.contacts, city, specialization, name
    ) { contacts, city, specialization, name ->
        contacts?.map { contact ->
            ItemSearchUi(
                id = contact.id,
                name = "${contact.surname} ${contact.name}",
                city = contact.city,
                specialization = contact.specialization,
                work = contact.work.orEmpty(),
                position = contact.position.orEmpty()
            )
        }?.filter { contact ->
            contact.city.contains(city.orEmpty(), true)
                    && contact.specialization.contains(specialization.orEmpty(), true)
                    && contact.name.contains(name.orEmpty(), true)
        } ?: emptyList()
    }

    val isCityClearButtonVisibility = city.map { it.isNotEmpty() }

    val isSpecializationClearButtonVisibility = specialization.map { it.isNotEmpty() }

    val isNameClearButtonVisibility = name.map { it.isNotEmpty() }


    fun onClickClearCity() {
        city.value = ""
    }

    fun onClickClearSpecialization() {
        specialization.value = ""
    }

    fun onClickClearName() {
        name.value = ""
    }

    fun onClickItemPosition(position: Int) {
        searchItems.value?.getOrNull(position)?.let { searchItems ->
            contactManager.contacts.value?.find { it.id == searchItems.id }?.let { contact ->
                log("Selected contact: $contact")
                contactManager.selectedContact.value = contact
                navigator.actionSearchToDetail()
            }
        }
    }

}