package Core;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ConvertObject {

    public static byte[] getByteArrayObject(String string){

        byte[] byteArrayObject = null;
        try {

            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(string);

            oos.close();
            bos.close();
            byteArrayObject = bos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return byteArrayObject;
        }
        return byteArrayObject;
    }


    public static String getJavaObject(byte[] convertObject){
        String objSimpleExample = null;

        ByteArrayInputStream bais;
        ObjectInputStream ins;
        try {

            bais = new ByteArrayInputStream(convertObject);
            ins = new ObjectInputStream(bais);
            objSimpleExample =(String)ins.readObject();

            ins.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return objSimpleExample;
    }
}