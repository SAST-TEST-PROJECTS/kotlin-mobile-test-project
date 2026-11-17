package com.mend.sample

import android.app.Activity
import android.os.Bundle
import java.io.File

class FileActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val fileName = intent.getStringExtra("fileName") ?: return
        val content = readDocument(fileName)
        title = content
    }

    private fun readDocument(fileName: String): String {
        val target = File(filesDir, fileName)
        return target.readText()
    }
}
