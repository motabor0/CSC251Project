// Policy.java
public class Policy {
    // Attributes
    private String policyNumber;
    private String providerName;
    private PolicyHolder policyHolder;

    private static int policyCount = 0;

    // No-arg constructor
    public Policy() {
        this.policyNumber = "Unknown";
        this.providerName = "Unknown";
        this.policyHolder = new PolicyHolder();
        policyCount++;
    }

    // Parameterized constructor
    public Policy(String policyNumber, String providerName, PolicyHolder policyHolder) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.policyHolder = policyHolder;
        policyCount++;
    }

    // Getters and setters
    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public PolicyHolder getPolicyHolder() {
        return policyHolder;
    }

    public void setPolicyHolder(PolicyHolder policyHolder) {
        this.policyHolder = policyHolder;
    }

    // Calculate Policy Price
    public double calculatePolicyPrice() {
        double baseFee = 600.0;
        double additionalFee = 0.0;

        // Additional fee for age over 50
        if (policyHolder.getAge() > 50) {
            additionalFee += 75.0;
        }

        // Additional fee for smokers
        if (policyHolder.getSmokingStatus().equalsIgnoreCase("smoker")) {
            additionalFee += 100.0;
        }

        // Additional fee for BMI over 35
        double bmi = policyHolder.calculateBMI();
        if (bmi > 35) {
            additionalFee += (bmi - 35) * 20;
        }

        return baseFee + additionalFee;
    }

    // toString method
    @Override
    public String toString() {
        return "Policy Number: " + policyNumber + "\n" +
               "Provider Name: " + providerName + "\n" +
               policyHolder.toString() +
               String.format("Policy Price: $%.2f\n", calculatePolicyPrice());
    }

    // Get policy count
    public static int getPolicyCount() {
        return policyCount;
    }
}
