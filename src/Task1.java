abstract class Record implements Comparable<Record>{
    public abstract String show();
    @Override
    public abstract int compareTo(Record other);
}


class Trial extends Record{// implements Comparable<Trial>{
    private int score;
    private int maxScore;

    private boolean validity;

    public Trial(int maxScore) {
        this.maxScore = maxScore;
        validity = false;
    }

    protected int getMaxScore() {
        return maxScore;
    }
    protected int getScore() {
        return score;
    }
    protected boolean getValidity() {
        return validity;
    }
    public void passingTheTest(int score) {
        if (score > this.maxScore) {
            validity = false;
            return;
        }
        validity = true;
        this.score = score;
    }

    public String show() {
        if (validity == false) return "test not started";
        return "The test is written for " + score + " out of " + maxScore;
    }

    public int compareTo(Record other) {
        // Сортуємо за спаданням оцінки (score)
        int result = Integer.compare(((Trial)other).score, this.score);
        if (result == 0) {
            // У разі однакової оцінки сортуємо за зростанням максимальної оцінки (maxScore)
            result = Integer.compare(this.maxScore, ((Trial)other).maxScore);
        }
        return result;
    }
}


class Test extends Trial {
    private int numberOfTests;
    private int numberOfCorrectAnswers;

    public Test(int maxScore, int numberOfTests) {
        super(maxScore);
        this.numberOfTests = numberOfTests;
    }

    protected int getNumberOfTests() {
        return numberOfTests;
    }

    public void passingTheTest(int numberOfCorrectAnswers) {
        this.numberOfCorrectAnswers = numberOfCorrectAnswers;
        super.passingTheTest(numberOfCorrectAnswers * getMaxScore() / numberOfTests);
    }

    public String show() {
        if (getValidity() == false) return "test not started";
        return super.show() + "\n" + numberOfCorrectAnswers + " out of " + numberOfTests + " correct answers ";
    }

    public int compareTo(Record other) {
        // Сортуємо за спаданням оцінки (score)
        int result = Integer.compare(((Trial)other).getScore(), this.getScore());
        if (result == 0) {
            // У разі однакової оцінки сортуємо за зростанням максимальної оцінки (maxScore)
            result = Integer.compare(this.getMaxScore(), ((Trial)other).getMaxScore());
        }
        if (result == 0) {
            // У разі однакової оцінки сортуємо за зростанням максимальної оцінки (maxScore)
            result = Integer.compare(this.numberOfTests, ((Test)other).numberOfTests);
        }
        return result;
    }
}


class Exam extends Test {
    private int passingScore;
    private String evaluation;

    public Exam(int maxScore, int numberOfTests, int passingScore) {
        super(maxScore, numberOfTests);
        this.passingScore = passingScore;
    }
    private void setEvaluation() {
        if (getScore() < passingScore) {
            evaluation = "test failed";
        }
        else {
            evaluation = "test is passed";
        }
    }

    public void passingTheTest(int numberOfCorrectAnswers) {
        super.passingTheTest(numberOfCorrectAnswers);
        setEvaluation();
    }

    public String show() {
        if (getValidity() == false) return "test not started";
        return super.show() + "\n" + evaluation;
    }

    public int compareTo(Record other) {
        // Сортуємо за спаданням оцінки (score)
        int result = Integer.compare(((Trial)other).getScore(), this.getScore());
        if (result == 0) {
            // У разі однакової оцінки сортуємо за зростанням максимальної оцінки (maxScore)
            result = Integer.compare(this.getMaxScore(), ((Trial)other).getMaxScore());
        }
        if (result == 0) {
            // У разі однакової оцінки сортуємо за зростанням максимальної оцінки (maxScore)
            result = Integer.compare(this.getNumberOfTests(), ((Test)other).getNumberOfTests());
        }
        if (result == 0) {
            // У разі однакової оцінки сортуємо за зростанням максимальної оцінки (maxScore)
            result = Integer.compare(this.passingScore, ((Exam)other).passingScore);
        }

        return result;
    }
}


class FinalExam extends Exam {
    private String stringRating;

    public FinalExam(int maxScore, int numberOfTests) {
        super(maxScore, numberOfTests, maxScore / 2);
    }

    private void setStringRating() {
        if (getScore() > 90 * getMaxScore() / 100)
        {
            stringRating = "A";
        }
        else if (getScore() > 80 * getMaxScore() / 100)
        {
            stringRating = "B";
        }
        else if (getScore() > 70 * getMaxScore() / 100)
        {
            stringRating = "C";
        }
        else if (getScore() > 50 * getMaxScore() / 100)
        {
            stringRating = "D";
        }
        else
        {
            stringRating = "E";
        }
    }

    public void passingTheTest(int numberOfCorrectAnswers) {
        super.passingTheTest(numberOfCorrectAnswers);
        setStringRating();
    }

    public String show() {
        if (getValidity() == false) return "test not started";
        return super.show() + "\n" + "string rating: " + stringRating;
    }

}
