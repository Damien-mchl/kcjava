package kcjava;

import java.net.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class Test {
     public static void main (String[] args) throws InterruptedException {
        new Thread(new TCPServer()).start();
        TimeUnit.SECONDS.sleep(5);
        new Thread(new TCPClient()).start();
    }
}