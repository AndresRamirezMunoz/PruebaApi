package co.com.choucair.certification.api.utils;

import co.com.choucair.certification.api.models.ReqresUserResponse;

import java.io.*;

public class DataSave {

    private static final String PATH = "src/main/resources/user.obj";

    public static void save(ReqresUserResponse user) {

        try (FileOutputStream fileOutputStream = new FileOutputStream(PATH);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ReqresUserResponse read() {

        try (FileInputStream fileInputStream = new FileInputStream(PATH);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            return (ReqresUserResponse) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
