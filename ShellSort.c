# include <stdio.h>

void ShellSort(int a[], int N);

int main(void)
{
    int i = 0;
    int a[11] = {8, 9, 4, 5, 6,12, 3, 0, 1, 5, 7};
    ShellSort(a, 11);

    for (i = 0; i < 11; i++)
    {
        printf("%d ", a[i]);
    }

    return 0;
}

void ShellSort(int a[], int N)
{
    int i, j, Increment;
    int Temp;

    for (Increment = N / 2; Increment > 0; Increment /= 2)
    {
        for (i = Increment; i < N; i++)
        {
            Temp = a[i];
            for (j = i; j >= Increment; j -= Increment)
            {
                if (Temp < a[j - Increment])
                {
                    a[j] = a[j - Increment];
                }   
                else
                {
                    break;
                }
                a[j - Increment] = Temp;
            }
        }
    }
}
