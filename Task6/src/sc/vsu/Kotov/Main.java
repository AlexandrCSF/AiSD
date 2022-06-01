package sc.vsu.Kotov;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        HashMap<String, Integer> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число");
        int n = scanner.nextInt();


        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Введите название файла, из которого надо считать текст \n (War_and_Society.txt это текст войны и мира)");
        String file = scanner2.nextLine();

        if (!file.toLowerCase().endsWith(".txt")) {
            file += ".txt";
        }
        System.out.println(solution(map,file,n));
    }

        public static String solution(HashMap<String, Integer> map, String file, int n){
            String[] separatedLine;
            String result = "";

            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();

                while (line != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());

                    separatedLine = line.split(" |\\d|\\W+");
                    for (String word : separatedLine) {
                        if (map.containsKey(word)) {
                            map.put(word, (map.get(word)) + 1);
                        } else {
                            map.put(word, 1);
                        }
                    }
                    line = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Вот все слова, которые встречаются в файле " + n + " раз(а):");
            System.out.println("Программа не работает с русским языком т.к русские буквы приравниваются к небуквенным символам");
            for (String word : map.keySet()) {
                if (map.get(word) == n) {
                    result += word + ", ";
                }
            }
            return result;
        }
    }
