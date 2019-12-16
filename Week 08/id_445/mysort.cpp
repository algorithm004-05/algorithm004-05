#include <vector>
#include <random>
#include <map>
#include <iostream>
using namespace std;
class mysort
{
private:
    /**
 * arrayNum: the amount of arrays that will be sorted 
 * maxSize: the max size of the arrays
 * minSize: the min size of the arrays
 * maxNum: the max number of each arrays
 * minNum: the min number of each arrays
 * arrays: arrays to  sort
*/
    int arrayNum, maxSize, minSize, maxNum, minNum;
    vector<int> *arrays;
    vector<int> **sortedArrays;

    typedef void (mysort::*FnPtr)(vector<int> &src);
    map<string, FnPtr> sortFuns;
    ///resize array based on random size between maxSize and minSize
    void generateArray(int num)
    {
        default_random_engine e;
        uniform_int_distribution<unsigned> u(minSize, maxSize);
        for (size_t i = 0; i < num; i++)
            arrays[i].resize(u(e));
    }
    /// genereate data for each array with random number between maxNum and minNum
    void generateData()
    {
        default_random_engine e;
        uniform_int_distribution<unsigned> u(minNum, maxNum);
        for (int i = 0; i < arrayNum; i++)
            for (int j = 0; j < arrays[i].size(); j++)
                arrays[i][j] = u(e);
    }

public:
    mysort(/* args */)
    {
        arrayNum = 10;
        maxSize = 20;
        minSize = 10;
        maxNum = 500;
        minNum = 100;
        arrays = new vector<int>[arrayNum];
        sortedArrays = new vector<int> *[arrayNum];
        generateArray(arrayNum);
        generateData();
        setfunc();
    };
    ~mysort()
    {
        delete[] arrays;
        delete[] sortedArrays;
    };
    ///regist sorting function
    void setfunc()
    {
        sortFuns["buddle"] = &mysort::buddleSort;
        sortFuns["select"] = &mysort::selectionSort;
        sortFuns["insertion"] = &mysort::insertionSort;
        sortFuns["quictsort"] = &mysort::quickSort;
        sortFuns["heapsort"] = &mysort::heapSort;
        sortFuns["shellsort"] = &mysort::shellSort;
        sortFuns["mergeSort"] = &mysort::mergeSort;
    }
    void testSort()
    {
        vector<int> **src = new vector<int> *[arrayNum];

        copyArrays(arrays, sortedArrays);
        /// create  sorted arrays
        for (int i = 0; i < arrayNum; i++)
        {
            buddleSort(*(sortedArrays[i]));
            // printArray(*sortedArrays[i]);
        }

        ///call sort function
        map<string, FnPtr>::iterator mapi = sortFuns.begin();
        for (; mapi != sortFuns.end(); mapi++)
        {
            copyArrays(arrays, src); ///create arrays for each sorting function from original array
            printArray(*(src[arrayNum - 1]));
            for (int i = 0; i < arrayNum; i++)
            {
                (*this.*(mapi->second))(*(src[i])); //call sort function
            }
            printArray(*(src[arrayNum - 1]));
            getResult(sortedArrays, src, mapi->first);
        }
        delete[] src;
    }

    void printArray(vector<int> &v)
    {
        cout << "\n-----array size:" << v.size() << "---\n";
        for (int j = 0; j < v.size(); j++)
            cout << " " << v[j];
        // cout << "\n";
    }
    void copyArrays(vector<int> *src, vector<int> **dest)
    {
        for (int i = 0; i < arrayNum; i++)
        {
            dest[i] = new vector<int>(src[i]);
        }
    }

