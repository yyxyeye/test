package com.imooc.controller;

import com.sun.jdi.PathSearchingVirtualMachine;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.*;

public class cmdController {

//     //一般的执行方法，有时执行exe会卡在那    stmt要执行的命令
//                public static void executive(String stmt) throws IOException, InterruptedException {
//                 Runtime runtime = Runtime.getRuntime();  //获取Runtime实例
//                 //执行命令
//                 try {
//                      String[] command = {"cmd", "/c", stmt};
//                      //runtime.load("F:/learning/soar/soar");
//
//                      Process process = runtime.exec(command,null,new File("f:/learning/soar/soar"));
//
//                       // 标准输入流（必须写在 waitFor 之前）
//                        String inStr = consumeInputStream(process.getInputStream());
//                       // 标准错误流（必须写在 waitFor 之前）
//                        String errStr = consumeInputStream(process.getErrorStream()); //若有错误信息则输出
//                         int proc = process.waitFor();
//                        if (proc == 0) {
//                System.out.println("执行成功");
//                            } else {
//                               System.out.println("执行失败" + errStr);
//                          }
//                     } catch (IOException | InterruptedException e) {
//                         e.printStackTrace();
//                     }
//            }
//
//    /**
//     27      * 消费inputstream，并返回
//     28      */
//    public static String consumeInputStream(InputStream is) throws IOException {
//                 BufferedReader br = new BufferedReader(new InputStreamReader(is,"GBK"));
//                 String s;
//                 StringBuilder sb = new StringBuilder();
//                 while ((s = br.readLine()) != null) {
//                         System.out.println(s);
//                         sb.append(s);
//                     }
//                 return sb.toString();
//             }
//
//    public static void main(String[] args) throws IOException, InterruptedException {
//        executive("soar --help");
//    }

    public void executeCMDconsole(String cmd) {
        //此方法为打印日志到控制台！！！！！！！！！！！！
        //此方法跑成功！！！

        System.out.println("在cmd里面输入"+cmd);
        //Process p;
        try {
            final Process p = Runtime.getRuntime().exec(cmd,null,new File("F:\\learning\\soar\\soar"));
            System.out.println(":::::::::::::::::::开始在控制台打印日志::::::::::::::::::::::>>>>>>");
            //p.waitFor();
            BufferedReader bReader=new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line=null;
            while((line=bReader.readLine())!=null)
                System.out.println(line);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("1111"+e);

        }
    }





    /**
     * 用于处理Runtime.getRuntime().exec产生的错误流及输出流
     * @author shaojing
     *
     */
    public class StreamGobbler extends Thread {
        InputStream is;
        String type;
        OutputStream os;

        StreamGobbler(InputStream is, String type) {
            this(is, type, null);
        }

        StreamGobbler(InputStream is, String type, OutputStream redirect) {
            this.is = is;
            this.type = type;
            this.os = redirect;
        }

        public void run() {
            InputStreamReader isr = null;
            BufferedReader br = null;
            PrintWriter pw = null;
            try {
                if (os != null)
                    pw = new PrintWriter(os);

                isr = new InputStreamReader(is);
                br = new BufferedReader(isr);
                String line=null;
                while ( (line = br.readLine()) != null) {
                    if (pw != null)
                        pw.println(line);
                    System.out.println(type + ">" + line);
                }

                if (pw != null)
                    pw.flush();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            } finally{
                pw.close();
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        //String cmd="D:/Android/android-sdk-windows/platform-tools/adb logcat -v time";
        //String cmd2="adb devices";
        //String cmd3="adb logcat -v time";
        //String cmd4="adb logcat -v time > d:/adb.log";
        cmdController adbc = new cmdController();
        adbc.executeCMDconsole("cmd /c soar -query query.sql > soar.html");
//        String commands[] = { "cmd", "soar","--help"};
//        adbc.executeCMDfile(commands, "D:/adb.logs", "F:/learning/soar/soar");
        //System.out.println(result);由于將日志輸出到文件裡面了，就不能再将日志輸出到console了
    }
}
