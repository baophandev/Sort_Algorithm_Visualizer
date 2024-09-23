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
public class MergeSort extends Sort {
    
    private Comparator<Integer> cmptor;

    public MergeSort(view.VisualPanel visualPanel, view.CodeVisual codeVisual, view.InfomationPanel infomationPanel) {
        super(visualPanel, codeVisual, infomationPanel);
    }

    public MergeSort() {
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
    private void mergeNoAnimation(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1,
            n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i ++) {
            L[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = array[mid + 1 + j];
        }
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (cmptor.compare(L[i], R[j]) <= 0) { // 11
                array[k] = L[i];
                swapCounts++;
                i++;
            } else { // 14
                array[k] = R[j];
                swapCounts++;
                j++;
            }
            k++;
        }
        while (i < n1) { // 20
            array[k] = L[i];
            swapCounts++;
            i++;
            k++;
        }
        while (j < n2) { // 25
            array[k] = R[j];
            swapCounts++;
            j++;
            k++;
        }
    }

    private void mergeSortNoAnimation(int[] array, int left, int right) {
        if (left < right) {
            // Find the middle point
            int mid = left + (right - left) / 2;
            // Sort first and second halves
            mergeSortNoAnimation(array, left, mid);
            mergeSortNoAnimation(array, mid + 1, right);
            // Merge the sorted halves
            mergeNoAnimation(array, left, mid, right);
        }
    }

    @Override
    public int sortWithoutAnimation(int[] array, int sortOrder) {
        swapCounts = 0;
        if (sortOrder == Configuration.ASC) {
            cmptor = (L, R) -> L - R;
        } else {
            cmptor = (L, R) -> R - L;
        }
        mergeSortNoAnimation(array, 0, array.length - 1);

        return swapCounts;
    }
    
}
