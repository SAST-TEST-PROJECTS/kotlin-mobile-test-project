package com.mend.sample

import android.app.Activity
import android.os.Bundle
import java.io.File

class ExportActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val exportName = intent.getStringExtra("exportName") ?: return
        val payload = intent.getStringExtra("payload") ?: return
        writeExport(exportName, payload)
    }

    private fun writeExport(exportName: String, payload: String) {
        val target = File(cacheDir, exportName)
        target.writeText(payload)
    }
}
