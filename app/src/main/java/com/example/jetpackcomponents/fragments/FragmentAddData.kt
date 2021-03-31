package com.example.jetpackcomponents.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.jetpackcomponents.Employee
import com.example.jetpackcomponents.R
import com.example.jetpackcomponents.showToast
import com.example.jetpackcomponents.viewmodels.EmployeeViewModel
import kotlinx.android.synthetic.main.fragment_add_data.*

class FragmentAddData: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_data,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        attachListeners()
    }

    private fun attachListeners() {

        add_data_btn.setOnClickListener {

            val application = activity!!.application
            val employeeViewModel = ViewModelProvider(this).get(EmployeeViewModel(application)::class.java)
            employeeViewModel.addEmployeeDetails(Employee(
                emp_id = null,
                name = et_employeeName.text.toString(),
                address = et_employeeAddress.text.toString(),
                contactNo = et_employeeContact.text.toString()
            ))
            context?.showToast("Data Added Successfully")
            fragmentManager?.popBackStack()
        }

        cancel_data_btn.setOnClickListener {
            fragmentManager?.popBackStack()
        }
    }

}