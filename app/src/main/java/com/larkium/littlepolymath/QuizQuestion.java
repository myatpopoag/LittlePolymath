package com.larkium.littlepolymath;

import android.app.Activity;

public class QuizQuestion extends Activity {
    private int id;
    private String title;
    private String question;
    private String opta;
    private String optb;
    private String optc;
    private String optd;
    private String answer;
    private String explanation;

    public QuizQuestion(String t,String q, String oa, String ob, String oc, String od, String ans, String exp) {
        title = t;
        question = q;
        opta = oa;
        optb = ob;
        optc = oc;
        optd = od;
        answer = ans;
        explanation = exp;
    }

    public QuizQuestion() {
        id = 0;
        title = "";
        question = "";
        opta = "";
        optb = "";
        optc = "";
        optd = "";
        answer = "";
        explanation = "";
    }

    public String getCategory() {
        return title;
    }

    public String getQuestion(){
        return question;
    }

    public String getOptA() {
        return opta;
    }

    public String getOptB() {
        return optb;
    }

    public String getOptC() {
        return optc;
    }

    public String getOptD() {
        return optd;
    }

    public String getAnswer() {
        return answer;
    }

    public String getExp(){return explanation;}

    public void setId(int i) {
        id = i;
    }

    public void setCategory(String t1){ title = t1;}

    public void setQuestion(String q1) {
        question = q1;
    }

    public void setOptA(String o1) {
        opta = o1;
    }

    public void setOptB(String o2) {
        optb = o2;
    }

    public void setOptC(String o3) {
        optc = o3;
    }

    public void setOptD(String o4) {
        optd = o4;
    }

    public void setAnswer(String ans) {
        answer = ans;
    }

    public void setExp(String exp){explanation=exp;}

}
