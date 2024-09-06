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
public class BubbleSort extends Sort {

    public BubbleSort(view.VisualPanel visualPanel) {
        super(visualPanel);
    }

    public BubbleSort() {
        super();
    }

    public String getCode(int sortType) {
        StringBuilder sb = new StringBuilder();
        sb.append("void BubbleSort(int array[]) {\n");
        sb.append("        for(int i = 0; i < array.length - 1; i++){\n");
        sb.append("           for(int j = array.length - 1; j>=1; j--) {\n");
        if (sortType == config.Configuration.ASC) {
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
        if (sortType == config.Configuration.ASC) {
            cmptor = (current, previous) -> current - previous;
        } else {
            cmptor = (current, previous) -> previous - current;
        }

        for (int i = 0; i < array.length - 1 && !isStop; i++) {
            for (int j = array.length - 1; j > i; j--) {
                // Sửa lỗi: Thêm điều kiện kiểm tra trước khi hoán đổi
                if (cmptor.compare(array[j], array[j - 1]) < 0) {
                    swap(array, j-1, j);
                }
            }
        }
    }

}
