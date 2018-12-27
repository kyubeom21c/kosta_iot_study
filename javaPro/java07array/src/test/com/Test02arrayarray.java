package test.com;

public class Test02arrayarray {

	public static void main(String[] args) {
		
		System.out.println("array....");

		//int a0,a1,a2.... >>>> int[] sus sus[i]
		//int[] sus0,sus1; 
		//int[][] suss suss[x][i]
		int[][] suss = new int[2][3];
		//{  {0,0,0} , {0,0,0}  }
		//suss[0] = new int[] {1,2,3};
		//suss[1] = new int[] {4,5,6};
		//suss[0][0]
		for (int x = 0; x < suss.length; x++) {
			//suss[x] = new int[] {1,2,3};
			for (int i = 0; i < suss[x].length; i++) {
				if(x==0)suss[x][i] = i+1;
				else suss[x][i] = i+4;
			}
		}
		for (int x = 0; x < suss.length; x++) {
			for (int i = 0; i < suss[x].length; i++) {
				System.out.print(suss[x][i]+" ");
			}
			System.out.println();
		}
		
		
		//String s0,s1,s2.... >>>> String[] strs strs[i]
		//String[] strs0,strs1; >>> 
		//String[][] strss strss[x][i]
		String[][] strss = new String[2][3];
		//{  {null,null,null} , {null,null,null} }
		//kim,lee,han
		//kim2,lee2,han2
		String[] strs0 = new String[3];
		strs0[0] = "kim";
		strs0[1] = "lee";
		strs0[2] = "han";
		
		for (int i = 0; i < strs0.length; i++) {
			System.out.print(strs0[i]+" ");
		}
		System.out.println();
		
		String[] strs1 = new String[3];
		strs1[0] = "kim2";
		strs1[1] = "lee2";
		strs1[2] = "han2";
		for (int i = 0; i < strs1.length; i++) {
			System.out.print(strs1[i]+" ");
		}
		System.out.println();
		
		strss[0] = strs0;
		strss[1] = strs1;
		
		for (int x = 0; x < strss.length; x++) {
			for (int i = 0; i < strss[x].length; i++) {
				System.out.print(strss[x][i]+" ");
			}
			System.out.println();
		}
		
		//boolean[][]
		boolean[] bs11 = new boolean[3];
		boolean[] bs22 = new boolean[3];
		
		boolean[][] bss = new boolean[][] {bs11,bs22};
		for (int x = 0; x < bss.length; x++) {
			for (int i = 0; i < bss[x].length; i++) {
				System.out.print(bss[x][i]+" ");
			}
			System.out.println();
		}
		
		//double[][]
		double[][] dss = new double[2][3];
//		for (int x = 0; x < dss.length; x++) {
//			dss[x] = new double[] {3.4 , 3.4 , 3.4};
//		}
		for (int x = 0; x < dss.length; x++) {
			for (int i = 0; i < dss[x].length; i++) {
				dss[x][i] = 1.1;
			}
		}
		
		for (int x = 0; x < dss.length; x++) {
			for (int i = 0; i < dss[x].length; i++) {
				System.out.print(dss[x][i]+" ");
			}
			System.out.println();
		}
		
		//char[][]
		
		
	}//end main()

}//end class
