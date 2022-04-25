package controller;

import com.google.gson.Gson;
import model.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class DataBase {
    public static int numberOfUsers(){
        int n = 0;
        File file = new File("numberOfUsers.txt");
        try {
            Scanner scanner = new Scanner(file);
            String num = scanner.nextLine();
            n = Integer.parseInt(num);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return n;
    }

    public static void setNumOfUsers(){
        try {
            FileWriter writer = new FileWriter("numberOfUsers.txt");
            int n=numberOfUsers()+1;
            writer.write(n);
            writer.close();
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