    void getResult(vector<int> **baseSrc, vector<int> **src, string msg)
    {
        for (int i = 0; i < arrayNum; i++)
        {
            for (int j = 0; j < baseSrc[i]->size(); j++)
            {
                if (baseSrc[i]->at(j) != src[i]->at(j))
                {

                    printArray(arrays[i]);
                    printArray(*src[i]);
                    cout << "\n"
                         << msg << " sort error" << endl;

                    exit(1);
                }
            }
        }

        cout << "\n " << msg << " sort success!\n";
    }
    void buddleSort(vector<int> &src)
    {
        int temp = 0;
        for (int i = 0; i < src.size(); i++)
        {
            for (int j = 1; j < src.size(); j++)
            {
                temp = src[j - 1];
                if (src[j - 1] > src[j])
                {
                    src[j - 1] = src[j];
                    src[j] = temp;
                }
            }
        }
    }
    void insertionSort(vector<int> &src)
    {
        int temp = 0;
        for (int i = 1; i < src.size(); i++)
        {
            temp = src[i];
            int j = i - 1;
            for (; j >= 0; j--)
            {
                if (src[j] <= temp)
                    break;
                src[j + 1] = src[j];
            }
            src[j + 1] = temp;
        }
    }
    void selectionSort(vector<int> &src)
    {

        for (int i = 0; i < src.size(); i++)
        {
            int temp = src[i], posi = i;
            for (int j = i + 1; j < src.size(); j++)
            {
                if (src[j] < src[posi])
                    posi = j;
            }
            src[i] = src[posi];
            src[posi] = temp;
        }
    }

    void quickSort(vector<int> &src)
    {
        quickSortDeep(src, 0, src.size() - 1);
    }
    void quickSortDeep(vector<int> &src, int start, int end)
    {
        if (end - start < 1)
            return;
        int mid = partition(src, start, end);
        quickSortDeep(src, start, mid - 1);
        quickSortDeep(src, mid + 1, end);
        // cout <<"test" <<endl;
    }
    int partition(vector<int> &src, int start, int end)
    {
        int posi = (end - start) / 2 + start;
        int pivot = src[posi];
        src[posi] = src[start];
        src[start] = pivot;
        while (start < end)
        {
            while ((start < end) && (pivot <= src[end]))
                end--;
            src[start] = src[end];
            while ((start < end) && (src[start] <= pivot))
                start++;
            src[end] = src[start];
        }
        src[start] = pivot;
        return start;
    }
    void shellSort(vector<int> &src)
    {
        vector<int> incrSeq{1, 2, 3, 5, 8};
        ///set step in first  loop
        for (int i = src.size() / 2; i > 0; i /= 2)
        {
            for (int j = 0; j < i; j++) ///second loop from 1 to fisrt step num
            {
                for (int k = j + i; k < src.size(); k += i) ///third loop start insertiontsort with specified loop step
                {
                    int temp = src[k];
                    int m = k - i;
                    for (; m >= j; m -= i)
                    {
                        if (src[m] <= temp)
                            break;
                        src[m + i] = src[m];
                    }
                    src[m + i] = temp;
                }
            }
        }
    }
    void mergeSort(vector<int> &src)
    {
        merge(src, 0, src.size() - 1);
    }
    void merge(vector<int> &src, int start, int end)
    {
        if (start == end)
            return;
        int mid = (end + start) / 2;
        merge(src, start, mid);
        merge(src, mid + 1, end);
        vector<int> temp(mid - start + 1);
        temp.assign(src.begin() + start, src.begin() + mid + 1);

        for (int i = start, j = 0, k = 0; (j < mid - start + 1) || (k < end - mid);)
        {
            if ((j < mid - start + 1) && (!(k < end - mid) || temp[j] <= src[mid + k + 1]))
                src[i++] = temp[j++];

            if ((k < end - mid) && (!(j < mid - start + 1) || src[k + mid + 1] < temp[j]))
                src[i++] = src[k++ + mid + 1];
        }

        // vector<int> temp2(src.begin());
    }
    ///heapsort
    void heapSort(vector<int> &src)
    {
        //heapify
        for (int i = src.size() / 2; i >= 0; i--)
            percDown(src, i, src.size());
        //sort

        for (int i = src.size() - 1; i > 0; i--)
        {
            int temp = src[0];
            src[0] = src[i];
            src[i] = temp;
            percDown(src, 0, i);
        }
    }
    inline int leftChild(int i)
    {
        return 2 * i + 1;
    }
    void percDown(vector<int> &src, int i, int n)
    {
        int child = 0;
        int temp;
        for (temp = src[i]; leftChild(i) < n; i = child)
        {
            child = leftChild(i);
            if (child != n - 1 && src[child + 1] > src[child])
                child++;
            if (src[child] > temp)
                src[i] = src[child];
            else
                break;
        }
        src[i] = temp;
    }
};

int main()
{
    mysort ms;
    // ms.setfunc();
    ms.testSort();
}
