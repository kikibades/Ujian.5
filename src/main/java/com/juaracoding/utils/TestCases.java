package com.juaracoding.utils;

public enum TestCases {

    T1("Sistem menangani skenario di mana user mencoba login dengan menggunakan kredensial yang valid"),
    T2("User menambahkan product ke dalam cart");

    private String testCaseName;

    TestCases(String value){
        testCaseName = value;
    }

    public String getTestCaseName(){
        return testCaseName;
    }
}