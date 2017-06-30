package com.org.benefitplan.domain;

public enum GroupType {

	CORPORATE, INDIVIDUAL, OTHER;

	public static GroupType getDefault() {
		return CORPORATE;
	}
}
