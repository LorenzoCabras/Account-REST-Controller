package it.bank.account.dto.domain.moneytransfer;

import java.time.LocalDate;
import java.util.Objects;

public class MoneyTransferRequest {
    private Creditor creditor;
    private String executionDate;
    private String uri;
    private String description;
    private double amount;
    private String currency;
    private boolean isUrgent;
    private boolean isInstant;
    private String feeType;
    private String feeAccountId;

/* Field commented as it is not recognized in the Sandbox environment.
    private TaxRelief taxRelief;
 */

    class TaxRelief {
        private String taxReliefId;
        private boolean isCondoUpgrade;
        private String creditorFiscalCode;
        private String beneficiaryType;
        private NaturalPersonBeneficiary naturalPersonBeneficiary;
        private LegalPersonBeneficiary legalPersonBeneficiary;

        public TaxRelief(String taxReliefId, boolean isCondoUpgrade, String creditorFiscalCode, String beneficiaryType, NaturalPersonBeneficiary naturalPersonBeneficiary, LegalPersonBeneficiary legalPersonBeneficiary) {
            this.taxReliefId = taxReliefId;
            this.isCondoUpgrade = isCondoUpgrade;
            this.creditorFiscalCode = creditorFiscalCode;
            this.beneficiaryType = beneficiaryType;
            this.naturalPersonBeneficiary = naturalPersonBeneficiary;
            this.legalPersonBeneficiary = legalPersonBeneficiary;
        }

        public TaxRelief() {
        }

        public String getTaxReliefId() {
            return taxReliefId;
        }

        public void setTaxReliefId(String taxReliefId) {
            this.taxReliefId = taxReliefId;
        }

        public boolean isCondoUpgrade() {
            return isCondoUpgrade;
        }

        public void setCondoUpgrade(boolean condoUpgrade) {
            isCondoUpgrade = condoUpgrade;
        }

        public String getCreditorFiscalCode() {
            return creditorFiscalCode;
        }

        public void setCreditorFiscalCode(String creditorFiscalCode) {
            this.creditorFiscalCode = creditorFiscalCode;
        }

        public String getBeneficiaryType() {
            return beneficiaryType;
        }

        public void setBeneficiaryType(String beneficiaryType) {
            this.beneficiaryType = beneficiaryType;
        }

        public NaturalPersonBeneficiary getNaturalPersonBeneficiary() {
            return naturalPersonBeneficiary;
        }

        public void setNaturalPersonBeneficiary(NaturalPersonBeneficiary naturalPersonBeneficiary) {
            this.naturalPersonBeneficiary = naturalPersonBeneficiary;
        }

        public LegalPersonBeneficiary getLegalPersonBeneficiary() {
            return legalPersonBeneficiary;
        }

        public void setLegalPersonBeneficiary(LegalPersonBeneficiary legalPersonBeneficiary) {
            this.legalPersonBeneficiary = legalPersonBeneficiary;
        }

        @Override
        public String toString() {
            return "TaxRelief{" +
                    "taxReliefId='" + taxReliefId + '\'' +
                    ", isCondoUpgrade=" + isCondoUpgrade +
                    ", creditorFiscalCode='" + creditorFiscalCode + '\'' +
                    ", beneficiaryType='" + beneficiaryType + '\'' +
                    ", naturalPersonBeneficiary=" + naturalPersonBeneficiary +
                    ", legalPersonBeneficiary=" + legalPersonBeneficiary +
                    '}';
        }

        class NaturalPersonBeneficiary {
            private String fiscalCode1;
            private String fiscalCode2;
            private String fiscalCode3;
            private String fiscalCode4;
            private String fiscalCode5;

            public NaturalPersonBeneficiary() {
            }

            public NaturalPersonBeneficiary(String fiscalCode1, String fiscalCode2, String fiscalCode3, String fiscalCode4, String fiscalCode5) {
                this.fiscalCode1 = fiscalCode1;
                this.fiscalCode2 = fiscalCode2;
                this.fiscalCode3 = fiscalCode3;
                this.fiscalCode4 = fiscalCode4;
                this.fiscalCode5 = fiscalCode5;
            }

            @Override
            public String toString() {
                return "NaturalPersonBeneficiary{" +
                        "fiscalCode1='" + fiscalCode1 + '\'' +
                        ", fiscalCode2='" + fiscalCode2 + '\'' +
                        ", fiscalCode3='" + fiscalCode3 + '\'' +
                        ", fiscalCode4='" + fiscalCode4 + '\'' +
                        ", fiscalCode5='" + fiscalCode5 + '\'' +
                        '}';
            }

