package sendquick.remittance.limit.domain;

import java.util.Date;

public class TransactionLimit {

    private String customerId;
    private String payeeId;

    private String sourceCountry;
    private String sourceCurrency;

    private String destinationCountry;
    private String destinationCurrency;

    private Double remitAmount;
    private Double exchangeRateUSD;

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

}
