package patterns_with_lambda.template_method.lambda;

/**
 * Created by Mezentsev.Y on 5/16/2016.
 */
public class CompanyLoanApplication  extends LoanApplication{

    public CompanyLoanApplication(Company company) {
        super(company::checkIdentity,
                company::checkHistoricalDebt,
                company::checkProfitAndLoss);
//        super(
//                ()-> company.checkIdentity(),
//                ()-> company.checkHistoricalDebt(),
//                ()-> company.checkProfitAndLoss()
//        );
    }
}
