import java.io.IOException;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class Test {

	public static void main(String[] args) throws IOException {                                         
		                                                               
		 int m = 0;
			System.out.println("Введите кол-во узлов");
			
			Scanner sc = new Scanner(System.in); // создаём объект класса Scanner
	        if(sc.hasNextInt()) { // возвращает истинну если с потока ввода можно считать целое число
	          m = sc.nextInt(); // считывает целое число с потока ввода и сохраняем в переменную
	        } else {
	          System.out.println("Вы ввели не целое число");
	        }                                                              
	                                                                             
	 
	    JFrame jf = new JFrame("Tree with " + m + " nodes");                                       
	
	    DefaultMutableTreeNode super_root = new DefaultMutableTreeNode(0);
        // создаем узел являющийся корнем дерева
	    for (int i = 0; i < m; i++) {
	    	int k = 1 + (int) (Math.random() * 1000); // генерим произвольное чиселко
            // для каждого корня файловой системы создается собственный узел дерева JTree
            DefaultMutableTreeNode mroot = new DefaultMutableTreeNode(k);
            // затем он помещается внутрь корневого узла
            super_root.add(mroot);
        }
	    
	    final JTree jt = new JTree(super_root);
	    
	    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                           
	    jf.getContentPane().add(new JScrollPane(jt));                                
	    jf.pack();                                                                   
	    jf.setVisible(true); 
	    
	    
	    int n = 0;
		System.out.println("Введите искомый ключ");
		
		Scanner sc2 = new Scanner(System.in); // создаём объект класса Scanner
        if(sc2.hasNextInt()) { // возвращает истинну если с потока ввода можно считать целое число
          n = sc2.nextInt(); // считывает целое число с потока ввода и сохраняем в переменную
        } else {
          System.out.println("Вы ввели не целое число");
        }
        
           
        
   

        /*
        super_root.getChildAt(n); //выводит значение n-ого ребенка
        super_root.getChildCount(); //выводит кол-во дочерних узлов
        
        super_root.children();
        */
       
  /*      Search sss = new Search();
        int find = -1;
        int i = 0; 
        for (i = 0; i < m; i++ ){
        
        find = sss.memRead(super_root, i); // ДАААА!!! Поолучилось!!!!
        
        if (find == n){
      	  System.out.println("Искомый ключ находится в узле " + (i+1) + "-ого ребенка главного корня"); 
      //	  return;
        }
                 
        }
        */
        
	    int st = 0;
		System.out.println("Введите кол-во нитей");
		
		Scanner sc3 = new Scanner(System.in); // создаём объект класса Scanner
        if(sc3.hasNextInt()) { // возвращает истинну если с потока ввода можно считать целое число
          st = sc3.nextInt(); // считывает целое число с потока ввода и сохраняем в переменную
        } else {
          System.out.println("Вы ввели не целое число");
        }
        
        int step = m/st;
        
        Thread [] thread = new Thread[st];
        Function [] function = new Function[st];
        for(int i=0;i<(st-1);i++){
        	function[i] = new Function((step*i), step, super_root, n);
        	thread[i] = new Thread(function[i]);
        	thread[i].start();
        	
        }
        
        function[st-1] = new Function((step*(st-1)), (m-((st-1)*step)), super_root, n);
    	thread[st-1] = new Thread(function[st-1]);
    	thread[st-1].start();
        
		for (int i = 0; i < st; i++) {
			try {
				thread[i].join();
			} catch (InterruptedException e) {
				System.out.println("Intrrupted!");
			}
		}
        
        
        System.out.println("Все очень плохо");
	}
}
