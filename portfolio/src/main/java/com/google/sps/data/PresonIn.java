package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PresonIn {
    private String name;
    private int age;
    public String address;

public void setName(String a)
{
    name=a;
}

public void  setAge(int b)
{
    age=b;
}

public void  setAddress(String c)
{
    address=c;
}


}
