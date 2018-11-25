package cn.matrix.utils.Serialize;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

/**
 * @author Du:
 * @version ����ʱ�䣺2016��6��19�� ����9:52:05 ˵����
 */
public class FileIO {
	/*
	* 
	*/
//PanelView�?200
	public static void write_to_ByteArray_file(String path, byte[] a)
			throws FileNotFoundException, IOException {

		File file = new File(path);
		FileOutputStream fop=null;
		try  {
			// if file doesn't exists, then create it
			 fop= new FileOutputStream(file);
			if (!file.exists()) {
				file.createNewFile();
			}
			// get the content in bytes
			fop.write(a);
			fop.flush();
			

		}finally{
			fop.close();
		}
	}
//PanelView 226
	public static byte[] file_to_ByteArray(String filename) throws IOException {

		FileChannel fc = null;
		try {
			fc = new RandomAccessFile(filename, "r").getChannel();
			MappedByteBuffer byteBuffer = fc.map(MapMode.READ_ONLY, 0,
					fc.size()).load();
			// System.out.println(byteBuffer.isLoaded());
			byte[] result = new byte[(int) fc.size()];
			if (byteBuffer.remaining() > 0) {
				// System.out.println("remain");
				byteBuffer.get(result, 0, byteBuffer.remaining());
			}
			return result;
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				fc.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
