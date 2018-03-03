package com.ipiecoles.java.java340.model;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class CommercialParameterizedTest {

	// La performance est le parametre 0
    @Parameterized.Parameter(value = 0)
    public Integer perf;

    // La note attendue est le parametre 1
    @Parameterized.Parameter(value = 1)
    public Note expectedNote;

    // On crée une liste de valeurs attendues : à gauche la performance, à droite la note attendue 
    @Parameterized.Parameters(name = "performance {0} équivalent à {1}")
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {0, Note.INSUFFISANT},
                {50, Note.INSUFFISANT},
                {100, Note.PASSABLE},
                {150, Note.BIEN},
                {200, Note.TRES_BIEN},
                {null, null},
                {600, null},
                {151, null}
        });
    }

    // Méthode permettant de lancer le test : on définit la valeur de la performance en utilisant le paramètre 0 (on teste donc 8 valeurs en tout). On y applique alors la fonction de model commercial pour définir la note équivalente. Finalement on teste si la note attendue (donc le parametre 1) correspond bien à ce qui a été fait par la méthode equivalenceNote(); 
    @Test
    public void testEquivalenceNote(){
        //Given
        Commercial commercial = new Commercial();
        commercial.setPerformance(perf);

        //When
        Note note = commercial.equivalenceNote();

        //Then
        Assertions.assertThat(note).isEqualTo(expectedNote);
    }
    
}
