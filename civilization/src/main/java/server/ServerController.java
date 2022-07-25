package server;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ServerController {


    public Integer numberOfUsers()throws IOException {
        File file = new File("numberOfUsers.txt");
        int n = 0;
        if (file.length() != 0) {
            FileInputStream inputStream = new FileInputStream(file);
            String num = new String(inputStream.readAllBytes());
            inputStream.close();
            n = Integer.parseInt(num);
        }

        return n;
    }

    public void setNumOfUsers(){
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

    public String getUserFromDataBase(int n) {
        String fileName = "user" + n + ".json";
        try {
           return new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }



    public String getInput(String input) throws IOException {
        if (input.startsWith("exit")) {
            return "exit";
        } else if(input.startsWith("numberOfUsers")) {
            try {
                return String.valueOf(numberOfUsers());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if(input.startsWith("setNumOfUsers")) {
            setNumOfUsers();
            return "set num of users successful";
        } else if(input.startsWith("getUserFromDataBase")) {
            String[] part = input.split(" ");
            return getUserFromDataBase(Integer.parseInt(part[1]));
        }
        return "null";

    }


}


