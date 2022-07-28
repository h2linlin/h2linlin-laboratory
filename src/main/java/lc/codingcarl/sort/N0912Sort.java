package lc.codingcarl.sort;

import lc.DisplayUtil;

// 排序：给你一个整数数组 nums，请你将该数组升序排列。
public class N0912Sort {

/*    public int[] sortArray(int[] nums) {
        // 边界处理
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        sort(nums, 0,1,nums.length - 1);

        return nums;
    }

    // 递归
    public void sort(int[] nums, int start, int i, int j) {
        if (i >= j) {
            return;
        }

        int head = i;
        int tail = j;

            while (i != j) {
            while (nums[j] > nums[start] && j >= head) j--;  // 一定是j先开始，最后才能和start换。
            while (nums[i] < nums[start] && i <= tail) i++;

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

        }

        int temp = nums[start];
        nums[start] = nums[i];
        nums[i] = temp;

        sort(nums, start, start+1, i-1);
        sort(nums, i+1, i+2, tail);
    }*/

    public static void main(String[] args) {
        int[] nums1 = {2,6,5,3,1,4,7};
        int[] nums2 = {8,7,6,2,1,4,3,5};

        System.out.println("----------");
        DisplayUtil.display(nums1);
        DisplayUtil.display(mergeSort0(nums1));

        System.out.println("----------");
        DisplayUtil.display(nums2);
        DisplayUtil.display(mergeSort0(nums2));
    }

    /**
     * 归并排序：
     * 递归。先拆再和。
     * 注意mid的边界，bgn - mid, mid+1 - end
     */
    private static int[] mergeSort0(int[] nums) {
        mergeSort0Split(nums, 0, nums.length - 1);
        return nums;
    }

    private static void mergeSort0Split(int[] nums, int bgn, int end) {
        if (bgn >= end) {
            return;
        }

        int mid = (bgn + end) >> 1;

        // 拆
        mergeSort0Split(nums, bgn, mid);
        mergeSort0Split(nums, mid + 1, end);
        // 合
        mergeSort0Merge(nums, bgn, mid, end);
    }

    private static void mergeSort0Merge(int[] nums, int bgn, int mid, int end) {
        int[] arr = new int[end - bgn + 1];
        int i = 0;
        int lef = bgn;
        int rgt = mid + 1;

        while (lef <= mid && rgt <= end) {
            if (nums[lef] < nums[rgt]) {
                arr[i++] = nums[lef++];
            } else {
                arr[i++] = nums[rgt++];
            }
        }

        while (lef <= mid) { arr[i++] = nums[lef++]; };
        while (rgt <= end) { arr[i++] = nums[rgt++]; }

        for (int k = 0; k < arr.length; k++) {
            nums[bgn + k] = arr[k];
        }
    }

    /**
     * 快速排序：
     * 本质上是交换排序。由于可以跳跃交换，所以效率比冒泡高。
     *
     * 每一趟，找出基准点的位置。基准点左边都小于它，右边都大于它。
     * 用两个指针，从两边往中间靠，靠的过程中判断是否要交换。直到两个指针相遇。
     *
     * 最坏情况：当选取的轴是最大值或最小值时，效率最差，接近冒泡，为n^2
     *
     * 不稳定排序。试想一下，假设B、C都等于2，两个指针往中间移动的时候，如果B、C都交换到对面去了，试想一下，交换后，它们的位置是镜像的。也就是前后顺序表过来了。
     */
    private static int[] quickSort0(int[] nums) {
        return quickSort0Sub(nums, 0, nums.length - 1);
    }

    private static int[] quickSort0Sub(int[] nums, int i, int j) {
        if (i >= j) { return nums; }

        int start = i;
        int end = j;

        // 三数选轴优化
        if (nums.length > 16) {
            if (nums[i] > nums[j]) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = nums[i];
            }

            int mid = (i + j) / 2;
            if (nums[i] < nums[mid]) {
                int temp = nums[i];
                nums[i] = nums[mid];
                nums[mid] = nums[i];
            }
        }

