package com.digitalcity.advanced.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SectionDAO {


    List<Section> sections;


    public SectionDAO() {
        sections = new ArrayList<>();
    }


    public List<Section> getAllSections() {
        String query = "SELECT * FROM section";
        if (sections == null || sections.isEmpty()) {
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
        return sections;
    }

    public Section getSectionByID(int id) {
        String query = "SELECT section_name, delegate_id FROM section WHERE section_id=" + id;
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
}
