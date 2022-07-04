import java.time.Instant;
import java.util.Date;

public class AgeCalculator {
    private static final int MILLIS_IN_SEC = 1000;
    public static final String FUTURE_ERROR_MESSAGE = "Could not get age for object not born yet.";

    public long calculateAgeInSecs(Date birthDate) throws Exception {
        if (birthDate.toInstant().isAfter(Instant.now())) throw new Exception(FUTURE_ERROR_MESSAGE);

        return (System.currentTimeMillis() - birthDate.getTime()) / MILLIS_IN_SEC;
    }

}
