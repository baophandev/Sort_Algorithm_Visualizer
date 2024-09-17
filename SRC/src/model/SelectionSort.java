/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import config.Configuration;
import java.awt.Color;
import java.util.Comparator;
import javax.swing.SwingWorker;

/**
 *
 * @author GIA BAO
 */
public class SelectionSort extends Sort {

    public SelectionSort(view.VisualPanel visualPanel, view.CodeVisual codeVisual, view.InfomationPanel infomationPanel) {
        super(visualPanel, codeVisual, infomationPanel);
    }

    public SelectionSort() {
        super();
    }

    @Override
    public String getCode(int sortOrder) {
        StringBuilder sb = new StringBuilder();

        sb.append("void SelectionSort(int array[]) {\n");
        sb.append("     for (int i = 0; i < array.length - 1; i++) {\n");
        if (sortOrder == Configuration.ASC) {
            sb.append("         int minIdx = i;\n");
            sb.append("         for(int j = i+1; j < array.length; j++) {\n");
            sb.append("             if (array[j] < array[minIdx]) {\n");
            sb.append("                 minIdx = j;\n");
            sb.append("             }\n");
            sb.append("         }\n");
            sb.append("         if (minIdx == i) continue;\n");
            sb.append("         swap(array, i, minIdx);\n");
        } else {
            sb.append("         int maxIdx = i;\n");
            sb.append("         for(int j = i+1; j < array.length; j++) {\n");
            sb.append("             if (array[j] > array[maxIdx]) {\n");
            sb.append("                 maxIdx = j;\n");
            sb.append("             }\n");
            sb.append("         }\n");
            sb.append("         if (maxIdx == i) continue;\n");
            sb.append("         swap(array, i, maxIdx);\n");
        }
        sb.append("     }\n");
        sb.append("}");

        return sb.toString();
    }

    @Override
    public void sort(int[] array, int sortType) {
        SwingWorker<Void, Void> worker;
        worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
                Comparator<Integer> cmptor;
                if (sortType == Configuration.ASC) {
                    cmptor = (current, previous) -> current - previous;
                } else {
                    cmptor = (current, previous) -> previous - current;
                }

                infomationPanel.setText("Bắt đầu thuật toán sắp xếp chọn");

                for (int i = 0; i < array.length - 1 && !isStop; i++) {
                    int minIdx = i;
                    setSelectedLine(1);
                    setSelectedLine(2);
                    visualPanel.setNodeLabel1(i, "i=" + i);
                    if (sortType == Configuration.ASC) {
                        visualPanel.setNodeLabel(i, "min");
                        infomationPanel.setText("minIndex = " + minIdx);
                    } else {
                        visualPanel.setNodeLabel(i, "max");
                        infomationPanel.setText("maxIndex = " + minIdx);
                    }
                    for (int j = i + 1; j < array.length && !isStop; j++) {
                        visualPanel.setNodeLabel(j, "j=" + j);
                        visualPanel.setNodeColor(j, config.Configuration.YELLOW);
                        setSelectedLine(3);
                        setSelectedLine(4);
                        visualPanel.setNodeLabel(j, "j=" + j);
                        if (cmptor.compare(array[j], array[minIdx]) < 0) {

                            visualPanel.setNodeColor(j, config.Configuration.HIGHLIGHT_NODE);

                            if (sortType == Configuration.ASC) {
                                visualPanel.setNodeLabel(j, "min");
                                infomationPanel.setText("minIndex = " + j);
                            } else {
                                visualPanel.setNodeLabel(j, "max");
                                infomationPanel.setText("maxIndex = " + j);
                            }
                            setSelectedLine(5);
                            visualPanel.setNodeColor(minIdx, config.Configuration.COLOR_HEADER);
                            visualPanel.setNodeLabel(minIdx, " ");
                            minIdx = j;
                        } else {
                            visualPanel.setNodeColor(j, config.Configuration.COLOR_HEADER);
                            visualPanel.setNodeLabel(j, " ");
                        }

                    }

                    setSelectedLine(8);
                    if (!isStop) {
                        if (minIdx != i) {
                            setSelectedLine(9);
                            swap(array, i, minIdx);
                            visualPanel.setNodeColor(minIdx, config.Configuration.COLOR_HEADER);
                            visualPanel.setNodeLabel(minIdx, " ");
                            infomationPanel.setText("Hoán đổi vị trí " + "[" + i + "]" + " và " + "[" + minIdx + "]");
                        }
                        visualPanel.setNodeColor(i, Configuration.HIGHLIGHT_NODE);
                    }

                    // Cập nhật lại giao diện sau mỗi bước của i
                    visualPanel.revalidate();
                    visualPanel.repaint();
                }
                if (!isStop) {
                    visualPanel.setNodeColor(array.length - 1, config.Configuration.HIGHLIGHT_NODE);
                }
                return null;
            }

            @Override
            protected void done() {
                if (!isStop) {
                    System.out.println("Sorting completed.");
                    infomationPanel.setText("Hoàn thành sắp xếp");
                } else {
                    infomationPanel.setText("Đã dừng sắp xếp");
                }
            }
        };

        worker.execute();
    }
}
