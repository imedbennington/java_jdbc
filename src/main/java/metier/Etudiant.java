package metier;

public class Etudiant {
    private Long idEtudiant;
    private String name, familyName, mail, state;

    //


    public Etudiant() {
    }

    public Etudiant(String name, String familyName, String mail, String state) {
        this.name = name;
        this.familyName = familyName;
        this.mail = mail;
        this.state = state;
    }

    public Long getIdEtudiant() {
        return idEtudiant;
    }

    public void setIdEtudiant(Long idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "idEtudiant=" + idEtudiant +
                ", name='" + name + '\'' +
                ", familyName='" + familyName + '\'' +
                ", mail='" + mail + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
