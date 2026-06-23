import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class datastore {
    private static final String FILE_NAME = "users_data.txt";

    public static void saveUser(userprofile user) {
        List<userprofile> all = loadAllUsers();
        boolean updated = false;

        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getName().equalsIgnoreCase(user.getName())) {
                all.set(i, user);
                updated = true;
                break;
            }
        }

        if (!updated) {
            all.add(user);
        }

        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (userprofile u : all) {
                pw.println(u.toDataString());
            }
            System.out.println("User data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    public static userprofile loadUserByName(String name) {
        List<userprofile> all = loadAllUsers();
        for (userprofile u : all) {
            if (u.getName().equalsIgnoreCase(name)) {
                return u;
            }
        }
        return null;
    }

    public static List<userprofile> loadAllUsers() {
        List<userprofile> list = new ArrayList<>();
        File f = new File(FILE_NAME);
        if (!f.exists()) {
            return list;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                userprofile u = userprofile.fromDataString(line);
                if (u != null) {
                    list.add(u);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
        return list;
    }
}
