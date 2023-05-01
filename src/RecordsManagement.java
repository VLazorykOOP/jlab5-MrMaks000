import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class RecordsManagement {
    public static void Task1() {
        ArrayList<Trial> trials = readTrialsFromFile("D:\\Repos\\Sours\\J\\Lab5\\src\\trials.txt");
        ArrayList<Test> tests = readTestsFromFile("D:\\Repos\\Sours\\J\\Lab5\\src\\tests.txt");
        ArrayList<Exam> exams = readExamsFromFile("D:\\Repos\\Sours\\J\\Lab5\\src\\exams.txt");
        ArrayList<FinalExam> finalExams = readFinalExamsFromFile("D:\\Repos\\Sours\\J\\Lab5\\src\\finalExams.txt");


        System.out.println("\nTrials:");
        for (Trial trial : trials) {
            System.out.println(trial.show());
        }
        Collections.sort(trials);
        System.out.println("\nSorted Trials:");
        for (Trial trial : trials) {
            System.out.println(trial.show());
        }

        int maxScore = 5;
        int score = 3;
        Trial temtTrial = new Trial(maxScore);
        temtTrial.passingTheTest(score);
        trials.add(temtTrial);

        Collections.sort(trials);
        System.out.println("\nSorted new Trials:");
        for (Trial trial : trials) {
            System.out.println(trial.show());
        }





        System.out.println("\nTests:");
        for (Test test : tests) {
            System.out.println(test.show());
        }
        Collections.sort(tests);
        System.out.println("\nSorted Tests:");
        for (Test test : tests) {
            System.out.println(test.show());
        }

        maxScore = 10;
        int numberOfTests = 5;
        score = 3;
        //scanner.nextLine();
        Test tempTest = new Test(maxScore, numberOfTests);
        tempTest.passingTheTest(score);
        tests.add(tempTest);

        Collections.sort(tests);
        System.out.println("\nSorted new Tests:");
        for (Test test : tests) {
            System.out.println(test.show());
        }






        System.out.println("\nExams:");
        for (Exam exam : exams) {
            System.out.println(exam.show());
        }
        Collections.sort(exams);
        System.out.println("\nSorted Exams:");
        for (Exam exam : exams) {
            System.out.println(exam.show());
        }
        maxScore = 10;
        numberOfTests = 20;
        int passingScore = 5;
        score = 10;
        //scanner.nextLine();
        Exam tempExam = new Exam(maxScore, numberOfTests, passingScore);
        tempExam.passingTheTest(score);
        exams.add(tempExam);

        Collections.sort(exams);
        System.out.println("\nSorted new Exams:");
        for (Exam exam : exams) {
            System.out.println(exam.show());
        }



        System.out.println("\nFinal exams:");
        for (FinalExam finalExam : finalExams) {
            System.out.println(finalExam.show());
        }
        Collections.sort(finalExams);
        System.out.println("\nSorted Final exams:");
        for (FinalExam finalExam : finalExams) {
            System.out.println(finalExam.show());
        }
        maxScore = 20;
        numberOfTests = 20;
        score = 10;
        //scanner.nextLine();
        FinalExam tempFinalExam = new FinalExam(maxScore, numberOfTests);
        tempFinalExam.passingTheTest(score);
        finalExams.add(tempFinalExam);

        Collections.sort(finalExams);
        System.out.println("\nSorted Final exams:");
        for (FinalExam finalExam : finalExams) {
            System.out.println(finalExam.show());
        }



        //---------------------------------------------------------------------
        // частина 2
        System.out.println("\nBlock 2:");
        ArrayList<Record> records = new ArrayList<>();
        readRecordsFromFile("D:\\Repos\\Sours\\J\\Lab5\\src\\trials.txt", records, "Trial");
        readRecordsFromFile("D:\\Repos\\Sours\\J\\Lab5\\src\\tests.txt", records, "Test");
        readRecordsFromFile("D:\\Repos\\Sours\\J\\Lab5\\src\\exams.txt", records, "Exam");
        readRecordsFromFile("D:\\Repos\\Sours\\J\\Lab5\\src\\finalExams.txt", records, "FinalExam");

        for (Record record : records) {
            System.out.println("\n");
            System.out.println(record.show());
        }
        Collections.sort(records);
        System.out.println("\nSorted Block 2:");
        for (Record record : records) {
            System.out.println("\n");
            System.out.println(record.show());
        }
    }

    public static void Task2() {
        List<Integer> list = new ArrayList<>(Arrays.asList(-3, 2, 1, -5, 6, -4, 3, -2));

        // початкові індекси для додатніх та від'ємних чисел
        int positiveIndex = 0;
        int negativeIndex = list.size() - 1;

        // проходимо список і переставляємо елементи
        while (positiveIndex <= negativeIndex) {
            if (list.get(positiveIndex) < 0) {
                // якщо елемент додатний - міняємо його з останнім від'ємним елементом
                int temp = list.get(positiveIndex);
                list.set(positiveIndex, list.get(negativeIndex));
                list.set(negativeIndex, temp);
                negativeIndex--;
            } else {
                // якщо елемент від'ємний - просто переходимо до наступного елементу
                positiveIndex++;
            }
        }

        // виводимо результат
        System.out.println(list);
    }

    private static ArrayList<Trial> readTrialsFromFile(String filename) {
        ArrayList<Trial> trials = new ArrayList<>();
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                int maxScore = scanner.nextInt();
                int score = scanner.nextInt();
                //scanner.nextLine();
                Trial trial = new Trial(maxScore);
                trial.passingTheTest(score);
                trials.add(trial);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
        return trials;
    }

    private static ArrayList<Test> readTestsFromFile(String filename) {
        ArrayList<Test> tests = new ArrayList<>();
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                int maxScore = scanner.nextInt();
                int numberOfTests = scanner.nextInt();
                int score = scanner.nextInt();
                //scanner.nextLine();
                Test test = new Test(maxScore, numberOfTests);
                test.passingTheTest(score);
                tests.add(test);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
        return tests;
    }

    private static ArrayList<Exam> readExamsFromFile(String filename) {
        ArrayList<Exam> exams = new ArrayList<>();
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                int maxScore = scanner.nextInt();
                int numberOfTests = scanner.nextInt();
                int passingScore = scanner.nextInt();
                int score = scanner.nextInt();
                //scanner.nextLine();
                Exam exam = new Exam(maxScore, numberOfTests, passingScore);
                exam.passingTheTest(score);
                exams.add(exam);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
        return exams;
    }

    private static ArrayList<FinalExam> readFinalExamsFromFile(String filename) {
        ArrayList<FinalExam> finalExams = new ArrayList<>();
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                int maxScore = scanner.nextInt();
                int numberOfTests = scanner.nextInt();
                int score = scanner.nextInt();
                //scanner.nextLine();
                FinalExam finalExam = new FinalExam(maxScore, numberOfTests);
                finalExam.passingTheTest(score);
                finalExams.add(finalExam);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
        return finalExams;
    }

    private static void readRecordsFromFile(String filename, ArrayList<Record> records, String recordType) {
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            if (recordType.equals("Trial")) {
                records.add(readTrialsFromFile(filename).get(0));
                //readTrialsFromFile(filename);
            } else if (recordType.equals("Test")) {
                records.add(readTestsFromFile(filename).get(0));
            } else if (recordType.equals("Exam")) {
                records.add(readExamsFromFile(filename).get(0));
            } else if (recordType.equals("FinalExam")) {
                records.add(readFinalExamsFromFile(filename).get(0));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
    }
}