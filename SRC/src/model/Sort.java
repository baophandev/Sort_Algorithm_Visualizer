package model;

import controller.Controller;
import view.VisualPanel;
import view.CodeVisual;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.InfomationPanel;

public abstract class Sort {

    protected final VisualPanel visualPanel;
    protected final CodeVisual codeVisual;
    protected final InfomationPanel infomationPanel;

    protected int swapCounts = 0;
    protected volatile boolean isStop = false; // Đảm bảo thread-safe khi dừng
    protected int speed = 2; // Tốc độ mặc định
    protected final long sleepTime = 800; // Thời gian chờ mặc định

    // Constructor mặc định
    public Sort() {
        this.visualPanel = null;
        this.codeVisual = null;
        this.infomationPanel = null;
    }

    // Constructor có tham số
    public Sort(VisualPanel visualPanel, CodeVisual codeVisual, InfomationPanel infomationPanel) {
        this.visualPanel = visualPanel;
        this.codeVisual = codeVisual;
        this.infomationPanel = infomationPanel;
    }

    // Lấy mã thuật toán (tuỳ loại sort)
    public abstract String getCode(int sortType);

    // Thực hiện thuật toán sắp xếp
    public abstract void sort(int[] array, int sortType);

    // Thực hiện việc đổi chỗ hai phần tử trong mảng
    protected void swap(int[] array, int i, int j) {
        visualPanel.swapNodes(i, j);
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
        swapCounts++; // Tăng số lần swap
    }

    // Phương thức để kiểm soát tốc độ
    protected void delay() {
        try {
            int delayTime;
            switch (speed) {
                case 1: // nhanh
                    delayTime = 50;
                    break;
                case 2: // trung bình
                    delayTime = 300;
                    break;
                case 3: // chậm
                    delayTime = 600;
                    break;
                default:
                    delayTime = 300; // mặc định trung bình
            }
            Thread.sleep(delayTime);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
    
    // Đặt dòng code được highlight
    protected void setSelectedLine(int idx) {
        codeVisual.setSelectedLine(idx);
        try {
            Thread.sleep(sleepTime / speed); // Tạm dừng với tốc độ điều chỉnh
        } catch (InterruptedException ex) {
            Logger.getLogger(Controller.class.getName())
                  .log(Level.SEVERE, null, ex);
        }
    }

    // Kiểm tra nếu thuật toán đang dừng
    public boolean isStop() {
        return isStop;
    }

    // Thiết lập trạng thái dừng thuật toán
    public void setStop(boolean isStop) {
        this.isStop = isStop;
    }

    // Thiết lập tốc độ (giới hạn từ 1 đến 3)
    public void setSpeed(int speed) {
        if (speed >= 1 && speed <= 3) {
            this.speed = speed;
        }
    }

    // Đặt lại số lần swap
    public void resetSwapCount() {
        swapCounts = 0;
    }

    // Lấy số lần swap hiện tại
    public int getSwapCount() {
        return swapCounts;
    }
}
