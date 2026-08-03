package com.example.todoapp.util

import android.content.Context
import android.net.Uri
import java.io.File
import java.io.FileOutputStream

/**
 * Copies a picked image (from the Photo Picker) into the app's internal storage
 * so it survives app restarts, without needing any storage permissions or
 * persistable URI grants.
 */
object ImageStorageUtil {

    private const val IMAGE_DIR = "todo_images"

    fun saveImageToInternalStorage(context: Context, uri: Uri): String? {
        return try {
            val inputStream = context.contentResolver.openInputStream(uri) ?: return null
            val dir = File(context.filesDir, IMAGE_DIR).apply { if (!exists()) mkdirs() }
            val fileName = "todo_img_${System.currentTimeMillis()}.jpg"
            val outFile = File(dir, fileName)

            inputStream.use { input ->
                FileOutputStream(outFile).use { output ->
                    input.copyTo(output)
                }
            }
            outFile.absolutePath
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    fun deleteImage(path: String?) {
        if (path.isNullOrEmpty()) return
        try {
            val file = File(path)
            if (file.exists()) file.delete()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
