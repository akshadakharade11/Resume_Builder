package com.example.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.zidio.services.FileUploadService;
	
	@RequestMapping("api/fileuploads/")
	public class FileUploadController {

		@Autowired
		private FileUploadService fileUploadService;

		@PostMapping("/resume")
		public ResponseEntity<String> uploadResume(@RequestParam("file") MultipartFile file) throws IOException {
			return ResponseEntity.ok(fileUploadService.uploadFile(file, "resume"));
		}

		@PostMapping("/image")
		public ResponseEntity<String> uploadCertificate(@RequestParam("file") MultipartFile file) throws IOException {
			return ResponseEntity.ok(fileUploadService.uploadFile(file, "certificate"));
		}
		
		@PostMapping("/invoice")
		public ResponseEntity<String> uploadInvoice(@RequestParam("file") MultipartFile file) throws IOException {
			return ResponseEntity.ok(fileUploadService.uploadFile(file, "invoice"));
		}
		
		

	}


