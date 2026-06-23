// public class Main {
//     public static void main(String[] args) {

//         userprofile u = new userprofile(
//                 "Adil",      // name
//                 20,          // age
//                 "male",      // gender
//                 170,         // heightCm
//                 65,          // weightKg
//                 "medium",    // activityLevel
//                 "loss"       // goal
//         );

//         dietplan dp = RecommendationEngine.generatePlan(u);

//         System.out.println(dp);
//     }
// }

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        System.out.print("Enter Height(cm): ");
        int height = sc.nextInt();

        System.out.print("Enter Weight(kg): ");
        int weight = sc.nextInt();

        System.out.println("\n1. Weight Loss");
        System.out.println("2. Weight Gain");

        System.out.print("Choose Goal: ");
        int choice = sc.nextInt();

        String goal;

        if (choice == 1)
            goal = "loss";
        else
            goal = "gain";

        userprofile u = new userprofile(
                name,
                age,
                "male",
                height,
                weight,
                "medium",
                "goal");

        double bmi = weight / Math.pow(height / 100.0, 2);

        System.out.printf("\nBMI: %.2f\n", bmi);

        System.out.println("BMI Category: " +
                RecommendationEngine.bmiCategory(bmi));

        dietplan dp = RecommendationEngine.generatePlan(u);

        System.out.println(dp);
    }
}