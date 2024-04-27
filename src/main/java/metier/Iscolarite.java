package metier;

import java.util.List;

public interface Iscolarite {

    void addEtudiant (Etudiant et);
    List<Etudiant> listEtudiants();
    List<Etudiant> etudiantsParMC(String mc);
    Etudiant getEtudiant(Long id);
    Etudiant updateEtudiant(Etudiant et);
    void deleteEtudiant (Long id);

}
