package com.jasaunders.customtags2;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The type Hello message with time of day.
 */
public class HelloMessageWithTimeOfDay extends SimpleTagSupport{

    @Override
    public void doTag() throws JspException, IOException {
        LocalDateTime localDateTime = LocalDateTime.now();
        int hour = localDateTime.getHour();
        String formattedDate = localDateTime.getDayOfWeek().toString()
                + ", "
                + localDateTime.getMonth().toString()
                + " "
                + localDateTime.getDayOfMonth()
                + ", "
                + localDateTime.getYear();


        //get a Localdatetime DayOfoWeek object and turn into a string.
        String day =  localDateTime.getDayOfWeek().toString();

        super.doTag();
        JspWriter out = getJspContext().getOut();
        //consider functionality you might repeat on your JSPs for your project.
        if(hour < 12) {
            out.println("Good Morning! <br />");
        } else if (hour < 16) {
            out.println("Good Afternoon! <br />");
        } else {
            out.println("Good Evening! <br />");
        }
        out.println("Today is " + formattedDate + "<br />");

        if (day.equals("Friday")) {
            out.println("TGIF!! Time to relax...");
        } else if (day.equals("Monday")) {

            out.println("Welcome to the work week! Let's write some Java");
        } else if (day.equals("Saturday") || day.equals("Sunday")) {
            out.println("WEEKEND! My time!");
        } else {
            out.println("Keep Working! You got this!");
        }

    }
}
