package controller;

import com.google.gson.Gson;
import model.User;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class DataBase {

    public static int numberOfUsers()throws IOException{
        File file = new File("numberOfUsers.txt");
        int n = 0;
        if(file.length() != 0) {
            FileInputStream inputStream = new FileInputStream(file);
            String num = new String(inputStream.readAllBytes());
            inputStream.close();
            n = Integer.parseInt(num);
        }

        return n;
    }

    public static void setNumOfUsers(){
        try {
            File file = new File("numberOfUsers.txt");
            int n=numberOfUsers()+1;
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.write(Integer.toString(n));
            printWriter.flush();
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static User getUserFromDataBase(int n){
        String fileName = "user" + n + ".json";
        try {
            String json = new String(Files.readAllBytes(Paths.get(fileName)));
            User user = new Gson().fromJson(json,User.class);
            return user;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

//user create --username fsl --nickname fdd --password 99
