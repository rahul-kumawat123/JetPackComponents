package com.example.jetpackcomponents.viewmodels

import android.annotation.SuppressLint
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.jetpackcomponents.Employee
import com.example.jetpackcomponents.database.RoomDatabaseBuilder
import java.util.concurrent.Executors

class EmployeeViewModel(application: Application): AndroidViewModel(application) {

    @SuppressLint("StaticFieldLeak")
    private val context =  getApplication<Application>().applicationContext
    var allEmployees : LiveData<List<Employee>>
    private val roomDatabaseBuilder = RoomDatabaseBuilder.getInstance(context)


    init{
        allEmployees = roomDatabaseBuilder.employeeDao().getAllEmployees()
        Executors.newSingleThreadExecutor().execute {

        }

    }

    fun addEmployeeDetails(employee: Employee){
        Executors.newSingleThreadExecutor().execute {
            roomDatabaseBuilder.employeeDao().insertEmployee(
                Employee(
                    emp_id = employee.emp_id,
                    name = employee.name,
                    address = employee.address,
                    contactNo = employee.contactNo
                )
            )
        }
    }
}