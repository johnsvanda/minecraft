package cz.mendelu.pjj.minecraft.domain;

public class CantFightException extends RuntimeException {
    public CantFightException(String message, Throwable cause) {
        super(message, cause);
    }
}
