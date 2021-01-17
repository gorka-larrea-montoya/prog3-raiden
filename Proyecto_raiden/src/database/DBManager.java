package database;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import logica_interna.*;
import niveles.*;

public class DBManager {
	
	private static Connection conn = null;
	
	public DBManager() throws DBException {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DBException("No se pudo cargar el driver de la base de datos", e);
		}
	}
	
	public void open() throws DBException {
		try {
			conn = DriverManager.getConnection("jdbc:sqlite:raiden_database.db");
			System.out.println("Conectado");
		} catch (SQLException e) {
			throw new DBException("No se pudo conectar con la base de datos de raiden", e);
		}
	}
	/*
	public static Connection ConnectDB() {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:raidenDataBase.sqbpro");
			System.out.println("Connected");
			return conn;
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
		
	}
	*/
	
	
	
	
	public static void createNewTable() {
      
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS Player (\n"
                + "	id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + "	name TEXT NOT NULL DEFAULT 'Jugador 1',\n"
                + "	score INTEGER NOT NULL DEFAULT 0,\n"
                + "	kills INTEGER NOT NULL DEFAULT 0,\n"
                + "	date TEXT\n"
                + ");";
        
     
            Statement stmt = null;
				try {
					stmt = conn.createStatement();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            // create a new table
            try {
				stmt.execute(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
       
    }
	
	public void insertPlayer(PlayerObject p)  throws DBException {
		try {
			  PreparedStatement prepSt = conn.prepareStatement("INSERT INTO player VALUES (null, ?, ?, ?, ?)");
	
			  prepSt.setString(1, p.getName());
			  prepSt.setInt(2,(int) GameMain.getScore());
			  prepSt.setInt(3, (int) GameMain.getEnemiesKilledMain());
			  prepSt.setString(4, GameMain.getDateString());
	          
			  prepSt.executeUpdate();
			} catch (SQLException e) {
				throw new DBException("Error al guardar la partida", e);
			}
		}
	
	public ResultSet fillLeaderboard() throws SQLException{
		PreparedStatement pStatement = conn.prepareStatement("SELECT NAME, SCORE, KILLS, DATE FROM PLAYER ORDER BY SCORE DESC");

		try {
			ResultSet rs = pStatement.executeQuery();
			return rs;
		} catch (SQLException e) {
		}
		return null;
	}
	
	public void close() throws DBException {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("No se pudo desconectar correctamente de la base de datos", e);
		}
	}

}
