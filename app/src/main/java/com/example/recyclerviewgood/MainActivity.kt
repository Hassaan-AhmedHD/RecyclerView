package com.example.recyclerviewgood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

data class Person(val name:String,val age:Int)
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // steps to implement recycler view
        // 1.Add RecyclerView androidx library to gradle Done
        // 2.Define a modal class to use as data source
        val contacts:List<Person> = createContacts()
        // 3.Add Recycler View to your Activity
        // 4.Create your custom row layout XMl
        // 5.Create  a RecyclerView.Adapter and ViewHolder to render the item
        rvContacts.adapter = ContactsAdapter(this,contacts)
        // 6.Bind the adapter to the data source to populate the recycler view
        rvContacts.layoutManager = LinearLayoutManager(this)
    }
    private fun createContacts():List<Person> {
        val contacts: MutableList<Person> = mutableListOf<Person>()
        for (i in 1..100) {
            contacts.add(Person("Person $i", i))
        }
        return contacts
    }
}