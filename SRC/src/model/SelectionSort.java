/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import config.Configuration;

/**
 *
 * @author GIA BAO
 */
public class SelectionSort extends Sort{
    
    public SelectionSort(){
        
    }

    @Override
    public String getCode(int sortOrder) {
        StringBuilder sb = new StringBuilder();
        sb.append("void BubbleSort(int array[]) {\n");
        sb.append("     for(int i = 0; i < array.length - 1; i++) {\n");
        sb.append("         for(int j = array.length - 1; j >= i; j--) {\n");
        if (sortOrder == Configuration.ASC) {
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
