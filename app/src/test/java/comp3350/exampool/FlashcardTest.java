package comp3350.exampool;

import org.junit.Test;

import static org.junit.Assert.*;
import comp3350.exampool.Flashcards.*;
public class FlashcardTest {
    Flashcard newCard = new Flashcard();
    Flashcard newCard2 = new Flashcard();

    @Test
    public void setFrontLAQ() {
        LAQ newQuest = new LAQ("What year was Tireni Kuti was born?", "2000");
        newCard.setFront(newQuest);
        assertEquals(newQuest, newCard.getFront());
    }

    @Test
    public void setFrontSAQ() {
        LAQ newQuest = new LAQ("What year was Tireni Kuti was born?", "2000");
        SAQ newQuest2 = new SAQ("Tireni Kuti was born in 2000", 5);
        newCard.setFront(newQuest2);
        assertNotEquals(newQuest, newCard.getFront());
        assertEquals(newQuest2, newCard.getFront());
    }
    @Test
    public void setFrontMCQ() {
        LAQ newQuest = new LAQ("What year was Tireni Kuti was born?", "2000");
        SAQ newQuest2 = new SAQ("Tireni Kuti was born in 2000", 5);
        MCQ newQuest3 = new MCQ("What year was Tireni Kuti born?", "2000");

        newQuest3.addAnswers("2001");
        newQuest3.addAnswers("2002");
        newQuest3.addAnswers("1999");
        newCard.setFront(newQuest3);
        assertNotEquals(newQuest, newCard.getFront());
        assertNotEquals(newQuest2, newCard.getFront());
        assertEquals(newQuest3, newCard.getFront());

    }
    @Test
    public void setFrontTFQ() {
        LAQ newQuest = new LAQ("What year was Tireni Kuti was born?", "2000");
        SAQ newQuest2 = new SAQ("Tireni Kuti was born in 2000", 5);
        MCQ newQuest3 = new MCQ("What year was Tireni Kuti born?", "2000");

        TFQ newQuest4 = new TFQ("Tireni Kuti was born in 2002", "false");
        newCard.setFront(newQuest4);
        assertNotEquals(newQuest, newCard.getFront());
        assertNotEquals(newQuest2, newCard.getFront());
        assertNotEquals(newQuest3, newCard.getFront());
        assertEquals(newQuest4, newCard.getFront());
    }


    @Test
    public void setBackLAQ() {
        LAQ newQuest = new LAQ("What year was Tireni Kuti was born?", "2000");
        newCard2.setFront(newQuest);
        newCard2.setBack("No it wont");
        assertNotEquals(newQuest.getAnswer(), newCard2.getBack());
        assertEquals("No it wont", newCard2.getBack());


    }

    @Test
    public void setBackSAQ() {
        LAQ newQuest = new LAQ("What year was Tireni Kuti was born?", "2000");
        SAQ newQuest2 = new SAQ("Tireni Kuti was born in 2000", 5);
        newCard2.setFront(newQuest2);
        newCard2.setBack("No it wont");
        assertNotEquals(newQuest.getAnswer(), newCard2.getBack());
        assertNotEquals(newQuest2.getAnswer(), newCard2.getBack());
        assertEquals("No it wont", newCard2.getBack());

    }

    @Test
    public void setBackMCQ() {
        LAQ newQuest = new LAQ("What year was Tireni Kuti was born?", "2000");
        SAQ newQuest2 = new SAQ("Tireni Kuti was born in 2000", 5);
        MCQ newQuest3 = new MCQ("What year was Tireni Kuti born?", "2000");
        newQuest3.addAnswers("2001");
        newQuest3.addAnswers("2002");
        newQuest3.addAnswers("1999");
        newCard2.setFront(newQuest3);
        newCard2.setBack("No it wont");
        assertNotEquals(newQuest.getAnswer(), newCard2.getBack());
        assertNotEquals(newQuest2.getAnswer(), newCard2.getBack());
        assertNotEquals(newQuest3.getAnswer(), newCard2.getBack());
        assertEquals("No it wont", newCard2.getBack());

    }

