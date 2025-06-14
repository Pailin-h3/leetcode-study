package Heap;

import java.util.ArrayList;
import java.util.Arrays;

public class MedianFinder {
    private ArrayList<Integer> list;

    public MedianFinder() {
        list = new ArrayList<>();
    }
    
    public void addNum(int num) {
        if(list.isEmpty()){
            list.add(num);
        }else{
            for(int i = 0 ; i<list.size() ; i++){
                if(i == list.size()-1){
                    if(list.get(i) > num){
                        list.add(i, num);
                        break;
                    }else{
                        list.add(num);
                        break;
                    }
                }else 
                if(list.get(i) > num){
                    list.add(i, num);
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(list.toArray()));
    }
    
    public double findMedian() {

        if(list.size()%2 != 0){
            double median = (double) list.get(list.size()/2);
            System.out.println(median);
            return median;
        }else{
            double median = ((double) list.get((list.size()/2) -1) + (double) list.get(list.size()/2)) / 2;
            System.out.println(median);
            return median;
        }
    }
}
