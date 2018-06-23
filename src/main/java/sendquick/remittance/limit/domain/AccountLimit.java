package sendquick.remittance.limit.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author narayana
 */
public class AccountLimit {

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
}
