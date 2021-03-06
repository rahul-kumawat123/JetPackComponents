package com.example.jetpackcomponents.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpackcomponents.Employee
import com.example.jetpackcomponents.R
import com.example.jetpackcomponents.adapters.CustomAdapter
import com.example.jetpackcomponents.viewmodels.EmployeeViewModel
import kotlinx.android.synthetic.main.fragment_display_data.*

class FragmentDisplayData: Fragment() {

    private lateinit var adapter: CustomAdapter
    private val TAG =  "DisplayDataFragment"
    private var employeeList: ArrayList<Employee> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_display_data,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        Log.i(TAG,"onActivityCreated")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.i(TAG,"onViewCreated")

        //setting up UI
        setupUI()

        floatingActionButton.setOnClickListener {
            openAddPersonDetailsFragment()
        }
    }


    /**
     * Replace old fragment with another fragment
     * to add the new person details
     */
    private fun openAddPersonDetailsFragment() {

        val fragmentManager = fragmentManager
        val fragmentTransaction = fragmentManager?.beginTransaction()
        fragmentTransaction?.replace(R.id.fragmentContainer,FragmentAddData())

        fragmentTransaction?.addToBackStack(null)
        fragmentTransaction?.commit()
    }

    private fun setupUI() {
        val layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        recyclerView.layoutManager = layoutManager

        adapter = CustomAdapter(context!!, employeeList)
        recyclerView.adapter = adapter

        setupListFromRoom()
    }

    private fun setupListFromRoom() {
        // With LiveData
        val application = activity!!.application
        val employeeViewModel = ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(EmployeeViewModel(application)::class.java)

        employeeViewModel.allEmployees.observe(viewLifecycleOwner, Observer {
            Log.i(TAG,it.toString())
            employeeList = it as ArrayList<Employee>
            adapter.notifyDataSetChanged()
        })
    }
}