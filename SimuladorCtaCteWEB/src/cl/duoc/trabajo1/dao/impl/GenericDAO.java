package cl.duoc.trabajo1.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GenericDAO {

	protected Connection conn = null;
	protected PreparedStatement pstmt = null;
	protected ResultSet rs = null;

	protected void close(Object obj) {
		try {

			if (obj instanceof Connection) {

				((Connection) obj).close();

			} else if (obj instanceof PreparedStatement) {

				((PreparedStatement) obj).close();

			} else if (obj instanceof ResultSet) {

				((ResultSet) obj).close();

			}

		} catch (Exception ex) {

			ex.printStackTrace();

		}
	}

}