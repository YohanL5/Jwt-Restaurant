package com.behl.cerberus.entity;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private UUID id;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email_id", nullable = false, unique = true)
	private String emailId;

	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "status", nullable = false)
	private UserStatus userStatus;

	@Column(name = "created_at", nullable = false)
	private LocalDateTime createdAt;

	@PrePersist
	void onCreate() {
		this.id = UUID.randomUUID();
		this.userStatus = UserStatus.PENDING_APPROVAL;
		this.createdAt = LocalDateTime.now(ZoneOffset.UTC);
	}

}