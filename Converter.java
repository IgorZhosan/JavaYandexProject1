public class Converter {
    double step = 0.75;
    byte calories = 50;

    StepTracker stepTracker = new StepTracker();


    public double converterSteps(String monthName) {

        return step * stepTracker.countStep(monthName) / 1000;
    }

    public double converterCalories(String monthName) {
        return calories * stepTracker.countStep(monthName) / 1000;
    }

}
