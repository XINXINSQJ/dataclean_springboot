package com.dataclean.dataclean_springboot.controller;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;

import java.io.IOException;
import java.nio.charset.Charset;

public class SSHTest {
    private static Connection conn;
    /** 远程机器IP */
    private static String ip = "10.11.24.169";
    /** 用户名 */
    private static String userName;
    /** 密码 */
    private static String password;
    private static String charset = Charset.defaultCharset().toString();

    private static final int TIME_OUT = 1000 * 5 * 60;

    private static boolean getConnection(String username, String password) throws IOException {
        ip = ip;
        userName = userName;
        password = password;

        conn = new Connection(ip);
        conn.connect();
        return conn.authenticateWithPassword(userName, password);
    }

    public static void main(String[] args) throws IOException {
        String username = "root";
        String password = "liuying1979";
        boolean connection = getConnection(username, password);
        System.out.println(connection);
    }
}
