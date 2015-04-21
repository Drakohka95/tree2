
import java.io.IOException;

import javax.swing.tree.DefaultMutableTreeNode;


public class Function implements Runnable {
		int start,step,key;
		DefaultMutableTreeNode node;
	public Function(int start,int step, DefaultMutableTreeNode node, int key){
		this.start = start;
		this.step = step;
		this.node = node;
		this.key = key;
	}
	public void run() {
		Search sss = new Search();
        int find = -1;
        int i = 0; 
        for (i = start; i < (start+step) ; i++ ){
        
        try {
			find = sss.memRead(node, i);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // ДАААА!!! Поолучилось!!!!
        
        if (find == key){
      	  System.out.println("Искомый ключ находится в узле " + (i+1) + "-ого ребенка главного корня"); 
      //	  return;
        }
                 
        }
		
		
	}
}
