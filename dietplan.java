public class dietplan {
    private String goal;
    private int caloriesTarget;
    private String breakfast;
    private String lunch;
    private String dinner;
    private String snacks;

    public dietplan(String goal, int caloriesTarget,
                    String breakfast, String lunch, String dinner, String snacks) {
        this.goal = goal;
        this.caloriesTarget = caloriesTarget;
        this.breakfast = breakfast;
        this.lunch = lunch;
        this.dinner = dinner;
        this.snacks = snacks;
    }

    @Override
public String toString() {
    return "Breakfast: " + breakfast +
           "\nLunch: " + lunch +
           "\nDinner: " + dinner;
}

    public void displayPlan() {
        System.out.println("\n========== Your Personalized Diet Plan ==========");
        System.out.println("Goal           : " + goal);
        System.out.println("Target Calories: " + caloriesTarget + " kcal");
        System.out.println("-----------------------------------------------");
        System.out.println("Breakfast: " + breakfast);
        System.out.println("Lunch    : " + lunch);
        System.out.println("Dinner   : " + dinner);
        System.out.println("Snacks   : " + snacks);
        System.out.println("===============================================\n");
    }
}

