package com.ishisystems.workshop.merchant.validators;

import com.ishisystems.workshop.merchant.RomanSymbolWithTypeInformation;
import com.ishisystems.workshop.merchant.SymbolsVisitor;

/**
 * Filename:    $RCSfile$ Label:       $Name$ Last Change: $Author$    	 On:	$Date$
 * <p/>
 * Validates if RomanSymbols are in valid sequence for Substraction rule when smaller value precedes larger value
 *
 * @author GGSHAH
 * @version $Revision$
 */
public class SequenceValidator implements SymbolsVisitor {

    @Override
    public void visit(RomanSymbolWithTypeInformation romanSymbol, RomanSymbolWithTypeInformation previousSymbol) {
        if (previousSymbol.getValue() >= romanSymbol.getValue()) {
            return;
        }
        if (previousSymbol.isFirstDigitFive()) {
            throwExceptionForIllegalSubtractionSequence(romanSymbol, previousSymbol);
        }

        if (isPrecedingASymbolWithMorethanTenTimesValue(romanSymbol, previousSymbol)) {
            throwExceptionForIllegalSubtractionSequenceForPrecedingMoreThanTenTimesValue(romanSymbol, previousSymbol);
        }
    }

    private boolean isPrecedingASymbolWithMorethanTenTimesValue(RomanSymbolWithTypeInformation romanSymbol, RomanSymbolWithTypeInformation previousSymbol) {
        return (previousSymbol.getValue() * 10 ) < romanSymbol.getValue();
    }

    private void throwExceptionForIllegalSubtractionSequence(RomanSymbolWithTypeInformation romanSymbol, RomanSymbolWithTypeInformation previousSymbol) {
        throw new IllegalArgumentException("Illegal sequence, the symbol " + previousSymbol.getSymbolName() +
                " cannot precede the symbol " + romanSymbol.getSymbolName());
    }

    private void throwExceptionForIllegalSubtractionSequenceForPrecedingMoreThanTenTimesValue(RomanSymbolWithTypeInformation romanSymbol, RomanSymbolWithTypeInformation previousSymbol) {
        throw new IllegalArgumentException("Illegal sequence, a symbol cannot precede a symbol which is more than ten times its value, " + previousSymbol.getSymbolName() +
                " has preceded " + romanSymbol.getSymbolName());
    }
}