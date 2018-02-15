package com.ipiecoles.java340.repository.model;

import com.ipiecoles.java.java340.model.Commercial;
import com.ipiecoles.java.java340.model.Note;
import org.assertj.core.api.Assertions;
import org.hibernate.annotations.Parameter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)//org.junit.runners.Parameterized
public class CommercialParameterized{
     @Parameterized.Parameter(value = 0)
        public int perf;
     @Parameterized.Parameter(value=1)
         public Note expnotes;

        //org.junit.runners.Parameterized.Parameters

        @Test
        public void EquivalenceNote() {

            Commercial commercial=new Commercial();
            commercial.setPerformance(perf);
            //when
           Note note= commercial.equivalenceNote();
            //then
            Assertions.assertThat(note).isEqualTo(expnotes);

        }

        @Parameterized.Parameters(name = "performance {0} est equivalent à {1}")
        public static   Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                    {0, Note.INSUFFISANT},
                    {50, Note.INSUFFISANT},
                    {100, Note.PASSABLE},
                    {150, Note.BIEN},
                    {200, Note.TRES_BIEN},
                    {null, null},
                    {600, null},
            });
        }



    }
