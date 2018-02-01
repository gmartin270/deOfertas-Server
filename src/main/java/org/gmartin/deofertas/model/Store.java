package org.gmartin.deofertas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="STORES")
public class Store extends GenericObject {

	@Column(name="BUSINESS_NAME", nullable=false)
	private String businessName;

	@Column(name="LOGO", nullable=true)
	private byte[] logo;
	
	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public byte[] getLogo() {
		return logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}
}