    @Test
    public void setBackTFQ() {
        LAQ newQuest = new LAQ("What year was Tireni Kuti was born?", "2000");
        SAQ newQuest2 = new SAQ("Tireni Kuti was born in 2000", 5);
        MCQ newQuest3 = new MCQ("What year was Tireni Kuti born?", "2000");
        TFQ newQuest4 = new TFQ("Tireni Kuti was born in 2002", "false");
        newCard2.setFront(newQuest4);
        newCard2.setBack("No it wont");
        assertNotEquals(newQuest.getAnswer(), newCard2.getBack());
        assertNotEquals(newQuest2.getAnswer(), newCard2.getBack());
        assertNotEquals(newQuest3.getAnswer(), newCard2.getBack());
        assertNotEquals(newQuest4.getAnswer(), newCard2.getBack());
        assertEquals("No it wont", newCard2.getBack());

    }

    @Test
    public void displayFlashcard() {
        assertNotNull(newCard);
    }


    @Test
    public void QuestiongetQuestTag() {
        LAQ newQuest = new LAQ("What year was Tireni Kuti was born?", "2000");
        SAQ newQuest2 = new SAQ("Tireni Kuti was born in 2000", 5);

        MCQ newQuest3 = new MCQ("What year was Tireni Kuti born?", "2000");
        newQuest3.addAnswers("2001");
        newQuest3.addAnswers("2002");
        newQuest3.addAnswers("1999");

        TFQ newQuest4 = new TFQ("Tireni Kuti was born in 2002", "false");

        assertNotNull(newQuest.getQuestTag());
        assertEquals("What year was Tireni Kuti was born?", newQuest.getQuestTag());

        assertNotNull(newQuest2.getQuestTag());
        assertEquals("Tireni Kuti was born in ________", newQuest2.getQuestTag());

        assertNotNull(newQuest3.getQuestTag());
        assertEquals("What year was Tireni Kuti born?", newQuest3.getQuestTag());

        assertNotNull(newQuest4.getQuestTag());
        assertEquals("Tireni Kuti was born in 2002", newQuest4.getQuestTag());
    }

    @Test
    public void QuestiongetAnswer() {
        LAQ newQuest = new LAQ("What year was Tireni Kuti was born?", "2000");
        SAQ newQuest2 = new SAQ("Tireni Kuti was born in 2000", 5);

        MCQ newQuest3 = new MCQ("What year was Tireni Kuti born?", "2000");
        newQuest3.addAnswers("2001");
        newQuest3.addAnswers("2002");
        newQuest3.addAnswers("1999");

        TFQ newQuest4 = new TFQ("Tireni Kuti was born in 2002", "false");

        assertNotNull(newQuest.getAnswer());
        assertEquals("2000", newQuest.getAnswer());
        assertNotEquals("2001", newQuest.getAnswer());
        assertNotEquals("2002", newQuest.getAnswer());
        assertNotEquals("1999", newQuest.getAnswer());

        assertNotNull(newQuest2.getQuestTag());
        assertEquals("2000", newQuest2.getAnswer());
        assertNotEquals("2001", newQuest2.getAnswer());
        assertNotEquals("2002", newQuest2.getAnswer());
        assertNotEquals("1999", newQuest2.getAnswer());


        assertNotNull(newQuest3.getQuestTag());
        assertEquals((newQuest3.getCorrectTag() + ".2000"), newQuest3.getAnswer());
        assertNotEquals("2001", newQuest3.getAnswer());
        assertNotEquals("2002", newQuest3.getAnswer());
        assertNotEquals("1999", newQuest3.getAnswer());

        assertNotNull(newQuest4.getQuestTag());
        assertEquals("FALSE", newQuest4.getAnswer());
        assertNotEquals("2001", newQuest4.getAnswer());
        assertNotEquals("2002", newQuest4.getAnswer());
        assertNotEquals("1999", newQuest4.getAnswer());
    }

