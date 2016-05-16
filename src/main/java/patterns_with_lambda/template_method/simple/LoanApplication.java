package patterns_with_lambda.template_method.simple;

import patterns_with_lambda.template_method.ApplicationDenied;

/**
 * Created by Mezentsev.Y on 5/16/2016.
 */
public abstract class LoanApplication {
    public void checkLoanApplication() throws ApplicationDenied {
        checkIdentity();
        checkCreditHistory();
        checkIncomeHistory();
        reportFindings();
    }

    protected abstract void checkIdentity() throws ApplicationDenied;

    protected abstract void checkIncomeHistory() throws ApplicationDenied;

    protected abstract void checkCreditHistory() throws ApplicationDenied;

    private void reportFindings() {
// END LoanApplication

    }
}
