package com.org.benefitplan.domain;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class BenefitPlan {

	private int benefitPlanId;

	public int getBenefitPlanId() {
		return benefitPlanId;
	}

	public void setBenefitPlanId(int benefitPlanId) {
		this.benefitPlanId = benefitPlanId;
	}

	public String getBenefitPlanName() {
		return benefitPlanName;
	}

	public void setBenefitPlanName(String benefitPlanName) {
		this.benefitPlanName = benefitPlanName;
	}

	@NotNull
	private String benefitPlanName;

}
