/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import config.Configuration;
import java.util.Comparator;

/**
 *
 * @author GIA BAO
 */
public class InsertionSort extends Sort {

    public InsertionSort(view.VisualPanel visualPanel, view.CodeVisual codeVisual, view.InfomationPanel infomationPanel) {
        super(visualPanel, codeVisual, infomationPanel);
    }

    public InsertionSort() {
        super();
    }

    @Override
    public String getCode(int sortType) {
        StringBuilder sb = new StringBuilder();
        sb.append("void InsertionSort(int array[]) {\n");
        sb.append("     for(int i = 1; i <= array.length -1; i++) {\n");
        sb.append("          int j = i;\n");

        if (sortType == Configuration.ASC) {
            sb.append("          while(j > 0 && array[j] < array[j-1]) {\n");
        } else {
            sb.append("          while(j > 0 && array[j] > array[j-1]) {\n");
        }
        sb.append("               Swap(array[j], array[j-1]);\n");
        sb.append("               j--;\n");
        sb.append("          }\n");
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

        for (int i = 0; i < array.length && !isStop; i++) {
            setSelectedLine(1);

            visualPanel.setNodeColor(i, Configuration.HIGHLIGHT_NODE);
            visualPanel.setNodeLabel1(i, "i=" + i);

            setSelectedLine(2);

            int j = i;
            while (j > 0 && cmptor.compare(array[j], array[j - 1]) < 0 && !isStop) {
                setSelectedLine(3);
                visualPanel.setNodeColor(j, Configuration.YELLOW);
                visualPanel.setNodeColor(j - 1, Configuration.YELLOW);

                setSelectedLine(4);
                swap(array, j - 1, j);

                visualPanel.setNodeColor(j - 1, Configuration.COLOR_HEADER);
                visualPanel.setNodeColor(j, Configuration.COLOR_HEADER);
                setSelectedLine(5);
                j--;
            }
            visualPanel.setNodeLabel1(i, "i=" + i);
        }
    }

}
