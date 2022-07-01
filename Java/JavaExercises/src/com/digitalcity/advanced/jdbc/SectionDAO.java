package com.digitalcity.advanced.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SectionDAO {
    String url = "jdbc:mysql://localhost:3306/dbslide";
    String username = "root";
    String password = "";

    List<Section> sections;
    Section sectionByID;


    public SectionDAO() {
        sections = new ArrayList<>();
    }

    public List<Section> getAllSections() {
        if (sections == null || sections.isEmpty()) {
            extractAllSection(fetchData("SELECT * FROM section"));
        }
        return sections;
    }

    public Section getSectionByID(int id) {
        return extractSectionByID(fetchData("SELECT * FROM section WHERE section_id=" + id), id);

    }

    private void extractAllSection(ResultSet rs) {
        try {
            while (rs.next()) {
                Section newSection = new Section(rs.getInt(1), rs.getString(2), rs.getInt(3));
                sections.add(newSection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("JDBC - Connection failed");
        }
    }

    private Section extractSectionByID(ResultSet rs, int id) {
        Section newSection;
        try {

            while (rs.next()) {
                newSection = new Section(rs.getInt(1), rs.getString(2), rs.getInt(3));
            }
            return newSection;
        }
    } catch(SQLException e) {
        e.printStackTrace();
        System.out.println("JDBC - Connection failed");
        throw new RuntimeException("JDBC - Could not extract Section");
    }
}
    }

    private ResultSet fetchData(String query) {
        try (
                Connection connection = DriverManager.getConnection(url, username, password);
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(query)
        ) {
            return rs;
        } 
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("JDBC - Connection failed");
        }
    }
}

}
