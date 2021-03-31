package com.example.jetpackcomponents.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.jetpackcomponents.Employee
import com.example.jetpackcomponents.database.EmployeeDao

@Database(entities = [Employee::class],version = 11)
abstract class AppRoomDatabase: RoomDatabase() {
    abstract fun employeeDao(): EmployeeDao
}