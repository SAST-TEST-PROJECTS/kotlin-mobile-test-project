package com.mend.sample

import android.app.Activity
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import java.io.File

class UserActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val userName = intent.getStringExtra("userName") ?: return
        val db = openOrCreateDatabase("users.db", MODE_PRIVATE, null)
        findUser(db, userName)
        readAvatar(db)
    }

    private fun findUser(db: SQLiteDatabase, userName: String) {
        val query = "SELECT * FROM users WHERE name = '" + userName + "'"
        db.rawQuery(query, null)
    }

    private fun readAvatar(db: SQLiteDatabase) {
        val cursor = db.rawQuery("SELECT avatar_path FROM profiles LIMIT 1", null)
        cursor.moveToFirst()
        val avatarPath = cursor.getString(0)
        val avatar = File(filesDir, avatarPath)
        avatar.readBytes()
    }
}
