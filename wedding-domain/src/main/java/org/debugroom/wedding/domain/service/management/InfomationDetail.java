package org.debugroom.wedding.domain.service.management;

import java.io.Serializable;

import java.util.List;

import org.debugroom.wedding.domain.model.entity.User;
import org.debugroom.wedding.domain.model.entity.Infomation;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Data
@AllArgsConstructor
@Builder
public class InfomationDetail implements Serializable{

	public InfomationDetail(){
	}

	private Infomation infomation;
	private List<User> accessedUsers;
	private List<User> noAccessedUsers;
	
}
