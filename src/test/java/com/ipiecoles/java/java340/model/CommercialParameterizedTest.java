package com.ipiecoles.java.java340.model;

import com.ipiecoles.java.java340.model.model.Commercial;
import com.ipiecoles.java.java340.model.model.Note;
import org.joda.time.LocalDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.assertj.core.api.Assertions;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)//org.junit.runners.Parameterized
public class CommercialParameterizedTest {

    @Parameter(value = 0)//org.junit.runners.Parameterized.Parameter
    public Integer performance;

    @Parameter(value = 1)
    public Note note;

    @Parameterized.Parameters(name = "Performance {0} est egale à note {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0, Note.INSUFFISANT},
                {50, Note.INSUFFISANT},
                {100, Note.PASSABLE},
                {150, Note.BIEN},
                {200, Note.TRES_BIEN},
                {null, null},
                {600, null}
        });
    }

    @Test
    public void testCheckBadImmatriculation() {
        //Given
        Commercial commercial = new Commercial("Venet", "Julien", "C00029", new LocalDate(), 10000d, 600000d);
        commercial.setPerformance(performance);

        //When,
        Note note = commercial.equivalenceNote();

        //Then
        Assertions.assertThat(commercial.equivalenceNote()).isEqualTo(note);
    }
}
