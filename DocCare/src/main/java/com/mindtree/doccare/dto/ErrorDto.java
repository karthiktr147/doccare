package com.mindtree.doccare.dto;

public class ErrorDto {
private String errorMessage;
private Throwable cause;
public ErrorDto() {
	super();
}
public ErrorDto(String errorMessage, Throwable cause) {
	super();
	this.errorMessage = errorMessage;
	this.cause = cause;
}
public ErrorDto(String message) {
}
public ErrorDto(String string, String string2) {
}
public String getErrorMessage() {
	return errorMessage;
}
public void setErrorMessage(String errorMessage) {
	this.errorMessage = errorMessage;
}
public Throwable getCause() {
	return cause;
}
public void setCause(Throwable cause) {
	this.cause = cause;
}

}
