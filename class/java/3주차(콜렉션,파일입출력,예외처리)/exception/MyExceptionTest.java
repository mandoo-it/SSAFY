package com.exception;
// 사용자 정의 예외 클래스 Exception을 상속 받아야한다.

class YourException extends Exception {
    @Override
    public String toString() {
        return "YourException 발생";
    }
}
class MyException extends Exception {
    @Override
    public String toString() {
        return "MyException 발생";
    }
}
public class MyExceptionTest {
    public void first(int a) throws MyException, YourException {
        second(a);
    }
    public void second(int a) throws MyException, YourException {
        if (a < 0) {
            // 예외 상황 -> 예외 발생
            throw new MyException();
        } else if (a == 0) {
            throw new YourException();
        } else {
            System.out.println(++a);
        }
    }
    public static void main(String[] args)/* throws MyException */ {
        MyExceptionTest m = new MyExceptionTest();
        try {
            m.first(-7);
        } catch (MyException | YourException e) {
            // TODO: handle exception
        }
        try {
            m.second(7);
        } catch (MyException | YourException e) {
            System.out.println(e);
        }
        try {
            m.second(0);
        } catch (MyException | YourException e) {
            System.out.println(e);
        }
        try {
            m.second(-7);
        } catch (MyException | YourException e) {
            System.out.println(e);
        }
        // Unhandled exception type MyException
        // m.second(77);
    }
}