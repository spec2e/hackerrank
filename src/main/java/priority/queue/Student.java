package priority.queue;

class Student implements Comparable<Student> {

    private int token;
    private String fname;
    private double cgpa;

    public Student(int id, String fname, double cgpa) {
        super();
        this.token = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getToken() {
        return token;
    }

    public String getFname() {
        return fname;
    }

    public double getCgpa() {
        return cgpa;
    }

    public int compareTo(Student o) {

        if (o.getCgpa() > getCgpa()) {
            return 1;
        } else if (o.getCgpa() < getCgpa()) {
            return -1;
        }

        if (o.getFname().compareTo(getFname()) == 0) {
            return o.getToken() > getToken() ? -1 : 1;
        } else {
            return o.getFname().compareTo(getFname()) * -1;
        }

        //return 0;
    }
}
