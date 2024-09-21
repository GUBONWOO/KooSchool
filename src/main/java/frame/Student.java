package frame;

public class Student {
     String name;
    int studentId;
     int mathScore;
     int scienceScore;
     int englishScore;
     double average;


    public Student(){}


    public Student(String name, int studentId) {
        this.name = name;
        this.studentId = studentId;
    }

    public Student(String name, int studentId, int mathScore, int scienceScore, int englishScore) {
        this.name = name;
        this.studentId = studentId;
        this.mathScore = mathScore;
        this.scienceScore = scienceScore;
        this.englishScore = englishScore;
    }

    public void setScores(int mathScore, int scienceScore , int englishScore){
        this.mathScore = mathScore;
        this.scienceScore = scienceScore;
        this.englishScore = englishScore;
    }

    public double getAverage(){

        int sum = this.englishScore + this.mathScore + this.scienceScore;
        this.average = (double) sum/3;
        return average;
    }

    public  String getName() {
        return name;
    }


    public void printStudentInfo(){
        System.out.println("name = " + name);
        System.out.println("studentId = " + studentId);
        System.out.println("mathScore = " + mathScore);
        System.out.println("scienceScore = " + scienceScore);
        System.out.println("englishScore = " + englishScore);
        System.out.println("average = " + average);
    }

}
