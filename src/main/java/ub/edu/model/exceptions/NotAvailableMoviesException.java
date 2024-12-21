package ub.edu.model.exceptions;

public class NotAvailableMoviesException extends NotAvailableException {
    public NotAvailableMoviesException() {
        super("No hi ha cap pel·lícula disponible");
    }
}
