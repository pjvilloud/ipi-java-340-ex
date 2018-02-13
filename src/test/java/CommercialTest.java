import org.assertj.core.api.Assertions;
import org.junit.Test;

import com.ipiecoles.java.java340.model.Commercial;

public class CommercialTest {

	@Test
	public void testerPrimeAnnuelleWithCANull() {
		// Given
		Commercial commercial = new Commercial();
		commercial.setCaAnnuel(null);

		// When
		Double prime = commercial.getPrimeAnnuelle();

		// Then
		Assertions.assertThat(prime).isEqualTo(500d);
	}
	
	@Test
	public void testerPrimeAnnuelleWithCA0() {
		// Given
		Commercial commercial = new Commercial();
		commercial.setCaAnnuel(0d);

		// When
		Double prime = commercial.getPrimeAnnuelle();

		// Then
		Assertions.assertThat(prime).isEqualTo(500d);
	}

	@Test
	public void testerPrimeAnnuelleWithCA10000() {
		// Given
		Commercial commercial = new Commercial();
		commercial.setCaAnnuel(10000d);

		// When
		Double prime = commercial.getPrimeAnnuelle();

		// Then
		Assertions.assertThat(prime).isEqualTo(500d);
	}

	@Test
	public void testerPrimeAnnuelleWithCA100000() {
		// Given
		Commercial commercial = new Commercial();
		commercial.setCaAnnuel(100000d);

		// When
		Double prime = commercial.getPrimeAnnuelle();

		// Then
		Assertions.assertThat(prime).isEqualTo(5000d);
	}

}
