package com.ishisystems.workshop.merchant;

import java.util.ArrayList;
import java.util.List;

public class SymbolParser {

    private final List<RomanSymbolWithTypeInformation> romanSymbolList;

    public SymbolParser(List<RomanSymbol> romanSymbols) {
        this.romanSymbolList = new ArrayList<RomanSymbolWithTypeInformation>();
        int sequenceNumber = 0;
        for (RomanSymbol romanSymbol : romanSymbols) {
            boolean isFirstDigitFive = isFirstDigitFive(romanSymbol);
            romanSymbolList.add(RomanSymbolWithTypeInformation.createInstance(romanSymbol, isFirstDigitFive, sequenceNumber++));
        }
    }

    public List<RomanSymbolWithTypeInformation> parseSymbols(String inputString) {
        List<RomanSymbolWithTypeInformation> inputAsSymbols = new ArrayList<RomanSymbolWithTypeInformation>();
        for (char character : inputString.toCharArray()) {
            inputAsSymbols.add(getSymbol(character));
        }
        return inputAsSymbols;
    }

    private RomanSymbolWithTypeInformation getSymbol(Character inputCharacter) {
        for (RomanSymbolWithTypeInformation romanSymbol : romanSymbolList) {
            if (romanSymbol.getSymbolName().equals(inputCharacter.toString())) {
                return romanSymbol;
            }
        }
        return null;
//    throw new IllegalArgumentException("Invalid Symbol");
    }

    private boolean isFirstDigitFive(RomanSymbol romanSymbol) {
        int value = romanSymbol.getValue();
        while (value > 10) {
            value = value / 10;
        }
        return (value == 5);
    }


}