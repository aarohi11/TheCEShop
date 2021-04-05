import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// Q-3: Print all combinations that add to 10
// Logic: use dynamic programming bottom-up approach to find combinations with sum-10, then bfs to print them

class Pair
{
	int i,j;
	String psf="";
	Pair(int i,int j,String psf)
	{
		this.i=i;
		this.j=j;
		this.psf = psf;
	}
}

public class TargetSum10 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int target = 10;
		System.out.println("\n Enter n:");
		int n;
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		
		int []nums = new int[n];
		System.out.println("\n Enter numbers:");
		for(int i=0;i<n;i++)
		{
			nums[i] = scan.nextInt();
		}
		
		boolean [][]dp = new boolean[n+1][11];
		
		for(int i=0;i<dp[0].length;i++)
		{
			dp[0][i]=false;
		}
		
		for(int i=0;i<dp.length;i++)
		{
			dp[i][0] = true;
		}
		
		for(int i=1;i<dp.length;i++)
		{
			for(int j=1;j<dp[0].length;j++)
			{
				if(dp[i-1][j])
				{
					dp[i][j]=true;
				}
				else if(j>=nums[i-1])
				{
					if(dp[i-1][j-nums[i-1]])
					{
						dp[i][j] = dp[i-1][j-nums[i-1]];
					}
				}
			}
		}
		
		/*for(int i=0;i<dp.length;i++)
		{
			for(int j=0;j<dp[0].length;j++)
			{
				System.out.print("\t"+dp[i][j]);
			}
			System.out.print("\n");
		}*/
		System.out.println("\n Array Elements:");
		for(int i=0;i<nums.length;i++)
		{
			System.out.print("\t"+nums[i]);
		}
		
		System.out.println("\n Combinations with Sum 10:");
		
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(n,target,""));
		
		while(!queue.isEmpty())
		{
			int size = queue.size();
			while(size>0)
			{
				Pair current = queue.remove();
				size--;
				
				int i = current.i;
				int j = current.j;
				
				if(i==0 || j==0)
				{
					System.out.println("\n"+current.psf);
					break;
				}
				
				if(dp[i-1][j])
				{
					queue.add(new Pair(i-1,j,current.psf));
				}
				if(j>=nums[i-1])
				{
					if(dp[i-1][j-nums[i-1]])
					{
						queue.add(new Pair(i-1,j-nums[i-1],nums[i-1]+" "+current.psf));
					}
				}
			}
		}
		

	}

}
