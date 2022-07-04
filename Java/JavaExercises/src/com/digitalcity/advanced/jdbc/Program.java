// Créez une classe Section représentant des sections comme structurées dans la DB.
//
// Créez une classe SectionDAO.
// Créez dans cette classe une methode permettant de recupérer sous la forme
// d'une List<Section> toutes les sections de la base de données.
//
// BONUS:
// - créez une méthode permettant de recupérer une Section par rapport à son id (section_id)

package com.digitalcity.advanced.jdbc;

import java.util.List;

public class Program {
    public static void main(String[] args) {
        SectionDAO sectionDAO = new SectionDAO();
        StudentDAO studentDAO = new StudentDAO();

//        System.out.println("Every sections :");
//        sectionDAO.getAllSections().forEach(System.out::println);
//        System.out.println();
//        System.out.println("Section 1110 : ");
//        System.out.println(sectionDAO.getSectionByID(1110));
//        System.out.println();
//        System.out.println("Inserting...");
//        Section newSection = new Section(1234, "Dark Magic", null);
//        sectionDAO.insert(newSection);
//        System.out.println();
//        System.out.println("Updating...");
//        Section updatedSection = new Section(666, "Dark Magic", 10);
//        sectionDAO.update(1234, updatedSection);
//        System.out.println();
//        System.out.println("Deleting...");
//        sectionDAO.delete(1234);
//        System.out.println();
//        System.out.println("Updating delegate id...");
//        sectionDAO.updateDelegate(1234, 666);

//        System.out.println();
//        System.out.println("Inserting...");
//
//        Section earthBending = new Section(4321, "Earth Bending", 4);
//        sectionDAO.insert(earthBending);
//        System.out.println(earthBending);
//
//        Section fireBending = new Section(8888, "Fire Bending", 3);
//        sectionDAO.insert(fireBending);
//        System.out.println(fireBending);
//
//        Section waterBendingSection = new Section(5522, "Water Bending", 7);
//        sectionDAO.insert(waterBendingSection);
//        System.out.println(waterBendingSection);
//
//        Section airBending = new Section(1111, "Air Bending", null);
//        sectionDAO.insert(airBending);
//        System.out.println(airBending);

        // Will not work, because the primary key is linked as foreign key in other tables.
//        System.out.println();
//        Section testUpdateOldSection = new Section(2222, "BSc Management", 12);
//        sectionDAO.update(1010, testUpdateOldSection);

        int sectionID = 1110;
        System.out.println("Every students from section " + sectionID);
        List<Student> students = studentDAO.getStudentsFromSection(sectionID);
        students.forEach(System.out::println);

    }
}