        int head = nums[i];

        // 找比head小的，所以j先走。
        while (i < j) {
            while (i < j && nums[j] > head) { j--; }
            if (i < j) { nums[i] = nums[j]; }

            while (i < j && nums[i] < head) { i++; }
            if (i < j) { nums[j] = nums[i]; }
        }

        nums[i] = head;
        quickSort0Sub(nums, start, i-1);
        quickSort0Sub(nums, i+1, end);
        return nums;
    }

    // == leetcode参考代码 =====================================================
    /**
     快速排序
     **/
    void qSort(int[] arr,int s,int e){
        int l = s, r = e;
        if(l < r){
            int temp = arr[l];
            while(l < r){
                while(l < r && arr[r] >= temp) r--;
                if(l < r) arr[l] = arr[r];
                while(l < r && arr[l] < temp) l++;
                if(l < r) arr[r] = arr[l];
            }
            arr[l] = temp;
            qSort(arr,s,l);
            qSort(arr,l + 1, e);
        }
    }
    /**
     选择排序
     **/
    void selectSort(int[] arr){
        int min;
        for(int i = 0;i<arr.length;i++){
            min = i;
            for(int j = i;j<arr.length;j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            if(min != i) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }
    /**
     *
     * 插入排序：数列前面部分看为有序，依次将后面的无序数列元素插入到前面的有序数列中，初始状态有序数列仅有一个元素，即首元素。在将无序数列元素插入有序数列的过程中，采用了逆序遍历有序数列，相较于顺序遍历会稍显繁琐，但当数列本身已近排序状态效率会更高。
     *
     * 时间复杂度：O(N2) 　　稳定性：稳定
     * @param arr
     */
    void insertSort(int arr[]){
        for(int i = 1; i < arr.length; i++){
            int rt = arr[i];
            for(int j = i - 1; j >= 0; j--){
                if(rt < arr[j]){
                    arr[j + 1] = arr[j];
                    arr[j] = rt;
                }else{
                    break;
                }
            }
        }
    }
    /**
     * 希尔排序 - 插入排序的改进版。为了减少数据的移动次数，在初始序列较大时取较大的步长，通常取序列长度的一半，此时只有两个元素比较，交换一次；之后步长依次减半直至步长为1，即为插入排序，由于此时序列已接近有序，故插入元素时数据移动的次数会相对较少，效率得到了提高。
     *
     * 时间复杂度：通常认为是O(N3/2) ，未验证　　稳定性：不稳定
     * @param arr
     */
    void shellSort(int arr[]){
        int d = arr.length >> 1;
        while(d >= 1){
            for(int i = d; i < arr.length; i++){
                int rt = arr[i];
                for(int j = i - d; j >= 0; j -= d){
                    if(rt < arr[j]){
                        arr[j + d] = arr[j];
                        arr[j] = rt;
                    }else break;
                }
            }
            d >>= 1;
        }
    }
    /**
     * 桶排序 - 实现线性排序，但当元素间值得大小有较大差距时会带来内存空间的较大浪费。首先，找出待排序列中得最大元素max，申请内存大小为max + 1的桶（数组）并初始化为0；然后，遍历排序数列，并依次将每个元素作为下标的桶元素值自增1；
     * 最后，遍历桶元素，并依次将值非0的元素下标值载入排序数列（桶元素>1表明有值大小相等的元素，此时依次将他们载入排序数列），遍历完成，排序数列便为有序数列。
     *
     * 时间复杂度：O(x*N) 　　稳定性：稳定
     * @param arr
     */
    void bucketSort(int[] arr){
        int[] bk = new int[50000 * 2 + 1];
        for(int i = 0; i < arr.length; i++){
            bk[arr[i] + 50000] += 1;
        }
        int ar = 0;
        for(int i = 0; i < bk.length; i++){
            for(int j = bk[i]; j > 0; j--){
                arr[ar++] = i - 50000;
            }
        }
    }
    /**
     * 基数排序 - 桶排序的改进版，桶的大小固定为10，减少了内存空间的开销。首先，找出待排序列中得最大元素max，并依次按max的低位到高位对所有元素排序；
     * 桶元素10个元素的大小即为待排序数列元素对应数值为相等元素的个数，即每次遍历待排序数列，桶将其按对应数值位大小分为了10个层级，桶内元素值得和为待排序数列元素个数。
     * @param arr
     */
    void countSort(int[] arr){
        int[] bk = new int[19];
        Integer max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            if(max < Math.abs(arr[i])) max = arr[i];
        }
        if(max < 0) max = -max;
        max = max.toString().length();
        int [][] bd = new int[19][arr.length];
        for(int k = 0; k < max; k++) {
            for (int i = 0; i < arr.length; i++) {
                int value = (int)(arr[i] / (Math.pow(10,k)) % 10);
                bd[value+9][bk[value+9]++] = arr[i];
            }
            int fl = 0;
            for(int l = 0; l < 19; l++){
                if(bk[l] != 0){
                    for(int s = 0; s < bk[l]; s++){
                        arr[fl++] = bd[l][s];
                    }
                }
            }
            bk = new int[19];
            fl = 0;
        }
    }

    /**
     * 归并排序 - 采用了分治和递归的思想，递归&分治-排序整个数列如同排序两个有序数列，依次执行这个过程直至排序末端的两个元素，再依次向上层输送排序好的两个子列进行排序直至整个数列有序（类比二叉树的思想，from down to up）。
     *
     * 时间复杂度：O(NlogN) 　　稳定性：稳定
     * @param arr
     */
    void mergeSortInOrder(int[] arr,int bgn,int mid, int end){
        int l = bgn, m = mid +1, e = end;
        int[] arrs = new int[end - bgn + 1];
        int k = 0;
        while(l <= mid && m <= e){
            if(arr[l] < arr[m]){
                arrs[k++] = arr[l++];
            }else{
                arrs[k++] = arr[m++];
            }
        }
        while(l <= mid){
            arrs[k++] = arr[l++];
        }
        while(m <= e){
            arrs[k++] = arr[m++];
        }
        for(int i = 0; i < arrs.length; i++){
            arr[i + bgn] = arrs[i];
        }
    }
    void mergeSort(int[] arr, int bgn, int end)
    {
        if(bgn >= end){
            return;
        }
        int mid = (bgn + end) >> 1;
        mergeSort(arr,bgn,mid);
        mergeSort(arr,mid + 1, end);
        mergeSortInOrder(arr,bgn,mid,end);
    }

    /**
     * 堆排序 - 堆排序的思想借助于二叉堆中的最大堆得以实现。首先，将待排序数列抽象为二叉树，并构造出最大堆；然后，依次将最大元素（即根节点元素）与待排序数列的最后一个元素交换（即二叉树最深层最右边的叶子结点元素）；
     * 每次遍历，刷新最后一个元素的位置（自减1），直至其与首元素相交，即完成排序。
     *
     * 时间复杂度：O(NlogN) 　　稳定性：不稳定
     *
     */
    void heapSort(int[] nums) {
        int size = nums.length;
        for (int i = size/2-1; i >=0; i--) {
            adjust(nums, size, i);
        }
        for (int i = size - 1; i >= 1; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            adjust(nums, i, 0);
        }
    }
    void adjust(int []nums, int len, int index) {
        int l = 2 * index + 1;
        int r = 2 * index + 2;
        int maxIndex = index;
        if (l<len&&nums[l]>nums[maxIndex])maxIndex = l;
        if (r<len&&nums[r]>nums[maxIndex])maxIndex = r;
        if (maxIndex != index) {
            int temp = nums[maxIndex];
            nums[maxIndex] = nums[index];
            nums[index] = temp;
            adjust(nums, len, maxIndex);
        }
    }
}
