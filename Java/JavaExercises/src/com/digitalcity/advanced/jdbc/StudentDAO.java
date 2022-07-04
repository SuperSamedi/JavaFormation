// Créez un DAO pour les etudiants
// permettant de :
//      - faire le crud de base
//          -insert renvoie le student ajouté
//          -update renvoie un boolean
//          -delete renvoie le student ajouté
//
// La classe Student doit posséder une variable Section contenant toutes les infos de sa
// section plutot que seulement l'id (via un join)
//
// Créez une methode permettant de transférer tous les étudiants d'une section dans une autre.
//
// BONUS
// -----
// - Créez une methode appliquant le traitement suivant: Tous les étudiants
// ayant un résultat au dessus de la moyen se vois accordé le privilège d'un préfixe
// 'winner'au debut de leur login. (il est possible qu'un étudiant ait recu un login de
// ce type par le passé et que ses résultat ne matche plus. Il perd alors son 'winner')

package com.digitalcity.advanced.jdbc;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    public List<Student> getStudentsFromSection(int id) {
        List<Student> students = new ArrayList<>();

        String query = "SELECT * FROM student LEFT JOIN section ON student.section_id = section.section_id WHERE section_id = " + id;

        try (
                Connection connection = ConnectionFactory.createConnection();
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(query)
        ) {
            while (rs.next()) {
                int studentID = rs.getInt("student_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                Date sqlDateOfBirth = rs.getDate("birth_date");
                String login = rs.getString("login");
                int yearResult = rs.getInt("year_result");
                String courseID = rs.getString("course_id");
                int sectionID = rs.getInt("section_id");
                String sectionName = rs.getString("section_name");
                Integer selectionDelegateID = rs.getInt("delegate_id");
                if (rs.wasNull()) {
                    selectionDelegateID = null;
                }

                // Convert sqlDate to localDate
                LocalDate dateOfBirth = sqlDateOfBirth.toLocalDate();
                Section newSection = new Section(sectionID, sectionName, selectionDelegateID);
                Student newStudent = new Student(studentID, firstName, lastName, dateOfBirth, login, yearResult, courseID, newSection);
                students.add(newStudent);
            }
            return students;
        } catch (SQLException ex) {
            throw new RuntimeException("SQL error - " + ex.getSQLState() + " : " + ex.getErrorCode() + " - " + ex.getMessage());
        }
    }

    public Student getStudentByID(int id) {
        String query = "SELECT *" +
                " FROM student" +
                " LEFT JOIN section" +
                " ON student.section_id = section.section_id" +
                " WHERE student_id = " + id;
//        String query = "SELECT * FROM student WHERE student_id = " + id;
        try (
                Connection connection = ConnectionFactory.createConnection();
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(query)
        ) {
            if (rs.next()) {
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                Date sqlDateOfBirth = rs.getDate("birth_date");
                String login = rs.getString("login");
                int yearResult = rs.getInt("year_result");
                String courseID = rs.getString("course_id");
                int sectionID = rs.getInt("section_id");
                String sectionName = rs.getString("section_name");
                Integer selectionDelegateID = rs.getInt("delegate_id");
                if (rs.wasNull()) {
                    selectionDelegateID = null;
                }

                // Convert sqlDate to localDate
                LocalDate dateOfBirth = sqlDateOfBirth.toLocalDate();
                Section newSection = new Section(sectionID, sectionName, selectionDelegateID);
                return new Student(id, firstName, lastName, dateOfBirth, login, yearResult, courseID, newSection);
            }

            return null;

        } catch (SQLException e) {
            throw new RuntimeException("SQL error - " + e.getSQLState() + " : " + e.getErrorCode() + " - " + e.getMessage());
        }
    }

    public Student insert(Student student) {
        if (student == null) {
            throw new RuntimeException("Error - trying to insert null object.");
        }

        String query = "INSERT INTO student VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (
                Connection connection = ConnectionFactory.createConnection();
                PreparedStatement stmt = connection.prepareStatement(query)
        ) {
            stmt.setInt(1, student.getId());

            if (student.getFirstName() != null) {
                stmt.setString(2, student.getFirstName());
            } else {
                stmt.setNull(2, Types.VARCHAR);
            }

            if (student.getLastName() != null) {
                stmt.setString(3, student.getLastName());
            } else {
                stmt.setNull(3, Types.VARCHAR);
            }

            if (student.getDateOfBirth() != null) {
                // Convert localDate to sqlDate
                Date sqlDOB = Date.valueOf(student.getDateOfBirth());
                stmt.setDate(4, sqlDOB);
            } else {
                stmt.setNull(4, Types.DATE);
            }

            if (student.getLogin() != null) {
                stmt.setString(5, student.getLogin());
            } else {
                stmt.setNull(5, Types.VARCHAR);
            }

            if (student.getSectionID() != null) {
                stmt.setInt(6, student.getSection().getId());
            } else {
                stmt.setNull(6, Types.INTEGER);
            }

            if (student.getYearResult() != null) {
                stmt.setInt(7, student.getYearResult());
            } else {
                stmt.setNull(7, Types.INTEGER);
            }

            stmt.setString(8, student.getCourseID());

            int affected = stmt.executeUpdate();
            if (affected != 1) {
                throw new RuntimeException("Error - Data insert failed.");
            }

            return student;

        } catch (SQLException e) {
            throw new RuntimeException("SQL error - " + e.getSQLState() + " : " + e.getErrorCode() + " - " + e.getMessage());
        }
    }

    public Student delete(int id) {
        Student student = getStudentByID(id);
        if (student == null) {
            return null;
        }

        String query = "DELETE FROM student WHERE student_id = " + id;
        try (
                Connection connection = ConnectionFactory.createConnection();
                Statement stmt = connection.createStatement();
        ) {
            int deleted = stmt.executeUpdate(query);
            if (deleted != 1) {
                throw new RuntimeException("Error - Data delete failed.");
            }

            return student;
        } catch (SQLException e) {
            throw new RuntimeException("SQL error - " + e.getSQLState() + " : " + e.getErrorCode() + " - " + e.getMessage());
        }
    }

    // Can not update primary key if it is already linked to other tables as a foreign key.
    public boolean update(int studentID, String newLogin, Integer newSectionID, Integer newYearResult, String newCourseID) {

        String query = "UPDATE student SET login = ?, section_id = ?, year_result = ?, course_id = ? WHERE student_id = " + studentID;

        try (
                Connection connection = ConnectionFactory.createConnection();
                PreparedStatement stmt = connection.prepareStatement(query)
        ) {

            if (newLogin != null) {
                stmt.setString(1, newLogin);
            } else {
                stmt.setNull(1, Types.VARCHAR);
            }

            if (newSectionID != null) {
                stmt.setInt(2, newSectionID);
            } else {
                stmt.setNull(2, Types.INTEGER);
            }

            if (newYearResult != null) {
                stmt.setInt(3, newYearResult);
            } else {
                stmt.setNull(3, Types.INTEGER);
            }

            stmt.setString(4, newCourseID);

            int affected = stmt.executeUpdate();
            if (affected != 1) {
                return false;
            }

            return true;

        } catch (SQLException e) {
            throw new RuntimeException("SQL error - " + e.getSQLState() + " : " + e.getErrorCode() + " - " + e.getMessage());
        }
    }

    public void transferStudents(int fromSectionID, int toSectionID) {
        List<Student> studentsToTransfer = getStudentsFromSection(fromSectionID);
        for (Student student : studentsToTransfer) {
            update(student.getId(),student.getLogin(), toSectionID, student.getYearResult(), student.getCourseID());
        }
    }
}
