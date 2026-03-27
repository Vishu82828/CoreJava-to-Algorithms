public class SearchEfficiencyLinear {
    public static void main(String[] args) {
        int [] myData = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
//        System.out.println("Index : "+SearchEfficiency.LinearSearch(myData,10)+" || Counter : "+SearchEfficiency.count);
        System.out.println("Index : "+BinarySearchDemo.binarySearch(myData,80)+" || Counter : "+BinarySearchDemo.count);
    }
}

class SearchEfficiency {
    public static int count = 0;
    public static int LinearSearch(int[] numbers, int target) {
        for (int i = 0; i <= numbers.length -1; i++) {
            count++;
            if (numbers[i] == target) {
                return i;
            }
        }
        return -1;
    }
}

class BinarySearchDemo {
    public static int count = 0;
    public static int binarySearch(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length - 1;
        while (low <= high) {
            count++;
            int mid = (low + high)/2;
            if(numbers[mid] == target){
            return mid;
            }else if( numbers[mid] < target){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}