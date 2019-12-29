package com.defteam.modal;


import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="cms_user_claim_transaction_details")
public class ClaimDetail {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CLAIM_ID")
	private	Long id;//claimId
	
	@Column(name="EMP_ID")	
	private	String empId;
	
	@Column(name="TO_MAIL_ID")	
	private	String toMailId;
	
	@Column(name="FROM_MAIL_ID")	
	private	String fromMailId;
	
	@Column(name="FROM_MAILID_USER_NAME")	
	private	String fromMaildUserName;
	
	
	@Column(name="CLAIM_DATE")	
	private	Date claimDate;
	
	@Column(name="TRANSACTION_DATE")	
	private	Date transactionDate;
	
	@Column(name="CLAIM_CODE")	
	private String claimCode	;
	
	@Column(name="CLAIM_TYPE")	
	private	String claimType;
	
	@Column(name="CLAIM_DESCRIPTION")	
	private	String claimDescription;
	
	@Column(name="CURRENCY_TYPE")	
	private	String currencyType;
	
	
	@Column(name="CLAIM_AMOUNT")	
	private	String claimAmount;
	
	@Column(name="CLAIM_VERSION")	
	private	String claimVersion;
	
	@Column(name="CLAIM_SECTION")	
	private	String claimSection;
	
	@Column(name="ATTACHMENT_NAME")	
	private	String attachmentName;
	
	@Column(name="ATTACHMENT_SEQUENCE")	
	private	Integer attachmentSequence;
	
	@Column(name="PROCESS_TIME_STAMP")	
	private	Date processTimeStamp;

	@Column(name="IS_USER_COMMIT")	
	private	String isUserCommit;
	
	@Column(name="STATUS")
	private	String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getToMailId() {
		return toMailId;
	}

	public void setToMailId(String toMailId) {
		this.toMailId = toMailId;
	}

	public String getFromMailId() {
		return fromMailId;
	}

	public void setFromMailId(String fromMailId) {
		this.fromMailId = fromMailId;
	}

	public String getFromMaildUserName() {
		return fromMaildUserName;
	}

	public void setFromMaildUserName(String fromMaildUserName) {
		this.fromMaildUserName = fromMaildUserName;
	}

	public Date getClaimDate() {
		return claimDate;
	}

	public void setClaimDate(Date claimDate) {
		this.claimDate = claimDate;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getClaimCode() {
		return claimCode;
	}

	public void setClaimCode(String claimCode) {
		this.claimCode = claimCode;
	}

	public String getClaimType() {
		return claimType;
	}

	public void setClaimType(String claimType) {
		this.claimType = claimType;
	}

	public String getClaimDescription() {
		return claimDescription;
	}

	public void setClaimDescription(String claimDescription) {
		this.claimDescription = claimDescription;
	}

	public String getCurrencyType() {
		return currencyType;
	}

	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}

	public String getClaimAmount() {
		return claimAmount;
	}

	public void setClaimAmount(String claimAmount) {
		this.claimAmount = claimAmount;
	}

	public String getClaimVersion() {
		return claimVersion;
	}

	public void setClaimVersion(String claimVersion) {
		this.claimVersion = claimVersion;
	}

	public String getClaimSection() {
		return claimSection;
	}

	public void setClaimSection(String claimSection) {
		this.claimSection = claimSection;
	}

	public String getAttachmentName() {
		return attachmentName;
	}

	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}

	public Integer getAttachmentSequence() {
		return attachmentSequence;
	}

	public void setAttachmentSequence(Integer attachmentSequence) {
		this.attachmentSequence = attachmentSequence;
	}

	public Date getProcessTimeStamp() {
		return processTimeStamp;
	}

	public void setProcessTimeStamp(Date processTimeStamp) {
		this.processTimeStamp = processTimeStamp;
	}

	public String getIsUserCommit() {
		return isUserCommit;
	}

	public void setIsUserCommit(String isUserCommit) {
		this.isUserCommit = isUserCommit;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClaimDetail other = (ClaimDetail) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ClaimDetail [id=" + id + ", empId=" + empId + ", toMailId=" + toMailId + ", fromMailId=" + fromMailId
				+ ", fromMaildUserName=" + fromMaildUserName + ", claimDate=" + claimDate + ", transactionDate="
				+ transactionDate + ", claimCode=" + claimCode + ", claimType=" + claimType + ", claimDescription="
				+ claimDescription + ", currencyType=" + currencyType + ", claimAmount=" + claimAmount
				+ ", claimVersion=" + claimVersion + ", claimSection=" + claimSection + ", attachmentName="
				+ attachmentName + ", attachmentSequence=" + attachmentSequence + ", processTimeStamp="
				+ processTimeStamp + ", isUserCommit=" + isUserCommit + ", status=" + status + "]";
	}

	



	
}
