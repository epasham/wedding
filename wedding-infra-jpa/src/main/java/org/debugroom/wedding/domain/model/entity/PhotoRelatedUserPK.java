package org.debugroom.wedding.domain.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the photo_related_user database table.
 * 
 */
@AllArgsConstructor
@Builder
@Embeddable
public class PhotoRelatedUserPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="photo_id", insertable=false, updatable=false, unique=true, nullable=false, length=10)
	private String photoId;

	@Column(name="user_id", insertable=false, updatable=false, unique=true, nullable=false, length=8)
	private String userId;

	public PhotoRelatedUserPK() {
	}
	public String getPhotoId() {
		return this.photoId;
	}
	public void setPhotoId(String photoId) {
		this.photoId = photoId;
	}
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PhotoRelatedUserPK)) {
			return false;
		}
		PhotoRelatedUserPK castOther = (PhotoRelatedUserPK)other;
		return 
			this.photoId.equals(castOther.photoId)
			&& this.userId.equals(castOther.userId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.photoId.hashCode();
		hash = hash * prime + this.userId.hashCode();
		
		return hash;
	}
}
