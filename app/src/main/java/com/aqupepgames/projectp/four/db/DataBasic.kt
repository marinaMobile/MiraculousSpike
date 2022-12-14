package com.aqupepgames.projectp.four.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "BasicDataBase")
data class DataBasic(
    @PrimaryKey (autoGenerate = true)
    var id: Int,

)
