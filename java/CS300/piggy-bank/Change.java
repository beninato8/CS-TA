public class Change {

    public static int partition(int arr[], int low, int high) 
    { 
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) 
        { 
            if (arr[j] <= pivot) 
            { 
                i++; 
  
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            }
        }
  
        int temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
  
        return i+1; 
    } 
    public static void sort(int arr[], int low, int high) 
    { 
        if (low < high) 
        { 
            int pivot = partition(arr, low, high); 
            /* [low-] [pivot] [-high] */
            sort(arr, low, pivot-1); 
            sort(arr, pivot+1, high); 
        } 
    }

    public static int [] sorted(int [] arr)
    {
        sort(arr, 0, arr.length - 1);
        return arr;
    }

    public static int sum(int [] arr)
    {
        int sum = 0;
        for (int x : arr)
            sum += x;
        return sum;
    }

    public static int max(int [] arr)
    {
        int big = arr[0];
        for (int x : arr)
            if (x > big)
                big = x;
        return big;
    }

    public static int indexOf(int [] arr, int n)
    {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == n)
                return i;
      return -1;
    }

    public static int [] make_change(int amount, int [] coins)
    {
        if (sum(coins) < amount)
        {
            System.out.println("Amount is bigger than sum");
            return new int [] {};
        }
        int [] out = new int [coins.length];
        int outIndex = 0;
        int startingAmount = amount;
        while (sum(out) < startingAmount)
        {
            int biggest = max(coins);
            int currentCoin = biggest;
            for (int coin : sorted(coins))
            {
                if (coin >= amount && coin != 0)
                {
                    currentCoin = coin;
                    break;
                }
            }
            amount -= currentCoin;
            coins[indexOf(coins, currentCoin)] = 0;
            out[outIndex] = currentCoin;
            outIndex++;
        }

        return out;
    }

    public static void main(String [] args)
    {
        int [] coins = new int [] {10, 10, 5, 5, 5, 1, 1, 1, 1};
        int amount = 28;
        int [] change = make_change(amount, coins);
        for (int x : change)
        {
            System.out.println(x);
        }
    }
}