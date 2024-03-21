package com.example.test.DAO;

import com.example.test.entities.Experience;
import com.example.test.entities.PersonalAccount;
import com.example.test.entities.Project;
import com.example.test.entities.Qualification;
import com.example.test.utils.DataBaseConnection;

import java.sql.*;

public class AccountDAO {
    private static Connection connection = DataBaseConnection.getInstance();
    public static int save(PersonalAccount account) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String sql = "INSERT INTO accounts (first_name, last_name, email, password, phone_number, date_of_birth, gender, country) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, account.getFirstName());
            pstmt.setString(2, account.getLastName());
            pstmt.setString(3, account.getEmail());
            pstmt.setString(4, account.getPassword());
            pstmt.setString(5, account.getPhoneNumber());
            pstmt.setDate(6, java.sql.Date.valueOf(account.getDateOfBirth()));
            pstmt.setString(7, account.getGender());
            pstmt.setString(8, account.getCountry());
            pstmt.executeUpdate();

            rs = pstmt.getGeneratedKeys();
            if (rs.next())
                return rs.getInt(1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return -1;
    }
    public static void saveQualifications(PersonalAccount account, int accountId) {
        String sql = "INSERT INTO qualifications (account_id, diploma, title, institution, technology, start_date, finish_date, description) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            for (Qualification qualification : account.getQualifications()) {
                pstmt.setInt(1, accountId);
                pstmt.setString(2, qualification.getDiploma());
                pstmt.setString(3, qualification.getTitle());
                pstmt.setString(4, qualification.getInstitution());
                pstmt.setString(5, qualification.getTechnology());
                pstmt.setDate(6, java.sql.Date.valueOf(qualification.getStartDate()));
                pstmt.setDate(7, java.sql.Date.valueOf(qualification.getFinishDate()));
                pstmt.setString(8, qualification.getDescription());

                pstmt.executeUpdate();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static void saveProjects(PersonalAccount account, int accountId) {
        String sql = "INSERT INTO projects (account_id, title, start_date, finish_date, description) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            for (Project project : account.getProjects()) {
                pstmt.setInt(1, accountId);
                pstmt.setString(2, project.getTitle());
                pstmt.setDate(3, java.sql.Date.valueOf(project.getStartDate()));
                pstmt.setDate(4, java.sql.Date.valueOf(project.getFinishDate()));
                pstmt.setString(5, project.getDescription());

                pstmt.executeUpdate();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void saveExperiences(PersonalAccount account, int accountId) {
        String sql = "INSERT INTO experiences (account_id, title, type, mission, technology, start_date, finish_date, description) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            for (Experience experience : account.getExperiences()) {
                pstmt.setInt(1, accountId);
                pstmt.setString(2, experience.getTitle());
                pstmt.setString(3, experience.getType());
                pstmt.setString(4, experience.getMission());
                pstmt.setString(5, experience.getTechnology());
                pstmt.setDate(6, java.sql.Date.valueOf(experience.getStartDate()));
                pstmt.setDate(7, java.sql.Date.valueOf(experience.getFinishDate()));
                pstmt.setString(8, experience.getDescription());

                pstmt.executeUpdate();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void saveAccount(PersonalAccount p){
        int accountId = AccountDAO.save(p);
        saveQualifications(p,accountId);
        saveExperiences(p,accountId);
        saveProjects(p,accountId);
    }
}
