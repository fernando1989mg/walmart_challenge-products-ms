package com.walmart.challenge.domain;

public enum Errors {

    ERROR_GENERAL_APLICACION("ERROR_GENERAL_APLICACION", "Error general en la aplicacion", 500);


    private String code;
    private String description;
    private int statusCode;
    
    private Errors(String code, String description, int statusCode) {
    	this.code = code;
    	this.description = description;
    	this.statusCode = statusCode;
    }

    public static Errors getErrorType(String errorMessage){
        for (Errors e : values()) {
            if (errorMessage.contains(e.description)) {
                return e;
            }
        }
        return Errors.ERROR_GENERAL_APLICACION;
    }

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
    
    
}
