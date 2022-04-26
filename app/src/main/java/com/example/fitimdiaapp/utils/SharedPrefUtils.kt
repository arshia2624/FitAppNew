package com.example.fitimdiaapp.utils

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import com.example.fitimdiaapp.api.response.BaseResponse
import com.google.gson.Gson

 class SharedPrefUtils {
    private val USER_PREFS = "USER_PREFS"
    private var appSharedPrefs: SharedPreferences? = null
    private var prefsEditor: SharedPreferences.Editor? = null
    private var appContext: Context? = null
    val QUICK_ADDDATA_KEY = "quickAdd"
    val NOTIFICATION_COUNT = "notificationCount"



     fun SharedPrefUtils(applicationContext: Context) {
        appContext = applicationContext
        appSharedPrefs = appContext!!.getSharedPreferences(
            USER_PREFS,
            Activity.MODE_PRIVATE
        )
        appSharedPrefs?.let {
           prefsEditor= appSharedPrefs!!.edit()
        }
    }

    fun setStringObject(`object`: String?, key: String?) {
        prefsEditor!!.putString(key, `object`).commit()
    }

    fun getStringObject(key: String?): String? {
        return appSharedPrefs!!.getString(key, null)
    }

    fun setBooleanObject(`object`: Boolean, key: String?) {
        prefsEditor!!.putBoolean(key, `object`).commit()
    }

    fun getBooleanObject(key: String?): Boolean {
        return appSharedPrefs!!.getBoolean(key, false)
    }

    fun setUserDetails(loginData: BaseResponse?) {
        prefsEditor!!.putString(USER_DETAIL_KEY, Gson().toJson(loginData)).commit()
    }

    fun getLoginData(): BaseResponse? {
        return Gson().fromJson(
            appSharedPrefs!!.getString(USER_DETAIL_KEY, ""),
            BaseResponse::class.java
        )
    }

    /**
     * Save and get View Doc List in SharedPreference
     *
     * @param list
     */
    companion object {
        var phoneNumber = "phoneNumber"
        val USER_DETAIL_KEY = "userDetail"
        private var instance: SharedPrefUtils? = null

        @Synchronized
         fun getInstanceShared(applicationContext: Context?){
             if (instance == null)
                 instance = SharedPrefUtils()


         }
    }




 }