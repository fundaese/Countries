package com.example.countries.service

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.countries.model.Country

@Dao
interface CountryDao {

    //Data Access Object

    @Insert
    suspend fun insertAll(vararg country: Country) : List<Long>

    @Query("SELECT * FROM country")
    suspend fun getAllCountries() : List<Country>

    @Query("SELECT * FROM country WHERE uuid = :countryId")
    suspend fun getCountry(countryId : Int) : Country

    @Query("SELECT * FROM country")
    suspend fun deleteAllCountries() : Country
}