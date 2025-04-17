package com.IsteMySQL.Util;
import java.sql.*;

public class VeritabaniUtil {
	static Connection conn = null;
	
	public static Connection Baglan()
	{
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/bilgisayar_toplama_otomasyonu","root","mysql");
			return conn;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage().toString());
			return null;
		}
	}

}
