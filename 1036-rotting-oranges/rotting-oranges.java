class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int maxtime=-1;
        int time=0;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1)time++;
                else if(grid[i][j]==2)q.add(new int[]{i,j});
            }
        }
        if(time==0)return 0;
        maxtime=bfs(grid,q);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1)return -1;
            }
        }
        return maxtime;
    }
    public int bfs(int grid[][],Queue<int[]> q){
        int maxtime=-1;
        while(!q.isEmpty()){
            int s=q.size();
            maxtime++;
            int dr[]={-1,0,1,0};
            int dc[]={0,1,0,-1};
            for(int i=0;i<s;i++){
                int curr[]=q.poll();
                int x=curr[0];
                int y=curr[1];
                for(int k=0;k<4;k++){
                    int newi=x+dr[k];
                    int newj=y+dc[k];
                    if(valid(newi,newj,grid)){
                        grid[newi][newj]=2;
                        q.add(new int[]{newi,newj});
                    }
                }
            } 
        }
        return maxtime;
    }
    public boolean valid(int i,int j,int grid[][]){
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j]==2||grid[i][j]==0)return false;
        return true;
    }
}