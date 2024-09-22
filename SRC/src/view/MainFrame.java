/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author GIA BAO
 */
public class MainFrame extends javax.swing.JFrame {

    private static final MainFrame instance = new MainFrame();
    private HeaderPanel headerPanel;
    private ControlPanel controlPanel;
    private VisualPanel visualPanel;
    private CodeVisual codeVisual;
    private InfomationPanel infomationPanel;

    public static MainFrame getInstance() {
        return instance;
    }

    public MainFrame() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        getContentPane().setBackground(Color.white);
        setupUi();
        String iconPath = "D:\\Myproject\\NLCS\\SortAlgorithmVisualizer\\SRC\\src\\images\\logo.png";
        ImageIcon icon = new ImageIcon(iconPath);
        setIconImage(icon.getImage());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();

        fileChooser.setPreferredSize(new java.awt.Dimension(500, 500));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MÔ PHỎNG CÁC THUẬT TOÁN SẮP XẾP");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setupUi() {
        setLayout(new BorderLayout());
        headerPanel = new HeaderPanel();
        controlPanel = new ControlPanel();
        visualPanel = new VisualPanel();
        codeVisual = new CodeVisual();
        infomationPanel = new InfomationPanel();

        add(headerPanel, BorderLayout.NORTH);
        add(controlPanel, BorderLayout.WEST);
        add(visualPanel, BorderLayout.CENTER);
        add(infomationPanel, BorderLayout.SOUTH);
    }

    public File getSavingFile() {
        int res = fileChooser.showSaveDialog(this);
        if (res == JFileChooser.APPROVE_OPTION) {
            File saveFile = fileChooser.getSelectedFile();
            String fileName = saveFile.getName();
            if (!fileName.contains(".txt")) {
                saveFile = new File(saveFile.getAbsolutePath() + ".txt");
            }
            if (saveFile.exists()) {
                try {
                    saveFile.createNewFile();
                } catch (IOException ex) {
                    Logger.getLogger(controller.Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return saveFile;
        } else {
            return null;
        }
    }

    public void showAlert(String msg, String title) {
        JOptionPane.showMessageDialog(this, msg, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public boolean showConfirmMessage(String msg) {
        int res = JOptionPane.showConfirmDialog(this, msg, "Thông báo",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return res == JOptionPane.YES_OPTION;
    }

    public File getFileToRead() {
        int choice = fileChooser.showOpenDialog(this);
        return choice == JFileChooser.APPROVE_OPTION ? fileChooser.getSelectedFile() : null;
    }

    public ControlPanel getControlPanel() {
        return controlPanel;
    }

    public VisualPanel getVisualPanel() {
        return visualPanel;
    }

    public HeaderPanel getHeaderPanel() {
        return headerPanel;
    }

    public CodeVisual getCodeVisual() {
        return codeVisual;
    }

    public InfomationPanel getInfomationPanel() {
        return infomationPanel;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser fileChooser;
    // End of variables declaration//GEN-END:variables
}
