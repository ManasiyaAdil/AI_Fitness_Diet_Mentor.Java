public class userprofile {
    private String name;
    private int age;
    private String gender; // "M" or "F"
    private double heightCm;
    private double weightKg;
    private String activityLevel; // "low", "medium", "high"
    private String goal; // "loss", "gain", "maintain"

    public userprofile(String name, int age, String gender, double heightCm, double weightKg,
                       String activityLevel, String goal) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.heightCm = heightCm;
        this.weightKg = weightKg;
        this.activityLevel = activityLevel;
        this.goal = goal;
    }

    public String getName() {
        return name;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(double weightKg) {
        this.weightKg = weightKg;
    }

    public double getHeightCm() {
        return heightCm;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getActivityLevel() {
        return activityLevel;
    }

    public String getGoal() {
        return goal;
    }

    public double calculateBMI() {
        double heightMeters = heightCm / 100.0;
        return weightKg / (heightMeters * heightMeters);
    }

    // Mifflin St Jeor BMR formula
    public double calculateBMR() {
        if (gender.equalsIgnoreCase("M")) {
            return 10 * weightKg + 6.25 * heightCm - 5 * age + 5;
        } else {
            return 10 * weightKg + 6.25 * heightCm - 5 * age - 161;
        }
    }

    public double getActivityMultiplier() {
        if ("high".equalsIgnoreCase(activityLevel)) {
            return 1.55;
        } else if ("medium".equalsIgnoreCase(activityLevel)) {
            return 1.375;
        } else {
            return 1.2;
        }
    }

    public String toDataString() {
        return name + "," + age + "," + gender + "," + heightCm + "," + weightKg + "," +
                activityLevel + "," + goal;
    }

    public static userprofile fromDataString(String line) {
        String[] parts = line.split(",");
        if (parts.length != 7) return null;
        String name = parts[0];
        int age = Integer.parseInt(parts[1]);
        String gender = parts[2];
        double height = Double.parseDouble(parts[3]);
        double weight = Double.parseDouble(parts[4]);
        String activity = parts[5];
        String goal = parts[6];
        return new userprofile(name, age, gender, height, weight, activity, goal);
    }
}
