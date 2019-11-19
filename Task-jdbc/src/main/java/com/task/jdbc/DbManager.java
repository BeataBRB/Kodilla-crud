package com.task.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DbManager {

        private Connection conn;
        private static DbManager dbManagerInstance;

        private DbManager() throws SQLException {
            Properties connectionProps = new Properties();
            conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost/test?user=fred&password=secret&ssl=true",
                    connectionProps);
        }

        public static DbManager getInstance() throws SQLException {
            if (dbManagerInstance == null) {
                dbManagerInstance = new DbManager();
            }
            return dbManagerInstance;
        }

        public Connection getConnection() {
            return conn;
        }
    }

