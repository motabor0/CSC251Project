import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class Project_Matthew_Otabor {
    public static void main(String[] args) {
        ArrayList<Policy> policies = new ArrayList<>();
        int smokerCount = 0;
        int nonSmokerCount = 0;

        try {
            File file = new File("CSC251Project/PolicyInformation.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                // Read data from the file
                String policyNumber = scanner.nextLine();
                String providerName = scanner.nextLine();
                String firstName = scanner.nextLine();
                String lastName = scanner.nextLine();
                int age = Integer.parseInt(scanner.nextLine());
                String smokingStatus = scanner.nextLine();
                double height = Double.parseDouble(scanner.nextLine());
                double weight = Double.parseDouble(scanner.nextLine());

                // Create PolicyHolder object
                PolicyHolder policyHolder = new PolicyHolder(firstName, lastName, age, smokingStatus, height, weight);

                // Create Policy object
                Policy policy = new Policy(policyNumber, providerName, policyHolder);

                // Add policy to the list
                policies.add(policy);

                // Count smokers and non-smokers
                if (smokingStatus.equalsIgnoreCase("smoker")) {
                    smokerCount++;
                } else {
                    nonSmokerCount++;
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }

        // Display all policies
        for (Policy policy : policies) {
            System.out.println("\nPolicy Information:");
            System.out.println(policy);
        }

        // Display number of smokers and non-smokers
        System.out.println("\nNumber of Policyholders that are smokers: " + smokerCount);
        System.out.println("Number of Policyholders that are non-smokers: " + nonSmokerCount);
        System.out.println("\nNumber of Policy objects created: " + Policy.getPolicyCount());
    }
}
