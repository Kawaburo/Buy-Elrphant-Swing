package com.company;
//подключение нужных библиотек
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Locale;

public class MyJFrame extends JFrame { // класс должен быть наследником JFrame
    HashSet<String> hashSet = new HashSet<>();
    boolean flag= true;
    //ССылки на обьекты
    JTextField textField = new JTextField(15);
    JLabel label1 = new JLabel("Купи слона");
    JLabel label2 = new JLabel();
    JButton button1 = new JButton("Ввод");
    //Поля для методов
    String buyElephant;
    //Создание экземпляра класса слушатель
    Events events = new Events();

    public MyJFrame(String nameFrame){ //Конструктор с именем формы
        super(nameFrame);//Обращение к суппер классу для работы с формой
        setLayout(new GridLayout(2,1,10,10)); //Построчное отображение элементов
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Выход из программы после закрытия окна.Без нее прога будет дальше работать
        setSize(200,100);//Размеры формы
        setResizable(false);//Запрет на изменение размера формы
        setLocationRelativeTo(null); //Стартовое положение формы.Если null то по центру
        add(label1);//Добавление обьектов в фрейм
        add(textField);
        add(button1);
        add(label2);
        button1.addActionListener(events);
    }
    public class Events implements ActionListener{ //Класс для "слушателя". Создание событий
        @Override
        public void actionPerformed(ActionEvent e) { //Необходимая перегрузка метода из супер класса
            buyElephant=textField.getText();
            hashSet.add(buyElephant);
            String massage = "";
            if (buyElephant.toLowerCase().equals("хорошо")) { //сравнение строк через equals обязательно
                label2.setText("Ну и отлично.");
                for (String str : hashSet) { // Использование итератора для вывода всех отмаз
                    massage += str;
                    massage += "\n";
                }
                    JOptionPane.showMessageDialog(null, massage);
            }
            else label2.setText("Ну купи слона");
        }
    }
}
