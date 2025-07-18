package tech.pierandrei.Stuglish.exceptions;

public class CredentialsUnauthorizedException extends RuntimeException {

    public CredentialsUnauthorizedException(String message) {
        super(message);
    }
}
