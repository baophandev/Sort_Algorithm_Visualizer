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

    public void sort(int[] array, int sortType) {
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
                Comparator<Integer> cmptor;
                if (sortType == Configuration.ASC) {
                    cmptor = (current, previous) -> current - previous;
                } else {
                    cmptor = (current, previous) -> previous - current;
                }

                for (int i = 0; i < array.length - 1 && !isStop; i++) {
                    setSelectedLine(1);
                    for (int j = 0; j < array.length - i - 1 && !isStop; j++) { // điều chỉnh lại hướng chạy của j
                        setSelectedLine(2);
                        setSelectedLine(3);
                        if (cmptor.compare(array[j], array[j + 1]) > 0) {  // Sử dụng j+1 để so sánh
                            setSelectedLine(4);
                            swap(array, j, j + 1);  // Swap array[j] và array[j+1]
                        }
                    }
                }
                return null;
            }

            @Override
            protected void done() {
                System.out.println("Sorting completed.");
            }
        };

        worker.execute();
    }

}
