package patterns_with_lambda.template_method.lambda;

import patterns_with_lambda.template_method.ApplicationDenied;

/**
 * Created by Mezentsev.Y on 5/16/2016.
 */
public interface Criteria {
    void check() throws ApplicationDenied;
}
