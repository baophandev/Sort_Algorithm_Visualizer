/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import config.Configuration;
import java.awt.Color;
import java.util.Comparator;
import java.util.function.BiPredicate;

/**
 *
 * @author GIA BAO
 */
public class QuickSort extends Sort {

    private BiPredicate<Integer, Integer> fstPred, scdPred;

    public QuickSort(view.VisualPanel visualPanel, view.CodeVisual codeVisual, view.InfomationPanel infomationPanel, view.HeaderPanel headerPanel) {
        super(visualPanel, codeVisual, infomationPanel, headerPanel);
    }

    public QuickSort() {
        super();
    }

    @Override
    public String getCode(int sortOrder) {
        StringBuilder sb = new StringBuilder();

        sb.append("int FindPivot(int array[], int i,int j) {\n");                        //0
        sb.append("     int firstkey, k = i + 1;\n");
        sb.append("     firstkey = array[i];\n");
        sb.append("     while (k <= j && array[k] == firstkey) {\n");
        sb.append("         k++;\n");
        sb.append("     }\n");
        sb.append("     if (k > j)\n");
        sb.append("         return -1;\n");
        sb.append("     else if (array[k] > firstkey)\n");
        sb.append("         return k;\n");
        sb.append("     else return i;\n");
        sb.append("}\n");
        sb.append("int Partition(int array[], int i, int j, int pivot) {\n");             //12
        sb.append("     int Left = i, Right = j;\n");
        sb.append("     while (Left <= Right) {\n");
        if (sortOrder == Configuration.ASC) {
            sb.append("         while (array[Left] < pivot)\n");
            sb.append("             Left++;\n");
            sb.append("         while (array[Right] >= pivot)\n");
        } else {
            sb.append("         while (array[Left] >= pivot)\n");
            sb.append("             Left++;\n");
            sb.append("         while (array[Right] < pivot)\n");
        }
        sb.append("             Right--;\n");
        sb.append("         if (Left < Right)\n");
        sb.append("             Swap(array[Left], array[Right]);\n");
        sb.append("     }\n");
        sb.append("     return Left;\n");
        sb.append("}\n");
        sb.append("void QuickSort(int array[], int i, int j) {\n");                     //24
        sb.append("     int k, pivotindex, pivot;\n");
        sb.append("     pivotindex = FindPivot(array, i, j);\n");
        sb.append("     if (pivotindex != -1) {\n");
        sb.append("         pivot = array[pivotindex];\n");
        sb.append("         k = Partition(array, i, j, pivot);\n");
        sb.append("         QuickSort(array, i, k-1);\n");
        sb.append("         QuickSort(array, k, j);\n");
        sb.append("     }\n");
        sb.append("}\n");

        return sb.toString();
    }

    private int findPivot(int[] array, int i, int j) {
        int firstkey, k = i + 1;
        setSelectedLine(1);
        firstkey = array[i];
        setSelectedLine(2);
        setSelectedLine(3);
        while (k <= j && array[k] == firstkey && !isStop) {
            k++;
            setSelectedLine(4);
        }
        if (k > j && !isStop) {
            return -1;
        } else if (array[k] > firstkey && !isStop) {
            infomationPanel.setText("Chốt bằng: " + array[k]);
            return k;
        } else {
            setSelectedLine(12);
            return i;
        }
    }

    private int partition(int[] array, int i, int j, int pivot) {
        int Left = i, Right = j;
        setSelectedLine(13);
        setSelectedLine(14);

        while (Left <= Right && !isStop) {
            while (fstPred.test(array[Left], pivot) && !isStop) {
                setSelectedLine(15);
                setSelectedLine(16);
                Left++;
                visualPanel.setNodeColor(Left, Configuration.YELLOW);
            }

            while (scdPred.test(array[Right], pivot) && !isStop) {
                setSelectedLine(17);
                setSelectedLine(18);
                Right--;
                visualPanel.setNodeColor(Right, Configuration.YELLOW);
            }

            setSelectedLine(19);
            if (Left < Right && !isStop) {
                setSelectedLine(20);
                swap(array, Left, Right);
                visualPanel.setNodeColor(Left, Configuration.HIGHLIGHT_NODE);
                visualPanel.setNodeColor(Right, Configuration.HIGHLIGHT_NODE);
            }
        }

        setSelectedLine(22);
        return Left;
    }

    private void quickSort(int[] array, int i, int j) {
        setSelectedLine(24);
        int k, pivotindex, pivot;
        setSelectedLine(25);

        for (int l = i; l <= j && !isStop; l++) {
            visualPanel.setNodeColor(l, Configuration.COLOR_SUBHEADER);
        }

        //Tìm chốt
        setSelectedLine(26);
        pivotindex = findPivot(array, i, j);
        setSelectedLine(0);

        if (pivotindex != -1 && !isStop) {
            setSelectedLine(27);
            setSelectedLine(28);
            pivot = array[pivotindex];
            visualPanel.setNodeColor(pivotindex, Color.PINK);
            
            //Phân hoạch tại k
            setSelectedLine(29);
            k = partition(array, i, j, pivot);
            setSelectedLine(12);
            visualPanel.setNodeColor(k, Color.ORANGE);
            
            for(int l = i; l <= j && !isStop; l++){
                if(l == k && !isStop){
                    continue;
                }
                visualPanel.setNodeColor(l, Configuration.COLOR_HEADER);
            }
            setSelectedLine(30);
            quickSort(array, i, k-1);
            for(int l = i; l <= k-1; l++){
                visualPanel.setNodeColor(l, Configuration.HIGHLIGHT_NODE);
            }
            setSelectedLine(31);
            quickSort(array, k, j);
            for(int l = k; l <= j && !isStop; l++){
                visualPanel.setNodeColor(l, Configuration.COLOR_SUBHEADER);
            }
        }
    }

    @Override
    public void sort(int[] array, int sortType) {
        infomationPanel.setText("Bắt đầu thuật toán Sắp xếp Nhanh - Quick Sort");
        if (sortType == Configuration.ASC) {
            fstPred = (left, pivot) -> left < pivot;
            scdPred = (right, pivot) -> right >= pivot;
        } else {
            fstPred = (left, pivot) -> left >= pivot;
            scdPred = (right, pivot) -> right < pivot;
        }
        quickSort(array, 0, array.length-1);
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
