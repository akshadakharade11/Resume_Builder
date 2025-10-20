package com.example.demo.services;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.utils.ObjectUtils;
import com.example.zidio.security.CloudinaryConfig;

public class FileUploadService {

	@Autowired
	private CloudinaryConfig cloudinaryConfig;

	public String uploadFile(MultipartFile file, String folder) throws IOException {
		try {
			@SuppressWarnings("rawtypes")
			Map uploadFile = cloudinaryConfig.cloudinary().uploader().upload(file.getBytes(),
					ObjectUtils.asMap("folder", folder));

			return (String) uploadFile.get("secure_url");
		} catch (IOException e) {

			e.printStackTrace();
		}
		return null;
	}

}
