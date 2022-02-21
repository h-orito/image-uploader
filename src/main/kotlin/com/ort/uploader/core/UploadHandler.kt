package com.ort.uploader.core

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.multipart.MultipartFile
import java.io.FileOutputStream
import java.util.*

@Component
class UploadHandler {

    @Value("\${image.base-dir:}")
    private lateinit var dir: String

    fun upload(file: MultipartFile): String {
        val name = UUID.randomUUID().toString()
        val ext = file.originalFilename!!.let {
            it.substring(it.lastIndexOf("."))
        }
        val path = "/image/${name}${ext}"
        FileOutputStream("$dir$path").write(file.bytes)

        return path
    }
}