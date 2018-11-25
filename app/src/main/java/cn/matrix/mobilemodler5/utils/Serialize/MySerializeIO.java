package cn.matrix.mobilemodler5.utils.Serialize;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author Du:
 * @version ����ʱ�䣺2016��6��19�� ����9:26:30 ˵����
 */
public class MySerializeIO {
	/*
	* 
	*/
	//���л�
	public static ByteArrayOutputStream Serialize(Object object) throws IOException {
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		ObjectOutputStream oo = null;
		try {
			oo = new ObjectOutputStream(bo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		oo.writeObject(object);
		return bo;
	}
	//�����л�
	
	public static Object Deserialize(byte[] bo) throws IOException, ClassNotFoundException {
		ByteArrayInputStream bi = new ByteArrayInputStream(bo);
		ObjectInputStream oi = new ObjectInputStream(bi);
		return  (oi.readObject());
	}
	
}
