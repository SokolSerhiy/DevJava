package ua.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileWritter {

	String writte(MultipartFile file);
}