    @Test
    public void QuestionsetQuestTag() {
        LAQ newQuest = new LAQ("What year was Tireni Kuti was born?", "2000");

        SAQ newQuest2 = new SAQ("Tireni Kuti was born in 2000", 5);

        MCQ newQuest3 = new MCQ("What year was Tireni Kuti born?", "2000");
        newQuest3.addAnswers("2001");
        newQuest3.addAnswers("2002");
        newQuest3.addAnswers("1999");

        TFQ newQuest4 = new TFQ("Tireni Kuti was born in 2002", "false");

        newQuest.setQuestTag("Banana");
        assertNotEquals("What year was Tireni Kuti was born?", newQuest.getQuestTag());
        assertEquals("Banana", newQuest.getQuestTag());
        assertEquals("2000", newQuest.getAnswer());

        newQuest2.setQuestTag("Banana");
        assertNotEquals("Tireni Kuti was born in 2000", newQuest2.getQuestTag());
        assertEquals("Banana", newQuest2.getQuestTag());
        assertEquals("2000", newQuest2.getAnswer());

        newQuest3.setQuestTag("Banana");
        assertNotEquals("What year was Tireni Kuti was born?", newQuest3.getQuestTag());
        assertEquals("Banana", newQuest3.getQuestTag());
        assertEquals((newQuest3.getCorrectTag() + ".2000"), newQuest3.getAnswer());

        newQuest4.setQuestTag("Banana");
        assertNotEquals("Tireni Kuti was born in 2002", newQuest4.getQuestTag());
        assertEquals("Banana", newQuest4.getQuestTag());
        assertEquals("FALSE", newQuest4.getAnswer());

    }

    @Test
    public void QuestionsetAnswer() {
        LAQ newQuest = new LAQ("What year was Tireni Kuti was born?", "2000");

        SAQ newQuest2 = new SAQ("Tireni Kuti was born in 2000", 5);

        MCQ newQuest3 = new MCQ("What year was Tireni Kuti born?", "2000");
        newQuest3.addAnswers("2001");
        newQuest3.addAnswers("2002");
        newQuest3.addAnswers("1999");

        TFQ newQuest4 = new TFQ("Tireni Kuti was born in 2002", "false");

        newQuest.setAnswer("Ronald Reagan");
        assertEquals("What year was Tireni Kuti was born?", newQuest.getQuestTag());
        assertNotEquals("2000", newQuest.getAnswer());
        assertEquals("Ronald Reagan", newQuest.getAnswer());

        newQuest2.setAnswer("Ronald Reagan");
        assertEquals("Tireni Kuti was born in ________", newQuest2.getQuestTag());
        assertNotEquals("2000", newQuest2.getAnswer());
        assertEquals("Ronald Reagan", newQuest2.getAnswer());

        newQuest3.setAnswer("Ronald Reagan");
        assertEquals("What year was Tireni Kuti born?", newQuest3.getQuestTag());
        assertNotEquals((newQuest3.getCorrectTag() + ".2000"), newQuest3.getAnswer());
        assertEquals((newQuest3.getCorrectTag() + ".Ronald Reagan"), newQuest3.getAnswer());

        newQuest4.setAnswer("TRUE");
        assertEquals("Tireni Kuti was born in 2002", newQuest4.getQuestTag());
        assertNotEquals("FALSE", newQuest4.getAnswer());
        assertEquals("TRUE", newQuest4.getAnswer());
    }


    @Test
    public void addAnswers() {
        MCQ newQuest3 = new MCQ("What year was Tireni Kuti born?", "2000");
        newQuest3.addAnswers("2001");
        newQuest3.addAnswers("2002");
        newQuest3.addAnswers("1999");
        assertThrows(AssertionError.class, ()-> newQuest3.addAnswers("1999"));

        MCQ newQuest5 = new MCQ("Whats 10 + 9 ", "19");
        newQuest5.addAnswers("18");
        assertThrows(AssertionError.class, ()-> newQuest5.addAnswers("19"));
    }

}