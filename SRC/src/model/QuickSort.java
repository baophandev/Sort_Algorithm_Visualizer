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
public class QuickSort extends Sort {

    private BiPredicate<Integer, Integer> fstPred, scdPred;
    
    public QuickSort(view.VisualPanel visualPanel, view.CodeVisual codeVisual, view.InfomationPanel infomationPanel) {
        super(visualPanel, codeVisual, infomationPanel);
    }

    public QuickSort() {
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
    private int findPivotNoAnimation(int[] array, int i, int j) {
        int firstkey, k = i + 1;
        firstkey = array[i];
        while (k <= j && array[k] == firstkey && !isStop) {
            k++;
        }
        if (k > j && !isStop) {
            return -1;
        } else if (array[k] > firstkey && !isStop) {
            return k;
        } else {
            return i;
        }
    }

    private int partitionNoAnimation(int[] array, int i, int j, int pivot) {
        int Left = i, Right = j;

        while (Left <= Right && !isStop) {
            while (fstPred.test(array[Left], pivot) && !isStop) {
                Left++;
            }
            while (scdPred.test(array[Right], pivot) && !isStop) {
                Right--;
            }
            if (Left < Right && !isStop) {
                int tmp = array[Left];
                array[Left] = array[Right];
                array[Right] = tmp;
                swapCounts++;
            }
        }
        return Left;
    }

    private void quickSortNoAnimation(int[] array, int i, int j) {
        int k, pivotindex, pivot;
        // Tìm chốt
        pivotindex = findPivotNoAnimation(array, i, j);
        if (pivotindex != -1 && !isStop) {
            pivot = array[pivotindex];
            // Phân hoạch tại k
            k = partitionNoAnimation(array, i, j, pivot);
            quickSortNoAnimation(array, i, k - 1);
            quickSortNoAnimation(array, k, j);
        }
    }

    @Override
    public int sortWithoutAnimation(int[] array, int sortOrder) {
        swapCounts = 0;
        if (sortOrder == Configuration.ASC) {
            /*
                array[Left] < pivot
                array[Right] >= pivot
             */
            fstPred = (left, pivot) -> left < pivot;
            scdPred = (right, pivot) -> right >= pivot;
        } else {
            /*
                array[Left] >= pivot
                array[Right] < pivot
             */
            fstPred = (left, pivot) -> left >= pivot;
            scdPred = (right, pivot) -> right < pivot;
        }
        quickSortNoAnimation(array, 0, array.length - 1);
        return swapCounts;
    }
    
}