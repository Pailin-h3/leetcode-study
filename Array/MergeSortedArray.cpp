#include <iostream>

int main()
{
    int nums1[2] = {2,0}; 
    int m = 1;
    int nums2[1] = {1};
    int n = 1;

    int idx1 = m-1;
    int idx2 = n-1;

    for(int i=m+n-1 ; i>=0 && idx2>=0 ; i--){
        printf("Round %d   ", i);
        printf("idx1: %d, idx2: %d ", idx1, idx2);
        printf("num1 [%d] num2 [%d] ", nums1[idx1] , nums2[idx2]);
        if(idx1 < 0 || nums1[idx1] < nums2[idx2]){
            printf("use num2\n");
            nums1[i] = nums2[idx2--];
        }else {
            printf("use num1\n");
            nums1[i] = nums1[idx1--];
        }
    }

    for(int i=0 ; i<m+n ; i++){
        printf("%d ", nums1[i]);
    }
}
