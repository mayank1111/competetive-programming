package july2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;


public class IPCTrainers {
	static int n,d,t;
	static class Trainer 
	{
		int di,si;
		Trainer(int d,int s)
		{
			di=d;
			si=s;
		}
	}
	static long sadness;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t =Integer.parseInt(br.readLine());
		
		while(t-->0)
		{
			ArrayList<Trainer> trainerList = new ArrayList<Trainer>();
			sadness=0;
			String[] split = br.readLine().split(" ");
			n=Integer.parseInt(split[0]);
			d=Integer.parseInt(split[1]);
			long totalsadness=0;
			for(int i=0;i<n;++i)
			{
				split = br.readLine().split(" ");
				int ni=Integer.parseInt(split[0]);
				int di =Integer.parseInt(split[1]);
				int si=Integer.parseInt(split[2]);
			
				for(int ind=ni;ind<=ni+di-1;++ind)
				{
					trainerList.add(new Trainer(ind, si));
					totalsadness+=si;
				}
			}
			Collections.sort(trainerList,new Comparator<Trainer>() {

				public int compare(Trainer arg0, Trainer arg1) {
					// TODO Auto-generated method stub
					if(arg0.di<arg1.di)
						return -1;
					if(arg0.di==arg1.di)
					{
						if(arg0.si>arg1.si)
							return -1;
						return 1;
					}
					return 1;
				}
			});
			/*for(int i=0;i<trainerList.size();++i)
			{
				System.out.println(trainerList.get(i).di+">>>>"+trainerList.get(i).si);
			}*/
			int len =trainerList.size();
			int dayno=1;
			PriorityQueue<Trainer> queue = new PriorityQueue<Trainer>(comparator);
			for(int i=0;i<len;)
			{
				if(trainerList.get(i).di>d)
					break;
				if(trainerList.get(i).di==dayno)
				{
					totalsadness-=trainerList.get(i).si;
					++dayno;
					if(dayno>d)
						break;
					++i;
				}
				else if(trainerList.get(i).di<dayno)
				{
					queue.add(trainerList.get(i));
					++i;
					
				}
				else
				{
					if(queue.size()!=0)
					{
						totalsadness-=queue.poll().si;
					}
					++dayno;
					if(dayno>d)
						break;
					
				}
			}
			if(dayno<=d)
			{
				while(!queue.isEmpty())
				{
					totalsadness-=queue.poll().si;
					++dayno;
					if(dayno>d)
						break;
				}
			}
			System.out.println(totalsadness);
			
		}
	}
	public static Comparator<Trainer> comparator = new Comparator<Trainer>() {

		public int compare(Trainer arg0, Trainer arg1) {
			// TODO Auto-generated method stub
			if(arg0.si>arg1.si)
				return -1;
			return 1;
		}
	};
}