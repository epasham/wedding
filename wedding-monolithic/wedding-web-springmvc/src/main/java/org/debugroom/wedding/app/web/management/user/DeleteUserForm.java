package org.debugroom.wedding.app.web.management.user;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Builder;


@Data
@AllArgsConstructor
@Builder
public class DeleteUserForm implements Serializable{

	private static final long serialVersionUID = 7440076377576575712L;

	public DeleteUserForm(){}
	

	@NotNull
	@Size(min=8, max=8)
	@Pattern(regexp = "[0-9]*")
	private String userId;

	@NotNull
	@Pattern(regexp = "[a-zA-Z0-9¥.¥-]*")
	private String type;

}
