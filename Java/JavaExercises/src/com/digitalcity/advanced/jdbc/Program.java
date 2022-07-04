// Créez une classe Section représentant des sections comme structurées dans la DB.
//
// Créez une classe SectionDAO.
// Créez dans cette classe une methode permettant de recupérer sous la forme
// d'une List<Section> toutes les sections de la base de données.
//
// BONUS:
// - créez une méthode permettant de recupérer une Section par rapport à son id (section_id)

package com.digitalcity.advanced.jdbc;

public class Program {
    public static void main(String[] args) {
        SectionDAO sectionDAO = new SectionDAO();

        System.out.println("Every sections :");
        sectionDAO.getAllSections().forEach(System.out::println);
        System.out.println();
        System.out.printf("Section 1110 : ");
        System.out.println(sectionDAO.getSectionByID(1110));
    }
}
