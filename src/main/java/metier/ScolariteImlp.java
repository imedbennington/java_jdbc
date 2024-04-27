package metier;

import dao.SingletonConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ScolariteImlp implements Iscolarite{
private Connection connection;
    public ScolariteImlp() {
        connection = SingletonConnection.getConnection();
    }
    @Override
    public void addEtudiant(Etudiant et) {

    }

    @Override
    public List<Etudiant> listEtudiants() {
        return null;
    }

    @Override
    public List<Etudiant> etudiantsParMC(String mc) {
        //declare de la liste dynamique des etuds
        List<Etudiant> etudiants = new ArrayList<>();
        /**
         * Communication avec la base
         */
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

//            Connection connection = DriverManager.getConnection
//                    (url, user, pass);

            String sql = "select * from etudiant where familyname like ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%"+mc+"%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Etudiant etudiant = new Etudiant();
                etudiant.setIdEtudiant(rs.getLong("id"));
                etudiant.setName(rs.getString("name"));
                etudiant.setFamilyName(rs.getString("familyname"));
                etudiant.setMail(rs.getString("mail"));
                etudiant.setState((rs.getString("estate")));
                etudiants.add(etudiant);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return etudiants;
    }
        //return null;

    @Override
    public Etudiant getEtudiant(Long id) {
        return null;
    }

    @Override
    public Etudiant updateEtudiant(Etudiant et) {
        return null;
    }

    @Override
    public void deleteEtudiant(Long id) {

    }
}
