package com.ishisystems.workshop.merchant.validators;

import com.ishisystems.workshop.merchant.RomanSymbol;
import com.ishisystems.workshop.merchant.RomanSymbolWithTypeInformation;
import com.ishisystems.workshop.merchant.SymbolsVisitor;

/**
 * Filename:    $RCSfile$ Label:       $Name$ Last Change: $Author$    	 On:	$Date$
 *
 * @author GGSHAH
 * @version $Revision$
 */
public class MoreThanOneSmallValuePrecedingValidator implements SymbolsVisitor {

    private RomanSymbol previousToPreviousSymbol = null;

    @Override
    public void visit(RomanSymbolWithTypeInformation romanSymbol, RomanSymbolWithTypeInformation previousSymbol) {
        if (previousToPreviousSymbol != null) {
            checkIfCurrentSymbolHasMoreThanOneSymbolsWithSmallerValues(romanSymbol, previousSymbol, previousToPreviousSymbol);
        }
        previousToPreviousSymbol = previousSymbol;
    }

    private void checkIfCurrentSymbolHasMoreThanOneSymbolsWithSmallerValues(RomanSymbol romanSymbol,
                                                                            RomanSymbol previousSymbol, RomanSymbol previousToPreviousSymbol) {
        if (previousToPreviousSymbol.getValue() < romanSymbol.getValue() && previousSymbol.getValue() < romanSymbol.getValue()) {
            throw new IllegalArgumentException("Illegal sequence, a symbol cannot be preceded with more than one small value symbol, "
                    + previousToPreviousSymbol.getSymbolName() + previousSymbol.getSymbolName() + " have preceded " + romanSymbol.getSymbolName());
        }
    }
}