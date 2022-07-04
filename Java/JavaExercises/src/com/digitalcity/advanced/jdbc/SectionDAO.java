package com.digitalcity.advanced.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SectionDAO {

    public List<Section> getAllSections() {
        List<Section> sections = new ArrayList<>();
        String query = "SELECT * FROM section";
        try (
                Connection connection = ConnectionFactory.createConnection();
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(query)
        ) {

            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                Integer delegateID = rs.getInt(3);
                if (rs.wasNull()) {
                    delegateID = null;
                }
                Section newSection = new Section(id, name, delegateID);
                sections.add(newSection);
            }

            return sections;
        } catch (SQLException e) {
            throw new RuntimeException("SQL error - " + e.getSQLState() + " : " + e.getErrorCode() + " - " + e.getMessage());
        }
    }

    public Section getSectionByID(int id) {
        String query = "SELECT section_name, delegate_id FROM section WHERE section_id = " + id;
        try (
                Connection connection = ConnectionFactory.createConnection();
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(query)
        ) {
            if (rs.next()) {
                String name = rs.getString("section_name");
                Integer delegateID = rs.getInt("delegate_id");
                if (rs.wasNull()) {
                    delegateID = null;
                }

                return new Section(id, name, delegateID);
            }

            return null;

        } catch (SQLException e) {
            throw new RuntimeException("SQL error - " + e.getSQLState() + " : " + e.getErrorCode() + " - " + e.getMessage());
        }
    }

    public void insert(Section section) {
        if (section == null) {
            throw new RuntimeException("Error - trying to insert null object.");
        }

        String query = "INSERT INTO section VALUES (?, ?, ?)";

        try (
                Connection connection = ConnectionFactory.createConnection();
                PreparedStatement stmt = connection.prepareStatement(query)
        ) {
            stmt.setInt(1, section.getId());
            stmt.setString(2, section.getName());

            if (section.getDelegateID() != null) {
                stmt.setInt(3, section.getDelegateID());
            } else {
                stmt.setNull(3, Types.INTEGER);
            }

            int affected = stmt.executeUpdate();
            if (affected != 1) {
                throw new RuntimeException("Error - Data insert failed.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void delete(int id) {
        String query = "DELETE FROM section WHERE section_id = " + id;
        try (
                Connection connection = ConnectionFactory.createConnection();
                Statement stmt = connection.createStatement();
        ) {
            int deleted = stmt.executeUpdate(query);
            if (deleted != 1) {
                throw new RuntimeException("Error - Data delete failed.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Can not update primary key if it is already linked to other tables as a foreign key.
    public void update(int sectionID, String newName, Integer newDelegateID) {

        String query = "UPDATE section SET section_name = ?, delegate_id = ? WHERE section_id = " + sectionID;

        try (
                Connection connection = ConnectionFactory.createConnection();
                PreparedStatement stmt = connection.prepareStatement(query)
        ) {

            stmt.setString(1, newName);
            if (newDelegateID != null) {
                stmt.setInt(2, newDelegateID);
            } else {
                stmt.setNull(2, Types.INTEGER);
            }

            int affected = stmt.executeUpdate();
            if (affected != 1) {
                throw new RuntimeException("Error - Data update failed.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void update(int sectionID, int newDelegateID) {

        String query = "UPDATE section SET delegate_id = ? WHERE section_id = " + sectionID;

        try (
                Connection connection = ConnectionFactory.createConnection();
                PreparedStatement stmt = connection.prepareStatement(query)
        ) {
            stmt.setInt(1, newDelegateID);

            int affected = stmt.executeUpdate();
            if (affected != 1) {
                throw new RuntimeException("Error - Delegate data update failed.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
