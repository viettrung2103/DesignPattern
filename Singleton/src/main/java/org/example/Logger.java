package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    private static Logger instance;
    private volatile BufferedWriter writer;
    private volatile long logTime;
    private volatile String fileName;
    private Charset  charset = Charset.forName("UTF-8");

    private Logger() {
        this.fileName = "logs.txt";
//        Charset charset = Charset.forName("UTF-8");
        try{
            System.out.println("Start writing log to file: " +this.fileName);
            writer = new BufferedWriter(new FileWriter(this.fileName,charset, true));
;
        } catch (IOException e){
            System.out.println("Failed to switch log file: " + e.getMessage());
        }
    }

    public static synchronized  Logger getInstance(){
        if ( instance == null){
            instance = new Logger();
        }
        return  instance;
    }

    public synchronized  void setFileName(String fileName){
        try {
            if ( writer != null){
                System.out.println("Stop writing log to file: " +this.fileName);
                writer.close();
            }
            this.fileName = fileName;
            System.out.println("Start writing log to new file: "+this.fileName);
            writer = new BufferedWriter(new FileWriter(this.fileName,this.charset,true));
        } catch (IOException e) {
            System.err.println("Cannot close current file and switch log file: " + e.getMessage());

        }
    }
    public synchronized  void setLogTime(long logTime){
        this.logTime = logTime;
    }
    public String getLogTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        long currentTime = System.currentTimeMillis();
        setLogTime(System.currentTimeMillis());
        String timeStr = sdf.format(new Date(logTime));
        return timeStr;
    }

    public synchronized  void setCharset(Charset charset){
        this.charset = charset;
    }
    public synchronized  void write (String message){
        try {
            if ( writer != null){
                String logTimeStr = this.getLogTime();
                String logMessage = "Log time: "+logTimeStr +"- message: "+message;
                System.out.println("Start writing message: "+logMessage+"to file: "+this.fileName);
                writer.write(logMessage);
                writer.newLine();
                writer.flush(); // make sure all the saved data from buffer is save to log file
            }
        } catch (IOException e){
            System.err.println("Cannot write log to file: "+this.fileName+ ". "+e.getMessage());
        }
    }

    public synchronized  void close(){
        try{
            if ( writer != null){
                System.out.println("Stop writing log to file: " +this.fileName);
                System.out.println("Closing the file after writing: "+this.fileName);
                writer.close();
            }
        }catch (IOException e){
            System.err.println("Cannot close file: "+this.fileName+ ". "+e.getMessage());
        }
    }
}
