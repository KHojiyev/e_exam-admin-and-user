package Module2_OOP.ExtraTasks.Lesson11;

import java.util.*;

public class Main {
    public static List<User> users = new ArrayList<>();
    public static Map<Integer, Questions> questions = new HashMap<>();
    public static ArrayList<Subject> subjects = new ArrayList<>();
    public static User activeUser = null;
    public static Set<String> tempName = new LinkedHashSet<>();
    public static String[] namesOfSubject = new String[10];
    public static Result[] results = new Result[2000];
    public static int score = 0;
    public static int sumOfQuestions = 0;
    public static int registerUserIndex = 5;
    public static int questionNumberP = 4;
    public static int questionNumberM = 54;
    public static int questionNumberPB = 104;
    public static int questionNumberPF = 154;
    public static int questionNumberNS = 201;
    public static boolean emailNotFound = true;

    public static void main(String[] args) {
        initBase();
        System.out.println("Welcome!");
        while (true) {
            loginRegisterMenu();
            Scanner scanner = new Scanner(System.in);
            System.out.print("-> ");
            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        login();
                        break;
                    case 2:
                        register();
                        break;
                    case 0:
                        System.out.println("==bye==");
                        return;
                    default:
                        System.out.println("error choice! ");
                        break;
                }
            } catch (InputMismatchException exception) {
                System.out.println("incorrect try please input only numberic symbol please! ");
                sumOfQuestions = 0;
            }


        }
    }

    private static void register() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("==Registering==");
        System.out.print("Role: ");
        String registerRole = scanner.nextLine();
        System.out.print("Name: ");
        String registerName = scanner.nextLine();
        System.out.print("Email: ");
        String registerEmail = scanner.nextLine();
        System.out.print("Password: ");
        String registerPassword = scanner.nextLine();
        System.out.print("Confirm Password: ");
        String reRegisterPassword = scanner.nextLine();
        if (registerPassword.equals(reRegisterPassword)) {
            users.add(registerUserIndex, new User(registerName, registerEmail, registerPassword, registerRole));
            System.out.println("You successfully registered please loge in!");
            registerUserIndex++;
        }

    }

    private static void login() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Email: ");
            String currentEmail = scanner.nextLine();
            System.out.print("Password: ");
            String currentPassword = scanner.nextLine();
            for (User currentUser : users) {
                if (currentUser.getEmail().equals(currentEmail)) {
                    emailNotFound = false;
                    if (currentUser.getPassword().equals(currentPassword)) {
                        if (currentUser.getRole().equals("user")) {
                            activeUser = currentUser;
                            operationsCurrentUser();
                        } else {
                            activeUser = currentUser;
                            operationsCurrentAdmin();

                        }
                    } else System.out.println("error password!");
                    return;

                }
            }
            if (emailNotFound) {
                System.out.println("such email not found!");

            }
        }
    }

    private static void operationsCurrentAdmin() {
        System.out.println("==Welcome to platform " + activeUser.getName() + " ==");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            mainMenuCurrentAdmin();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addingQuestions();
                    break;
                case 2:
                    break;
                case 0:
                    return;
                default:
                    System.out.println("error choice! ");
                    break;
            }
        }
    }

    private static void addingQuestions() {
        while (true) {
            boolean added = false;
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("==Adding Questions==");
                System.out.println("available new subject too!!");
                listOfSubjects();
                System.out.print("Subject(enter with letters): ");
                String subject = scanner.nextLine();
                if (subject.length() < 2) {
                    throw new Exception();
                }
                System.out.print("Question text: ");
                scanner = new Scanner(System.in);
                String text = scanner.nextLine();
                System.out.print("A: ");
                String variantA = scanner.nextLine();
                System.out.print("B: ");
                String variantB = scanner.nextLine();
                System.out.print("C: ");
                String variantC = scanner.nextLine();
                System.out.print("D: ");
                String variantD = scanner.nextLine();
                System.out.print("Right variant: ");
                String rightVariant = scanner.nextLine();
                added = true;
                switch (subject) {
                    case "Physics":
                        questions.put(questionNumberP, new Questions(text, new Answer(variantA, variantB, variantC, variantD, rightVariant)));
                        subjects.add(new Subject(subject, questions.get(questionNumberP)));
                        questionNumberP++;
                        break;
                    case "Math":
                        questions.put(questionNumberM, new Questions(text, new Answer(variantA, variantB, variantC, variantD, rightVariant)));
                        subjects.add(new Subject(subject, questions.get(questionNumberM)));
                        questionNumberM++;
                        break;
                    case "Programming for BackEnd":
                        questions.put(questionNumberPB, new Questions(text, new Answer(variantA, variantB, variantC, variantD, rightVariant)));
                        subjects.add(new Subject(subject, questions.get(questionNumberPB)));
                        questionNumberPB++;
                        break;
                    case "Programming for FrontEnd":
                        questions.put(questionNumberPF, new Questions(text, new Answer(variantA, variantB, variantC, variantD, rightVariant)));
                        subjects.add(new Subject(subject, questions.get(questionNumberPF)));
                        questionNumberPF++;
                        break;
                    default:
                        questions.put(questionNumberNS, new Questions(text, new Answer(variantA, variantB, variantC, variantD, rightVariant)));
                        subjects.add(new Subject(subject, questions.get(questionNumberNS)));
                        questionNumberNS++;

                }
            } catch (Exception e) {
                System.out.println("\nonly with letters PLEASE!!!\n");
            }
            if (!added) {
                return;
            }
        }
    }

    private static void mainMenuCurrentAdmin() {
        System.out.println("------------------------------");
        System.out.println("1.Add questions");
        System.out.println("2.Show results");
        System.out.println("0.Exit");
        System.out.println("------------------------------\n");
    }

    private static void mainMenuCurrentUser() {
        System.out.println("------------------------------");
        System.out.println("1.Exam");
        System.out.println("2.Show results");
        System.out.println("0.Exit");
        System.out.println("------------------------------");
    }

    private static void operationsCurrentUser() {
        System.out.println("==Welcome to platform " + activeUser.getName() + " ==");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            mainMenuCurrentUser();
            // try
            // boolean b = true;
            // while (b)
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    exam();
                    // b = false;
                    break;
                case 2:
                    showResult();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("error choice! ");
                    break;
            }// catch
        }
    }

    private static void showResult() {
        System.out.println("==Results==");
        for (Result result : results) {
            if (result != null) {
                if (result.getUser().equals(activeUser)) {
                    System.out.println(result.getSubject() + ":" + result.getScore() + " from " + result.getSumOfQuestiions());
                }
            }
        }

    }

    private static void exam() {
        listOfSubjects();
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        for (Subject subject : subjects) {
            if (subject.getName().equals(namesOfSubject[choice - 1])) {
                sumOfQuestions++;
            }
        }
        System.out.println("there is " + sumOfQuestions + "  questions. Do you start? yes-1 no-2");
        int yesNot = scanner.nextInt();
        if (yesNot == 1) {
            System.out.println("==Started==");
            int i;
            for (i = (choice - 1) * 50; i <= choice * 50; i++) {
                if (questions.get(i) != null) {
                    System.out.println(questions.get(i).getText());
                    System.out.println("A:" + questions.get(i).getAnswers().getVariantA() + " " +
                            "B:" + questions.get(i).getAnswers().getVariantB() + " " +
                            "C:" + questions.get(i).getAnswers().getVariantC() + " " +
                            "D:" + questions.get(i).getAnswers().getVariantD());
                    scanner = new Scanner(System.in);
                    String answerForQuest = scanner.nextLine();
                    answerForQuest = answerForQuest.toUpperCase();
                    score = checkAnswer(answerForQuest, i);
                }
            }
            results[i] = new Result(activeUser, namesOfSubject[choice - 1], score, sumOfQuestions);
            double tempScore = ((double) score / (double) sumOfQuestions) * 100;
            System.out.println("==Your Score==");
            System.out.printf("You answered %s (%.0f%%) rightly from %s questions", score, tempScore, sumOfQuestions);
            // You answered 2 (66%) rightly from 3 questions
            System.out.println();
            sumOfQuestions = 0;
            score = 0;

        }

    }

    private static int checkAnswer(String answer, int number) {
        if (answer.equals(questions.get(number).getAnswers().getRightVariant())) {
            score += 1;
        }
        return score;
    }

    private static void listOfSubjects() {
        for (Subject subject : subjects) {
            tempName.add(subject.getName());
        }
        System.out.println("------------------------------");
        Iterator<String> iterator = tempName.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            namesOfSubject[count] = iterator.next();
            count++;
        }
        for (int i = 0; i < namesOfSubject.length; i++) {
            if (namesOfSubject[i] != null) {
                System.out.println(i + 1 + "-" + namesOfSubject[i]);
            }
        }
        System.out.println("------------------------------");

    }

    private static void loginRegisterMenu() {
        System.out.println("------------------------------");
        System.out.println("1.Login");
        System.out.println("2.Register");
        System.out.println("0.Exit");
        System.out.println("------------------------------");

    }

    private static void initBase() {

        users.add(0, new User("Ahmad", "1", "1", "admin"));
        users.add(1, new User("Bobur", "bobur@gmail.com", "asd123", "user"));
        users.add(2, new User("Davlat", "davlat@gmail.com", "asd123", "user"));
        users.add(3, new User("Elbek", "elbek@gmail.com", "asd123", "admin"));
        users.add(4, new User("Ilyos", "ilyos@gmail.com", "asd123", "user"));
        // Physics
        questions.put(1, new Questions(" Formula of Water? ", new Answer("H2O", "H02", "2HO", "No answer", "A")));
        questions.put(2, new Questions(" Find the cars speed? \n Distance:120km and time:12 minutes ", new Answer("100m/s", "10km/h", "167m/s", "166.66m/min", "C")));
        questions.put(3, new Questions(" Find mistake! ", new Answer("P=pgh", "S=vt", "g=8.9m/s", "P=pv*v/2", "C")));
        // Math
        questions.put(51, new Questions(" Cos(pi)=?", new Answer("0", "1", "-1", "0.5", "C")));
        questions.put(52, new Questions(" 2Sin(a)Cos(a)=?", new Answer("Cos(2a)", "Sin(3a)", "Cos(a*a)", "Sin(2a)", "D")));
        questions.put(53, new Questions(" Which formula is it: a*a+b*b = c*c ", new Answer("Paskal", "Ford", "nyuton", "Arhimed", "A")));
        // Programming for BackEnd
        questions.put(101, new Questions(" What does this means: OOP ", new Answer("attribute library", "Conception", "Framework", "coding direction ", "D")));
        questions.put(102, new Questions(" Is console.log() in which coding language?", new Answer("React", "Java", "Python", "JScript", "D")));
        questions.put(103, new Questions(" How many differance by initially space between Map and Set? ", new Answer("10", "6", "4", "0", "B")));
        // Programming for FrontEnd
        questions.put(151, new Questions(" Which is paragraph tag? ", new Answer("<H>", "<p>", "<div>", "All of them", "B")));
        questions.put(152, new Questions(" Which is an element?", new Answer("<H>", "<p>", "<div>", "All of them", "D")));
        questions.put(153, new Questions(" How Much standard size at heading? ", new Answer("4", "5", "6", "7", "C")));

        subjects.add(new Subject("Physics", questions.get(1)));
        subjects.add(new Subject("Physics", questions.get(2)));
        subjects.add(new Subject("Physics", questions.get(3)));

        subjects.add(new Subject("Math", questions.get(51)));
        subjects.add(new Subject("Math", questions.get(52)));
        subjects.add(new Subject("Math", questions.get(53)));

        subjects.add(new Subject("Programming for BackEnd", questions.get(101)));
        subjects.add(new Subject("Programming for BackEnd", questions.get(102)));
        subjects.add(new Subject("Programming for BackEnd", questions.get(103)));

        subjects.add(new Subject("Programming for FrontEnd", questions.get(151)));
        subjects.add(new Subject("Programming for FrontEnd", questions.get(152)));
        subjects.add(new Subject("Programming for FrontEnd", questions.get(153)));

    }
}
