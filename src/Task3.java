interface Container2 {

    void sort();
    double norma();
    //boolean equals(Container2 N);
}

class Choice2 implements Container2 {
    int []array;
    public Choice2(int[] array) {
        this.array = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            this.array[i] = array[i];
        }
    }

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

    public double norma() {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum / array.length;
    }
    public String toString() {
        String str = "Choice2: ";
        for (int i = 0; i < array.length; i++) {
            str += Integer.toString(array[i]) + " ";
        }
        return str;
    }

    public boolean equals(Object N) {
        if (!(N instanceof Choice2 other)) return false;
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

class Bubble2 implements Container2 {
    int []array;
    public Bubble2(int[] array) {
        this.array = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            this.array[i] = array[i];
        }
    }

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

    public double norma() {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return Math. sqrt(sum);
    }

    public String toString() {
        String str = "Bubble2: ";
        for (int i = 0; i < array.length; i++) {
            str += Integer.toString(array[i]) + " ";
        }
        return str;
    }

    public boolean equals(Object N) {
        if (!(N instanceof Bubble2 other)) return false;
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
