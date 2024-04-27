package presentation;

import dao.SingletonConnection;
import metier.Etudiant;
import metier.ScolariteImlp;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //SingletonConnection.afficher();
        Etudiant et = new Etudiant();
        Scanner scanner = new Scanner(System.in);
        ScolariteImlp metier = new ScolariteImlp();
        System.out.println("Par nom oui ou nn");
        if (scanner.nextLine().equalsIgnoreCase("o")){
            System.out.println("Mot cle");
            String motcle = scanner.nextLine();
            List<Etudiant> etudiantList = metier.etudiantsParMC(motcle);
            if (!etudiantList.isEmpty()){
                for (Etudiant etudiant:etudiantList){
                    System.out.println(etudiant.getName());
                }
            }
        }
    }

}
