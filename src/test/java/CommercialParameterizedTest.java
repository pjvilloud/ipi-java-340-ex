import com.ipiecoles.java.java340.model.Commercial;
import com.ipiecoles.java.java340.model.Note;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import org.assertj.core.api.Assertions;

@RunWith(Parameterized.class)
public class CommercialParameterizedTest {

    @Parameterized.Parameter(value = 0)
    public Integer performance;

    @Parameterized.Parameter(value = 1)
    public Note note;

    @Parameterized.Parameters(name = "performance {0} donne la note : {1}")
    public static Collection<Object[]> Data() {
        return Arrays.asList(new Object[][]{
                {50, Note.INSUFFISANT},{100, Note.PASSABLE}
        });
    }


    @Test
    public void testEquivalenceNote() {

        //given
        Commercial commercial = new Commercial();

        //when
        commercial.setPerformance(performance);

        Assertions.assertThat(commercial.equivalenceNote()).isEqualTo(note);

    }
}
