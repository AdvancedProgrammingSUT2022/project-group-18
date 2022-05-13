package model;

import java.util.Random;
import java.util.Scanner;

public class hex {
    private static int indexFeature;
    private static int indexLand;
   public static  String[] Unit=new String[18];
   public static String[] City=new String[18];
   public static  int [] randFeature=new int[18];
    public static int [] randLend=new int[18];
    public static int [] featuresType=new int[18];

   public static void cc(String[] Unit,String[] City){
    for(int k=0;k<18;k++){
       City[k]="  ";
       Unit[k]=" ";

    }
   }
   public static void getInfo(String[] Unit, String[] City, int index) {
       Scanner scanner=new Scanner(System.in);
      Unit[index]=scanner.nextLine();
      City[index]=scanner.nextLine();
   }

    public static void printMap(String[] Unit, String[] City, int index, int [] randFeature, int[]randLand, int[] featuresType) {

       String[] u={"Archer","Chariotarcher","Scout","Settler","Spearman","Warrior","Worker","Catapult","Horseman","Swordsman","Crossbowman","Knight","Longswordsman","Pikeman","Trebuchet","Canon","Cavalry","Lancer","Musketman","Rifleman","Panzer","Tank","Infantry","Artillery","Anti-Tank Gun"};
        String[] units = {" A", "CA", "SC", " s", "SP", " W", " w", "CT", " H", "SW", "CR", " K", "LO", "PI", "TR", "CN", "CV", "LA", " M", " R", "PA", "TA", " I", "AR", "AN","  "};
        String[] features = {"FP", " I", " M", " O", " F", " J", " R","  "};
        String[] landscape = {"D", "G", "H", "O", "P", "S", "T", "M", " "};

        String[] colors = {"\u001B[103m", "\u001B[102m", "\u001B[43m", "\u001B[44m", "\u001B[42m", "\u001B[107m", "\u001B[106m", "\u001B[47m", "\u001B[100m", "\u001B[40m","\u001B[46m"};
        String[] colorsCivi = {"\u001B[31m", "\u001B[30m", "\u001B[35m","\u001B[103m", "\u001B[102m", "\u001B[43m","\u001B[103m", "\u001B[102m", "\u001B[43m", "\u001B[44m", "\u001B[42m", "\u001B[107m", "\u001B[106m", "\u001B[47m", "\u001B[100m", "\u001B[107m", "\u001B[106m", "\u001B[47m", "\u001B[100m", "\u001B[40m"};
        int[] randUnit = new int[18];
        int[] randCivi = new int[18];
        int[] randCiviunit = new int[18];
        String[] marz = new String[18];
        for (int i = 0; i <18 ; i++) {
            marz[i] = "\u001B[40m";
        }

            for (int i = index; i < 18; i++) {

                randLand[i] = 10;
                randFeature[i] = 7;
                randUnit[i] = 25;
                randCivi[i] = 17;

            }


        Random rand = new Random();

            for (int k=0;k<25;k++)
                  { if(Unit[index].equals(u[k]))
                  {
                      randUnit[index] = k;
                      randCivi[index] =index;
                      randCiviunit[index] = index;
                      randFeature[index] = rand.nextInt(7);
                      randLand[index] = rand.nextInt(8);

            }



            if (randFeature[index] == 6) {
                marz[index] = colors[6];
            }
        }
        String ar = "\u001B[0m";//Ansi_reset;
        int l = 0;
        featuresType[index]=randFeature[index];


        System.out.print("  " + marz[l] + "/" + colors[randLand[l]] + "    " + colorsCivi[randCivi[l]] + City[randCivi[l]].substring(0,1) + ar + colors[randLand[l]] + "    " + marz[l] + "\\" + ar);
        System.out.print("             " + marz[l + 2] + "/" + colors[randLand[l + 2]] + "    " + colorsCivi[randCivi[l + 2]] + City[randCivi[l + 2]].substring(0,1) + ar + colors[randLand[l + 2]] + "    " + marz[l + 2] + "\\" + ar);
        System.out.println("             " + marz[l + 4] + "/" + colors[randLand[l + 4]] + "    " + colorsCivi[randCivi[l + 4]] + City[randCivi[l + 4]].substring(0,1) + ar + colors[randLand[l + 4]] + "    " + marz[l + 4] + "\\" + ar);

        System.out.print(" " + marz[l] + "/" + colors[randLand[l]] + "   " + 0 + "," + "00" + colors[randLand[l]] + "    " + marz[l] + "\\" + ar);
        System.out.print("           " + marz[l + 2] + "/" + colors[randLand[l + 2]] + "   " + 0 + "," + "02" + colors[randLand[l + 2]] + "    " + marz[l + 2] + "\\" + ar);
        System.out.println("           " + marz[l + 4] + "/" + colors[randLand[l + 4]] + "   " + 0 + "," + "04" + colors[randLand[l + 4]] + "    " + marz[l + 4] + "\\" + ar);


        System.out.print(marz[l] + "/" + colors[randLand[l]] + "     " + colorsCivi[randCiviunit[l]] + units[randUnit[l]] + colors[randLand[l]] + "      " + ar + marz[l] + "\\" + ar);
        System.out.print("         ");
        System.out.print(marz[l + 2] + "/" + colors[randLand[l + 2]] + "     " + colorsCivi[randCiviunit[l + 2]] + units[randUnit[l + 2]] + colors[randLand[l + 2]] + "      " + ar + marz[l + 2] + "\\" + ar);
        System.out.print("         ");
        System.out.print(marz[l + 4] + "/" + colors[randLand[l + 4]] + "     " + colorsCivi[randCiviunit[l + 4]] + units[randUnit[l + 4]] + colors[randLand[l + 4]] + "      " + ar + marz[l + 4] + "\\" + ar);
        System.out.println("         ");

//=====================================================================================================


        while (l < 18) {
            String x;

            System.out.print(marz[l] + "\\" + colors[randLand[l]] + "     " + features[randFeature[l]] + colors[randLand[l]] + "      " + ar + marz[l] + "/" + ar);
            System.out.print(colors[randLand[l + 1]] + "    " + colorsCivi[randCivi[l + 1]] + City[randCivi[l + 1]].substring(0,1) + ar + colors[randLand[l + 1]] + "    " + ar);
            System.out.print(marz[l + 2] + "\\" + colors[randLand[l + 2]] + "     " + features[randFeature[l + 2]] + colors[randLand[l + 2]] + "      " + ar + marz[l + 2] + "/" + ar);
            System.out.print(colors[randLand[l + 3]] + "    " + colorsCivi[randCivi[l + 3]] + City[randCivi[l + 3]].substring(0,1) + ar + colors[randLand[l + 3]] + "    " + ar);
            System.out.print(marz[l + 4] + "\\" + colors[randLand[l + 4]] + "     " + features[randFeature[l + 4]] + colors[randLand[l + 4]] + "      " + ar + marz[l + 4] + "/" + ar);
            System.out.println(colors[randLand[l + 5]] + "    " + colorsCivi[randCivi[l + 5]] + City[randCivi[l + 5]].substring(0,1) + ar + colors[randLand[l + 5]] + "    " + marz[l + 5] + "\\" + ar);


            System.out.print(" " + marz[l] + "\\" + colors[randLand[l]] + "      " + colors[randLand[l]] + "     " + marz[l] + "/" + ar);
            if (l + 1 >= 10)
                x = "";
            else
                x = "0";
            System.out.print(colors[randLand[l + 1]] + "   " + l / 6 + "," + x + (l + 1) + colors[randLand[l + 1]] + "    " + ar);
            System.out.print("" + marz[l + 2] + "\\" + colors[randLand[l + 2]] + "      " + colors[randLand[l + 2]] + "     " + marz[l + 2] + "/" + ar);
            if (l + 3 >= 10)
                x = "";
            else
                x = "0";
            System.out.print(colors[randLand[l + 3]] + "   " + l / 6 + "," + x + (l + 3) + colors[randLand[l + 3]] + "    " + ar);
            System.out.print("" + marz[l + 4] + "\\" + colors[randLand[l + 4]] + "      " + colors[randLand[l + 4]] + "     " + marz[l + 4] + "/" + ar);
            if (l + 5 >= 10)
                x = "";
            else
                x = "0";
            System.out.println(colors[randLand[l + 5]] + "   " + l / 6 + "," + x + (l + 5) + colors[randLand[l + 5]] + "    " + marz[l + 5] + "\\" + ar);


            System.out.print("  " + marz[l] + "\\" + colors[randLand[l]] + "     " + ar + colors[randLand[l]] + "    " + marz[l] + "/" + ar);
            System.out.print(colors[randLand[l + 1]] + "     " + colorsCivi[randCiviunit[l + 1]] + units[randUnit[l+1]] + colors[randLand[l + 1]] + "      " + ar);
            System.out.print(marz[l + 2] + "\\" + colors[randLand[l + 2]] + "     " + ar + colors[randLand[l + 2]] + "    " + marz[l + 2] + "/" + ar);
            System.out.print(colors[randLand[l + 3]] + "     " + colorsCivi[randCiviunit[l + 3]] + units[randUnit[l + 3]] + colors[randLand[l + 3]] + "      " + ar);
            System.out.print(marz[l + 4] + "\\" + colors[randLand[l + 4]] + "     " + ar + colors[randLand[l + 4]] + "    " + marz[l + 4] + "/" + ar);
            System.out.println(colors[randLand[l + 5]] + "     " + colorsCivi[randCiviunit[l + 5]] + units[randUnit[l + 5]] + colors[randLand[l + 5]] + "      " + ar + marz[l + 5] + "\\" + ar);
            l += 6;


//-------------------------------------------------------------------------------
            if (l < 18) {
                System.out.print("  " + marz[l] + "/" + colors[randLand[l]] + "    " + colorsCivi[randCivi[l]] + City[randCivi[l]].substring(0,1) + ar + colors[randLand[l]] + "    " + marz[l] + "\\" + ar);
                System.out.print(colors[randLand[l - 5]] + "     " + features[randFeature[l - 5]] + colors[randLand[l - 5]] + "      " + ar);
                System.out.print(marz[l + 2] + "/" + colors[randLand[l + 2]] + "    " + colorsCivi[randCivi[l + 2]] + City[randCivi[l + 2]].substring(0,1) + ar + colors[randLand[l + 2]] + "    " + marz[l + 2] + "\\" + ar);
                System.out.print(colors[randLand[l - 3]] + "     " + features[randFeature[l - 3]] + colors[randLand[l - 3]] + "      " + ar);
                System.out.print(marz[l + 4] + "/" + colors[randLand[l + 4]] + "    " + colorsCivi[randCivi[l + 4]] + City[randCivi[l + 4]].substring(0,1) + ar + colors[randLand[l + 4]] + "    " + marz[l + 4] + "\\" + ar);
                System.out.println(colors[randLand[l - 1]] + "     " + features[randFeature[l - 1]] + colors[randLand[l - 1]] + "      " + marz[l - 1] + "/" + ar);

                if (l >= 10)
                    x = "";
                else
                    x = "0";
                System.out.print(" " + marz[l] + "/" + colors[randLand[l]] + "   " + l / 6 + "," + x + l + colors[randLand[l]] + "    " + marz[l] + "\\" + ar);
                System.out.print(colors[randLand[l - 5]] + "           " + ar);
                if (l + 2 >= 10)
                    x = "";
                else
                    x = "0";
                System.out.print(marz[l + 2] + "/" + colors[randLand[l + 2]] + "   " + l / 6 + "," + x + (l + 2) + colors[randLand[l + 2]] + "    " + marz[l + 2] + "\\" + ar);
                System.out.print(colors[randLand[l - 3]] + "           " + ar);
                if (l + 4 >= 10)
                    x = "";
                else
                    x = "0";
                System.out.print(marz[l + 4] + "/" + colors[randLand[l + 4]] + "   " + l / 6 + "," + x + (l + 4) + colors[randLand[l + 4]] + "    " + marz[l + 4] + "\\" + ar);
                System.out.println(colors[randLand[l - 1]] + "           " + marz[l - 1] + "/" + ar);


                System.out.print(marz[l] + "/" + colors[randLand[l]] + "     " + colorsCivi[randCiviunit[l]] + units[randUnit[l]] + colors[randLand[l]] + "      " + ar + marz[l] + "\\" + ar);
                System.out.print(colors[randLand[l - 5]] + "         " + ar);
                System.out.print(marz[l + 2] + "/" + colors[randLand[l + 2]] + "     " + colorsCivi[randCiviunit[l + 2]] + units[randUnit[l + 2]] + colors[randLand[l + 2]] + "      " + ar + marz[l + 2] + "\\" + ar);
                System.out.print(colors[randLand[l - 3]] + "         " + ar);
                System.out.print(marz[l + 4] + "/" + colors[randLand[l + 4]] + "     " + colorsCivi[randCiviunit[l + 4]] + units[randUnit[l + 4]] + colors[randLand[l + 4]] + "      " + ar + marz[l + 4] + "\\" + ar);
                System.out.println(colors[randLand[l - 1]] + "         " + marz[l - 1] + "/" + ar);
            }

//                l+=6;
//                      System.out.print("  " + marz[l + 6] + "/" + colors[randLand[l + 6]] + "    " + colorsCivi[randCivi[l + 6]] + City[randCivi[l + 6]] + ar + colors[randLand[l + 6]] + "    " + marz[l + 6] + "\\" + ar);
//                      System.out.print(colors[randLand[l + 1]] + "     " + features[randFeature[l + 1]] + colors[randLand[l + 1]] + "      " + ar);
//                      System.out.print(marz[l + 8] + "/" + colors[randLand[l + 8]] + "    " + colorsCivi[randCivi[l + 8]] + City[randCivi[l + 8]] + ar + colors[randLand[l + 8]] + "    " + marz[l + 8] + "\\" + ar);
//                      System.out.print(colors[randLand[l + 3]] + "     " + features[randFeature[l + 3]] + colors[randLand[l + 3]] + "      " + ar);
//                      System.out.print(marz[l + 10] + "/" + colors[randLand[l + 10]] + "    " + colorsCivi[randCivi[l + 10]] + City[randCivi[l + 10]] + ar + colors[randLand[l + 10]] + "    " + marz[l + 10] + "\\" + ar);
//                      System.out.println(colors[randLand[l + 5]] + "     " + features[randFeature[l + 5]] + colors[randLand[l + 5]] + "      " + ar);
//
//
//                      System.out.print(" " + marz[l + 6] + "/" + colors[randLand[l + 6]] + "    " + i + "," + j + colors[randLand[l + 6]] + "    " + marz[l + 6] + "\\" + ar);
//                      System.out.print(colors[randLand[l + 1]] + "           " + ar);
//                      System.out.print(marz[l + 8] + "/" + colors[randLand[l + 8]] + "    " + i + "," + j + colors[randLand[l + 8]] + "    " + marz[l + 2] + "\\" + ar);
//                      System.out.print(colors[randLand[l + 3]] + "           " + ar);
//                      System.out.print(marz[l + 10] + "/" + colors[randLand[l + 10]] + "    " + i + "," + j + colors[randLand[l + 10]] + "    " + marz[l + 4] + "\\" + ar);
//                      System.out.println(colors[randLand[l + 5]] + "           " + ar);
//
//
//                      System.out.print(marz[l + 6] + "/" + colors[randLand[l + 6]] + "     " + colorsCivi[randCiviunit[l + 6]] + units[randUnit[l + 6]] + colors[randLand[l + 6]] + "      " + ar + marz[l + 6] + "\\" + ar);
//                      System.out.print(colors[randLand[l + 1]] + "         " + ar);
//                      System.out.print(marz[l + 8] + "/" + colors[randLand[l + 8]] + "     " + colorsCivi[randCiviunit[l + 8]] + units[randUnit[l + 8]] + colors[randLand[l + 8]] + "      " + ar + marz[l + 8] + "\\" + ar);
//                      System.out.print(colors[randLand[l + 3]] + "         " + ar);
//                      System.out.print(marz[l + 10] + "/" + colors[randLand[l + 10]] + "     " + colorsCivi[randCiviunit[l + 10]] + units[randUnit[l + 10]] + colors[randLand[l + 10]] + "      " + ar + marz[l + 10] + "\\" + ar);
//                      System.out.println(colors[randLand[l + 5]] + "         " + ar);

        }

        System.out.print("            " + marz[l - 5] + "\\" + colors[randLand[l - 5]] + "     " + features[randFeature[l - 5]] + colors[randLand[l - 5]] + "      " + marz[l - 5] + "/" + ar);

        System.out.print("         " + marz[l - 3] + "\\" + colors[randLand[l - 3]] + "     " + features[randFeature[l - 3]] + colors[randLand[l - 3]] + "      " + marz[l - 3] + "/" + ar);

        System.out.println("         " + marz[l - 1] + "\\" + colors[randLand[l - 1]] + "      " + features[randFeature[l - 1]] + colors[randLand[l - 1]] + "     " + marz[l - 1] + "/" + ar);


        System.out.print("             " + marz[l - 5] + "\\" + colors[randLand[l - 5]] + "           " + marz[l - 5] + "/" + ar);

        System.out.print("           " + marz[l - 3] + "\\" + colors[randLand[l - 3]] + "           " + marz[l - 3] + "/" + ar);

        System.out.println("           " + marz[l - 1] + "\\" + colors[randLand[l - 1]] + "           " + marz[l - 1] + "/" + ar);


        System.out.print("              " + marz[l - 5] + "\\" + colors[randLand[l - 5]] + "         " + marz[l - 5] + "/" + ar);
        System.out.print("             " + marz[l - 3] + "\\" + colors[randLand[l - 3]] + "         " + marz[l - 3] + "/" + ar);
        System.out.println("             " + marz[l - 1] + "\\" + colors[randLand[l - 1]] + "         " + marz[l - 1] + "/" + ar);
        indexFeature = randFeature[index];
        indexLand = randLand[index];
    }
/*    public static int getFeature(int index){
       return featuresType[index];
    }*/
    public static int getFeature(){
        return indexFeature;
    }
    public static int getRandLand() {return indexLand;}
}

