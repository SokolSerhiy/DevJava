package ua.model.request;

import org.springframework.web.multipart.MultipartFile;

public class FileRequest {

	private MultipartFile file;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
}