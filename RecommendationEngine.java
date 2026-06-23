public class RecommendationEngine {

    public static dietplan generatePlan(userprofile user) {
        double bmr = user.calculateBMR();
        double maintenanceCalories = bmr * user.getActivityMultiplier();

        String goal = user.getGoal().toLowerCase();
        int targetCalories;

        if (goal.equals("loss")) {
            targetCalories = (int) (maintenanceCalories - 400);
            if (targetCalories < 1200) {
                targetCalories = 1200;
            }
            return new dietplan("Weight Loss", targetCalories,
                    "Oats with fruits and 1 boiled egg",
                    "2 chapati, dal, salad, 1 bowl vegetables",
                    "Grilled chicken or paneer, salad, light soup",
                    "Green tea, handful of nuts, 1 fruit");
        } else if (goal.equals("gain")) {
            targetCalories = (int) (maintenanceCalories + 400);
            return new dietplan("Weight Gain", targetCalories,
                    "Milk, dry fruits, peanut butter sandwich",
                    "Rice, 3 chapati, dal, sabji, curd",
                    "Paneer bhurji or chicken, rice, salad",
                    "Banana shake, peanut chikki, yogurt");
        } else {
            targetCalories = (int) (maintenanceCalories);
            return new dietplan("Maintain Weight", targetCalories,
                    "Poha or upma with peanuts, 1 fruit",
                    "2 chapati, dal, sabji, salad",
                    "Light khichdi or grilled paneer with salad",
                    "Buttermilk, roasted chana, fruit");
        }
    }

    public static String bmiCategory(double bmi) {
        if (bmi < 18.5) return "Underweight";
        else if (bmi < 25) return "Normal weight";
        else if (bmi < 30) return "Overweight";
        else return "Obese";
    }
}
