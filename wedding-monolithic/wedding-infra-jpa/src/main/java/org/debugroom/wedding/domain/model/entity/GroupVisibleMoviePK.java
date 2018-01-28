package org.debugroom.wedding.domain.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the group_visible_movie database table.
 * 
 */
@AllArgsConstructor
@Builder
@Embeddable
public class GroupVisibleMoviePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="movie_id", insertable=false, updatable=false, unique=true, nullable=false, length=10)
	private String movieId;

	@Column(name="group_id", insertable=false, updatable=false, unique=true, nullable=false, length=10)
	private String groupId;

	public GroupVisibleMoviePK() {
	}
	public String getMovieId() {
		return this.movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public String getGroupId() {
		return this.groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof GroupVisibleMoviePK)) {
			return false;
		}
		GroupVisibleMoviePK castOther = (GroupVisibleMoviePK)other;
		return 
			this.movieId.equals(castOther.movieId)
			&& this.groupId.equals(castOther.groupId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.movieId.hashCode();
		hash = hash * prime + this.groupId.hashCode();
		
		return hash;
	}
}
