package project.mandalart.service;

public class IdValidation {
    private static final Long NO_ID = 0L;

    public static boolean isNoId(Long id) {
        return id == NO_ID;
    }
}
