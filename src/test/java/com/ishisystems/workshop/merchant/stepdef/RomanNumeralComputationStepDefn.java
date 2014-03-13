package com.ishisystems.workshop.merchant.stepdef;

import com.ishisystems.workshop.merchant.RomanNumeralCalculator;
import com.ishisystems.workshop.merchant.RomanSymbol;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static com.googlecode.catchexception.CatchException.catchException;
import static com.googlecode.catchexception.CatchException.caughtException;
import static com.googlecode.catchexception.apis.CatchExceptionBdd.then;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RomanNumeralComputationStepDefn {

    private Integer result;
    private RomanNumeralCalculator romanNumeralCalculator;

    @Given("^Roman symbols having value:$")
    public void Roman_symbols_having_value(List<RomanSymbol> romanSymbols) throws Throwable {
        romanNumeralCalculator = new RomanNumeralCalculator(romanSymbols);
    }

    @When("^input is (\\w+)$")
    public void input_is(String inputString) throws Throwable {
        result = catchException(romanNumeralCalculator).getValue(inputString);
    }
    @Then("^value should be (\\d+)$")
    public void value_should_be(int expectedResult) throws Throwable {
        assertThat(result, is(expectedResult));
    }

    @Then("^an exception is thrown with the message: Illegal repetition of roman symbol, the symbol (\\w) has been repeated more than (\\d+) times? in succession$")
    public void an_exception_is_thrown_with_the_message_Illegal_repetition_of_roman_symbol_the_symbol_has_been_repeated_more_than_times_in_succession(Character symbolName, int repeatCount) throws Throwable {
        then(caughtException())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Illegal repetition of roman symbol, the symbol " + symbolName + " has been repeated more than " + repeatCount + " times in succession")
                .hasNoCause();
    }

    @Then("^an exception is thrown with the message: Illegal sequence, a symbol cannot precede a symbol which is more than ten times its value, (\\w) has preceded (\\w)$")
    public void an_exception_is_thrown_with_the_message_Illegal_sequence_a_symbol_cannot_precede_a_symbol_which_is_more_than_ten_times_its_value_I_has_preceded_L(Character precedingSymbolName, Character symbolName) throws Throwable {
        then(caughtException())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Illegal sequence, a symbol cannot precede a symbol which is more than ten times its value, " + precedingSymbolName + " has preceded " + symbolName)
                .hasNoCause();
    }

    @Then("^an exception is thrown with the message: Illegal sequence, the symbol (\\w) cannot precede the symbol (\\w)$")
    public void an_exception_is_thrown_with_the_message_Illegal_sequence_the_symbol_I_cannot_precede_the_symbol_L(Character precedingSymbolName, Character symbolName) throws Throwable {
        then(caughtException())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Illegal sequence, the symbol " + precedingSymbolName + " cannot precede the symbol " + symbolName)
                .hasNoCause();
    }

    @Then("^an exception is thrown with the message: Illegal sequence, a symbol cannot be preceded with more than one small value symbol, (\\w\\w) has preceded (\\w)$")
    public void an_exception_is_thrown_with_the_message_Illegal_sequence_a_symbol_cannot_be_preceded_with_more_than_one_small_value_symbol(String precedingSymbolNames, Character symbolName) throws Throwable {
        then(caughtException())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Illegal sequence, a symbol cannot be preceded with more than one small value symbol, " + precedingSymbolNames + " have preceded " + symbolName)
                .hasNoCause();
    }

    @Then("^an exception is thrown with the message: Illegal sequence, converted Arabic number cannot be broken into digits to get back the number.$")
    public void an_exception_is_thrown_with_the_message_Illegal_sequence_converted_Arabic_numeral_cannot_be_broken_into_digits_to_get_back_the_number() throws Throwable {
        then(caughtException())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Illegal sequence, converted Arabic number cannot be broken into digits to get back the number.")
                .hasNoCause();
    }


}
