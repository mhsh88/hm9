package api.dataBase;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
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

	public boolean saveObject() throws Exception {
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url = "jdbc:mysql://localhost:3306/hm9?user=root&password=salamgolabi";
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
			try{
			ps.executeUpdate();
			}
			catch(SQLIntegrityConstraintViolationException e){
				System.out.println(e.getMessage());
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}

	public void updateObject() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url = "jdbc:mysql://localhost:3306/hm9?user=root&password=salamgolabi";
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
		String url = "jdbc:mysql://localhost:3306/hm9?user=root&password=salamgolabi";
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

				Person person = (Person) ins.readObject();

				// System.out.println("Object in value : " + mc.getFirstName());
				ins.close();
				rmObj.add(person);

			} catch (Exception e) {

				e.printStackTrace();
			}

		}

		return rmObj;
	}
}