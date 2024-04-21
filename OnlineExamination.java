import java.util.Scanner;
class User 
{
    private String username;
    private String password;
    public User(String username, String password) 
    {
        this.username = username;
        this.password = password;
    }
    public boolean login() 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Username: ");
        String enteredUsername = sc.next();
        System.out.print("Enter Password: ");
        String enteredPassword = sc.next();
        return this.username.equals(enteredUsername) && this.password.equals(enteredPassword);
    }
    public void newUser(String newUsername, String newPassword) {
        this.username = newUsername;
        this.password = newPassword;
        System.out.println("Profile Updated successfully.");
    }
}
class Question 
{
    private String question;
    private String[] options;
    private char correctOption;
    public Question(String question, String[] options, char correctOption) 
    {
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
    }
    public String getQuestion() 
    {
        return question;
    }
    public String[] getOptions() 
    {
        return options;
    }
    public boolean verifyAnswer(char selectedOption) 
    {
        return selectedOption == correctOption;
    }
}

class Examination 
{
    private User user;
    private Question[] questions;
    private int totalTime;
    public Examination(User user, Question[] questions, int totalTime) 
    {
        this.user = user;
        this.questions = questions;
        this.totalTime = totalTime;
    }
    public void startExam() 
    {
        Scanner sc = new Scanner(System.in);
        int remainingTime = totalTime;
        int correctAnswers = 0;
        if (user.login()) 
        {
            System.err.println("Login Successfully.");
            System.err.println();
            for (Question question : questions) 
            {
                System.out.println(question.getQuestion());
                String[] options = question.getOptions();
                for (int i = 0; i < options.length; i++) 
                {
                    System.out.println((char) ('A' + i) + ". " + options[i]);
                }
                System.out.print("Enter your answer (A/B/C/D): ");
                char selectedOption = sc.next().toUpperCase().charAt(0);
                if (question.verifyAnswer(selectedOption)) 
                {
                    System.out.println("Correct answer!");
                    correctAnswers++;
                } 
                else 
                {
                    System.out.println("Incorrect answer.");
                }
            }
            int totalQuestions = questions.length;
            double score = ((double) correctAnswers / totalQuestions) * 100;
            System.out.println("Exam completed.\nThank you!");
            System.out.println("Your score: " + correctAnswers + "/" + totalQuestions + " (" + String.format("%.2f", score) + "%)");
        } 
        else 
        {
            System.out.println("Invalid login Credentials");
        }
        sc.close();
    }
}

public class OnlineExamination 
{
    public static void main(String[] args) 
    {
        User user = new User("Sudheerreddy", "9676");
        Question[] questions = 
        {
            new Question(" What is the correct way to declare a constant variable in Java?", new String[]{"final int CONSTANT_VAR = 10;", "int CONSTANT_VAR = 10;", "const int CONSTANT_VAR = 10;", "static int CONSTANT_VAR = 10;"}, 'A'),
            new Question("What is the default value of an instance variable of type int in Java if it is not explicitly initialized?", new String[]{"0", "0.0", "null", "Depends on Compiler"}, 'A'),
            new Question("Which keyword is used to define a subclass in Java?", new String[]{"subclass", "extends", "implements", "super"}, 'B'),
            new Question("Which of the following is not a valid Java identifier?", new String[]{"_variableName", "123variable", "variableName123", "$variableName"}, 'B'),
            new Question("Which of the following is not a valid access modifier in Java?", new String[]{"public", "protected", "private", "global"}, 'D')
        };
        Examination examination = new Examination(user, questions, 150);
        examination.startExam();
    }
}
