package com.example.baitap5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;


@SpringBootApplication
public class Baitap5Application {

    public static void main(String[] args) {
        SpringApplication.run(Baitap5Application.class, args);
        // Bài tập 1
        // Khởi tạo lớp giúp nhập dữ liệu từ bàn phím
//        Scanner scanner = new Scanner(System.in);
//        String input = scanner.nextLine();
//
//        String reverse = new StringBuffer(input).reverse().toString();
//        System.out.println(reverse);

        // Bài tập 2
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Chuỗi đầu vào: ");
//        String input1 = scanner.nextLine();
//        System.out.print("Tìm kiếm ký tự:");
//        String input2 = scanner.nextLine();
//        int count = 0;
//        int index = 0;
//        while ((index = input1.indexOf(input2,index)) != -1) {
//            count++;
//            index += input2.length();
//        }
//        System.out.println(count);
        // Bài tập 3
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Nhập vào chuỗi kiểm tra: ");
//        String input = scanner.nextLine();
//        Boolean check = false;
//        if(input.length() % 2 ==0 ) {
//            String text1 = input.substring(0, input.length()/2);
//            String text2 = input.substring(input.length()/2);
//            String reverse = new StringBuffer(text1).reverse().toString();
//            if(reverse.equals(text2)) {
//                check = true;
//            }
//            else check = false;
//        } else {
//            String text1 = input.substring(0, (int)input.length()/2);
//            String text2 = input.substring((int)input.length()/2+1);
//            String reverse = new StringBuffer(text1).reverse().toString();
//            if(reverse.equals(text2)) {
//                check = true;
//            } else check = false;
//        }
//        System.out.println(check);
//        scanner.close();

//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Nhập vào chuỗi kiểm tra: ");
//        String input = scanner.nextLine();
//
//        // Đảo ngược chuỗi và kiểm tra đối xứng
//        String reverse = new StringBuilder(input).reverse().toString();
//        boolean check = input.equals(reverse);
//
//        // In kết quả
//        System.out.println("Chuỗi \"" + input + "\" có phải là palindrome? " + check);
//
//        scanner.close();
        // Bài tập 4
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Nhập vào chuỗi cần tách: ");
//        String input = scanner.nextLine();
//        input = input.replace(" ", "\n");
//        System.out.println(input);

//        Scanner scanner = new Scanner(System.in);
//
//        // Nhập chuỗi từ bàn phím
//        System.out.print("Nhập vào chuỗi cần tách: ");
//        String input = scanner.nextLine();
//
//        // Sử dụng split để tách từ dựa trên khoảng trắng
//        String[] words = input.trim().split("\\s+");
//
//        // In từng từ trên một dòng
//        for (String word : words) {
//            System.out.println(word);
//        }
        //Bài tập 5
//        Scanner scanner = new Scanner(System.in);
//        // Nhập chuỗi từ người dùng
//        System.out.print("Nhập vào chuỗi: ");
//        String input = scanner.nextLine();
//
//        // Loại bỏ khoảng trắng thừa và tách từ
//        String[] words = input.trim().split("\\s+");
//
//        // Số lượng từ
//        int wordCount = words.length;
//
//        // In kết quả
//        System.out.println("Số từ trong chuỗi là: " + wordCount);
//        scanner.close();
        //Bài tập 6
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Nhập và chuỗi: ");
//        String input = scanner.nextLine();
//        String [] array = input.split("\\s+");
//        for (String s : array) {
//            System.out.print(s+"\t");
//        }
//        scanner.close();
//        Scanner scanner = new Scanner(System.in);
//
//        // Nhập chuỗi từ người dùng
//        System.out.print("Nhập vào chuỗi: ");
//        String input = scanner.nextLine();
//
//        // Loại bỏ khoảng trắng thừa giữa các từ
//        String result = String.join(" ", input.trim().split("\\s+"));
//
//        // In kết quả
//        System.out.println("Chuỗi sau khi xóa khoảng trắng thừa: " + result);
        //Bài tập 7
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Nhập vào chuỗi: ");
//        String input = scanner.nextLine();
//        for(int i = 0; i < input.length(); i++) {
//            if(input.lastIndexOf(input.charAt(i)) == input.indexOf(input.charAt(i))) {
//                System.out.print(input.charAt(i));
//                return;
//            }
//        }
//        System.out.print("Không có kí tự lại không bị lặp");
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Nhập vào chuỗi: ");
//        String input = scanner.nextLine();
//        LinkedHashMap<Character,Integer> charCountMap = new LinkedHashMap<>();
//        for (Character c : input.toCharArray()) {
//            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
//        }

        // Tìm ký tự đầu tiên không lặp lại
//        for (char c : charCountMap.keySet()) {
//            if (charCountMap.get(c) == 1) {
//                System.out.println("Ký tự không lặp lại đầu tiên là: " + c);
//                return;
//            }
//        }
//
//        // Nếu không tìm thấy ký tự nào không lặp lại
//        System.out.println("Không có ký tự nào không bị lặp lại.");
        // Bài tập 8
//        Scanner scanner = new Scanner(System.in);
//        char[] input = scanner.nextLine().toCharArray();
//        for (int i = 0; i < input.length; i++) {
//            if(Character.isUpperCase(input[i])) {
//                input[i] = Character.toLowerCase(input[i]);
//            }
//            else if(Character.isLowerCase(input[i])) {
//                input[i] = Character.toLowerCase(input[i]);
//            }
//        }
//        System.out.println(new String(input));
        // Bài tập 9
//        Scanner scanner = new Scanner(System.in);
//        String input = scanner.nextLine();
//        String[] split = input.split("");
//        for (int i = 0; i < split.length; i++) {
//            if(!Character.isDigit(split[i].charAt(0))){
//                System.out.print(split[i]);
//            }
//        }
        // Bài tập 10
//        Scanner scanner = new Scanner(System.in);
//        String input = scanner.nextLine();
//        String[] split = input.split("");
//        for(int i = 0; i < split.length; i++) {
//            for(int j = i+1; j < split.length; j++) {
//                if((split[j].codePointAt(0) < split[i].codePointAt(0))) {
//                    String temp = split[i];
//                    split[i] = split[j];
//                    split[j] = temp;
//                }
//            }
//
//        }
//        System.out.print(Arrays.toString(split));
//          Scanner scanner = new Scanner(System.in);
//          System.out.print("Nhập vào chuỗi: ");
//          String input = scanner.nextLine();
//
//          // Tách chuỗi thành mảng ký tự dạng String
//          String[] split = input.split("");
//
//          // Sắp xếp giảm dần bằng Comparator và Lambda
//          Arrays.sort(split, (a, b) -> a.compareTo(b));
//
//          // In kết quả
//          System.out.println("Chuỗi sau khi sắp xếp: " + String.join("", split));
        // Bài tập 11
//            Scanner scanner = new Scanner(System.in);
//            System.out.print("Nhập chuỗi ban đầu: ");
//            String input = scanner.nextLine();
//            System.out.print("Chuỗi cần tim: ");
//            String search = scanner.nextLine();
//            String[] split = input.split(" ");
//            Boolean result = input.contains(search);
//            System.out.println("Kết quả: "+result);
        // Bài tập 12
//              Scanner scanner = new Scanner(System.in);
//              System.out.print("Nhập chuỗi ban đầu: ");
//              String input = scanner.nextLine();
//              String [] split = input.split(" ");
//              HashMap<String,Integer> wordCountMap = new HashMap<>();
//              for (String word : split) {
//                  // Nếu từ tồn tại trong hashmap, tăng số đếm, ngược lại thêm vào với giá trị 1
//                  wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
//              }
//              for (String word : wordCountMap.keySet()) {
//                  System.out.println(word + " : " + wordCountMap.get(word));
//              }
        // Bài tập 13
//                Scanner scanner = new Scanner(System.in);
//                System.out.print("Nhập chuỗi: ");
//                String input = scanner.nextLine();
//                String[] split = input.split(" ");
//                List<String> listMax = new ArrayList<>();
//                int maxLength = 0;
//                for(String s : split){
//                    if(s.length() > maxLength) {
//                        maxLength = s.length();
//                        listMax.clear();
//                        listMax.add(s);
//                    }
//                    else if (s.length() == maxLength) {
//                        listMax.add(s);
//                    }
//                }
//                for(String s : listMax){
//                    System.out.println(s);
//                }
            // Bài tập 14
//                Scanner scanner = new Scanner(System.in);
//
//                System.out.print("Nhập chuỗi cần mã hóa: ");
//                String input = scanner.nextLine();
//
//                System.out.print("Nhập khoảng cách dịch chuyển (shift): ");
//                int shift = scanner.nextInt();
//
//                // Xây dựng chuỗi kết quả
//                StringBuilder result = new StringBuilder();
//
//                // Lặp qua từng ký tự
//                for (char c : input.toCharArray()) {
//                    if (Character.isLetter(c)) {
//                        // Xác định giới hạn (a-z hoặc A-Z)
//                        char base = Character.isUpperCase(c) ? 'A' : 'a';
//
//                        // Dịch chuyển và xử lý quay vòng trong bảng chữ cái
//                        char encryptedChar = (char) ((c - base + shift) % 26 + base);
//                        result.append(encryptedChar);
//                    } else {
//                        // Nếu không phải chữ cái, giữ nguyên
//                        result.append(c);
//                    }
//                }
//
//                // In chuỗi mã hóa
//                System.out.println("Chuỗi sau mã hóa: " + result);
                // Bài tập 15
//                    Scanner scanner = new Scanner(System.in);
//                    System.out.print("Nhập vào chuỗi 1: ");
//                    String input1 = scanner.nextLine();
//                    System.out.print("Nhập vào chuỗi 2: ");
//                    String input2 = scanner.nextLine();
//                    if(input1.equalsIgnoreCase(input2)){
//                        System.out.print("True");
//                    }
//                    else{
//                        System.out.print("False");
//                    }
                // Bài tập 16
//                        Scanner scanner = new Scanner(System.in);
//
//                        // Chuyển đổi số thành chuỗi
//                        System.out.print("Nhập một số: ");
//                        int number = scanner.nextInt();
//                        String numberAsString = String.valueOf(number);
//                        System.out.println("Số " + number + " dưới dạng chuỗi: \"" + numberAsString + "\"");
//
//                        // Chuyển đổi chuỗi thành số
//                        System.out.print("Nhập một chuỗi chứa số: ");
//                        scanner.nextLine(); // Đọc bỏ dòng thừa
//                        String inputString = scanner.nextLine();
//                        try {
//                            int stringAsNumber = Integer.parseInt(inputString);
//                            System.out.println("Chuỗi \"" + inputString + "\" dưới dạng số: " + stringAsNumber);
//                        } catch (NumberFormatException e) {
//                            System.out.println("Chuỗi nhập vào không hợp lệ để chuyển thành số!");
//                        }
//
//                        scanner.close();
                    // Bài tập 17
//                          Scanner scanner = new Scanner(System.in);
//                          System.out.print("Nhập vào chuỗi: ");
//                          String input = scanner.nextLine();
//                          StringBuffer result = new StringBuffer();
//                          HashMap<Character,Boolean> seen = new HashMap<>();
//                          for (char s : input.toCharArray()) {
//                              if(!seen.containsKey(s)){
//                                  result.append(s);
//                                  seen.put(s,true);
//                              }
//                          }
//                          System.out.println(result);
                    // Bài tập 18
//                            Scanner scanner = new Scanner(System.in);
//                            System.out.print("Nhập vào chuỗi: ");
//                            String input = scanner.nextLine();
//                            String [] words = input.split("\\s+");
//                            StringBuffer camelCase = new StringBuffer();
//                            for(String word : words) {
//                                camelCase.append(word.toUpperCase().charAt(0)+word.substring(1));
//                            }
//                            System.out.println(camelCase);
                   // Bài tập 19
//                              Scanner scanner = new Scanner(System.in);
//                              System.out.print("Nhập vào chuỗi 1: ");
//                              String input1 = scanner.nextLine();
//                              System.out.print("Nhập vào chuỗi 2: ");
//                              String input2 = scanner.nextLine();
//                              HashMap<String, Integer> wordCount1 = new HashMap<>();
//                              HashMap<String,Integer> wordCount2 = new HashMap<>();
//                              for(String word : input1.split("\\s+")) {
//                                  wordCount1.put(word, wordCount1.getOrDefault(word,0)+1);
//                              }
//                              for(String word : input2.split("\\s+")) {
//                                  wordCount2.put(word, wordCount2.getOrDefault(word,0)+1);
//                              }
//                              Boolean result = true;
//                              for(int i = 0 ; i < input1.length() ; i++) {
//                                  if(wordCount1.get(input1.charAt(i)) != wordCount2.get(input2.charAt(i))) {
//                                      result = false;
//                                  }
//                                  else {
//                                      result = true;
//                                  }
//                              }
//                              System.out.println(result);
                    //Bài tập 20
                                Scanner scanner = new Scanner(System.in);
                                System.out.print("Nhập vào chuỗi: ");
                                String input = scanner.nextLine();
                                HashMap<Character, Integer> wordCount = new HashMap<>();
                                for(char c : input.toCharArray()) {
                                    wordCount.put(c, wordCount.getOrDefault(c, 0) + 1);
                                }
                                ArrayList<Character> wordResult = new ArrayList<>();
                                int countMax = 0;
                                for(Map.Entry<Character, Integer> entry : wordCount.entrySet()) {
                                    if(entry.getValue() > countMax) {
                                        countMax = entry.getValue();
                                        wordResult.add(entry.getKey());
                                    }
                                }
                                for(Character c : wordResult.toArray(new Character[0])) {
                                    System.out.print(c);
                                }
    }
}
