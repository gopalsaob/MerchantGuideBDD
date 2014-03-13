package com.ishisystems.workshop.merchant;


public class RomanSymbol {
    private String symbolName;
    private Integer value;

    public RomanSymbol(String symbolName, Integer value) {
        this.symbolName = symbolName;
        this.value = value;
    }

    public String getSymbolName() {
        return symbolName;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        RomanSymbol that = (RomanSymbol) o;
        if (!symbolName.equals(that.symbolName)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return symbolName.hashCode();
    }
}
