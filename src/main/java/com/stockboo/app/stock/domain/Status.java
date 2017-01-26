package com.stockboo.app.stock.domain;

/**
 * Enum class to notify open and close the suggestions for stocks
 * 
 * @author sunil.r
 *
 */
public enum Status {
	OPEN(0),CLOSED(1);
	
	private final int statuscode;

	Status(int statuscode) {
        this.statuscode = statuscode;
    }
    
    public int getStatuscode() {
        return this.statuscode;
    }

}
