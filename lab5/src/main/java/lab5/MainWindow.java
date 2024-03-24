package lab5;

import data.MediaCollection;

import javax.swing.*;

public class MainWindow {
    private JList mediaList;
    private JButton btnSave;
    private JButton btnRead;
    private JButton btnSelectFile;
    private JTextField tfFilePath;
    private JPanel topPanel;
    private JButton btnAdd;
    private JButton btnDel;
    private JPanel bottomPanel;
    private JPanel mainPanel;
    private JScrollPane midelPanel;
    public MainWindow(MediaCollection mediaList) {
        JFrame frame = new JFrame("Список носіїв інформації");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        frame.add(this.mainPanel);

        frame.setVisible(true);
    }
}
