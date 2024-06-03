package com.polaris.common.demo.interviewreview;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExpression {
    public static void main(String[] args) {
        System.out.println(testAge("19X2"));
        System.out.println(matchStr("333BBB"));
    }
    public static boolean testAge(String test){
        return test.matches("19\\d\\d");
    }
    public static String matchStr(String test){
        Pattern pattern=Pattern.compile("\\d{1,}");
        Matcher matcher=pattern.matcher(test);
        if(matcher.find()){
            String result=test.substring(matcher.start(),matcher.end());
            return result;
        }
        return null;
    }
}
