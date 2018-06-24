package sendquick.remittance.limit.domain;

import java.util.Date;

public class TransactionLimit {

    private String customerId;
    private String payeeId;
    private Date payeeCreationDate;

    private Double remitAmount;

    private Date createdDate;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getPayeeId() {
        return payeeId;
    }

    public void setPayeeId(String payeeId) {
        this.payeeId = payeeId;
    }

    public Date getPayeeCreationDate() {
        return payeeCreationDate;
    }

    public void setPayeeCreationDate(Date payeeCreationDate) {
        this.payeeCreationDate = payeeCreationDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Double getRemitAmount() {
        return remitAmount;
    }

    public void setRemitAmount(Double remitAmount) {
        this.remitAmount = remitAmount;
    }
}
