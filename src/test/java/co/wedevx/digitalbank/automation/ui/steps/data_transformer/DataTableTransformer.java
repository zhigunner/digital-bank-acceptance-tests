package co.wedevx.digitalbank.automation.ui.steps.data_transformer;

import co.wedevx.digitalbank.automation.ui.models.*;
import io.cucumber.java.DataTableType;

import java.util.Map;

public class DataTableTransformer {

    @DataTableType
    public AccountCard accountCarsEntry(Map<String, String> entry) {
        String accountName = entry.get("accountName");
        String accountType = entry.get("accountType");
        String ownership = entry.get("ownership");
        long accountNumber = Long.valueOf(entry.get("accountNumber"));
        String interestRate = entry.get("interestRate");
        double balance = Double.parseDouble(entry.get("balance"));

        return new AccountCard(accountName, accountType, ownership, accountNumber, interestRate, balance);
    }

    @DataTableType
    public BankTransaction transactionEntry(Map<String,String> entry) {
        String date = entry.get("date");
        String category = entry.get("category");
        String description = entry.get("description");
        double amount = Double.parseDouble(entry.get("amount"));
        double balance = Double.parseDouble(entry.get("balance"));

        return new BankTransaction(date, category, description, amount, balance);
    }

    @DataTableType
    public CheckingAccountInfo checkingAccount_infoEntry(Map<String,String> entry) {
        String accountType = entry.get("checkingAccountType");
        String ownership = entry.get("accountOwnership");
        String accountName = entry.get("accountName");
        double balance = Double.parseDouble(entry.get("initialDepositAmount"));

        return new CheckingAccountInfo(accountType, ownership, accountName, balance);
    }

    @DataTableType
    public SavingsAccountInfo savingsAccount_infoEntry(Map<String,String> entry) {
        String savingsAccountType = entry.get("savingsAccountType");
        String savingsOwnership = entry.get("accountOwnership");
        String savingsAccountName = entry.get("accountName");
        double savingsBalance = Double.parseDouble(entry.get("initialDepositAmount"));

        return new SavingsAccountInfo(savingsAccountType, savingsOwnership, savingsAccountName, savingsBalance);
    }
}
