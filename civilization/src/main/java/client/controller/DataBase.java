package client.controller;

import client.view.MainMenuController;
import com.google.gson.Gson;
import client.model.graphicModel.User;

import java.io.IOException;

public class DataBase {

    public static int numberOfUsers()throws IOException{
        MainMenuController.dataOutputStream.writeUTF("numberOfUsers");
        MainMenuController.dataOutputStream.flush();
        return Integer.parseInt(MainMenuController.dataInputStream.readUTF());
    }

    public static void setNumOfUsers(){
        try {
            MainMenuController.dataOutputStream.writeUTF("setNumOfUsers");
            MainMenuController.dataOutputStream.flush();
            MainMenuController.dataInputStream.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static User getUserFromDataBase(int n){
        try {
            MainMenuController.dataOutputStream.writeUTF("getUserFromDataBase" + " " + n);
            MainMenuController.dataOutputStream.flush();
            return new Gson().fromJson(MainMenuController.dataInputStream.readUTF(), User.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
