import java.util.Scanner;

class InvalidTestScore extends Exception {
    
    public InvalidTestScore() {
        super("Invalid test score");
    }
    
}
class TestScores {
    private int[] scores;
    
    public TestScores(int[] inputScores)  throws InvalidTestScore {
        InvalidTestScore e = new InvalidTestScore();
        for(int score: inputScores) {
            
            
            if(score < 0 || score > 100) {
                throw e;
            }
        }
        this.scores = inputScores;   
    }
    
    public double getAverage() {
        double average = 0.0;
        double sum = 0.0;
        
        for(int score: this.scores) {
            sum += score;
        }
        average = sum/this.scores.length;
        return average;
    }
    
    public static void main(String[] args) throws InvalidTestScore {
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter number of test scores:");
        int numberOfScores = kb.nextInt();
        int[] scores = new int[numberOfScores];
        for(int i = 0; i < numberOfScores; i++) {
            System.out.print("Enter test score " + (i+1) + ":");
            scores[i] = kb.nextInt();
        }
        try {
            TestScores thisClass = new TestScores(scores);
            System.out.println(thisClass.getAverage());
        } catch(InvalidTestScore e) {
            System.out.println("Invalid test score.");
            System.exit(0);
        }
        
        
    }
}


    

