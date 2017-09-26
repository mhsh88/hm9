package api.dataBase;

import java.io.Serializable;

public class MyClass implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 6842736986680003476L;
	public String sName=null;

    public String getSName() {
        return sName;
    }

    public void setSName(String name) {
        sName = name;
    }

}
