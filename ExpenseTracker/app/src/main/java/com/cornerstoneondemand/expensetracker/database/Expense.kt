package com.cornerstoneondemand.expensetracker.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.cornerstoneondemand.expensetracker.utilities.Category
import com.cornerstoneondemand.expensetracker.utilities.DATABASE_NAME
import java.util.Date

class DateConverter {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }
}
@Entity(tableName = DATABASE_NAME)
data class Expense(
    @PrimaryKey(autoGenerate = true) var id:Int,
    @ColumnInfo(name ="amount") val amount:Double,
    @ColumnInfo(name="category_id") val category_id:Category,
    @ColumnInfo(name="note")val note:String?,
    @ColumnInfo(name="date")val date:Date,
    @ColumnInfo(name="payment_mode")val payment_mode:String?
    )