package org.debugroom.wedding.domain.model.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;

/**
 * The persistent class for the address database table.
 * 
 */
@AllArgsConstructor
@Builder
@Embeddable
public class CredentialPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="user_id", insertable=false, updatable=false, unique=true, nullable=false, length=8)
	private String userId;

	@Column(name="credential_type", unique=true, nullable=false, length=2147483647)
	private String credentialType;

	public CredentialPK() {
	}
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCredentialType() {
		return this.credentialType;
	}
	public void setCredentialType(String credentialType) {
		this.credentialType = credentialType;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CredentialPK)) {
			return false;
		}
		CredentialPK castOther = (CredentialPK)other;
		return 
			this.userId.equals(castOther.userId)
			&& this.credentialType.equals(castOther.credentialType);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.userId.hashCode();
		hash = hash * prime + this.credentialType.hashCode();
		
		return hash;
	}
}