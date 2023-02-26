package com.liu.utils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {
    private JTextField textField;
    private JTextArea textArea;

    public MyFrame() {
        // 设置窗口标题
        setTitle("csdn爬虫");

        // 创建并添加一个JLabel
        JLabel label = new JLabel("输入csdn博客地址:");
        label.setPreferredSize(new Dimension(100,40));
        add(label);

        // 创建并添加一个JTextField
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(600, 40)); // 设置输入框大小
        add(textField);

        // 创建并添加一个JButton
        JButton button = new JButton("OK");
        add(button);

        // 为按钮添加动作监听器
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = textField.getText();
                // 处理输入字符串
                String output = processInput(input);

                // 清空输入框
                textArea.setText("");
                // 在文本区域中显示输出
                textArea.append(output + "\n");

                // 清空输入框
                textField.setText("");
            }
        });

        // 创建一个文本区域，并将其添加到窗口底部
        textArea = new JTextArea(40, 90);

        textArea.setMargin(new Insets(10, 10, 10, 10));
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.SOUTH);

        // 设置布局管理器
        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.add(label);
        inputPanel.add(textField);
        inputPanel.add(button);
        add(inputPanel, BorderLayout.NORTH);

        // 设置窗口的大小为600x400像素

        // 显示窗口
        pack();
        setVisible(true);
    }

    // 处理输入字符串的方法
    private String processInput(String input) {
        ClimbUtil climbUtil = new ClimbUtil();
        String str ="";
        try {
            // 执行所需的处理，并返回字符串文本
            str = climbUtil.climbDetailByUrl(input);
        }catch (Exception e){
            str ="请检查url地址是否正确！";
        }

        return str;
    }
}
