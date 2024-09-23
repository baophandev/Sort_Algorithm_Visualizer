/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import config.Configuration;
import java.util.Comparator;
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
                visualPanel.setNodeLabel(j, "j = " + j);
                int y = j - 1;
                visualPanel.setNodeLabel(j - 1, "j = " + y);
                visualPanel.setNodeColor(j, config.Configuration.YELLOW);
                visualPanel.setNodeColor(j - 1, config.Configuration.YELLOW);
                setSelectedLine(3);

                if (cmptor.compare(array[j], array[j - 1]) < 0) {  // Sử dụng j+1 để so sánh
                    visualPanel.setNodeColor(j, config.Configuration.YELLOW);
                    setSelectedLine(4);
                    infomationPanel.setText("Hoán đổi i và j");
                    swap(array, j - 1, j);  // Swap array[j] và array[j+1]
                    delay();
                    visualPanel.setNodeLabel(j, " ");
                    visualPanel.setNodeLabel(j - 1, " ");
                } else {
                    visualPanel.setNodeColor(j, config.Configuration.COLOR_HEADER);
                    visualPanel.setNodeColor(j - 1, config.Configuration.COLOR_HEADER);
                    visualPanel.setNodeLabel(j, " ");
                    visualPanel.setNodeLabel(j - 1, " ");
                }
                visualPanel.setNodeColor(i, config.Configuration.COLOR_HEADER);
            }
            if (!isStop) {
                visualPanel.setNodeColor(i, config.Configuration.HIGHLIGHT_NODE);
                visualPanel.setNodeLabel(i, " ");
            }
        }
        if (!isStop) {
            visualPanel.setNodeColor(array.length - 1, config.Configuration.HIGHLIGHT_NODE);
        }
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
