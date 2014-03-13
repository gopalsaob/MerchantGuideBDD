package com.ishisystems.workshop.merchant;

import com.ishisystems.workshop.merchant.validators.MoreThanOneSmallValuePrecedingValidator;
import com.ishisystems.workshop.merchant.validators.ReconversionRuleValidator;
import com.ishisystems.workshop.merchant.validators.RepetitionValidator;
import com.ishisystems.workshop.merchant.validators.SequenceValidator;

import java.util.List;

public class RomanNumeralCalculator {
    private final SymbolParser symbolParser;

    public RomanNumeralCalculator(List<RomanSymbol> romanSymbols) {
        this.symbolParser = new SymbolParser(romanSymbols);
    }

    public Integer getValue(String inputString) {
        List<RomanSymbolWithTypeInformation> inputAsSymbols = symbolParser.parseSymbols(inputString);
        validate(inputAsSymbols, new MoreThanOneSmallValuePrecedingValidator());
        validate(inputAsSymbols, new SequenceValidator());
        validate(inputAsSymbols, new RepetitionValidator());
        validate(inputAsSymbols, new ReconversionRuleValidator());
        return computeValue(inputAsSymbols);
    }

    private Integer computeValue(List<RomanSymbolWithTypeInformation> inputAsSymbols) {
        Integer result = 0;
        RomanSymbol previousSymbol = null;
        for (RomanSymbol romanSymbol : inputAsSymbols) {
            if (previousSymbol != null && (previousSymbol.getValue() < romanSymbol.getValue())) {
                result += (romanSymbol.getValue() - (2 * previousSymbol.getValue()));
            } else {
                result += romanSymbol.getValue();
            }
            previousSymbol = romanSymbol;
        }
        return result;
    }

    private void validate(List<RomanSymbolWithTypeInformation> symbols, SymbolsVisitor visitor) {
        RomanSymbolWithTypeInformation previousSymbol = null;
        for (RomanSymbolWithTypeInformation symbol : symbols) {
            if (previousSymbol != null) {
                visitor.visit(symbol, previousSymbol);
            }
            previousSymbol = symbol;
        }
    }
}
