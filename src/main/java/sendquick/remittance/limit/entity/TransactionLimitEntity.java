package sendquick.remittance.limit.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TRANSACTION_LIMIT")
public class TransactionLimitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String customerId;
    private String payeeId;

    private Date payeeCreationDate;

    private String sourceCountry;
    private String sourceCurrency;

    private String destinationCountry;
    private String destinationCurrency;

    private Double remitAmount;
    private Double exchangeRateUSD;

    private String status;
    private String remarks;

    private Date createdDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getSourceCountry() {
        return sourceCountry;
    }

    public void setSourceCountry(String sourceCountry) {
        this.sourceCountry = sourceCountry;
    }

    public String getSourceCurrency() {
        return sourceCurrency;
    }

    public void setSourceCurrency(String sourceCurrency) {
        this.sourceCurrency = sourceCurrency;
    }

    public String getDestinationCountry() {
        return destinationCountry;
    }

    public void setDestinationCountry(String destinationCountry) {
        this.destinationCountry = destinationCountry;
    }

    public String getDestinationCurrency() {
        return destinationCurrency;
    }

    public void setDestinationCurrency(String destinationCurrency) {
        this.destinationCurrency = destinationCurrency;
    }

    public Double getRemitAmount() {
        return remitAmount;
    }

    public void setRemitAmount(Double remitAmount) {
        this.remitAmount = remitAmount;
    }

    public Double getExchangeRateUSD() {
        return exchangeRateUSD;
    }

    public void setExchangeRateUSD(Double exchangeRateUSD) {
        this.exchangeRateUSD = exchangeRateUSD;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @PrePersist
    public void preInserts() {
        createdDate = new Date();
    }
}
