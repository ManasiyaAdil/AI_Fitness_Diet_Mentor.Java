import java.util.Scanner;

public class fitnessapp {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("===========================================");
        System.out.println("   AI Based Fitness and Diet Mentor");
        System.out.println("===========================================\n");

        while (true) {
            System.out.println("1. Register or Update Profile");
            System.out.println("2. View Recommendations");
            System.out.println("3. Update Weight and Track Progress");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            int choice = readInt();

            switch (choice) {
                case 1:
                    registerOrUpdate();
                    break;
                case 2:
                    viewRecommendations();
                    break;
                case 3:
                    updateWeight();
                    break;
                case 4:
                    System.out.println("Thank you for using Fitness and Diet Mentor.");
                    return;
                default:
                    System.out.println("Invalid choice, try again.\n");
            }
        }
    }

    private static void registerOrUpdate() {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter age: ");
        int age = readInt();

        System.out.print("Enter gender (M/F): ");
        String gender = scanner.nextLine().trim();

        System.out.print("Enter height in cm: ");
        double height = readDouble();

        System.out.print("Enter weight in kg: ");
        double weight = readDouble();

        System.out.print("Activity level (low / medium / high): ");
        String activity = scanner.nextLine().trim();

        System.out.print("Goal (loss / gain / maintain): ");
        String goal = scanner.nextLine().trim();

        userprofile user = new userprofile(name, age, gender, height, weight, activity, goal);
        datastore.saveUser(user);
        System.out.println("Profile created or updated successfully.\n");
    }

    private static void viewRecommendations() {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine().trim();

        userprofile user = datastore.loadUserByName(name);
        if (user == null) {
            System.out.println("User not found. Please register first.\n");
            return;
        }

        double bmi = user.calculateBMI();
        String category = RecommendationEngine.bmiCategory(bmi);
        double bmr = user.calculateBMR();
        double maintenance = bmr * user.getActivityMultiplier();

        System.out.println("\n========== Health Summary ==========");
        System.out.printf("Name       : %s%n", user.getName());
        System.out.printf("BMI        : %.2f (%s)%n", bmi, category);
        System.out.printf("BMR        : %.2f kcal%n", bmr);
        System.out.printf("Maintenance: %.2f kcal per day%n", maintenance);
        System.out.println("Goal       : " + user.getGoal());
        System.out.println("===================================\n");

        dietplan plan = RecommendationEngine.generatePlan(user);
        plan.displayPlan();
    }

    private static void updateWeight() {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine().trim();

        userprofile user = datastore.loadUserByName(name);
        if (user == null) {
            System.out.println("User not found. Please register first.\n");
            return;
        }

        System.out.printf("Current weight: %.2f kg%n", user.getWeightKg());
        System.out.print("Enter new weight in kg: ");
        double newWeight = readDouble();
        user.setWeightKg(newWeight);
        datastore.saveUser(user);
        System.out.println("Weight updated successfully.\n");

        double bmi = user.calculateBMI();
        String category = RecommendationEngine.bmiCategory(bmi);
        System.out.printf("New BMI: %.2f (%s)%n%n", bmi, category);
    }

    private static int readInt() {
        while (true) {
            try {
                String line = scanner.nextLine();
                return Integer.parseInt(line.trim());
            } catch (NumberFormatException e) {
                System.out.print("Enter a valid number: ");
            }
        }
    }

    private static double readDouble() {
        while (true) {
            try {
                String line = scanner.nextLine();
                return Double.parseDouble(line.trim());
            } catch (NumberFormatException e) {
                System.out.print("Enter a valid numeric value: ");
            }
        }
    }
}
