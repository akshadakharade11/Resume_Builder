package com.example.demo.dtos;
import java.time.LocalDate;

	public class InternshipResponse {
	    private String title;
	    private String description;
	    private LocalDate startDate;
	    private LocalDate endDate;
	    private String certificateUrl;
	    private boolean verified;
	    
	    public InternshipResponse() {}
	    
		public InternshipResponse(String title, String description, LocalDate startDate, LocalDate endDate,
				String certificateUrl, boolean verified) {
			super();
			this.title = title;
			this.description = description;
			this.startDate = startDate;
			this.endDate = endDate;
			this.certificateUrl = certificateUrl;
			this.verified = verified;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public LocalDate getStartDate() {
			return startDate;
		}

		public void setStartDate(LocalDate startDate) {
			this.startDate = startDate;
		}

		public LocalDate getEndDate() {
			return endDate;
		}

		public void setEndDate(LocalDate endDate) {
			this.endDate = endDate;
		}

		public String getCertificateUrl() {
			return certificateUrl;
		}

		public void setCertificateUrl(String certificateUrl) {
			this.certificateUrl = certificateUrl;
		}

		public boolean isVerified() {
			return verified;
		}

		public void setVerified(boolean verified) {
			this.verified = verified;
		}

	}


