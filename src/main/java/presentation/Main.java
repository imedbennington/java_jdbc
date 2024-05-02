package presentation;

import dao.SingletonConnection;
import metier.Etudiant;
import metier.ScolariteImlp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean create = false;
        ScolariteImlp scl = new ScolariteImlp();
        Scanner scanner = new Scanner(System.in);
        //SingletonConnection.afficher();

        ScolariteImlp metier = new ScolariteImlp();
        System.out.println("Par nom oui ou nn");
        if (scanner.nextLine().equalsIgnoreCase("o")) {
            System.out.println("Mot cle");
            String motcle = scanner.nextLine();
            List<Etudiant> etudiantList = metier.etudiantsParMC(motcle);
            /*if (!etudiantList.isEmpty()){
                for (Etudiant etudiant:etudiantList){
                    System.out.println(etudiant.getName());
                }
            }
        }
            System.out.println("************;Ajout etudiant ****************");
            System.out.println("name");
            String name = scanner.nextLine();
            System.out.println("familyname");
            String fname = scanner.nextLine();
            System.out.println("mail");
            String mail = scanner.nextLine();
            System.out.println("estate");
            String estate = scanner.nextLine();
            Etudiant et = new Etudiant(name, fname, mail, estate);
            scl.addEtudiant(et);

            System.out.println(et.getName());
            System.out.println(et.getFamilyName());
            System.out.println(et.getMail());
            System.out.println(et.getState());*/

            /*
            // Call the listEtudiants() method to retrieve the list of students
            List<Etudiant> etudiants = scl.listEtudiants();

            // Process the retrieved list of students (e.g., print them)
            for (Etudiant etudiant : etudiants) {
                System.out.println(etudiant);
            }*/
            System.out.println("donner id ");
            Integer id = Integer.valueOf(scanner.nextLine());
            Etudiant etudiant = new Etudiant();
            etudiant = scl.getEtudiant(Long.valueOf(id));
            if (etudiant != null) {
                // Print the details of the retrieved student
                System.out.println("Student found:");
                System.out.println("ID: " + etudiant.getIdEtudiant());
                System.out.println("Name: " + etudiant.getName());
                System.out.println("Family Name: " + etudiant.getFamilyName());
                System.out.println("Mail: " + etudiant.getMail());
                System.out.println("State: " + etudiant.getState());
            } else {
                System.out.println("No student found with the provided ID.");
            }
        }
    }
}