package com.example.jetpackcomponents.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.jetpackcomponents.Employee


@Dao
interface EmployeeDao {

    @Query("Select * from Employee_Table")
    fun getAllEmployees(): LiveData<List<Employee>>

    @Insert
    fun insertEmployee(employee: Employee)

    /* @Update
     fun updateEmployee(employee: Employee)

     @Delete
     fun deleteEmployee(employee: Employee)*/
}