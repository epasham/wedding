package org.debugroom.wedding.app.model.profile;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Data
@AllArgsConstructor
@Builder
public class User implements Serializable{

	private static final long serialVersionUID = 385582443972476188L;

	public User(){
	}
	
	@NotNull
	@Size(min=8, max=8)
	@Pattern(regexp = "[0-9]*")
	private String userId;
	@NotNull
	@Size(min=1, max=50)
	@Pattern(regexp="^[^ =#$%&./<>?¥^¥~¥[¥]¥¥]+$")
	private String lastName;
	@NotNull
	@Size(min=1, max=50)
	@Pattern(regexp="^[^ =#$%&./<>?¥^¥~¥[¥]¥¥]+$")
	private String firstName;
	@NotNull
	@Size(min=1, max=1024)
	@Pattern(regexp = "[-¥.¥ ¥/a-zA-Z0-9]*")
	private String imageFilePath;
	@NotNull
	@Size(min=1, max=32)
	@Pattern(regexp = "[a-zA-Z0-9¥.¥-]*")
	private String loginId;
	@NotNull
	private boolean isBrideSide;
	@Valid
	private Address address;
	@Valid
	private List<Credential> credentials;
	@Valid
	private List<Email> emails;
	@Valid
	private List<Notification> notifications;

}
