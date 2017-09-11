package ua.service.impl;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ua.service.FileWritter;

@Service
public class FileWritterImpl implements FileWritter{

	@Value("${file.path}")
	private String path;
	
	@Override
	public String writte(MultipartFile file) {
		File fullPath = new File(path+file.getOriginalFilename());
		try {
			file.transferTo(fullPath);
		} catch (IllegalStateException | IOException e) {
			return null;
		}
		return file.getOriginalFilename();
	}
}
