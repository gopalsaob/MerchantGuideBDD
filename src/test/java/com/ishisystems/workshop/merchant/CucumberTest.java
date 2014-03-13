package com.ishisystems.workshop.merchant;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@Cucumber.Options(features = "classpath:com/ishisystems/workshop/merchant/",
        glue = "classpath:com.ishisystems.workshop.merchant.stepdef", format = {"pretty", "html:target/reports/cucumber"}
        )
//        , tags="@validation")
public class CucumberTest {
}
