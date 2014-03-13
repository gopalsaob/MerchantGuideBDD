package com.ishisystems.workshop.merchant;

/**
 * Filename:    $RCSfile$ Label:       $Name$ Last Change: $Author$    	 On:	$Date$
 *
 * @author GGSHAH
 * @version $Revision$
 */
public interface SymbolsVisitor {

    public void visit(RomanSymbolWithTypeInformation currentSymbol, RomanSymbolWithTypeInformation previousSymbol);

}