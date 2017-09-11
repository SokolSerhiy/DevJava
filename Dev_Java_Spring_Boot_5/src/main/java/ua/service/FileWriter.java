package ua.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileWriter {

	String write(MultipartFile file);
}
