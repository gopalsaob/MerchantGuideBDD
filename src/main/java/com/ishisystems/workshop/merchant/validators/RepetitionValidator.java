package com.ishisystems.workshop.merchant.validators;

import com.ishisystems.workshop.merchant.RomanSymbolWithTypeInformation;
import com.ishisystems.workshop.merchant.SymbolsVisitor;

/**
 * Filename:    $RCSfile$ Label:       $Name$ Last Change: $Author$    	 On:	$Date$
 *
 * @author GGSHAH
 * @version $Revision$
 */
public class RepetitionValidator implements SymbolsVisitor {

    private Integer numberOfRepeats = 1;
    private final Integer MAX_PERMITTED_REPEATS_FOR_SYMBOLS_WHOSE_FIRST_DIGIT_HAS_VALUE_FIVE = 1;
    private final Integer MAX_PERMITTED_REPEATS_FOR_OTHER_SYMBOLS = 3;

    @Override
    public void visit(RomanSymbolWithTypeInformation romanSymbol, RomanSymbolWithTypeInformation previousSymbol) {
        updateNumberOfRepeats(romanSymbol, previousSymbol);
        throwExceptionIfMaxRepeatExceeded(numberOfRepeats, romanSymbol);
    }

    private int getMaxPermittedRepeatation(RomanSymbolWithTypeInformation romanSymbol) {
        return romanSymbol.isFirstDigitFive() ?
                MAX_PERMITTED_REPEATS_FOR_SYMBOLS_WHOSE_FIRST_DIGIT_HAS_VALUE_FIVE :
                MAX_PERMITTED_REPEATS_FOR_OTHER_SYMBOLS;
    }

    private void updateNumberOfRepeats(RomanSymbolWithTypeInformation romanSymbol, RomanSymbolWithTypeInformation previousSymbol) {
        if (romanSymbol.equals(previousSymbol)) {
            incrementNumberOfRepeats();
        } else {
            resetNumberOfRepeats();
        }
    }

    private void incrementNumberOfRepeats() {
        numberOfRepeats++;
    }

    private void resetNumberOfRepeats() {
        numberOfRepeats = 1;
    }

    private void throwExceptionIfMaxRepeatExceeded(int numberOfRepeats, RomanSymbolWithTypeInformation romanSymbol) {
        if (numberOfRepeats > getMaxPermittedRepeatation(romanSymbol)) {
            throw new IllegalArgumentException("Illegal repetition of roman symbol, the symbol " + romanSymbol.getSymbolName()
                    + " has been repeated more than " + getMaxPermittedRepeatation(romanSymbol) + " times in succession");
        }
    }
}