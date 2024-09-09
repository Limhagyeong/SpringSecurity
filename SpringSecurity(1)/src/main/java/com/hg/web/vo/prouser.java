package com.hg.web.vo;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class prouser {
	private int id;

	private String username;

	private String password;

	private String role;
}
