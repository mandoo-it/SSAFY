package com.ssafy.java;
import java.util.*;

public class GameTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        System.out.print("번호를 입력하세요.");
        int num = sc.nextInt();
        System.out.println();
        
        
        if(num == 1) {
            int computer_ct = 0;
            int user_ct = 0;
            int ct = 3;
   
            while(user_ct < 3 && computer_ct < 3 && (user_ct+ computer_ct) < 5) {
                int computer = (int)(Math.random() * 3) + 1;
                System.out.print("가위바위보 중 하나 입력:");
                String userString = sc.next();
                int user = 0;
                switch(userString) {
                    case "가위" :
                        user = 1;
                        break;
                    case "바위" :
                        user = 2;
                        break;
                    case "보" :
                        user = 3;
                        break;
                }
                if (computer == user) {
                    System.out.println("비겼습니다.");    
                    computer_ct++;
                    user_ct++;
                      

                } else if ((computer == 1 && user == 2) || (computer == 2 && user == 3) || (computer == 3 && user == 1)) {
                    System.out.println("이겼습니다.");    
                    user_ct++;

                } else {

                    System.out.println("졌습니다.");        
                    computer_ct++;
                }
            }
            if(user_ct == computer_ct)
                System.out.println("### 무승부!!!!");    
            else if(user_ct > computer_ct)
                System.out.println("###사용자 승!!!");
            else if(user_ct < computer_ct)
                System.out.println("### 컴퓨터 승!!!");
            
        }
        else if(num == 2) {
            int computer_ct = 0;
            int user_ct = 0;
            
            while(user_ct < 2 && computer_ct < 2 && (user_ct+ computer_ct) < 3) {
                int computer = (int)(Math.random() * 3) + 1;
                System.out.print("가위바위보 중 하나 입력:");
                String userString = sc.next();
                int user = 0;
                switch(userString) {
                    case "가위" :
                        user = 1;
                        break;
                    case "바위" :
                        user = 2;
                        break;
                    case "보" :
                        user = 3;
                        break;
                }
            
                if (computer == user) {
                    System.out.println("비겼습니다.");    
                    computer_ct++;
                    user_ct++;

                } else if ((computer == 1 && user == 2) || (computer == 2 && user == 3) || (computer == 3 && user == 1)) {
                    System.out.println("이겼습니다.");    
                    user_ct++;

                } else {

                    System.out.println("졌습니다.");        
                    computer_ct++;

                }
            }
            if(user_ct == computer_ct)
                System.out.println("###  무승부!!!");    
            else if(user_ct > computer_ct)
                System.out.println("###  사용자 승!!!");
            else if(user_ct < computer_ct)
                System.out.println("### 컴퓨터 승!!!");
            
        }
        else if(num == 3) {
            int computer = (int)(Math.random() * 3) + 1;
            System.out.print("가위바위보 중 하나 입력:");
            String userString = sc.next();
            int user = 0;
            switch(userString) {
                case "가위" :
                    user = 1;
                    break;
                case "바위" :
                    user = 2;
                    break;
                case "보" :
                    user = 3;
                    break;
            }
            
            if (computer == user) {
                System.out.println("비겼습니다.");                
            } else if ((computer == 1 && user == 2) || (computer == 2 && user == 3) || (computer == 3 && user == 1)) {
                System.out.println("이겼습니다.");
            } else {
                System.out.println("졌습니다.");            
            }
        }
	}
}
