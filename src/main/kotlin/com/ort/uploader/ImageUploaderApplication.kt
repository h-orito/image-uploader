package com.ort.uploader

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ImageUploaderApplication

fun main(args: Array<String>) {
	runApplication<ImageUploaderApplication>(*args)
}
