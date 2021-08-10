/**
 * 一个很巧妙的线程排序
 */
public class SixSixSix {
    public static void main(String[] args) {
        int[] ints = {1, 4, 7, 3, 8, 9, 2, 6, 5};
        SortThread[] sortThreads = new SortThread[ints.length];
        for (int i = 0; i < sortThreads.length; i++) {
            sortThreads[i] = new SortThread(ints[i]);
        }
        for (int i = 0; i < sortThreads.length; i++) {
            sortThreads[i].start();
        }
    }

    static class SortThread extends Thread {
        int ms = 0;

        public SortThread(int ms) {
            this.ms = ms;
        }

        @Override
        public void run() {
            try {
                sleep(ms);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(ms);
        }
    }
}

