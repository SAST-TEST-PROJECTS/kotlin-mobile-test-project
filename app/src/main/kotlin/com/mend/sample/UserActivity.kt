package com.mend.sample

import android.app.Activity
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle

class UserActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val userName = intent.getStringExtra("userName") ?: return
        val db = openOrCreateDatabase("users.db", MODE_PRIVATE, null)
        findUser(db, userName)
    }

    private fun findUser(db: SQLiteDatabase, userName: String) {
        val query = "SELECT * FROM users WHERE name = '" + userName + "'"
        db.rawQuery(query, null)
    }
}
