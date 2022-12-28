package com.example.recyclerviewgood
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

private const val TAG = "ContactsAdapter"
class ContactsAdapter(val context: Context,val contacts: List<Person>) : RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {
//Create a new view -Expensive
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    Log.i(TAG, "onCreateViewHolder: ")
       val view = LayoutInflater.from(context).inflate(R.layout.item_person,parent,false)
       return ViewHolder(view)
    }

    //Returns How many items are in data set
    override fun getItemCount() = contacts.size

    //Bind the data at position into View Holder not Expensive
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.i(TAG, "onBindViewHolder: $position")
        val contact = contacts[position]
        //take the data from contact and bind it to holder
           holder.bind(contact)
    }

    //make references here
    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){


       var tvName = itemView.findViewById<TextView>(R.id.tvName)

       var tvAge = itemView.findViewById<TextView>(R.id.tvAge)
        fun bind(contact:Person){
            //Bind the data in the contact into the views
              tvName.text = contact.name
              tvAge.text  = "Age:${contact.age}"
        }
    }

}

