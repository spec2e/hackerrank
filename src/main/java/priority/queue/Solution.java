package priority.queue;

import java.util.*;

class Solution {

    public static final String ENTER = "ENTER";
    public static final String SERVED = "SERVED";

    Queue<Student> queue = new PriorityQueue<Student>();

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.serve(new Scanner(System.in));
    }

    public void serve(Scanner in) {

        int totalEvents = Integer.parseInt(in.nextLine());
        while(totalEvents>0){
            String event = in.next();

            if(event.equals(ENTER)) {
                queue.add(
                        buildStudent(in)
                );
            } else if (event.equals(SERVED)) {
                servePriorityStudent();
            }

            totalEvents--;

        }

        printQueue();
    }

    private void printQueue() {
        if(queue.isEmpty()) {
            System.out.println("EMPTY");
        }

        while(!queue.isEmpty()) {
            Student student = queue.poll();
            System.out.println(student.getFname());
        }
    }

    private Student buildStudent(Scanner in) {
        String name = in.next();
        double cgpa = in.nextDouble();
        int id = in.nextInt();
        Student student = new Student(
                id,
                name,
                cgpa
        );
        return student;
    }

    public Student servePriorityStudent() {
        return queue.poll();
    }

    public List<Student> getStudentsInQueue() {
        Student[] students = queue.toArray(new Student[queue.size()]);
        Arrays.sort(students);
        return Arrays.asList(students);
    }
}
