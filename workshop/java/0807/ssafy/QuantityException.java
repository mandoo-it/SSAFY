package com.ssafy;

public class QuantityException extends Exception{
	@Override
    public String toString() {
        return "수량이 부족합니다.";
    }
}
