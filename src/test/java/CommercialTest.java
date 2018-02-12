import org.junit.Test;

public class CommercialTest {

    @Test
    public void testGetPrimAnnuelle(){

        Commercial commercial = new Commercial();

        Double result = commercial.getPrimeAnnuelle();

        Assertions.assertThat(result).isEqualTo(500d);
    }


}