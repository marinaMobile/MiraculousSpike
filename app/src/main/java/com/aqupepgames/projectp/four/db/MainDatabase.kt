package com.aqupepgames.projectp.four.db

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [DataBasic::class], version = 1)
abstract class MainDatabase: RoomDatabase(){

    abstract fun basicDao(): BasicDao

}