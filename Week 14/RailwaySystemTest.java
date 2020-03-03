import ferrocarrilesDeAmericaDelSur.errors.RailwaySystemError;
import ferrocarrilesDeAmericaDelSur.railways.RailwaySystem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class RailwaySystemTest {
    @Test
    void railwaySystemErrorTest(){
        for (int i = 0; i < 10;i++) {
            String[] args = {};
            try {
                RailwaySystem.main(args);
            } catch (RailwaySystemError e) {
                fail();
            }
        }
    }
}
