package org.debugroom.wedding.app.web.common.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import org.debugroom.framework.spring.webmvc.fileupload.FileUploadHelper;

@Component
public class ProfileImageUploadHelper implements FileUploadHelper{

	@Value("${app.profile.image.rootdirectory}")
	private String uploadRootDirectory;

	@Value("${app.profile.image.directory}")
	private String uploadDirectory;

	@Override
	public String saveFile(MultipartFile multipartFile, String userId) {
		String uploadDirectoryContextPath = new StringBuilder()
									.append(uploadDirectory)
									.append("/")
									.append(userId)
									.append("/")
									.append(UUID.randomUUID().toString())
									.toString();
		String uploadDirectoryAbsolutePath = new StringBuilder()
									.append(uploadRootDirectory)
									.append("/")
									.append(uploadDirectoryContextPath)
									.append("/")
									.toString();
		
		File uploadFile = new File(uploadDirectoryAbsolutePath, multipartFile.getOriginalFilename());
		
		try {
			FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), uploadFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new StringBuilder()
				.append(uploadDirectoryContextPath)
				.append("/")
				.append(multipartFile.getOriginalFilename())
				.toString();
	}
	
}