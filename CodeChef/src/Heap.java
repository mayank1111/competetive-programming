import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Heap {
	static class Node
	{
		int salary;
		int employees;
		int index;
		
		Node(int salary,int employees,int index)
		{
			this.salary = salary;
			this.employees = employees;
			this.index=index;
		}
	}
	static int t,n,m;
	static int expectedjoboffers[];
	static Node job[];
	static int N=0;
	static String[] jobOffers;
	static int nCandidates,totalSalary,nCompany;
	static boolean visited[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t=Integer.parseInt(br.readLine());
		while(t-->0)
		{
			nCandidates=totalSalary=nCompany=0;
			String[] split = br.readLine().split(" ");
			n=Integer.parseInt(split[0]);
			m=Integer.parseInt(split[1]);
			String[] split2 = br.readLine().split(" ");
			expectedjoboffers=new int[n];
			for(int i=0;i<n;++i)
			{
				expectedjoboffers[i]=Integer.parseInt(split2[i]);
			}
			job = new Node[m+1];
			visited=new boolean[m];
			for(int i=0;i<m;++i)
			{
				String[] split3 = br.readLine().split(" ");
				int salaryOffer =Integer.parseInt(split3[0]); 
				int nEmployee =Integer.parseInt(split3[1]);
				job[N]=new Node(salaryOffer, nEmployee, i);
				percolateUp(N);
				N++;
			}
			jobOffers=new String[n];
			for(int i=0;i<n;++i)
			{
				jobOffers[i] = br.readLine();
				for(int index=0;index<N;++index)
				{
					if(jobOffers[i].charAt(index)=='1' && job[index].employees>0 && job[index].salary>=expectedjoboffers[i])
					{
						if(!visited[index])
							nCompany++;
						visited[index]=true;
						nCandidates++;
						totalSalary+=job[index].salary;
						job[index].employees--;
						if(job[index].employees==0)
						{
							job[index]=job[N-1];
							N--;
							percolateDown(index);
						}
						break;
					}
				}
			}
			nCompany=n-nCompany;
			System.out.println(nCandidates+" "+totalSalary+" "+nCompany);
		}
	}
	static int getParent(int i)
	{
		return ((i-1)/2);
	}
	
	static void percolateUp(int index)
	{
		if(index<1)
			return;
		if(index-1!=getParent(index))
		{
			if(job[index].salary>job[index-1].salary)
			{
				swap(index,index-1);
			}
		}
		if(job[index].salary>job[getParent(index)].salary)
		{
			swap(index,getParent(index));
			percolateUp(getParent(index));
		}
	}
	
	static void swap(int index1,int index2)
	{
		Node temp=job[index1];
		job[index1]=job[index2];
		job[index2]=temp;
	}
	
	static void percolateDown(int index)
	{
		int leftIndex=2*index+1;
		int rightIndex=2*index+2;
		int largestIndex=index;
		if(leftIndex<N && job[leftIndex].salary>job[largestIndex].salary)
		{
			largestIndex=leftIndex;
		}
		if(rightIndex<N && job[rightIndex].salary>job[largestIndex].salary)
		{
			largestIndex=rightIndex;
		}
		if(largestIndex!=index)
		{
			swap(largestIndex,index);
			percolateDown(largestIndex);
		}
	}
	
}
