package co.wedevx.digitalbank.automation.ui.models;

public class CheckingAccountWithoutAnAccountTypeInfo {
    private String accountOwnership;
    private String accountName;
    private double initialDepositAmount;

    public CheckingAccountWithoutAnAccountTypeInfo(String accountOwnership, String accountName, double initialDepositAmount) {
        this.accountOwnership = accountOwnership;
        this.accountName = accountName;
        this.initialDepositAmount = initialDepositAmount;
    }

    public String getAccountOwnership() {
        return accountOwnership;
    }

    public void setAccountOwnership(String accountOwnership) {
        this.accountOwnership = accountOwnership;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getInitialDepositAmount() {
        return initialDepositAmount;
    }

    public void setInitialDepositAmount(double initialDepositAmount) {
        this.initialDepositAmount = initialDepositAmount;
    }
}
