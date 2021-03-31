package com.example.jetpackcomponents.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpackcomponents.Employee
import com.example.jetpackcomponents.R
import com.example.jetpackcomponents.databinding.ItemViewBinding

class CustomAdapter(val context: Context?, val employeeDataSet:ArrayList<Employee>): RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {


    class MyViewHolder(binding: ItemViewBinding): RecyclerView.ViewHolder(binding.root){

        val empNameTv : TextView = binding.employeeName
        val empAddressTv : TextView = binding.employeeAddress
        val empContactTv : TextView = binding.employeeContact
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val binding = DataBindingUtil.inflate<ItemViewBinding>(LayoutInflater.from(parent.context),R.layout.item_view,parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val empName = employeeDataSet[position].name
        val empAddress = employeeDataSet[position].address
        val empContact = employeeDataSet[position].contactNo

        holder.empNameTv.text = empName
        holder.empAddressTv.text = empAddress
        holder.empContactTv.text = empContact
    }

    override fun getItemCount(): Int {
        return employeeDataSet.size
    }
}