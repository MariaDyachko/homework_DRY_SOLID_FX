package org.example;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static boolean pushed = false;
    public static boolean pushed1 = false;
    public static boolean pushed2 = false;
    public static boolean pushed3 = false;
    public static boolean pushed4 = false;

    public static int price;

    public static void main(String[] args) {

        launch(args);

    }

    @Override
    public void start(Stage stage) {

        //for (int i = 0; i < 5; i++) {
        //    Button btn + i = new Button();
        //    btn.setText("Положить в корзину");
        //}

        Product milk = new Grocery("milk", 50, 3);   //Liskov substitution principle
        Product bred = new Grocery("bred", 30, 4);
        Product mustard = new Grocery("mustard", 70, 100);
        Product doughMixer = new Technique("dough mixer", 15000);
        Product coffeeMachine = new Technique("coffee machine", 33000);

        Label center = new Label("Сумма покупки " + price);
        Button btn = new Button();
        btn.setText("Положить в корзину молоко");

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (!pushed) {
                    btn.setText("Выложить из корзины молоко");
                    price = price + milk.getPrice();  //Magics
                    pushed = true;
                } else {
                    btn.setText("Положить в корзину молоко");
                    pushed = false;
                    price = price - milk.getPrice();  //Open-closed principle
                }
                refreshPrice(center);  //DRY
            }
        });

        Button btn1 = new Button();
        btn1.setText("Положить в корзину хлеб");

        btn1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (!pushed1) {
                    btn1.setText("Выложить из корзины хлеб");
                    pushed1 = true;
                    price = price + bred.getPrice();
                } else {
                    btn1.setText("Положить в корзину хлеб");
                    pushed1 = false;
                    price = price - bred.getPrice();
                }
                refreshPrice(center);
            }
        });

        Button btn2 = new Button();
        btn2.setText("Положить в корзину горчицу");

        btn2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (!pushed2) {
                    btn2.setText("Выложить из корзины горчицу");
                    pushed2 = true;
                    price = price + mustard.getPrice();
                } else {
                    btn2.setText("Положить в корзину горчицу");
                    pushed2 = false;
                    price = price - mustard.getPrice();
                }
                refreshPrice(center);
            }
        });

        Button btn3 = new Button();
        btn3.setText("Положить в корзину миксер для теста");

        btn3.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (!pushed3) {
                    btn3.setText("Выложить из корзины миксер для теста");
                    pushed3 = true;
                    price = price + doughMixer.getPrice();
                } else {
                    btn3.setText("Положить в корзину миксер для теста");
                    pushed3 = false;
                    price = price - doughMixer.getPrice();
                }
                refreshPrice(center);
            }
        });

        Button btn4 = new Button();
        btn4.setText("Положить в корзину кофемашину");

        btn4.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (!pushed4) {
                    btn4.setText("Выложить из корзины кофемашину");
                    pushed4 = true;
                    price = price + coffeeMachine.getPrice();
                } else {
                    btn4.setText("Положить в корзину кофемашину");
                    pushed4 = false;
                    price = price - coffeeMachine.getPrice();
                }
                refreshPrice(center);
            }
        });

        Button btn5 = new Button();
        btn5.setText("Отправить письмо");

        btn5.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                MailSender.send(btn5);  //Single-responsibility principle
            }
        });





        BorderPane root = new BorderPane();

        FlowPane line = new FlowPane(Orientation.VERTICAL, 10, 10, btn, btn1, btn2, btn3, btn4);
        line.setVgap(20);

        //BorderPane.setAlignment(line, Pos.CENTER);
        root.setLeft(line);

        BorderPane.setAlignment(btn5, Pos.BOTTOM_CENTER);
        root.setBottom(btn5);

        root.setCenter(center);

        Scene scene = new Scene(root, 400, 250);
        stage.setScene(scene);
        stage.setTitle("Магазин");
        stage.show();

    }

    private void refreshPrice(Label center) {
        center.setText("Сумма покупки " + price);
    }

}