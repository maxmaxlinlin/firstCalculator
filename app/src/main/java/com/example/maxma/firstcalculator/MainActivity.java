package com.example.maxma.firstcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.HashSet;
import java.util.Set;
import java.lang.*;
import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {

    private Button zero;
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button add;
    private Button sub;
    private Button mul;
    private Button div;
    private Button equal;
    private Button clear;
    private Button delC;
    private Button sinC;
    private Button cosC;
    private Button tanC;
    private Button logC;
    private Button lnC;
    private Button sqaureC;
    private Button exC;
    private Button powerC;

    private TextView info;
    private TextView info2;
    private TextView result;

    private final char SINE = 'S';
    private final char COSINE = 'C';
    private final char  TAN ='T';
    private final char  exCC ='!';


    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char MULTIPLICATION = '*';
    private final char DIVISION = '/';
    private final char EXCLM = '!';

    private final char EQU = 0;
    private double val1 = Double.NaN;
    private double val2= Double.NaN;
    private int val5= 0;
    public double val3=0;
    private char ACTION='n';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUIViews();

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "0");
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "9");
            }
        });




        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(val3>=1){
                    ACTION = ADDITION;
                    DecimalFormat df = new DecimalFormat("#.#######");
                    if(result.getText().toString().contains("Sin")||result.getText().toString().contains("Tan")||result.getText().toString().contains("Cos")){
                        val1=val2;
                        result.setText(df.format((val1)) + "+");
                    }
                    else{result.setText(df.format((val1)) + "+");}
                    info.setText(null);
                }

                else if ((result.getText().toString().length()==0&&info.getText().toString().length()==0)){

                }
                else  {
                    if (ACTION=='n'){compute();}
                    ACTION = ADDITION;
                    result.setText(String.valueOf(val1) + "+");
                    info.setText(null);
                }
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(val3>=1){
                    ACTION = SUBTRACTION;
                    DecimalFormat df = new DecimalFormat("#.#######");
                    result.setText(df.format(String.valueOf(val1)) + "-");
                    info.setText(null);
                }
                else if ((result.getText().toString().length()==0&&info.getText().toString().length()==0)){

                }
                else  {
                    if (ACTION=='n'){compute();}
                     ACTION = SUBTRACTION;
                     result.setText(String.valueOf(val1) + "-");
                    info.setText(null);}
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(val3>=1){
                    ACTION = MULTIPLICATION;
                    DecimalFormat df = new DecimalFormat("#.#######");
                    result.setText(df.format(String.valueOf(val1)) + "×");
                    info.setText(null);
                }
                else if ((result.getText().toString().length()==0&&info.getText().toString().length()==0)){

                }
                else {
                    if (ACTION=='n'){compute();}
                    ACTION = MULTIPLICATION;
                     result.setText(String.valueOf(val1) + "×");
                    info.setText(null);
                }
            }
        });
        exC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(info.getText().toString())==(int)Integer.parseInt(info.getText().toString())){
                    ACTION=EXCLM;
                    compute();
                    result.setText(info.getText().toString()+"!="+val5);
                }
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(val3>=1){
                    ACTION = DIVISION;
                    DecimalFormat df = new DecimalFormat("#.#######");
                    result.setText(df.format(String.valueOf(val1)) + "÷");
                    info.setText(null);
                }
                else if ((result.getText().toString().length()==0&&info.getText().toString().length()==0)){



                }
                else {
                if (ACTION=='n'){compute();}
                ACTION = DIVISION;
                result.setText(String.valueOf(val1) + "÷");
                info.setText(null);
                 }
            }
        });

        sinC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isNumeric(info.getText().toString())&&result.getText().toString().length()==0) {// case where sin(number)
                    result.setText("Sin("+info.getText().toString()+")");
                    ACTION = SINE;
                    val1=1;
                    compute();
                    DecimalFormat df = new DecimalFormat("#.#########");
                    result.setText(result.getText().toString()+"="+df.format(val2));
                    info.setText(null);
                    val1=val2;
                }
                else if(isNumeric(info.getText().toString())&&!isNumeric(Character.toString(result.getText().toString().charAt(result.getText().toString().length()-1)))){// where
                    char ACTIONSub=ACTION;
                    ACTION=SINE;
                    compute();
                    ACTION=ACTIONSub;
                    DecimalFormat df = new DecimalFormat("#.#########");
                    info.setText("Sin("+info.getText().toString()+")"+"="+df.format(val2));
                    result.setText(result.getText().toString()+df.format(val2));
                }
                else if((result.getText().toString().contains("+")|| result.getText().toString().contains("-")||
                        result.getText().toString().contains("×")|| result.getText().toString().contains("÷"))&&info.getText().toString().equals("")){
                            String name1 = result.getText().toString();
                            String name2=name1.substring(0, name1.length());
                           DecimalFormat df = new DecimalFormat("#.#########");
                            ACTION = SINE;
                            val2=val1;
                            double val4= val2;
                            info.setText(name2);
                            compute();
                            result.setText("Sin("+val4+")="+df.format(val2));
                }
                else if((result.getText().toString().contains("Sin")||result.getText().toString().contains("tan")||result.getText().toString().contains("Cos"))){
                    String name1 = result.getText().toString();
                    String name2=name1.substring(0, name1.length());
                    result.setText(name2);
                    DecimalFormat df = new DecimalFormat("#.#########");
                    ACTION = SINE;
                    double val4=val2;
                    info.setText(name2);
                    compute();
                    result.setText("Sin("+df.format(val4)+")="+df.format(val2));
                }
            }

        });

        tanC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isNumeric(info.getText().toString())&&result.getText().toString().length()==0) {
                    result.setText("tan("+info.getText().toString()+")");
                    ACTION = TAN;
                    val1=1;
                    compute();
                    DecimalFormat df = new DecimalFormat("#.#######");
                    result.setText(result.getText().toString()+"="+df.format(val2));
                    info.setText(null);
                    val1=val2;
                }
                else if(isNumeric(info.getText().toString())&&!isNumeric(Character.toString(result.getText().toString().charAt(result.getText().toString().length()-1)))){
                    char ACTIONSub=ACTION;
                    ACTION=TAN;

                    compute();
                    ACTION=ACTIONSub;
                    DecimalFormat df = new DecimalFormat("#.#######");
                    info.setText("tan("+info.getText().toString()+")"+"="+df.format(val2));
                    result.setText(result.getText().toString()+df.format(val2));
                }
                else if((result.getText().toString().contains("+")|| result.getText().toString().contains("-")||
                        result.getText().toString().contains("×")|| result.getText().toString().contains("÷"))&&info.getText().toString().equals("")){
                    String name1 = result.getText().toString();
                    String name2=name1.substring(0, name1.length()-1);
                    result.setText(name2);
                    DecimalFormat df = new DecimalFormat("#.#########");
                    ACTION = TAN;
                    val2=val1;
                    double val4= val2;
                    info.setText(name2);
                    compute();
                    result.setText("tan("+val4+")="+df.format(val2));
                    val1=val2;
                }
                else if((result.getText().toString().contains("Sin")||result.getText().toString().contains("tan")||result.getText().toString().contains("Cos"))){
                    String name1 = result.getText().toString();
                    String name2=name1.substring(0, name1.length());
                    result.setText(name2);
                    DecimalFormat df = new DecimalFormat("#.#########");
                    ACTION = TAN;
                    // val1=1;
                    double val4=val2;
                    info.setText(name2);
                    compute();
                    result.setText("tan("+df.format(val4)+")="+df.format(val2));
                }
            }
        });

        cosC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isNumeric(info.getText().toString())&&result.getText().toString().length()==0) {  //info is a number and nothing in the result
                    result.setText("Cos("+info.getText().toString()+")");
                    ACTION = COSINE;
                    val1=1;
                    compute();
                    DecimalFormat df = new DecimalFormat("#.#######");
                    result.setText(result.getText().toString()+"="+df.format(val2));
                    info.setText(null);
                    val1=val2;
                }
                else if(isNumeric(info.getText().toString())&&!isNumeric(Character.toString(result.getText().toString().charAt(result.getText().toString().length()-1)))){// info has a number and result has a incompleted  number
                    char ACTIONSub=ACTION;
                    ACTION=COSINE;
                    compute();
                    ACTION=ACTIONSub;
                    DecimalFormat df = new DecimalFormat("#.#######");
                    info.setText("Cos("+info.getText().toString()+")"+"="+df.format(val2));
                    result.setText(result.getText().toString()+df.format(val2));
                }
                else if((result.getText().toString().contains("+")|| result.getText().toString().contains("-")||// result just completed a computation and info is empty
                        result.getText().toString().contains("×")|| result.getText().toString().contains("÷"))&&info.getText().toString().equals("")){
                    String name1 = result.getText().toString();
                    String name2=name1.substring(0, name1.length()-1);
                    result.setText(name2);
                    DecimalFormat df = new DecimalFormat("#.#########");
                    ACTION = COSINE;
                    val2=val1;
                    double val4= val2;
                    info.setText(name2);
                    compute();
                    result.setText("cos("+val4+")="+df.format(val2));
                    val1=val2;
                }
                else if((result.getText().toString().contains("Sin")||result.getText().toString().contains("tan")||result.getText().toString().contains("Cos"))){
                    String name1 = result.getText().toString();
                    String name2=name1.substring(0, name1.length());
                    result.setText(name2);
                    DecimalFormat df = new DecimalFormat("#.#########");
                    ACTION = COSINE;
                    double val4=val2;
                    info.setText(name2);
                    compute();
                    result.setText("Cos("+df.format(val4)+")="+df.format(val2));
                }
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(result.getText().toString().length()>=1){
                    char name2=result.getText().toString().charAt(result.getText().toString().length()-1);// result char
                    String name3 =Character.toString(name2); // last bit of result string
                    String name5=info.getText().toString(); // info string
                  if((name3.equals("+")|| name3.equals("-")|| name3.equals("÷")|| name3.equals("×"))&&name5.equals("")){// if the equation is not completed correct the input!
                      info.setText("error");
                      CharSequence name4 = result.getText().toString();
                      result.setText(name4.subSequence(0, name4.length()-2));
                      name4 = result.getText().toString();
                      info2.setText(name4);
                      val1=Double.parseDouble(result.getText().toString());
                  }
                else{                                                                                   //equation is correct
                      compute();
                      DecimalFormat df = new DecimalFormat("#.#######");
                      if(ACTION==SINE||ACTION==COSINE||ACTION==TAN){            //if the computation involoves the sin/tan/cos
                          String stg=result.getText().toString();
                          result.setText(stg);
                          val1=val2;
                      }
                          else if (ACTION==EQU){                                // if keep pressing the equal signs
                      }
                      else{                                                     // output the correct result
                         result.setText(result.getText().toString() + df.format(val2) + "=" + df.format(val1));
                      }
                        ACTION = EQU;
                        val3++;
                         info.setText(null);
                  }}
                  else{
                         String name6= result.getText().toString();
                         if((name6.equals("")&&!info.getText().toString().equals(""))){// if result is empty and info has stuff , then output the info to result .
                             result.setText(info.getText().toString());
                             info.setText(null);
                             val1= Double.parseDouble(result.getText().toString());
                             val3++;
                 }}
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(info.getText().length() > 0){
                    CharSequence name = info.getText().toString();
                    info.setText(null);
                }
                else{
                    val1 = Double.NaN;
                    val2 = Double.NaN;
                    val3 = Double.NaN;
                    ACTION='n';
                    info.setText(null);
                    result.setText(null);
                }
            }
        });

        delC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(info.getText().toString().length()>0&&info.getText().toString()!=""){// make sure the info bar is not empty
                    CharSequence name1 = info.getText().toString();
                    info.setText(name1.subSequence(0, name1.length()-1));
                    }
            }
        });


    }
    public static boolean isNumeric(String str)
    {
        try
        {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }

    private void setupUIViews(){
        one=(Button)findViewById(R.id.btn1);
        zero=(Button)findViewById(R.id.btn0);
        two=(Button)findViewById(R.id.btn2);
        three=(Button)findViewById(R.id.btn3);
        four=(Button)findViewById(R.id.btn4);
        five=(Button)findViewById(R.id.btn5);
        six=(Button)findViewById(R.id.btn6);
        seven=(Button)findViewById(R.id.btn7);
        eight=(Button)findViewById(R.id.btn8);
        nine=(Button)findViewById(R.id.btn9);
        add=(Button)findViewById(R.id.btnadd);
        sub=(Button)findViewById(R.id.btnsub);
        mul=(Button)findViewById(R.id.btnmul);
        div=(Button)findViewById(R.id.btndivide);
        equal=(Button)findViewById(R.id.btnequal);
        info=(TextView)findViewById(R.id.tvinfo);
        info2=(TextView)findViewById(R.id.tvinfo2);
        result=(TextView)findViewById(R.id.tvResult);
        clear=(Button)findViewById(R.id.btnclear);
        delC=(Button)findViewById(R.id.delC);
        sinC=(Button)findViewById(R.id.sinC);
        cosC=(Button)findViewById(R.id.cosC);
        tanC=(Button)findViewById(R.id.tanC);
        logC=(Button)findViewById(R.id.logC);
        lnC=(Button)findViewById(R.id.lnC);
        sqaureC=(Button)findViewById(R.id.sqaureC);
        exC=(Button)findViewById(R.id.exC);
        powerC=(Button)findViewById(R.id.powerC);
    }



    public String removeNum(String formattingInput){
        if(!formattingInput.contains(".")){
            return formattingInput;
        }
        int dotposition= formattingInput.indexOf(".");
        if(formattingInput.contains("+")||formattingInput.contains("-")||formattingInput.contains("÷")||formattingInput.contains("×")){


        }
        String newValue=formattingInput.substring(0,dotposition+5);
        return newValue;
    }
    public int fratorial(int input){
        if(input > 1)
            return input * fratorial(input - 1);
        else
            return 1;
    }
    private void compute(){
            if (!Double.isNaN(val1)) {
                if(((ACTION!=TAN)||(ACTION!=COSINE)||(ACTION!=SINE))&&Double.isNaN(val2)){/// if  the action is tan/sin/cos jump to val2 input
                            val2 = Double.parseDouble(info.getText().toString());}
                    else if(Double.isNaN(val2)){                                        /// if the computation is just a regular computation
                             val2=Double.parseDouble(info.getText().toString());
                     }
                switch (ACTION) {
                    case ADDITION:
                        val1 = val1 + val2;
                        break;
                    case SINE:
                        val2 = Math.sin(Math.toRadians(val2)) ;
                        break;
                    case COSINE:
                        val2 = Math.cos(Math.toRadians(val2)) ;
                        break;
                    case TAN:
                        val2 = Math.tan(Math.toRadians(val2)) ;
                        break;
                    case SUBTRACTION:
                        val1 = val1 - val2;
                        break;
                    case MULTIPLICATION:
                        val1 = val1 * val2;
                        break;
                    case DIVISION:
                        val1 = val1 / val2;
                        break;
                    case EXCLM:
                        val5=fratorial(val5);
                    case EQU:
                        break;
                }
            }
            else if (ACTION==EXCLM){
                val5=Integer.parseInt(info.getText().toString());
                val5=fratorial(val5);
            }
            else  {
                val1 = Double.parseDouble(info.getText().toString());
            }

    }

}
