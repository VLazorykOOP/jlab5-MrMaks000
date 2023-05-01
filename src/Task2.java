abstract class Container {
    protected  int []array;

    public Container(int []array) {
        this.array = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            this.array[i] = array[i];
        }

    }
    public abstract void sort();
    public abstract double norma();
    public String toString() {
        String str = "";
        for (int i = 0; i < array.length; i++) {
            str += Integer. toString(array[i]) + " ";
        }
        return str;
    }
    public boolean equals(Object N) {
        if (!(N instanceof Container other)) return false;
        if (this.array.length != other.array.length) {
            return false;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] != other.array[i]) {
                return false;
            }
        }
        return true;
    }
}

class Choice extends Container {

    public Choice(int[] array) {
        super(array);
    }

    @Override
    public void sort() {
        for (int i = 0; i < array.length - 1; ++i) {
            int minPos = i;
            for (int j = i + 1; j < array.length; ++j) {
                if (array[j] < array[minPos]) {
                    minPos = j;
                }
            }
            int saveValue = array[minPos];
            array[minPos] = array[i];
            array[i] = saveValue;
        }
    }

    @Override
    public double norma() {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum / array.length;
    }

    public String toString() {

        return "Choice: " + super.toString();
    }


    public boolean equal(Bubble N) {
        return super.equals(N);
    }

}

class Bubble extends Container {

    public Bubble(int[] array) {
        super(array);
    }

    @Override
    public void sort() {
        boolean isSorted = false;
        int buf;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length-1; i++) {
                if(array[i] > array[i+1]){
                    isSorted = false;

                    buf = array[i];
                    array[i] = array[i+1];
                    array[i+1] = buf;
                }
            }
        }
    }

    @Override
    public double norma() {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return Math. sqrt(sum);
    }

    public String toString() {
        return "Bubble: " + super.toString();
    }

    public boolean equal(Choice N) {
        return super.equals(N);
    }
}