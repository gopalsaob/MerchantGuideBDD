package com.ishisystems.workshop.merchant;

/**
 * Filename:    $RCSfile$ Label:       $Name$ Last Change: $Author$    	 On:	$Date$
 *
 * @author GGSHAH
 * @version $Revision$
 */
public class ValueCalculator implements SymbolsVisitor {

    private Integer result = 0;

    @Override
    public void visit(RomanSymbolWithTypeInformation romanSymbol, RomanSymbolWithTypeInformation previousSymbol) {
        if (previousSymbol != null && (previousSymbol.getValue() < romanSymbol.getValue())) {
            result += (romanSymbol.getValue() - (2 * previousSymbol.getValue()));
        } else {
            result += romanSymbol.getValue();
        }
    }

    public Integer getResult() {
        return result;
    }
}
