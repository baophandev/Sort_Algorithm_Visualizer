/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;

/**
 *
 * @author GIA BAO
 */
public abstract class Sort {
    protected final view.VisualPanel visualPanel;
    protected int swapCounts = 0;
    protected volatile boolean isStop = false;
    
    public Sort() {
        visualPanel = null;
    }
    
    public Sort(view.VisualPanel visualPanel){
        this.visualPanel = visualPanel;
    }
    
    public abstract void sort(int[] array, int sortType);
    
    protected void swap(int[] array, int i, int j){
        visualPanel.swapNodes(i, j);
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
        swapCounts++;
        
    }
    
    
    protected void setSelectedLine(int idx){
        
    }
    
    public int setSwapCount(){
        return swapCounts = 0;
    }
    
    public int getSwapCount(){
        return swapCounts = 0;
    } 
    
}
