package api.dataBase;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import api.Person.Person;

public class SaveObject {

	public Object javaObject = null;

	public Object getJavaObject() {
		return javaObject;
	}

	public void setJavaObject(Object javaObject) {
		this.javaObject = javaObject;
	}

	public void saveObject() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url = "jdbc:mysql://localhost:3308/hm7?user=root&password=";
			Connection conn = DriverManager.getConnection(url);
			PreparedStatement ps = null;
			String sql = null;

			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(bos);

			oos.writeObject(javaObject);
			oos.flush();
			oos.close();
			bos.close();

			byte[] data = bos.toByteArray();

			sql = "insert into javaobject (id, javaObject) values(" + ((Person) javaObject).getId() + ",?)";
			ps = conn.prepareStatement(sql);
			ps.setObject(1, data);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void updateObject() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url = "jdbc:mysql://localhost:3308/hm7?user=root&password=";
			Connection conn = DriverManager.getConnection(url);
			PreparedStatement ps = null;
			String sql = null;

			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(bos);

			oos.writeObject(javaObject);
			oos.flush();
			oos.close();
			bos.close();

			byte[] data = bos.toByteArray();
			sql = "update javaobject SET javaObject = ? where id =" + ((Person) javaObject).getId() + ";";
//			sql = "insert into javaobject (id, javaObject) values(" + ((Person) javaObject).getId() + ",?)";
			ps = conn.prepareStatement(sql);
			ps.setObject(1, data);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Object getObject(int id) throws Exception {
		ArrayList<Object> rmObj = new ArrayList<>();
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		String url = "jdbc:mysql://localhost:3308/hm7?user=root&password=";
		Connection conn = DriverManager.getConnection(url);
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;

		if (id != 0)
			sql = "select * from javaobject where id=" + id + ";";
		else
			sql = "select * from javaobject;";

		ps = conn.prepareStatement(sql);

		rs = ps.executeQuery();

		while (rs.next()) {
			ByteArrayInputStream bais;

			ObjectInputStream ins;

			try {

				bais = new ByteArrayInputStream(rs.getBytes("javaObject"));

				ins = new ObjectInputStream(bais);

				Person mc = (Person) ins.readObject();

				// System.out.println("Object in value : " + mc.getFirstName());
				ins.close();
				rmObj.add(mc);

			} catch (Exception e) {

				e.printStackTrace();
			}

		}

		return rmObj;
	}
}