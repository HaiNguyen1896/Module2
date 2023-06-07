public class find_Minimum {
    public static void main(String[] args) {
        int[]arr={4, 12, 7, 8, 1, 6, 9};
        //int index = minValue(arr);
        System.out.println("The smallest number of array is "+minValue(arr));
    }
    public static int minValue(int[]array){
        int min = array[0];
        for (int i =0;i<array.length;i++){
            if(min>array[i]) min=array[i];
        }
        return min;
    }
}

