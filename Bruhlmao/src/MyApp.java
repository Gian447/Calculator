import javafx.application.Application;
import javafx.geometry.NodeOrientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.mariuszgromada.math.mxparser.*;

public class MyApp extends Application {
    @Override
    public void init() throws Exception{
        System.out.println("before...");
    }
    StringBuilder expression = new StringBuilder();
    boolean op = false;
    boolean calculated = false;
    double answer = 0;
    @Override
    public void start(Stage stage) throws Exception{
        GridPane gp = new GridPane();
        TextArea ta = new TextArea();
        ta.setPrefHeight(100);
        ta.setPrefWidth(400);
        ta.setText("0");
        ta.setEditable(false);
        ta.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        ta.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        gp.add(ta, 0, 0);
        HBox h = new HBox();
        Button CLEAR = new Button("AC");
        CLEAR.setPrefWidth(100);
        CLEAR.setPrefHeight(80);
        CLEAR.setOnAction(e->{
            expression = new StringBuilder();
            ta.setText("0");
            System.out.println(expression);
        });
        Button DELETE = new Button("DEL");
        DELETE.setPrefWidth(100);
        DELETE.setPrefHeight(80);
        DELETE.setOnAction(e->{
            if (!isOperator(expression.charAt(expression.length()-1))){
                if (expression.length() == 1){
                    ta.setText("0");
                    expression = new StringBuilder("0");
                }else
                if (expression.length() >= 2 && isOperator(expression.charAt(expression.length()-2))){
                    ta.setText("0");
                    expression = new StringBuilder(expression.substring(0, expression.length()-1)).append('0');
                }else {
                    if (expression.charAt(expression.length()-2) == '.') {
                        ta.setText(ta.getText(0, ta.getLength()-2));
                        expression = new StringBuilder(expression.substring(0, expression.length()-2));
                    }else {
                        ta.setText(ta.getText(0, ta.getLength() - 1));
                        expression = new StringBuilder(expression.substring(0, expression.length() - 1));
                    }
                }
                calculated = false;
            }
        });
        Button MODULO = new Button("%");
        MODULO.setPrefHeight(80);
        MODULO.setPrefWidth(100);
        MODULO.setOnAction(e-> {
            if (!isOperator(expression.charAt(expression.length()-1))){
                if (calculated) calculated = false;
                expression.append("#");
                op = true;
            }
            System.out.println(expression);
        });
        Button DIV = new Button("/");
        DIV.setPrefHeight(80);
        DIV.setPrefWidth(100);
        DIV.setOnAction(e-> {
            if (!isOperator(expression.charAt(expression.length()-1))) {
                if (calculated) calculated = false;
                expression.append("/");
                op = true;
            }
            System.out.println(expression);
        });
        h.getChildren().addAll(CLEAR, DELETE, MODULO, DIV);
        gp.add(h, 0, 1);
        HBox h2 = new HBox();
        Button SEVEN = new Button("7");
        SEVEN.setPrefWidth(100);
        SEVEN.setPrefHeight(80);
        SEVEN.setOnAction(e->{
            if (calculated){
                expression = new StringBuilder("7");
                ta.setText("7");
                calculated = false;
            }else
            if (ta.getText().equals("0") || op) {
                ta.setText("7");
                expression.append('7');
                op = false;
            }else{
                ta.appendText("7");
                expression.append('7');
            }
            System.out.println(expression);
        });
        Button EIGHT = new Button("8");
        EIGHT.setPrefWidth(100);
        EIGHT.setPrefHeight(80);
        EIGHT.setOnAction(e->{
            if (calculated){
                expression = new StringBuilder("8");
                ta.setText("8");
                calculated = false;
            }else
            if (ta.getText().equals("0") || op) {
                ta.setText("8");
                expression.append('8');
                op = false;
            }else{
                ta.appendText("8");
                expression.append('8');
            }
            System.out.println(expression);
        });
        Button NINE = new Button("9");
        NINE.setPrefWidth(100);
        NINE.setPrefHeight(80);
        NINE.setOnAction(e->{
            if (calculated){
                expression = new StringBuilder("9");
                ta.setText("9");
                calculated = false;
            }else
            if (ta.getText().equals("0") || op) {
                ta.setText("9");
                expression.append('9');
                op = false;
            }else{
                ta.appendText("9");
                expression.append('9');
            }
            System.out.println(expression);
        });
        Button MULT = new Button("*");
        MULT.setPrefWidth(100);
        MULT.setPrefHeight(80);
        MULT.setOnAction(e->{
            if (!isOperator(expression.charAt(expression.length()-1))) {
                if (calculated) calculated = false;
                expression.append('*');
                op = true;
            }
            System.out.println(expression);
        });
        h2.getChildren().addAll(SEVEN, EIGHT, NINE, MULT);
        gp.add(h2, 0, 2);
        HBox h3 = new HBox();
        Button FOUR = new Button("4");
        FOUR.setPrefWidth(100);
        FOUR.setPrefHeight(80);
        FOUR.setOnAction(e->{
            if (calculated){
                expression = new StringBuilder("4");
                ta.setText("4");
                calculated = false;
            }else
            if (ta.getText().equals("0") || op) {
                ta.setText("4");
                expression.append('4');
                op = false;
            }else{
                ta.appendText("4");
                expression.append('4');
            }
            System.out.println(expression);
        });
        Button FIVE = new Button("5");
        FIVE.setPrefWidth(100);
        FIVE.setPrefHeight(80);
        FIVE.setOnAction(e->{
            if (calculated){
                expression = new StringBuilder("5");
                ta.setText("5");
                calculated = false;
            }else
            if (ta.getText().equals("0") || op) {
                ta.setText("5");
                expression.append('5');
                op = false;
            }else{
                ta.appendText("5");
                expression.append('5');
            }
            System.out.println(expression);
        });
        Button SIX = new Button("6");
        SIX.setPrefWidth(100);
        SIX.setPrefHeight(80);
        SIX.setOnAction(e->{
            if (calculated){
                expression = new StringBuilder("6");
                ta.setText("6");
                calculated = false;
            }else
            if (ta.getText().equals("0") || op) {
                ta.setText("6");
                expression.append('6');
                op = false;
            }else{
                ta.appendText("6");
                expression.append('6');
            }
            System.out.println(expression);
        });
        Button SUB = new Button("-");
        SUB.setPrefWidth(100);
        SUB.setPrefHeight(80);
        SUB.setOnAction(e->{
            if (!isOperator(expression.charAt(expression.length()-1))) {
                if (calculated) calculated = false;
                expression.append('-');
                op = true;
            }
            System.out.println(expression);
        });
        h3.getChildren().addAll(FOUR, FIVE, SIX, SUB);
        gp.add(h3, 0, 3);
        HBox h4 = new HBox();
        Button ONE = new Button("1");
        ONE.setPrefWidth(100);
        ONE.setPrefHeight(80);
        ONE.setOnAction(e->{
            if (calculated){
                expression = new StringBuilder("1");
                ta.setText("1");
                calculated = false;
            }else
            if (ta.getText().equals("0") || op) {
                ta.setText("1");
                expression.append('1');
                op = false;
            }else{
                ta.appendText("1");
                expression.append('1');
            }
            System.out.println(expression);
        });
        Button TWO = new Button("2");
        TWO.setPrefWidth(100);
        TWO.setPrefHeight(80);
        TWO.setOnAction(e->{
            if (calculated){
                expression = new StringBuilder("2");
                ta.setText("2");
                calculated = false;
            }else
            if (ta.getText().equals("0") || op) {
                ta.setText("2");
                expression.append('2');
                op = false;
            }else{
                ta.appendText("2");
                expression.append('2');
            }
            System.out.println(expression);
        });
        Button THREE = new Button("3");
        THREE.setPrefWidth(100);
        THREE.setPrefHeight(80);
        THREE.setOnAction(e->{
            if (calculated){
                expression = new StringBuilder("3");
                ta.setText("3");
                calculated = false;
            }else
            if (ta.getText().equals("0") || op) {
                ta.setText("3");
                expression.append('3');
                op = false;
            }else{
                ta.appendText("3");
                expression.append('3');
            }
            System.out.println(expression);
        });
        Button ADD = new Button("+");
        ADD.setPrefWidth(100);
        ADD.setPrefHeight(80);
        ADD.setOnAction(e->{
            if (!isOperator(expression.charAt(expression.length()-1))) {
                if (calculated) calculated = false;

                expression.append('+');
                op = true;
            }
            System.out.println(expression);
        });
        h4.getChildren().addAll(ONE, TWO, THREE, ADD);
        gp.add(h4, 0, 4);
        HBox h5 = new HBox();
        Button ZERO = new Button("0");
        ZERO.setPrefWidth(100);
        ZERO.setPrefHeight(80);
        ZERO.setOnAction(e->{
            if (calculated){
                expression = new StringBuilder("0");
                ta.setText("0");
                calculated = false;
            }else
            if (op) {
                op = false;
                ta.setText("0");
            }else{
                ta.appendText("0");
                expression.append('0');
            }
            System.out.println(expression);
        });
        Button ANS = new Button("Ans");
        ANS.setPrefWidth(100);
        ANS.setPrefHeight(80);
        ANS.setOnAction(e->{
            if (calculated){
                expression = new StringBuilder(String.valueOf(answer));
                ta.setText(String.valueOf(answer));
                calculated = false;
            }else
            if (ta.getText().equals("0") || op) {
                ta.setText(String.valueOf(answer));
                if (answer < 0){
                    expression.append('(').append(answer).append(')');
                }else expression.append(answer);
                op = false;
            }else{
                ta.appendText(String.valueOf(answer));
                expression.append(answer);
            }
            System.out.println(expression);
        });
        Button DOT = new Button(".");
        DOT.setPrefHeight(80);
        DOT.setPrefWidth(100);
        DOT.setOnAction(e->{
            if (op || calculated){
                ta.setText("0.");
                op = false;
                calculated = false;
            }else ta.appendText(".");
            expression.append('.');
            System.out.println(expression);
        });
        Button EQUAL = new Button("=");
        EQUAL.setPrefWidth(100);
        EQUAL.setPrefHeight(80);
        EQUAL.setOnAction(e->{
//            op = true;
            calculated = true;
            answer = new Expression(expression.toString()).calculate();
            ta.setText(String.valueOf(new Expression(expression.toString()).calculate()));
            expression = new StringBuilder(String.valueOf(new Expression(expression.toString()).calculate()));
            System.out.println(expression);
        });
        h5.getChildren().addAll(ZERO, ANS, DOT, EQUAL);
        gp.add(h5, 0, 5);
        Scene scene = new Scene(gp);
        scene.getStylesheets().add("Stylesheets/styles.css");
        stage.setScene(scene);
        stage.setMaxHeight(500);
        stage.setMinHeight(500);
        stage.setMaxWidth(400);
        stage.setMinWidth(400);
        stage.initStyle(StageStyle.UTILITY);
        stage.show();
    }

    @Override
    public void stop() throws Exception{
        System.out.println("... and after.");
    }
    private static boolean isOperator(char c){
        return c == '#' || c == '/' || c == '*' || c == '-' || c == '+';
    }
}
