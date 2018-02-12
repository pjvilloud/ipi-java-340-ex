import com.ipiecoles.java.java340.model.Commercial;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class CommercialTest {
    @Test
    public void testGetPrimeAnnulleWithCAnnull(){
        //given
        Commercial commercial=new Commercial();
        commercial.setCaAnnuel(null);
        //when
        Double prime= commercial.getPrimeAnnuelle();
        //then
        Assertions.assertThat(prime).isEqualTo(50g0d);

    }
}