            public String getFiscalCode1() {
                return fiscalCode1;
            }

            public void setFiscalCode1(String fiscalCode1) {
                this.fiscalCode1 = fiscalCode1;
            }

            public String getFiscalCode2() {
                return fiscalCode2;
            }

            public void setFiscalCode2(String fiscalCode2) {
                this.fiscalCode2 = fiscalCode2;
            }

            public String getFiscalCode3() {
                return fiscalCode3;
            }

            public void setFiscalCode3(String fiscalCode3) {
                this.fiscalCode3 = fiscalCode3;
            }

            public String getFiscalCode4() {
                return fiscalCode4;
            }

            public void setFiscalCode4(String fiscalCode4) {
                this.fiscalCode4 = fiscalCode4;
            }

            public String getFiscalCode5() {
                return fiscalCode5;
            }

            public void setFiscalCode5(String fiscalCode5) {
                this.fiscalCode5 = fiscalCode5;
            }
        }

        class LegalPersonBeneficiary {
            private String fiscalCode;
            private String legalRepresentativeFiscalCode;

            public LegalPersonBeneficiary(String fiscalCode, String legalRepresentativeFiscalCode) {
                this.fiscalCode = fiscalCode;
                this.legalRepresentativeFiscalCode = legalRepresentativeFiscalCode;
            }

            public LegalPersonBeneficiary() {
            }

            @Override
            public String toString() {
                return "LegalPersonBeneficiary{" +
                        "fiscalCode='" + fiscalCode + '\'' +
                        ", legalRepresentativeFiscalCode='" + legalRepresentativeFiscalCode + '\'' +
                        '}';
            }

            public String getFiscalCode() {
                return fiscalCode;
            }

            public void setFiscalCode(String fiscalCode) {
                this.fiscalCode = fiscalCode;
            }

            public String getLegalRepresentativeFiscalCode() {
                return legalRepresentativeFiscalCode;
            }

            public void setLegalRepresentativeFiscalCode(String legalRepresentativeFiscalCode) {
                this.legalRepresentativeFiscalCode = legalRepresentativeFiscalCode;
            }
        }
    }

    public MoneyTransferRequest(Creditor creditor, String executionDate, String uri, String description, double amount, String currency, boolean isUrgent, boolean isInstant, String feeType, String feeAccountId) {
        this.creditor = creditor;
        this.executionDate = executionDate;
        this.uri = uri;
        this.description = description;
        this.amount = amount;
        this.currency = currency;
        this.isUrgent = isUrgent;
        this.isInstant = isInstant;
        this.feeType = feeType;
        this.feeAccountId = feeAccountId;
//        this.taxRelief = taxRelief;
    }

    public MoneyTransferRequest() {
    }

    public Creditor getCreditor() {
        return creditor;
    }

    public void setCreditor(Creditor creditor) {
        this.creditor = creditor;
    }

    public String getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(String executionDate) {
        this.executionDate = executionDate;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public boolean isUrgent() {
        return isUrgent;
    }

    public void setUrgent(boolean urgent) {
        isUrgent = urgent;
    }

    public boolean isInstant() {
        return isInstant;
    }

    public void setInstant(boolean instant) {
        isInstant = instant;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public String getFeeAccountId() {
        return feeAccountId;
    }

    public void setFeeAccountId(String feeAccountId) {
        this.feeAccountId = feeAccountId;
    }
/*
    public TaxRelief getTaxRelief() {
        return taxRelief;
    }

    public void setTaxRelief(TaxRelief taxRelief) {
        this.taxRelief = taxRelief;
    }
*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoneyTransferRequest that = (MoneyTransferRequest) o;
        return Double.compare(amount, that.amount) == 0 && isUrgent == that.isUrgent && isInstant == that.isInstant && Objects.equals(creditor, that.creditor) && Objects.equals(executionDate, that.executionDate) && Objects.equals(uri, that.uri) && Objects.equals(description, that.description) && Objects.equals(currency, that.currency) && Objects.equals(feeType, that.feeType) && Objects.equals(feeAccountId, that.feeAccountId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(creditor, executionDate, uri, description, amount, currency, isUrgent, isInstant, feeType, feeAccountId);
    }

    @Override
    public String toString() {
        return "MoneyTransferRequest{" +
                "creditor=" + creditor +
                ", executionDate='" + executionDate + '\'' +
                ", uri='" + uri + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", isUrgent=" + isUrgent +
                ", isInstant=" + isInstant +
                ", feeType='" + feeType + '\'' +
                ", feeAccountId='" + feeAccountId + '\'' +
                '}';
    }
}