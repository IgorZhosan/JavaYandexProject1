import java.util.ArrayList;
import java.util.HashMap;

public class StepTracker {
    double stepMonth = 10000;

    HashMap<Integer, MonthData> monthToData = new HashMap<Integer, MonthData>();

    int getMonthIndex(String month) {
        switch (month) {
            case "Январь":
                return 0;
            case "Февраль":
                return 1;
            case "Март":
                return 2;
            case "Апрель":
                return 3;
            case "Май":
                return 4;
            case "Июнь":
                return 5;
            case "Июль":
                return 6;
            case "Август":
                return 7;
            case "Сентябрь":
                return 8;
            case "Октябрь":
                return 9;
            case "Ноябрь":
                return 10;
            case "Декабрь":
                return 11;
            default:
                return -1;
        }
    }

    public StepTracker() {
        for (int i = 0; i < 12; i++) {
            monthToData.put(i, new MonthData());
        }
    }

    public void saveStep(String monthName, int day, int steps) {

        MonthData monthData = monthToData.get(getMonthIndex(monthName));
        monthData.saveStep(day, steps);
    }

    public void printStep(String monthName) {
        MonthData monthData = monthToData.get(getMonthIndex(monthName));
        for (Integer i : monthData.stepData.keySet()) {
            System.out.println(i + " день: " + monthData.stepData.get(i));

        }
        System.out.println();
    }

    public double countStep(String monthName) {

        MonthData monthData = monthToData.get(getMonthIndex(monthName));
        double count = 0;

        if (monthData.stepData.get(1) == null) return 0;
        else {
            for (Integer i : monthData.stepData.values()) {
                count += i;
            }
            return count;
        }
    }

    public double averageSteps(String monthName) {

        MonthData monthData = monthToData.get(getMonthIndex(monthName));
        if (monthData.stepData.get(1) == null) return 0;
        else {
            double averageStep = 0;
            byte count = 0;
            for (Integer i : monthData.stepData.values()) {
                averageStep += i;
                count++;
            }
            return averageStep / count;
        }
    }

    public int maxMonthStep(String monthName) {
        MonthData monthData = monthToData.get(getMonthIndex(monthName));

        if (monthData.stepData.get(1) == null) return 0;
        else {
            int max = monthData.stepData.get(1);

            for (Integer i : monthData.stepData.values()) {
                if (i > max) max = i;
            }
            return max;
        }
    }

    public void setStepMonth(double stepMonth) {
        this.stepMonth = stepMonth;
    }

    public double getStepMonth() {
        return stepMonth;
    }

    public int bestSeries(String monthName) {
        MonthData monthData = monthToData.get(getMonthIndex(monthName));
        byte localMax = 0;
        byte globalMax = 0;
        for (int i = 1; i <= monthData.stepData.get(i- 1) ; i++) { // доработать.....
            if (monthData.stepData.get(i) > stepMonth && monthData.stepData.get(i + 1) > stepMonth) {
                localMax++;
            } else {
                globalMax = localMax;
                localMax = 0;
            }

        }
        return globalMax;
    }

}


class MonthData {
    HashMap<Integer, Integer> stepData = new HashMap<>();

    public void saveStep(int day, int steps) {
        stepData.put(day, steps);
    }
}
