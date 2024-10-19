/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import config.Configuration;
import java.awt.Color;
import java.util.function.BiPredicate;

/**
 *
 * @author GIA BAO
 */
public class HeapSort extends Sort {

    private BiPredicate<Integer, Integer> fPred, sPred1, sPred2, tPred1, tPred2;

    public HeapSort(view.VisualPanel visualPanel, view.CodeVisual codeVisual, view.InfomationPanel infomationPanel) {
        super(visualPanel, codeVisual, infomationPanel);
    }

    public HeapSort() {
        super();
    }

    @Override
    public String getCode(int sortOrder) {

        StringBuilder sb = new StringBuilder();

        sb.append("void PushDown(int[] array,int first, int last) {\n"); // 0
        sb.append("     int r = first;\n");
        sb.append("     while(r <= (last - 1)/2) {\n");

        if (sortOrder == Configuration.ASC) {
            sb.append("         if (last == 2 * r + 1){\n");
            sb.append("             if (array[r] <= array[last]) {\n");
            sb.append("                 Swap(array[r], array[last]);\n");
            sb.append("             }\n");
            sb.append("                 r = 2 * r + 1;\n");
            sb.append("         }\n");
            sb.append("         else if ((array[r] <= array[2*r+1]) && (array[2*r+1] > array[2*r++2])) {\n");
            sb.append("                 Swap(array[r], array[2*r+1]);\n");
            sb.append("                 r = 2 * r + 1;\n");
            sb.append("         }\n");
            sb.append("         else if ((array[r] <= array[2*r+2]) && (array[2*r+2] >= array[2*r++1])) {\n");
            sb.append("                 Swap(array[r], array[2*r+2]);\n");
            sb.append("                 r = 2 * r + 2;\n");
            sb.append("         }\n");
            sb.append("         else\n");
            sb.append("             r = last;\n"); // 18
        } else {
            sb.append("            if(array[r] > array[last]){\n");
            sb.append("                swap(array[r], array[last]);\n");
            sb.append("            }\n");
            sb.append("            r = 2 * r + 1;\n");
            sb.append("         }\n");
            sb.append("        else if((array[r] > array[2 * r + 1]) && (array[2 * r + 1] <= array[2 * r + 2])){\n");
            sb.append("            swap(array[r], array[2 * r + 1]);\n");
            sb.append("            r = 2 * r + 1;\n");
            sb.append("        }\n");
            sb.append("        else if((array[r] > array[2 * r + 2]) && (array[2 * r + 2] < array[2 * r + 1])){\n");
            sb.append("            swap(array[r], array[2 * r + 1]);\n");
            sb.append("            r = 2 * r + 2;\n");
            sb.append("        }\n");
        }

        sb.append("         }\n");
        sb.append("}\n"); // 20
        sb.append("\n");
        sb.append("void HeapSort(int[] array) {\n"); // 22
        sb.append("     int n = array.length;\n");
        sb.append("     for (int i = (n-2)/2; i >= 0; i--)\n");
        sb.append("         PushDown(array, i, n-1);\n"); // 25
        sb.append("     for(int i = n-1; i >= 2; i--) {\n");
        sb.append("         Swap(array[0], array[i]);\n");
        sb.append("         PushDown(array, 0, i-1);\n");
        sb.append("     }\n");
        sb.append("     Swap(array[0], array[1]);\n"); // 30
        sb.append("}\n");

        return sb.toString();
    }

    private void pushDown(int[] array, int first, int last) {
        int r = first;
        setSelectedLine(0);
        setSelectedLine(1);
        setSelectedLine(2);
        while (r <= (last - 1) / 2 && !isStop) {
            if (last == 2 * r + 1 && !isStop) {
                setSelectedLine(3);
                if (fPred.test(array[r], array[last]) && !isStop) {
                    setSelectedLine(4);
                    setSelectedLine(5);
                    visualPanel.setNodeLabel(r, "Nút");
                    visualPanel.setNodeColor(r, Configuration.HIGHLIGHT_NODE);
                    delay();
                    visualPanel.setNodeLabel(last, "Con trái");
                    visualPanel.setNodeColor(last, Color.ORANGE);
                    delay();
                    infomationPanel.setText("Nút lớn hơn con trái");
                    delay();
                    infomationPanel.setText("Hoán đổi nút với con trái");
                    delay();
                    swap(array, r, last);
                }
                r = last;
                setSelectedLine(7);
            } else if (sPred1.test(array[r], array[2 * r + 1])
                    && sPred2.test(array[2 * r + 1], array[2 * r + 2]) && !isStop) {
                setSelectedLine(9);
                setSelectedLine(10);
                visualPanel.setNodeLabel(r, "Nút");
                visualPanel.setNodeColor(r, Configuration.HIGHLIGHT_NODE);
                delay();
                visualPanel.setNodeLabel(2 * r + 1, "Con trái");
                visualPanel.setNodeColor(2 * r + 1, Color.ORANGE);
//                delay();
                visualPanel.setNodeLabel(2 * r + 2, "Con phải");
                visualPanel.setNodeColor(2 * r + 2, Color.ORANGE);
                delay();
                infomationPanel.setText("Nút lớn hơn con trái");
                delay();
                infomationPanel.setText("Con trái lớn hơn con phải");
                delay();
                infomationPanel.setText("Hoán đổi nút với con trái");
                delay();
                swap(array, r, 2 * r + 1);
                r = 2 * r + 1;
                setSelectedLine(11);

            } else if (tPred1.test(array[r], array[2 * r + 2])
                    && tPred2.test(array[2 * r + 2], array[2 * r + 1]) && !isStop) {
                setSelectedLine(13);
                setSelectedLine(14);

                visualPanel.setNodeLabel(r, "Nút");
                visualPanel.setNodeColor(r, Configuration.HIGHLIGHT_NODE);
                delay();
                visualPanel.setNodeLabel(2 * r + 1, "Con trái");
                visualPanel.setNodeColor(2 * r + 1, Color.ORANGE);
//                delay();
                visualPanel.setNodeLabel(2 * r + 2, "Con phải");
                visualPanel.setNodeColor(2 * r + 2, Color.ORANGE);
                delay();
                infomationPanel.setText("Nút lớn hơn con phải");
                delay();
                infomationPanel.setText("Con phải lớn hơn con trái");
                delay();
                infomationPanel.setText("Hoán đổi nút với con phải");
                delay();
                swap(array, r, 2 * r + 2);
                r = 2 * r + 2;

                setSelectedLine(15);
            } else {
                r = last;
                setSelectedLine(18);
            }
            visualPanel.setAllNodeColor(array, Configuration.COLOR_HEADER);
            visualPanel.setNodeDefaultLabel(array);
        }
    }

