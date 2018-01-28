package org.debugroom.wedding.domain.model.gallery;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class Media implements Serializable{

	private static final long serialVersionUID = 3828463753784745572L;
	
	public Media(){
	}
	
	private String mediaId;
	private MediaType mediaType;
	private String extension;
	private String originalFilename;
	private String filePath;
	private String thumbnailFilePath;
	private String folderId;
	private String userId;
}
