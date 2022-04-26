package com.example.fitimdiaapp.utils

public class StringUtils {
    public fun isNullOrBlank(s: String?): Boolean {
        return s == null || s.trim { it <= ' ' } == ""
    }

}