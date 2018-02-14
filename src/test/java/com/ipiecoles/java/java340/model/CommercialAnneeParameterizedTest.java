//package com.ipiecoles.java.java340.model;
//
//import com.ipiecoles.java.java340.model.exception.EmployeException;
//import com.ipiecoles.java.java340.model.model.Commercial;
//import com.ipiecoles.java.java340.model.model.Employe;
//import org.assertj.core.api.Assertions;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.Parameterized;
//import org.joda.time.LocalDate;
//import java.util.Arrays;
//import java.util.Collection;
//
//@RunWith(value = Parameterized.class)
//public class CommercialAnneeParameterizedTest {
//
//    private static LocalDate now = LocalDate.now();
//    private static LocalDate yesterday = now.minusDays(1);
//    private static LocalDate tomorrow = now.minusDays(1);
//
//    @Parameterized.Parameter(value = 0)
//    LocalDate dateEmbaucheIn;
//
//    @Parameterized.Parameter(value = 1)
//    LocalDate dateEmbaucheExpected;
//
//    @Parameterized.Parameters(name = "dateEmbauce {0} set {1}")
//    public static Collection<Object[]>data(){
//        return Arrays.asList(new Object[][]{
//            {now,now}, {yesterday, yesterday}, {tomorrow, null}
//        });
//    }
//
//    @Test
//    public void testSetDateEmbauche() throws EmployeException{
//        //Given
//        Employe commercial = new Commercial("Venet", "Julien", "C00029", new LocalDate(), 10000d, 600000d);
//
//        //When
//        try{
//            commercial.setDateEmbauche(dateEmbaucheIn);
//            //Then
//            Assertions.assertThat(commercial.getDateEmbauche()).isEqualTo(dateEmbaucheExpected);
//            Assertions.assertThat(dateEmbaucheExpected).isNotNull();
//        }catch(EmployeException e ){
//            Assertions.assertThat(e.getMessage()).isEqualTo("La date d'embauche ne peut être postérieur à la date courante");
//            Assertions.assertThat(dateEmbaucheExpected).isNull();
//        }//finally{
//            //Assertions.assertThat(commercial.getDateEmbauche()).isEqualTo(dateEmbaucheExpected);
//        //}
//    }
//}
