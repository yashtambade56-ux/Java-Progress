public class LectureSchedule {
    
    public static void main(String[] args) {
        
        for (int time = 1; time <= 6; time++){

            if (time == 4){
                continue;
            }
            System.out.println("Lecture in time " + time);
        }
    }
}
