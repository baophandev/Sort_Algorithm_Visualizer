/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import config.Configuration;
import java.awt.Color;
import java.util.Comparator;

/**
 *
 * @author GIA BAO
 */
public class BubbleSort extends Sort {

    public BubbleSort(view.VisualPanel visualPanel, view.CodeVisual codeVisual, view.InfomationPanel infomationPanel, view.HeaderPanel headerPanel) {
        super(visualPanel, codeVisual, infomationPanel, headerPanel);
    }

    public BubbleSort() {
        super();
    }

    @Override
    public String getCode(int sortType) {
        StringBuilder sb = new StringBuilder();
        sb.append("void BubbleSort(int array[]) {\n");
        sb.append("        for(int i = 0; i < array.length - 1; i++){\n");
        sb.append("           for(int j = array.length - 1; j>=1; j--) {\n");
        if (sortType == Configuration.ASC) {
            sb.append("             if (array[j] < array[j-1]) {\n");
        } else {
            sb.append("             if (array[j] > array[j-1]) {\n");
        }
        sb.append("                 Swap(array[j], array[j-1]);\n");
        sb.append("             }\n");
        sb.append("         }\n");
        sb.append("     }\n");
        sb.append("}");
        return sb.toString();
    }

    @Override
    public void sort(int[] array, int sortType) {
        Comparator<Integer> cmptor;
        if (sortType == Configuration.ASC) {
            cmptor = (current, previous) -> current - previous;
        } else {
            cmptor = (current, previous) -> previous - current;
        }

        infomationPanel.setText("Bắt đầu thuật toán sắp xếp nổi bọt");

        for (int i = 0; i < array.length - 1 && !isStop; i++) {
            setSelectedLine(1);
            visualPanel.setNodeLabel(i, "i = " + i);
            for (int j = array.length - 1; j > i && !isStop; j--) { // điều chỉnh lại hướng chạy của j
                setSelectedLine(2);
                int x = j - 1;
                infomationPanel.setText("array[" + x + "]=" + array[j - 1] + " , array[" + j + "]= " + array[j]);
                int y = j - 1;
                visualPanel.setNodeColor(j, config.Configuration.YELLOW);
                visualPanel.setNodeColor(j - 1, config.Configuration.YELLOW);
                setSelectedLine(3);

                if (cmptor.compare(array[j], array[j - 1]) < 0) {  // Sử dụng j+1 để so sánh
                    visualPanel.setNodeColor(j, config.Configuration.YELLOW);
                    setSelectedLine(4);
                    infomationPanel.setText("Hoán đổi i và j");
                    swap(array, j - 1, j);  // Swap array[j] và array[j+1]
                    visualPanel.setNodeColor(j-1, Configuration.COLOR_HEADER);
                    visualPanel.setNodeColor(j, Configuration.COLOR_HEADER);
                    delay();
                    visualPanel.setNodeLabel(j, " ");
                    visualPanel.setNodeLabel(j - 1, " ");
                } else {
                    visualPanel.setNodeColor(j, config.Configuration.COLOR_HEADER);
                    visualPanel.setNodeColor(j - 1, config.Configuration.COLOR_HEADER);
                }
                visualPanel.setNodeColor(i, config.Configuration.COLOR_HEADER);
            }
            if (!isStop) {
                visualPanel.setNodeColor(i, config.Configuration.HIGHLIGHT_NODE);
            }
        }
        if (!isStop) {
            visualPanel.setNodeColor(array.length - 1, config.Configuration.HIGHLIGHT_NODE);
        }else{
            visualPanel.setAllNodeColor(array, Configuration.COLOR_HEADER);
            visualPanel.setNodeDefaultLabel(array);
        }
        
    }

    @Override
    public int sortWithoutAnimation(int[] array, int sortType){
        swapCounts = 0;
        Comparator<Integer> cmptor;
        if (sortType == Configuration.ASC) {
            cmptor = (current, previous) -> current - previous;
        } else {
            cmptor = (current, previous) -> previous - current;
        }

        for (int i = 0; i < array.length - 1 ; i++) { // 1         
            for (int j = array.length - 1; j > i; j--) { // 2
                if (cmptor.compare(array[j], array[j - 1]) < 0) { // 3
                    int tmp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = tmp;
                    swapCounts++;
                }
            }
        }
        return swapCounts;
    }
    
}
