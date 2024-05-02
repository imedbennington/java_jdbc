package metier;

import dao.SingletonConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ScolariteImlp implements Iscolarite{
private Connection connection;
    public ScolariteImlp() {
        connection = SingletonConnection.getConnection();
    }
    @Override
    public void addEtudiant(Etudiant et) {
        /*try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "insert into etudiant (name, familyname, mail, estate) values(?, ?, ?, ?)";
            PreparedStatement ps =connection.prepareStatement(sql);
            ps.setString(1, et.getName());
            ps.setString(2, et.getFamilyName());
            ps.setString(3, et.getMail());
            ps.setString(4, et.getState());
            ps.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }*/
         /* Communication avec la base
         */
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

//            Connection connection = DriverManager.getConnection
//                    (url, user, pass);

            String sql = "insert into etudiant (name, familyname, mail, estate) values(?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, et.getName());
            ps.setString(2, et.getFamilyName());
            ps.setString(3, et.getMail());
            ps.setString(4, et.getState());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Etudiant> listEtudiants() {

        List<Etudiant> etudiants = new ArrayList<>();
        /*
         * Communication avec la base
         */
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "select * from etudiant";
            PreparedStatement ps = connection.prepareStatement(sql);
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
        List<Etudiant> etudiants = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "select * from etudiant where id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
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
        }catch (Exception e){
            e.printStackTrace();
        }
        if (!etudiants.isEmpty()) {
            return etudiants.get(0);
        } else {
            // Return null or handle appropriately when no student is found
            return null;
        }
    }

    @Override
    public Etudiant updateEtudiant(Etudiant et) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "UPDATE etudiant SET name = ?, familyname = ?, mail = ?, estate = ? WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, et.getName());
            ps.setString(2, et.getFamilyName());
            ps.setString(3, et.getMail());
            ps.setString(4, et.getState());
            ps.setLong(5, et.getIdEtudiant()); // Set the id parameter for the WHERE clause
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                // If the update was successful, return the updated Etudiant object
                return et;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources
            // Handle SQLException and close resources properly
        }

        // If the update failed or an exception occurred, return null
        return null;
    }

    @Override
    public void deleteEtudiant(Long id) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            PreparedStatement ps = connection.prepareStatement("delete from etudiant where id = ?");
            ps.setLong(1, id);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Student with ID " + id + " deleted successfully.");
            } else {
                System.out.println("No student found with ID " + id + ". No deletion performed.");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
