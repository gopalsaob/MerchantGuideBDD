package com.ishisystems.workshop.merchant;

public class RomanSymbolWithTypeInformation extends RomanSymbol {

    public RomanSymbolWithTypeInformation(String symbolName, Integer value) {
        super(symbolName, value);
    }

    private boolean isFirstDigitFive;

    public boolean isFirstDigitFive() {
        return isFirstDigitFive;
    }

    public void setFirstDigitFive(boolean isFirstDigitFive) {
        this.isFirstDigitFive = isFirstDigitFive;
    }

    public static RomanSymbolWithTypeInformation createInstance(RomanSymbol romanSymbol, boolean isFirstDigitFive, int sequenceNumber) {
        RomanSymbolWithTypeInformation romanSymbolWithTypeInformation = new RomanSymbolWithTypeInformation(romanSymbol.getSymbolName(), romanSymbol.getValue());
        romanSymbolWithTypeInformation.setFirstDigitFive(isFirstDigitFive);
        return romanSymbolWithTypeInformation;
    }
}
