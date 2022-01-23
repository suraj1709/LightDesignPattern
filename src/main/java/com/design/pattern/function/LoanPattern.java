package com.design.pattern.function;

import java.util.function.Consumer;

public class LoanPattern {

    private int userId;

    private LoanPattern(int userId) {
        this.userId = userId;
    }

    public LoanPattern validateLoan() {
        //Some Check or Logic
        System.out.println("Validating loan for user Id : " + this.userId);
        if (this.userId % 2 != 0) {
            this.loanProcessSuccess();
        } else {
            this.loanProcessFailed();
        }
        return this;
    }

    private LoanPattern loanProcessSuccess() {
        System.out.println("Validation Complete Processing for loan : " + this.userId);
        return this;
    }

    private LoanPattern loanProcessFailed() {
        System.out.println("Validation Incomplete Processing for loan : " + this.userId);
        return this;
    }

    private void loanProcessed() {
        System.out.println("Loan Processed");
    }


    public static void loanApproved(int userId, Consumer<LoanPattern> loan) {
        LoanPattern loanPattern = new LoanPattern(userId);
        try {
            loan.accept(loanPattern);
            System.out.println("Loan System Complete for user : " + userId);
        } finally {
            loanPattern.loanProcessed();
        }

    }

}

class LoanPatternTest {
    public static void main(String[] args) {
        LoanPattern.loanApproved(123, loanToProcess ->
                loanToProcess.validateLoan());
    }

}
