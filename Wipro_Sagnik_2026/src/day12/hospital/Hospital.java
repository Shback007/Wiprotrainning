package day12.hospital;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Hospital implements Serializable {

    private int patientId;
    private String patientName;
    private int age;
    private String disease;

    private ArrayList<String> reports =
            new ArrayList<>();

    private ArrayList<String> treatments =
            new ArrayList<>();

    Hospital(int patientId,
             String patientName,
             int age,
             String disease) {

        this.patientId = patientId;
        this.patientName = patientName;
        this.age = age;
        this.disease = disease;
    }

    public void addReport(String report) {

        if(report == null || report.trim().isEmpty()) {

            reports.add("Invalid Report Entry");
            return;
        }

        reports.add(report);
    }
    public void addTreatment(String treatment) {

        if(treatment == null ||
           treatment.trim().isEmpty()) {

            treatments.add(
                    "Invalid Treatment Entry");

            return;
        }

        treatments.add(treatment);
    }

    public void showDetails() {

        System.out.println("Patient ID: " + patientId);
        System.out.println("Patient Name: " + patientName);
        System.out.println("Age: " + age);
        System.out.println("Disease: " + disease);

        System.out.println("\nMedical Reports:");

        for(String r : reports) {
            System.out.println(r);
        }

        System.out.println("\nTreatments:");

        for(String t : treatments) {
            System.out.println(t);
        }
    }
}