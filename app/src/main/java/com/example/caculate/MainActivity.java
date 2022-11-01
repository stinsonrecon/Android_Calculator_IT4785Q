package com.example.caculate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText inputBar;
    TextView resultBar;
    Button buttC;
    Button chiaPhanTram;
    Button divide;
    ImageButton delete;
    Button no0;
    Button no1;
    Button no2;
    Button no3;
    Button no4;
    Button no5;
    Button no6;
    Button no7;
    Button no8;
    Button no9;
    Button multiply;
    Button minus;
    Button addOn;
    Button equal;
    Button comma;
    Button ans;

    Animation animSlideUp;

    String memory = "";
    String resultMem = "";
    String so0 = "0";
    String so1 = "1";
    String so2 = "2";
    String so3 = "3";
    String so4 = "4";
    String so5 = "5";
    String so6 = "6";
    String so7 = "7";
    String so8 = "8";
    String so9 = "9";
    String dauCong = " + ";
    String dauTru = " - ";
    String dauChia = " / ";
    String dauChiaPhanTram = " % ";
    String dauNhan = " x ";
    String dauPhay = ",";
    Animation a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputBar = findViewById(R.id.inputBar);
        resultBar = findViewById(R.id.resultBar);
        buttC = findViewById(R.id.buttC);
        chiaPhanTram = findViewById(R.id.chiaPhanTram);
        divide = findViewById(R.id.divine);
        delete = findViewById(R.id.delete);
        no0 = findViewById(R.id.no0);
        no1 = findViewById(R.id.no1);
        no2 = findViewById(R.id.no2);
        no3 = findViewById(R.id.no3);
        no4 = findViewById(R.id.no4);
        no5 = findViewById(R.id.no5);
        no6 = findViewById(R.id.no6);
        no7 = findViewById(R.id.no7);
        no8 = findViewById(R.id.no8);
        no9 = findViewById(R.id.no9);
        multiply = findViewById(R.id.multiply);
        minus = findViewById(R.id.minus);
        addOn = findViewById(R.id.addOn);
        equal = findViewById(R.id.equal);
        comma = findViewById(R.id.comma);
        ans = findViewById(R.id.Ans);

        inputBar.setShowSoftInputOnFocus(false);

         a = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_up);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            // OnClick on number
            case R.id.no0:
                memory = memory + so0;
                inputBar.setText(memory);
                Toast.makeText(MainActivity.this,"number 0",Toast.LENGTH_SHORT).show();
                break;
            case R.id.no1:
                memory = memory + so1;
                inputBar.setText(memory);
                break;
            case R.id.no2:
                memory = memory + so2;
                inputBar.setText(memory);
                break;
            case R.id.no3:
                memory = memory + so3;
                inputBar.setText(memory);
                break;
            case R.id.no4:
                memory = memory + so4;
                inputBar.setText(memory);
                break;
            case R.id.no5:
                memory = memory + so5;
                inputBar.setText(memory);
                break;
            case R.id.no6:
                memory = memory + so6;
                inputBar.setText(memory);
                break;
            case R.id.no7:
                memory = memory + so7;
                inputBar.setText(memory);
                break;
            case R.id.no8:
                memory = memory + so8;
                inputBar.setText(memory);
                break;
            case R.id.no9:
                memory = memory + so9;
                inputBar.setText(memory);
                break;

            //OnClick on delete
            case R.id.delete:
                try {
                    Editable result = inputBar.getText();
                    int startIndex = result.length() - 1;
                    int endIndex = result.length();
                    result = result.delete(startIndex, endIndex);
                    memory = result.toString();
                    inputBar.setText(result);
                    resultBar.setText("");
                } catch (Exception e) {
                    break;
                }
                break;

            //OnClick on math marks
            case R.id.addOn:
                memory = memory + dauCong;
                inputBar.setText(memory);
                break;
            case R.id.minus:
                memory = memory + dauTru;
                inputBar.setText(memory);
                break;
            case R.id.multiply:
                memory = memory + dauNhan;
                inputBar.setText(memory);
                break;
            case R.id.divine:
                memory = memory + dauChia;
                inputBar.setText(memory);
                break;
            case R.id.chiaPhanTram:
                memory = memory + dauChiaPhanTram;
                inputBar.setText(memory);
                break;
            case R.id.comma:
                memory = memory + dauPhay;
                inputBar.setText(memory);
                break;
            case R.id.buttC:
                inputBar.setText("");
                resultBar.setText("0");
                memory = "";
                break;

            case R.id.equal:
                try {
                    if (memory.contains(dauCong)) {
                        if (memory.contains(dauPhay)) {
                            double sum = 0.0;
                            String[] number = memory.split("\\+");
                            for (String s : number) {
                                double nu = Double.parseDouble(s.trim().replace(",", "."));
                                sum += nu;
                            }
                            resultMem = String.valueOf(sum);
                        } else {
                            int sum = 0;
                            String[] number = memory.split("\\+");
                            for (String s : number) {
                                int nu = Integer.parseInt(s.trim());
                                sum += nu;
                            }
                            resultMem = String.valueOf(sum);
                            Log.d("abc",resultMem);
                        }
                        resultBar.setText(resultMem.trim().replace(".", ","));

                    }
                    else if (memory.contains(dauTru)) {
                        if (memory.contains(dauPhay)) {
                            double minus = 0.0;
                            String[] number = memory.split("-");
                            for (String s : number) {
                                double nu = Double.parseDouble(s.trim().replace(",", "."));
                                if (minus == 0.0) {
                                    minus = nu;
                                } else {
                                    minus -= nu;
                                }
                            }
                            resultMem = String.valueOf(minus);
                        } else {
                            int minus = 0;
                            String[] number = memory.split("-");
                            for (String s : number) {
                                int nu = Integer.parseInt(s.trim());
                                if (minus == 0) {
                                    minus = nu;
                                } else {
                                    minus -= nu;
                                }
                            }
                            resultMem = String.valueOf(minus);
                        }
                        resultBar.setText(resultMem.trim().replace(".", ","));
                    }
                    else if(memory.contains(dauNhan)) {
                        if (memory.contains(dauPhay)) {
                            double multiply = 1.0;
                            String[] number = memory.split("x");
                            for (String s : number) {
                                double nu = Double.parseDouble(s.trim().replace(",", "."));
                                if (multiply == 1.0) {
                                    multiply = nu;
                                } else {
                                    multiply *= nu;
                                }
                            }
                            resultMem = String.valueOf(multiply);
                        } else {
                            int multiply = 1;
                            String[] number = memory.split("x");
                            for (String s : number) {
                                int nu = Integer.parseInt(s.trim());
                                if (multiply == 1) {
                                    multiply = nu;
                                } else {
                                    multiply *= nu;
                                }
                            }
                            resultMem = String.valueOf(multiply);
                        }
                        resultBar.setText(resultMem.trim().replace(".", ","));
                    }
                    else if(memory.contains(dauChia)) {
                        try {
                            if (memory.contains(dauPhay)) {
                                double divide = 0.0;
                                String[] number = memory.split("/");
                                for (String s : number) {
                                    double nu = Double.parseDouble(s.trim().replace(",", "."));
                                    if (divide == 0.0) {
                                        divide = nu;
                                    } else {
                                        divide /= nu;
                                    }
                                }
                                resultMem = String.valueOf(divide);
                            } else {
                                int divide = 0;
                                String[] number = memory.split("/");
                                for (String s : number) {
                                    int nu = Integer.parseInt(s.trim());
                                    if (divide == 0) {
                                        divide = nu;
                                    } else {
                                        divide /= nu;
                                    }
                                }
                                resultMem = String.valueOf(divide);
                            }
                            resultBar.setText(resultMem.trim().replace(".", ","));
                        } catch (ArithmeticException e) {
                            resultBar.setText("Math Error");
                        }
                    }
                    else if(memory.contains(dauChiaPhanTram)) {
                        try {
                            if (memory.contains(dauPhay)) {
                                double divideTakeBalance = 0.0;
                                String[] number = memory.split("%");
                                for (String s : number) {
                                    double nu = Double.parseDouble(s.trim().replace(",", "."));
                                    if (divideTakeBalance == 0.0) {
                                        divideTakeBalance = nu;
                                    } else {
                                        divideTakeBalance %= nu;
                                    }
                                }
                                resultMem = String.valueOf(divideTakeBalance);
                            } else {
                                int divideTakeBalance = 0;
                                String[] number = memory.split("%");
                                for (String s : number) {
                                    int nu = Integer.parseInt(s.trim());
                                    if (divideTakeBalance == 0) {
                                        divideTakeBalance = nu;
                                    } else {
                                        divideTakeBalance %= nu;
                                    }
                                }
                                resultMem = String.valueOf(divideTakeBalance);
                            }
                            resultBar.setText(resultMem.trim().replace(".", ","));
                        } catch (ArithmeticException e) {
                            resultBar.setText("Math error");
                        }
                    }
                    else {
                        if (memory.matches(",")) {
                            resultBar.setText("Syntax Error");
                            break;
                        }
                        else if(memory.matches(".*([,])\\1+.*")){
                            resultBar.setText("Syntax Error");
                            break;
                        }
                        else {
                            resultMem = memory.trim();
                            resultBar.setText(memory.trim());
                        }
                    }
                } catch (Exception e) {
                    resultBar.setText("Syntax Error");
                    break;
                }
                break;
            case R.id.Ans:
                memory += resultMem.replace(".", ",");
                inputBar.setText(memory);
                break;
            default:
                break;
        }
    }
}