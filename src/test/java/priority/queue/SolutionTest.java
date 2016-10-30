package priority.queue;

import org.junit.Before;
import org.junit.Test;
import test.BaseTest;

import java.util.List;

public class SolutionTest extends BaseTest {

    private static final String FILE_PREFIX = "/queue/";

    private Solution cut;
    @Before
    public void setUp() throws Exception {
        cut = new Solution();
    }

    @Test
    public void whenEightEventEnter_thenEightStudentsInQueue() {

        cut.serve(getScannerFor(
                buildFilePath("test_1")
        ));
        List<Student> students = cut.getStudentsInQueue();
        assertEquals(8, students.size());
    }

    @Test
    public void whenEightInQueue_thenPrioritizedForCgpa() {
        cut.serve(getScannerFor(
                buildFilePath("test_1")
        ));
        List<Student> students = cut.getStudentsInQueue();
        assertEquals(4, students.size());

        assertEquals("Dan", cut.servePriorityStudent().getFname());
        assertEquals("Ashley", cut.servePriorityStudent().getFname());
        assertEquals("Shafaet", cut.servePriorityStudent().getFname());
        assertEquals("Maria", cut.servePriorityStudent().getFname());


    }


    @Test
    public void whenNamesAndCgpaAreEquals_thenPrioritizedIsBasedOnIndex() {

        cut.serve(getScannerFor(
                buildFilePath("test_2")
        ));
        List<Student> students = cut.getStudentsInQueue();
        assertEquals(8, students.size());

        Student anik1 = cut.servePriorityStudent();
        assertEquals("Anik", anik1.getFname());
        assertEquals(49, anik1.getToken());

        Student anik2 = cut.servePriorityStudent();
        assertEquals("Anik", anik2.getFname());
        assertEquals(51, anik2.getToken());

        Student dan1 = cut.servePriorityStudent();
        assertEquals("Dan", dan1.getFname());
        assertEquals(50, dan1.getToken());

        Student dan2 = cut.servePriorityStudent();
        assertEquals("Dan", dan2.getFname());
        assertEquals(52, dan2.getToken());

        Student dbn = cut.servePriorityStudent();
        assertEquals("Dbn", dbn.getFname());

        Student ashley = cut.servePriorityStudent();
        assertEquals("Ashley", ashley.getFname());

        Student shafaet = cut.servePriorityStudent();
        assertEquals("Shafaet", shafaet.getFname());

        Student maria = cut.servePriorityStudent();
        assertEquals("Maria", maria.getFname());


    }

    @Test
    public void whenAllServed_thenQueueIsEmpty() {

        cut.serve(getScannerFor(
                buildFilePath("test_3")
        ));
        List<Student> students = cut.getStudentsInQueue();
        assertEquals(0, students.size());

    }

    private String buildFilePath(String fileName) {
        return FILE_PREFIX + fileName + ".txt";
    }

}
