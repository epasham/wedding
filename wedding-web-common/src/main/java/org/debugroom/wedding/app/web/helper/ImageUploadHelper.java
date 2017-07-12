package org.debugroom.wedding.app.web.helper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.debugroom.framework.common.exception.BusinessException;
import org.debugroom.framework.spring.webmvc.fileupload.FileUploadHelper;

@Component
public class ImageUploadHelper implements FileUploadHelper{

	@Value("${image.upload.root.directory}")
	private String imageUploadRootDirectory;
	@Value("${image.upload.directory}")
	private String imageUploadDirectory;
	
	private static final String FILE_SEPARATOR = System.getProperty("file.separator");

	@Override
	public String saveFile(MultipartFile multipartFile, String userId) throws BusinessException {
		String uploadDirectoryContextPath = new StringBuilder()
				.append(imageUploadDirectory)
				.append(FILE_SEPARATOR)
				.append(userId)
				.append(FILE_SEPARATOR)
				.append(UUID.randomUUID().toString())
				.toString();
		String uploadDirectoryAbsolutePath = new StringBuilder()
				.append(imageUploadRootDirectory)
				.append(FILE_SEPARATOR)
				.append(uploadDirectoryContextPath)
				.append(FILE_SEPARATOR)
				.toString();
		File uploadFile = new File(uploadDirectoryAbsolutePath, multipartFile.getOriginalFilename());
		try {
			FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), uploadFile);
		} catch (IOException e) {
			throw new BusinessException("imageUploadHelper.error.0001", null, userId);
		}
		return new StringBuilder()
				.append(uploadDirectoryContextPath)
				.append("/")
				.append(multipartFile.getOriginalFilename())
				.toString();
	}

}
