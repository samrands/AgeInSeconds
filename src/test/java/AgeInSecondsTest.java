import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

public class AgeInSecondsTest {
    private AgeCalculator ageCalculator;

    @Before
    public void setUp() {
        ageCalculator = new AgeCalculator();
    }

    @Test
    public void testAgeZero() throws Exception{
        Date today = Date.from(Instant.now());

        long seconds = ageCalculator.calculateAgeInSecs(today);

        Assert.assertTrue(seconds < 86400);
    }

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testFuture() throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1);

        Date tomorrow = calendar.getTime();

        expectedException.expect(Exception.class);
        expectedException.expectMessage(AgeCalculator.FUTURE_ERROR_MESSAGE);
        ageCalculator.calculateAgeInSecs(tomorrow);
    }
}
