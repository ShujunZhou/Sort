# include <stdio.h>

# define Cutoff 3

int Median3(int A[], int Left, int Right);//三数中值分割法
void Qsort(int A[], int Left, int Right);//快速排序法
void Swap(int *p1, int *p2);//交换两个数的位置
void InsertionSort(int A[], int N);//插入排序

int main(void)
{
    int i = 0;
    int A[10] = {5, 8, 1, 2, -5, 3, 0, 10, 4, 6};
    Qsort(A, 0, 9);

    for (i = 0; i < 10; i++)
    {
        printf("%d\t", A[i]);
    }

    return 0;
}


/*
 * 选出数组左端、右端/和中心位置上的三个元素的中值作为枢纽元
 * 并将枢纽元放到倒数第二个位置
 * */
int Median3(int A[], int Left, int Right)
{
    int Center = (Left + Right) / 2;

    if (A[Left] > A[Center]) //数组左端元素与数组中心位置元素进行比较，较小的放置前面
    {
        Swap(&A[Left], &A[Center]);
    }
    if (A[Left] > A[Right]) //数组左端元素与数组右端元素进行比较，较小的放置前面
    {
        Swap(&A[Left], &A[Right]);
    }
    if (A[Center] > A[Right]) //数组中心位置元素与右端元素进行比较，较小的置中
    {
        Swap(&A[Center], &A[Right]);
    }

    Swap(&A[Center], &A[Right - 1]); //将枢纽元放置到倒数第二个位置

    return A[Right - 1]; //返回枢纽元
}

void Qsort(int A[], int Left, int Right)
{
    int i, j;

    int Pivot;

    if (Cutoff + Left <= Right)
    {
        Pivot = Median3(A, Left, Right);//获取枢纽元
        i = Left;
        j = Right - 1;

        while (true) 
        {
            while (A[++i] < Pivot){}//A[Left + 1]开始
            while (A[--j] > Pivot){}//A[Right - 2]开始
            if (i < j)
            {
                Swap(&A[i], &A[j]);//交换A[i]和A[j]的值
            }   
            else 
            {
                break;
            }
        }
        Swap(&A[i], &A[Right - 1]);//将枢纽元与i所指向的元素交换

        Qsort(A, Left, i-1);//对小于枢纽元的元素进行排序
        Qsort(A, i+1, Right);//对大于枢纽元的元素进行排序
    }
    else 
    {
        InsertionSort(A + Left, Right - Left +1);//当Right-Left小于3的时候进行插入排序
    }
}

void InsertionSort(int A[], int N)//插入排序
{
    int i, j, Temp;

    for (i = 1; i < N; i++)
    {
        Temp = A[i];
        for (j = i; j > 0 && A[j - 1] > Temp; j--)
        {
            A[j] = A[j - 1];
        }
        A[j] = Temp;
    }
}

void Swap(int *p1, int *p2)//交换两个数的位置
{
    int temp = 0;

    temp = *p1;
    *p1 = *p2;
    *p2 = temp;
}
