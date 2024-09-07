/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import config.Configuration;
import java.util.Comparator;
import javax.swing.SwingWorker;



/**
 *
 * @author GIA BAO
 */
public class BubbleSort extends Sort {

    public BubbleSort(view.VisualPanel visualPanel, view.CodeVisual codeVisual) {
        super(visualPanel, codeVisual);
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
        if (sortType == config.Configuration.ASC) {
            cmptor = (current, previous) -> current - previous;
        } else {
            cmptor = (current, previous) -> previous - current;
        }

        // Tạo SwingWorker để xử lý thuật toán sắp xếp
        SwingWorker<Void, int[]> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                for (int i = 0; i < array.length - 1 && !isStop; i++) {
                    publish(array.clone());  // Cập nhật giao diện bằng cách publish
                    setSelectedLine(1);
                    for (int j = array.length - 1; j > i; j--) {
                        setSelectedLine(2);
                        setSelectedLine(3);
                        if (cmptor.compare(array[j], array[j - 1]) < 0) {
                            setSelectedLine(4);
                            swap(array, j-1, j);
                        }
                        publish(array.clone());  // Cập nhật giao diện sau mỗi lần hoán đổi
                    }
                }
                return null;
            }

        };

        worker.execute();  // Bắt đầu worker
    }

}
