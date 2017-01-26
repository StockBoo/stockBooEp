package com.stockboo.app.stock.domain;

/**
 * Type of the suggestion
 * 
 * @author sunil.r
 *
 */
public enum SugesstionType {
	SHORT_TERM(0), MID_TERM(1), LONG_TERM(2);
	
	private final int sugesstionTypeCode;

	SugesstionType(int sugesstionTypeCode) {
        this.sugesstionTypeCode = sugesstionTypeCode;
    }
    
    public int getSugesstionTypecode() {
        return this.sugesstionTypeCode;
    }

}
