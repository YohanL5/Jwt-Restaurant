package com.behl.cerberus.entity;

import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserStatus {
	
	PENDING_APPROVAL("Pending Approval", List.of("userprofile.read", "userprofile.update", "useridentity.verify")),
	APPROVED("Approved", List.of("fullaccess")),
	Admin("Admin", List.of("fullaccessAdmin")),
	DEACTIVATED("Deactivated", List.of("userprofile.read"));
	
	private final String value;
	private final List<String> scopes;

}
