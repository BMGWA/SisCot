package model;

public class Provider {
	private String providerCnpj;
	private String providerName;
	private String providerEmail;
	private String providerPassword;
	private int providerDdd;
	private int providerPhone;
	private String prodiverAdress;
	private String prodiverCity;
	private String prodiverState;
	private int prodiverZip;
	
	public Provider() {
		
	}

	public Provider(String providerCnpj, String providerName, String providerEmail, String providerPassword,
			int providerDdd, int providerPhone, String prodiverAdress, String prodiverCity, String prodiverState,
			int prodiverZip) {
		super();
		this.providerCnpj = providerCnpj;
		this.providerName = providerName;
		this.providerEmail = providerEmail;
		this.providerPassword = providerPassword;
		this.providerDdd = providerDdd;
		this.providerPhone = providerPhone;
		this.prodiverAdress = prodiverAdress;
		this.prodiverCity = prodiverCity;
		this.prodiverState = prodiverState;
		this.prodiverZip = prodiverZip;
	}

	public String getProviderCnpj() {
		return providerCnpj;
	}

	public void setProviderCnpj(String providerCnpj) {
		this.providerCnpj = providerCnpj;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public String getProviderEmail() {
		return providerEmail;
	}

	public void setProviderEmail(String providerEmail) {
		this.providerEmail = providerEmail;
	}

	public String getProviderPassword() {
		return providerPassword;
	}

	public void setProviderPassword(String providerPassword) {
		this.providerPassword = providerPassword;
	}

	public int getProviderDdd() {
		return providerDdd;
	}

	public void setProviderDdd(int providerDdd) {
		this.providerDdd = providerDdd;
	}

	public int getProviderPhone() {
		return providerPhone;
	}

	public void setProviderPhone(int providerPhone) {
		this.providerPhone = providerPhone;
	}

	public String getProdiverAdress() {
		return prodiverAdress;
	}

	public void setProdiverAdress(String prodiverAdress) {
		this.prodiverAdress = prodiverAdress;
	}

	public String getProdiverCity() {
		return prodiverCity;
	}

	public void setProdiverCity(String prodiverCity) {
		this.prodiverCity = prodiverCity;
	}

	public String getProdiverState() {
		return prodiverState;
	}

	public void setProdiverState(String prodiverState) {
		this.prodiverState = prodiverState;
	}

	public int getProdiverZip() {
		return prodiverZip;
	}

	public void setProdiverZip(int prodiverZip) {
		this.prodiverZip = prodiverZip;
	}
}
