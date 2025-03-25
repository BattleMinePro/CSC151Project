import java.util.*;
import java.io.*;

public class Project_William_Weisman {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:/Users/WillTheWise/Desktop/CSC151Project/CSC151Project/PolicyInformation.txt");
        Scanner input = new Scanner(file);

        ArrayList<Policy> policies = new ArrayList<>();
        int smokerCount = 0;
        int nonSmokerCount = 0;

        while (input.hasNextLine()) {
            int policyNumber = Integer.parseInt(input.nextLine());
            String providerName = input.nextLine();
            String firstName = input.nextLine();
            String lastName = input.nextLine();
            int age = Integer.parseInt(input.nextLine());
            String smokingStatus = input.nextLine();
            double height = Double.parseDouble(input.nextLine());
            double weight = Double.parseDouble(input.nextLine());

            Policy policy = new Policy(policyNumber, providerName, firstName, lastName, age, smokingStatus, height, weight);
            policies.add(policy);
        }

        input.close();

        for (Policy policy : policies) {
            System.out.println("Policy Number: " + policy.getPolicyNumber());
            System.out.println("Provider Name: " + policy.getProviderName());
            System.out.println("Policyholder's First Name: " + policy.getPolicyholderFirstName());
            System.out.println("Policyholder's Last Name: " + policy.getPolicyholderLastName());
            System.out.println("Policyholder's Age: " + policy.getPolicyholderAge());
            System.out.println("Policyholder's Smoking Status (smoker/non-smoker): " + policy.getPolicyholderSmokingStatus());
            System.out.println("Policyholder's Height: " + policy.getPolicyholderHeight() + " inches");
            System.out.println("Policyholder's Weight: " + policy.getPolicyholderWeight() + " pounds");
            System.out.printf("Policyholder's BMI: %.2f\n", policy.calculateBMI());
            System.out.printf("Policy Price: $%.2f\n", policy.calculatePolicyPrice());
            System.out.println();

            if (policy.getPolicyholderSmokingStatus().equalsIgnoreCase("smoker")) {
                smokerCount++;
            } else {
                nonSmokerCount++;
            }
        }

        System.out.println("The number of policies with a smoker is: " + smokerCount);
        System.out.println("The number of policies with a non-smoker is: " + nonSmokerCount);
    }
}
