package org.debugroom.wedding.app.model.profile;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Data
@AllArgsConstructor
@Builder
public class Notification implements Serializable{

	private static final long serialVersionUID = -3716910480746912532L;
	public Notification(){
	}

	private NotificationPK id;
	private boolean isAccessed;
	private Timestamp lastUpdatedDate;
	private Integer ver;
	
}
