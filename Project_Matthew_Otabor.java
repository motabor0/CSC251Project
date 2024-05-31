import java.util.Scanner;

public class Project_Matthew_Otabor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for input
        System.out.print("Enter the Policy Number: ");
        String policyNumber = scanner.nextLine();

        System.out.print("Enter the Provider Name: ");
        String providerName = scanner.nextLine();

        System.out.print("Enter the Policyholder’s First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter the Policyholder’s Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter the Policyholder’s Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();  // Consume the newline

        System.out.print("Enter the Policyholder’s Smoking Status (smoker/non-smoker): ");
        String smokingStatus = scanner.nextLine();

        System.out.print("Enter the Policyholder’s Height (in inches): ");
        double height = scanner.nextDouble();

        System.out.print("Enter the Policyholder’s Weight (in pounds): ");
        double weight = scanner.nextDouble();

        // Create Policy object
        Policy policy = new Policy(policyNumber, providerName, firstName, lastName, age, smokingStatus, height, weight);

        // Display Policy information
        System.out.println("\nPolicy Information:");
        System.out.println("Policy Number: " + policy.getPolicyNumber());
        System.out.println("Provider Name: " + policy.getProviderName());
        System.out.println("Policyholder’s First Name: " + policy.getPolicyholderFirstName());
        System.out.println("Policyholder’s Last Name: " + policy.getPolicyholderLastName());
        System.out.println("Policyholder’s Age: " + policy.getPolicyholderAge());
        System.out.println("Policyholder’s Smoking Status: " + policy.getPolicyholderSmokingStatus());
        System.out.println("Policyholder’s Height: " + policy.getPolicyholderHeight() + " inches");
        System.out.println("Policyholder’s Weight: " + policy.getPolicyholderWeight() + " pounds");
        System.out.printf("Policyholder’s BMI: %.2f\n", policy.calculateBMI());
        System.out.printf("Policy Price: $%.2f\n", policy.calculatePolicyPrice());

        scanner.close();
    }
}
