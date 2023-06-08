package StopWatchExercise;

public class Main {
    public static void main(String[] args) {
        StopWatch watch = new StopWatch();
        watch.startTime();
        double[] randomArr = new double[100000];
        for (int i = 0; i < randomArr.length; i++) {
            randomArr[i] = Math.random();
            randomArr[i] = randomArr[i] * 100000 + 1;
        }
        for (int i = 0; i < randomArr.length; i++) {
            for (int j = i + 1; j < randomArr.length; j++) {
                if (randomArr[i] > randomArr[j]) {
                    double temp = randomArr[i];
                    randomArr[i] = randomArr[j];
                    randomArr[j] = temp;
                }
            }
        }
        watch.endTime();
        System.out.println(watch.getElapsedTime());
    }
}
