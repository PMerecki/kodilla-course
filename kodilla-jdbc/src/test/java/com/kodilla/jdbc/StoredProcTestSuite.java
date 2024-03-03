package com.kodilla.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoredProcTestSuite {
    @Test
    public void testUpdateVipLevels() throws SQLException {
        // Given
        DbManager dbManager = DbManager.getInstance();
        String sqlUpdate = "UPDATE READERS SET VIP_LEVEL=\"Not set\"";
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);
        String sqlCheckTable = "SELECT COUNT(*) AS HOW_MANY FROM READERS WHERE VIP_LEVEL=\"Not set\"";

        // When
        Statement statement2 = dbManager.getConnection().createStatement();
        String sqlProcedureCall = "CALL UpdateVipLevels()";
        statement2.execute(sqlProcedureCall);
        ResultSet rs = statement.executeQuery(sqlCheckTable);

        // Then
        int howMany = -1;
        if (rs.next()) {
            howMany = rs.getInt("HOW_MANY");
        }
        assertEquals(0, howMany);
        rs.close();
        statement.close();
        statement2.close();
    }

    @Test
    public void testUpdateBestsellers() throws SQLException {
        // Given
        DbManager dbManager = DbManager.getInstance();

        // Pobranie początkowej liczby książek, które nie są bestsellerami
        int initialNonBestsellersCount = getNonBestsellersCount(dbManager.getConnection().createStatement());

        // When
        // Wywołanie procedury UpdateBestsellers
        Statement statement = dbManager.getConnection().createStatement();
        String sqlProcedureCall = "CALL UpdateBestsellers()";
        statement.execute(sqlProcedureCall);
        statement.close();

        // Ponowne pobranie liczby książek, które nie są bestsellerami
        int updatedNonBestsellersCount = getNonBestsellersCount(dbManager.getConnection().createStatement());

        // Then
        // Porównanie wyników
        assertEquals(initialNonBestsellersCount, updatedNonBestsellersCount);
    }

    private int getNonBestsellersCount(Statement statement) throws SQLException {
        String sqlCheckTable = "SELECT COUNT(*) AS HOW_MANY FROM BOOKS WHERE BESTSELLER = FALSE";
        ResultSet rs = statement.executeQuery(sqlCheckTable);
        int count = 0;
        if (rs.next()) {
            count = rs.getInt("HOW_MANY");
        }
        rs.close();
        statement.close();
        return count;
    }
}