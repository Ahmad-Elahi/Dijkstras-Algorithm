
public class Dijkstra {

    // disply the adjacent matrix: Matrix.
  public void displayMatrix(Integer[][] Matrix) {
    for(int i=0; i < Matrix.length; i++){
      for(int j=0; j < Matrix[i].length; j++){
        if (Matrix[i][j]==Integer.MAX_VALUE) {
          System.out.print(" Inf");
        }
        else {
          System.out.print(" "+Matrix[i][j]);
        }
      }
      System.out.println();
    }     
  }
    
      

  public void findShortestPath(Integer[][] Matrix, Integer[][] weightMatrix, int index){
    Integer[] d = new Integer[5];
    Integer[] reached_nodes = {1, 1, 1, 1, 1}; // 1 = node has yet to be reached, 2 = reached
    Integer[] p = new Integer[5];
    // 1: foreach v in V do
    for(int i=0; i<d.length; i++){
      // 3: pred[v] <- nil 
      p[i] = 0;
      if(i==0){
        d[i]=0;
      }
      else{
        // 2: d[v] <- inf 
        d[i] = Integer.MAX_VALUE;
      }
    } // 4: endfor 
    // 5: S={}
    Integer[] S = new Integer[5];
    // 6: d[s] <- 0
    d[0] = 0;
    
    int count = 0; // keeps track of how many nodes have been reached for inner while loop
    int r_count = 0; // keeps track of how many nodes have been reached for outer while loop
    int counter; // used for loops to cycle through all nodes (in calculating "S", "d", and "pred")
    
    System.out.println("S | d | pred |");
    System.out.println("-------------------------------------------------------------------------------------");
    // 7: while(V is not empty) do 
    while(r_count <= 5){ 
      System.out.println(" ");
      // Calculates and prints out "S"
      counter = 0;        
      while(counter < 5){
        if(reached_nodes[counter] == 2){ //if node has been reached
          System.out.print(counter + " ");
        }
        counter++;
      }
      System.out.print("|");
      
      // Calculates and prints out "d"
      counter = 0;
      while(counter < 5){
        if((d[counter] == Integer.MAX_VALUE) && (reached_nodes[counter] == 1)){
          System.out.print(" d["+ counter +"]=Inf ");
        }
        else if(reached_nodes[counter] == 1){
          System.out.print(" d["+ counter +"]="+ d[counter]);
        }
        counter++;
      }
      System.out.print(" |");
      
      // Calculates and prints out "pred"
      counter = 0;
      while(counter < 5){
        if((p[counter] > 0) && (reached_nodes[counter] == 1)){
          System.out.print(" p["+ counter+ "]="+ p[counter]);
        }
        else if((p[counter] == 0) && (reached_nodes[counter] == 1)){
          System.out.print(" p["+ counter+ "]=0");
        }
        counter++;
      }
      System.out.print(" |");
      
      
      int u = 0; // stores node with shortest distance
      int new_min = Integer.MAX_VALUE;
      count = 0;
      // while loop below finds next closest node
      // 8: for u in V such that d[u] is minimal 
      while(count < 5){ // runs until all nodes are checked
        // 9: S <- S union {u}, V <- V - {u} 
        if(d[count] < new_min && reached_nodes[count] < 2){
          u = count;
          new_min = d[count];
        }
        count++;
      }
      reached_nodes[u] = 2; // updates which nodes have been reached
      // 10: for each vertex v adjacent to u 
      for(int i = 0; i < 5; i++){
        // 11: if ( v in not in S and d[v] > d[u] + w(u,v)) 
        if((weightMatrix[u][i] != Integer.MAX_VALUE) && (d[i] > d[u] + weightMatrix[u][i])){
          // 12: d[v] <- d[u] + w(u,v) 
          d[i] = d[u] + weightMatrix[u][i];
          // 13: pred[v] <- u 
          p[i] = u;
        } // 14: end if 
      } // 15: end for 
      r_count++;
      if(r_count == 3){
        System.out.println(" ");
        System.out.print("Program written by Ahmad Elahi, Half Way to Go!");
      }  
    } // 16: end while 
  }
}
