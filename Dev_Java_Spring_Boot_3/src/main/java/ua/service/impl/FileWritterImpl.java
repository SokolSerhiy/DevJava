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
	public String write(MultipartFile file) {
		String filename = file.getOriginalFilename();
		File pathToFolder = new File(path);
		File pathToFile = new File(pathToFolder, filename);
		try {
			file.transferTo(pathToFile);
		} catch (IllegalStateException | IOException e) {
			return null;
		}
		return pathToFile.toString();
	}
}