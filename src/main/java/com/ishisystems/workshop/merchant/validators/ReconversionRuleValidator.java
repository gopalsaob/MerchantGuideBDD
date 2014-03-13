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
public class ReconversionRuleValidator implements SymbolsVisitor {

    private RomanSymbol previousToPreviousSymbol = null;

    @Override
    public void visit(RomanSymbolWithTypeInformation romanSymbol, RomanSymbolWithTypeInformation previousSymbol) {
        if (previousToPreviousSymbol != null) {
            checkIfCurrentSymbolHasMoreThanOneSymbolsWithSmallerValues(romanSymbol, previousToPreviousSymbol);
        }
        previousToPreviousSymbol = previousSymbol;
    }

    private void checkIfCurrentSymbolHasMoreThanOneSymbolsWithSmallerValues(RomanSymbol romanSymbol, RomanSymbol previousToPreviousSymbol) {
        if (previousToPreviousSymbol.getValue() < romanSymbol.getValue()) {
            throw new IllegalArgumentException("Illegal sequence, converted Arabic number cannot be broken into digits to get back the number.");
        }
    }
}