    private void heapSort(int[] array, int n) {
        int i;
        //Tạo Heap
        for (i = (n - 2) / 2; i >= 0 && !isStop; i--) {
            pushDown(array, i, n - 1);
        }

        //Sắp xếp
        for (i = n - 1; i >= 2 && !isStop; i--) {
            visualPanel.setNodeColor(0, Color.yellow);
            visualPanel.setNodeColor(i, Color.yellow);
            infomationPanel.setText("Hoán đổi array[0] và array[" + i + "]");
            delay();
            swap(array, 0, i);
            infomationPanel.setText(" ");
            pushDown(array, 0, i - 1);
        }
        visualPanel.setNodeColor(0, Color.yellow);
        visualPanel.setNodeColor(1, Color.yellow);
        infomationPanel.setText("Hoán đổi array[0] và array[1]");
        delay();
        swap(array, 0, 1);
    }

    @Override
    public void sort(int[] array, int sortType) {
        infomationPanel.setText("Bắt đầu thuật toán Sắp xếp Vun đống - Heap Sort");
        if (sortType == Configuration.ASC) {
            fPred = (aF, L) -> aF <= L; // TH1

            // TH2
            sPred1 = (aF, L) -> aF <= L;
            sPred2 = (L, R) -> L > R;

            // TH3
            tPred1 = (aF, R) -> aF <= R;
            tPred2 = (R, L) -> R >= L;
        } else {
            fPred = (aF, L) -> aF > L;

            sPred1 = (aF, L) -> aF > L;
            sPred2 = (L, R) -> L <= R;

            tPred1 = (aF, R) -> aF > R;
            tPred2 = (R, L) -> R < L;
        }

        heapSort(array, array.length);
    }

    // Dung de so sanh toi uu, khong animation
    private void pushDownNoAnimation(int[] array, int first, int last) {
        int r = first;
        while (r <= (last - 1) / 2 && !isStop) {
            if (last == 2 * r + 1 && !isStop) {
                if (fPred.test(array[r], array[last])) {
                    int tmp = array[r];
                    array[r] = array[last];
                    array[last] = tmp;
                    swapCounts++;
                }
                r = last;
            } else if (sPred1.test(array[r], array[2 * r + 1])
                    && sPred2.test(array[2 * r + 1], array[2 * r + 2]) && !isStop) {
                int tmp = array[r];
                array[r] = array[2 * r + 1];
                array[2 * r + 1] = tmp;
                swapCounts++;
                r = 2 * r + 1;
            } else if (tPred1.test(array[r], array[2 * r + 2])
                    && tPred2.test(array[2 * r + 2], array[2 * r + 1]) && !isStop) {
                int tmp = array[r];
                array[r] = array[2 * r + 2];
                array[2 * r + 2] = tmp;
                swapCounts++;
                r = 2 * r + 2;
            } else {
                r = last;
            }
        }
    }

    private void heapSortNoAnimation(int[] array) {
        int n = array.length;
        for (int i = (n - 2) / 2; i >= 0; i--) {
            pushDownNoAnimation(array, i, n - 1);
        }
        for (int i = n - 1; i >= 2; i--) {
            int tmp = array[0];
            array[0] = array[i];
            array[i] = tmp;
            swapCounts++;
            pushDownNoAnimation(array, 0, i - 1);
        }
        int tmp = array[0];
        array[0] = array[1];
        array[1] = tmp;
        swapCounts++;
    }

    @Override
    public int sortWithoutAnimation(int[] array, int sortOrder) {
        swapCounts = 0;
        if (sortOrder == Configuration.ASC) {
            fPred = (aF, L) -> aF <= L; // TH1

            // TH2
            sPred1 = (aF, L) -> aF <= L;
            sPred2 = (L, R) -> L > R;

            // TH3
            tPred1 = (aF, R) -> aF <= R;
            tPred2 = (R, L) -> R >= L;
        } else {
            fPred = (aF, L) -> aF > L;

            sPred1 = (aF, L) -> aF > L;
            sPred2 = (L, R) -> L <= R;

            tPred1 = (aF, R) -> aF > R;
            tPred2 = (R, L) -> R < L;
        }
        heapSortNoAnimation(array);
        return swapCounts;
    }

}
