package com.ort.uploader.api

import com.ort.uploader.core.UploadHandler
import org.jetbrains.annotations.NotNull
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/upload")
@CrossOrigin
class UploadController(private val handler: UploadHandler) {

    @PostMapping
    private fun upload(@Validated form: UploadRequest): UploadResponse {
        check(form.file!!.contentType!!.startsWith("image/"))
        val path = handler.upload(form.file)
        return UploadResponse(path)
    }

    data class UploadRequest(@field:NotNull val file: MultipartFile?)

    data class UploadResponse(val path: String)
}