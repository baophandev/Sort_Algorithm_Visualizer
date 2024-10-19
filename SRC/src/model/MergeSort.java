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
public class MergeSort extends Sort {

    private Comparator<Integer> cmptor;

    public MergeSort(view.VisualPanel visualPanel, view.CodeVisual codeVisual, view.InfomationPanel infomationPanel) {
        super(visualPanel, codeVisual, infomationPanel);
    }

    public MergeSort() {
        super();
    }

    @Override
    public String getCode(int sortOrder) {
        StringBuilder sb = new StringBuilder();
        sb.append("void Merge(int[] array, int left, int mid, int right) {\n");    //0
        sb.append("    int n1 = mid - left + 1;\n");
        sb.append("    int n2 = right - mid;\n");
        sb.append("    int[] L = new int[n1];\n");
        sb.append("    int[] R = new int[n2];\n");
        sb.append("    for (int i = 0; i < n1; i ++)\n");
        sb.append("        L[i] = array[left + i];\n");
        sb.append("    for (int j = 0; j < n2; j ++)\n");
        sb.append("        R[j] = array[mid + 1 + j];\n");
        sb.append("    int i = 0, j = 0, k = left;\n"); // 9
        sb.append("    while (i < n1 && j < n2) {\n"); // 10
        if (sortOrder == Configuration.ASC) {
            sb.append("        if (L[i] <= R[j]) {\n");
        } else {
            sb.append("        if (L[i] >= R[j]) {\n");
        }
        sb.append("            array[k] = L[i];\n");
        sb.append("            i++;\n");
        sb.append("        } else {\n");
        sb.append("            array[k] = R[j];\n");
        sb.append("            j++;\n");
        sb.append("        }\n");
        sb.append("        k++;\n");
        sb.append("    }\n");
        sb.append("    while (i < n1) {\n"); // 20
        sb.append("        array[k] = L[i];\n");
        sb.append("        i++;\n");
        sb.append("        k++;\n");
        sb.append("    }\n");
        sb.append("    while (j < n2) {\n"); // 25
        sb.append("        array[k] = R[j];\n");
        sb.append("        j++;\n");
        sb.append("        k++;\n");
        sb.append("    }\n");
        sb.append("}\n");
        sb.append("void MergeSort(int[] array, int left, int right) {\n"); // 31
        sb.append("    if (left < right) {\n");
        sb.append("        int mid = (left + right) / 2;\n");
        sb.append("        MergeSort(array, left, mid);\n");
        sb.append("        MergeSort(array, mid + 1, right);\n");
        sb.append("        Merge(array, left, mid, right);\n");
        sb.append("    }\n");
        sb.append("}");

        return sb.toString();
    }

    //Mảng con a1 có k phần tử
    //Mảng con a2 có l phần tử
    //Trộn 2 mảng a1 và a2 thành mảng a
    private void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy dữ liệu vào các mảng con tạm thời L[] và R[]
        for (int i = 0; i < n1 && !isStop; i++) {
            L[i] = array[left + i];
            visualPanel.setNodeColor(left + i, Color.GREEN);  // Animation cho mảng L
        }

        for (int j = 0; j < n2 && !isStop; j++) {
            R[j] = array[mid + 1 + j];
            visualPanel.setNodeColor(mid + 1 + j, Color.orange);  // Animation cho mảng R
        }

        // Hợp nhất các mảng con L[] và R[] trở lại mảng gốc array[]
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2 && !isStop) {
            if (cmptor.compare(L[i], R[j]) <= 0 && !isStop) {
                array[k] = L[i];
                visualPanel.swapNodes(k, i);
                i++;
            } else {
                array[k] = R[j];
                visualPanel.swapNodes(k, j);
                j++;
            }
            k++;
        }

        // Sao chép các phần tử còn lại của L[], nếu có
        while (i < n1 && !isStop) {
            array[k] = L[i];
            visualPanel.swapNodes(k, i);
            i++;
            k++;
        }

        // Sao chép các phần tử còn lại của R[], nếu có
        while (j < n2 && !isStop) {
            array[k] = R[j];
            visualPanel.swapNodes(k, j);
            j++;
            k++;
        }
    }

    private void mergeSort(int[] array, int left, int right) {
        setSelectedLine(31);

        for(int i = left; i<= right; i++){
            visualPanel.setNodeColor(i, Configuration.HIGHLIGHT_NODE);
        }
        
        if (left < right && !isStop) {
            setSelectedLine(32);
            setSelectedLine(33);
            int mid = left + (right - left) / 2;
            
            for(int i=left; i<=mid && !isStop; i++){
                visualPanel.setNodeColor(i, Configuration.YELLOW);
            }
            
            setSelectedLine(34);
            mergeSort(array, left, mid);
            
            for(int i = mid; i <= right && !isStop; i++){
                visualPanel.setNodeColor(i, Color.GREEN);
            }
            
            setSelectedLine(35);
            mergeSort(array, mid+1, right);
            setSelectedLine(36);
            for(int i = left; i <= mid && !isStop; i++){
                visualPanel.setNodeColor(i, Configuration.YELLOW);
            }
            
            for(int i = mid + 1; i<=right && !isStop; i++){
                visualPanel.setNodeColor(i, Color.GREEN);
            }
            
            merge(array, left, mid, right);

        }

        setSelectedLine(38);
    }

    @Override
    public void sort(int[] array, int sortType) {
        if (sortType == Configuration.ASC) {
            cmptor = (L, R) -> L - R;
        } else {
            cmptor = (L, R) -> R - L;
        }
        infomationPanel.setText("Bắt đầu thuật toán sắp xếp trộn - Merge Sort");
        mergeSort(array, 0, array.length - 1);
    }

    // Dung de so sanh toi uu, khong animation
    private void mergeNoAnimation(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1,
                n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++) {
            L[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = array[mid + 1 + j];
        }
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (cmptor.compare(L[i], R[j]) <= 0) { // 11
                array[k] = L[i];
                i++;
            } else { // 14
                array[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) { // 20
            array[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) { // 25
            array[k] = R[j];
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
