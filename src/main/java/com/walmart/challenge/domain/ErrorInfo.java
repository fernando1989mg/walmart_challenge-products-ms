package com.walmart.challenge.domain;

public class ErrorInfo {
    private String url;
    private String code;
    private String message;

    public ErrorInfo(String url, String code, String message) {
        this.url = url;
        this.code = code;
        this.message = message;
    }

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
    
    
}
