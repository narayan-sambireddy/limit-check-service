package sendquick.remittance.limit.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author narayana
 */
@Entity
@Table(name = "ACCOUNT_LIMIT")
public class AccountLimitEntity {

	@Id
	private String customerId;
	private Double yearlyLimit;
	private Double remainingYearlyLimit;
	private Double dailyLimit;
	private Double remainingDailyLimit;
	private Date lastModifiedDate;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Double getYearlyLimit() {
		return yearlyLimit;
	}

	public void setYearlyLimit(Double yearlyLimit) {
		this.yearlyLimit = yearlyLimit;
	}

	public Double getRemainingYearlyLimit() {
		return remainingYearlyLimit;
	}

	public void setRemainingYearlyLimit(Double remainingYearlyLimit) {
		this.remainingYearlyLimit = remainingYearlyLimit;
	}

	public Double getDailyLimit() {
		return dailyLimit;
	}

	public void setDailyLimit(Double dailyLimit) {
		this.dailyLimit = dailyLimit;
	}

	public Double getRemainingDailyLimit() {
		return remainingDailyLimit;
	}

	public void setRemainingDailyLimit(Double remainingDailyLimit) {
		this.remainingDailyLimit = remainingDailyLimit;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	@PrePersist
	@PreUpdate
	@JsonIgnore
	public void preInserts() {
		lastModifiedDate = new Date();
	}

}
